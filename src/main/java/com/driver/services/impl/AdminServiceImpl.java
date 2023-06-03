package com.driver.services.impl;

import com.driver.model.Admin;
import com.driver.model.Country;
import com.driver.model.CountryName;
import com.driver.model.ServiceProvider;
import com.driver.repository.AdminRepository;
import com.driver.repository.CountryRepository;
import com.driver.repository.ServiceProviderRepository;
import com.driver.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository1;

    @Autowired
    ServiceProviderRepository serviceProviderRepository1;

    @Autowired
    CountryRepository countryRepository1;

    @Override
    public Admin register(String username, String password) {
        Admin admin= new Admin(username,password);
        Admin savedAdmin= adminRepository1.save(admin);
        return savedAdmin;
    }

    @Override
    public Admin addServiceProvider(int adminId, String providerName) {
      Admin admin= adminRepository1.findById(adminId).get();
      ServiceProvider serviceProvider= new ServiceProvider(providerName);
      admin.getServiceProviders().add(serviceProvider);
      serviceProvider.setAdmin(admin);
      return adminRepository1.save(admin);
    }

    @Override
    public ServiceProvider addCountry(int serviceProviderId, String countryName) throws Exception{
        if (countryName.equalsIgnoreCase("ind") ||
                countryName.equalsIgnoreCase("usa") ||
                countryName.equalsIgnoreCase("aus") ||
                countryName.equalsIgnoreCase("chi") ||
                countryName.equalsIgnoreCase("jpn")
        ){

            Country country = new Country();
            ServiceProvider serviceProvider=serviceProviderRepository1.findById(serviceProviderId).get();

            if(countryName.equalsIgnoreCase("ind")){
                country.setCountryName(CountryName.IND);
                country.setCode(CountryName.IND.toCode());
            }

            if(countryName.equalsIgnoreCase("usa")){
                country.setCountryName(CountryName.USA);
                country.setCode(CountryName.USA.toCode());
            }

            if(countryName.equalsIgnoreCase("chi")){
                country.setCountryName(CountryName.CHI);
                country.setCode(CountryName.CHI.toCode());
            }
            if(countryName.equalsIgnoreCase("jpn")){
                country.setCountryName(CountryName.JPN);
                country.setCode(CountryName.JPN.toCode());
            }

            if(countryName.equalsIgnoreCase("aus")){
                country.setCountryName(CountryName.AUS);
                country.setCode(CountryName.AUS.toCode());
            }
            //setting country attribute
            country.setServiceProvider(serviceProvider);
            //adding country in country list of parent service provider
            serviceProvider.getCountryList().add(country);
            //saving parent entity service provider which will save country due to bi directional mapping
            return serviceProviderRepository1.save(serviceProvider);

        }

        else{
            throw new Exception("Country not found");
        }
    }
}
