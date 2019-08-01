package com.nba.centralrules;

import com.nba.centralrules.model.TaxiRide;
import com.nba.centralrules.service.TaxiFareConfiguration;
import com.nba.centralrules.service.TaxiService;
import com.nba.centralrules.model.Fare;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DroolDemoApplication  implements CommandLineRunner {

    public void run(String... args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(TaxiFareConfiguration.class);
        TaxiService taxiFareCalculatorService = (TaxiService) context.getBean(TaxiService.class);
        TaxiRide taxiRide = new TaxiRide();
        taxiRide.setIsNightSurcharge(false);
        taxiRide.setDistanceInMile(90L);
        Fare rideFare = new Fare();
        taxiFareCalculatorService.calculateFare(taxiRide, rideFare);
    }

    public static void main(String[] args) {
        SpringApplication.run(DroolDemoApplication.class, args);

    }

}
