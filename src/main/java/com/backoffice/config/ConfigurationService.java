package com.backoffice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConfigurationService {

    @Autowired
    private ConfigurationRepository configurationRepository;

    public Configuration findById(String id){
        Optional<Configuration> configuration = this.configurationRepository.findById(id);
        if(configuration.isPresent()){
            return configuration.get();
        }
        Configuration config = new Configuration();
        config.setId(null);
        config.setAge(0);
        config.setPourcentage_prix(0);
        return config;
    }

    public void save (Configuration configuration){
        this.configurationRepository.save(configuration);
    }

}
