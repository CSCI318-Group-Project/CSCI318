package CSCI318.BusinessIntelligence.Service;

import org.apache.kafka.streams.state.KeyValueIterator;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.springframework.cloud.stream.binder.kafka.streams.InteractiveQueryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
/*
@Service
public class ProductInteractiveQuery {

    private InteractiveQueryService interactiveQueryService;

    //@Autowired
    public ProductInteractiveQuery(InteractiveQueryService interactiveQueryService) {
        this.interactiveQueryService = interactiveQueryService;
    }

    public long getProductQuantity(String productName) {
        if (keyValueStore().get(productName) != null) {
            return keyValueStore().get(productName);
            //long quantity = keyValueStore().get(productName);
            //return new BrandQuantity(productName, quantity);
        } else {
            throw new NoSuchElementException(); //TODO: should use a customised exception.
        }
    }

    public List<String> getProductNames() {
        List<String> productList = new ArrayList<>();
        KeyValueIterator<String, Long> all = keyValueStore().all();
        while (all.hasNext()) {
            String next = all.next().key;
            productList.add(next);
        }
        return productList;
    }

    private ReadOnlyKeyValueStore<String, Long> keyValueStore() {
        return this.interactiveQueryService.getQueryableStore(ProductStreamProcessing.STATE_STORE,
                QueryableStoreTypes.keyValueStore());
    }

}
*/