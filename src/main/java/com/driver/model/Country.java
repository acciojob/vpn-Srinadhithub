// Note: Do not write @Enumerated annotation above CountryName in this model.
package com.driver.model;

import javax.persistence.*;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    CountryName countryName;
    String code;
    @JoinColumn
    @OneToOne
    User user;
    @JoinColumn
    @ManyToOne
    ServiceProvider serviceProvider;

    public Country(){

    }

    public Country( CountryName countryName, String code, User user, ServiceProvider serviceProvider) {

        this.countryName = countryName;
        this.code = code;

    }
    public Country(CountryName countryName) {
        this.countryName = countryName;

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CountryName getCountryName() {
        return countryName;
    }

    public void setCountryName(CountryName countryName) {
        this.countryName = countryName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }
}