package com.example.userlistapp.data;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;

    // Getters and setters (or use public fields if you want simpler)

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getWebsite() { return website; }
    public void setWebsite(String website) { this.website = website; }

    public Company getCompany() { return company; }
    public void setCompany(Company company) { this.company = company; }

    // Inner classes for Address and Company

    public static class Address implements Serializable {
        private String street;
        private String suite;
        private String city;
        private String zipcode;

        // getters and setters
        public String getStreet() { return street; }
        public void setStreet(String street) { this.street = street; }

        public String getSuite() { return suite; }
        public void setSuite(String suite) { this.suite = suite; }

        public String getCity() { return city; }
        public void setCity(String city) { this.city = city; }

        public String getZipcode() { return zipcode; }
        public void setZipcode(String zipcode) { this.zipcode = zipcode; }
    }

    public static class Company implements Serializable {
        private String name;
        private String catchPhrase;
        private String bs;

        // getters and setters
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getCatchPhrase() { return catchPhrase; }
        public void setCatchPhrase(String catchPhrase) { this.catchPhrase = catchPhrase; }

        public String getBs() { return bs; }
        public void setBs(String bs) { this.bs = bs; }
    }
}
