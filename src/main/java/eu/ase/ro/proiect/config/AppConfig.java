package eu.ase.ro.proiect.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import eu.ase.ro.proiect.factories.SpaceFactory;
import eu.ase.ro.proiect.service.RoomFilterService;

@Configuration
public class AppConfig {

    @Bean
    public SpaceFactory spaceFactory() {
        return new SpaceFactory();
    }
    @Bean
    public RoomFilterService roomFilterService() {
        return new RoomFilterService();
    }
}
