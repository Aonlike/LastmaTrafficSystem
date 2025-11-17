package data.models;

public class Owner {
    String name;
    String address;
    String phone;
    String gender;
    String email;
    String id;

    public Owner(String name, String address, String phone, String gender, String email, String id) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.gender = gender;
        this.email = email;
        this.id = id;
    }

    public Owner(String name, String ownerAddress, String ownerPhone, String ownerEmail, Object ownerId) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
