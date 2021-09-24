package CSCI318.Customer.Model;

public class CustomerAddressPhone {
    //Variables
    private String address;
    private String phone;

    
    //Default contstructor
    CustomerAddressPhone(){}
    
    //Constructor
    public CustomerAddressPhone(String address, String phone){
        this.address = address;
        this.phone = phone;
    }

    public String getAddress(){
        return address;
    }

    public String getPhone(){
        return phone;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

