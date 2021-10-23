package CSCI318.BusinessIntelligence.Service;

/* This class computes a stream of brand quantities
 * and creates a state store for interactive queries.
 */

import CSCI318.BusinessIntelligence.Model.OrderEvent;
import CSCI318.BusinessIntelligence.Model.ProductQuantity;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Printed;
import org.apache.kafka.streams.state.KeyValueStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ProductStreamProcessing {

    public final static String STATE_STORE = "my-store";

    @Bean
    public Function<KStream<?, OrderEvent>, KStream<String, ProductQuantity>> process() {
        return inputStream -> {
            KTable<String, Long> brandKTable = inputStream.
                    mapValues(OrderEvent::getProductName).
                    groupBy((keyIgnored, value) -> value).
                    count(
                            Materialized.<String, Long, KeyValueStore<Bytes, byte[]>>as(STATE_STORE).
                                    withKeySerde(Serdes.String()).
                                    withValueSerde(Serdes.Long())
                    );
            KStream<String, ProductQuantity> productQuantityStream = brandKTable.
                    toStream().
                    map((k, v) -> KeyValue.pair(k, new ProductQuantity(k, v)));
            // use the following code for testing
            productQuantityStream.print(Printed.<String, ProductQuantity>toSysOut().withLabel("Console Output"));

            return productQuantityStream;
        };
    }
}
