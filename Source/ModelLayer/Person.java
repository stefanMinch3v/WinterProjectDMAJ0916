package ModelLayer;

/**
 * Created by RedJohn on 23-Nov-16.
 */
public abstract class Person {
    private String name, address, email, city, phone;

    public Person(String name, String address, String email, String phone, String city) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.city = city;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
