package com.driver.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String username;
    String password;
    String originalIp;
    String maskedIp;
    Boolean connected;
@ManyToMany
@JoinColumn
List<ServiceProvider> serviceProviderList=new ArrayList<>();
@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Connection> connectionList=new ArrayList<>();
@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
Country originalCountry;

    public User(String username, String password, String countryName) {
    }

    public User() {

    }

    public int  getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOriginalIp() {
        return originalIp;
    }

    public void setOriginalIp(String originalIp) {
        this.originalIp = originalIp;
    }

    public String getMaskedIp() {
        return maskedIp;
    }

    public void setMaskedIp(String maskedIp) {
        this.maskedIp = maskedIp;
    }

    public Boolean getConnected() {
        return connected;
    }

    public void setConnected(Boolean connected) {
        this.connected = connected;
    }

    public Country getOriginalCountry() {
        return originalCountry;
    }

    public void setOriginalCountry(Country originalCountry) {
        this.originalCountry = originalCountry;
    }

    public List<Connection> getConnectionList() {
        return connectionList;
    }

    public void setServiceProviderList(List<ServiceProvider> serviceProviderList) {
        this.serviceProviderList = serviceProviderList;
    }

    public void setConnectionList(List<Connection> connectionList) {
        this.connectionList = connectionList;
    }

    public List<ServiceProvider> getServiceProviderList() {
        return  this.serviceProviderList;
    }
}
