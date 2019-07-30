package me.dvsingh.drools;

import me.dvsingh.drools.model.Fare;
import me.dvsingh.drools.model.TaxiRide;
import me.dvsingh.drools.service.TaxiFareConfiguration;
import me.dvsingh.drools.service.TaxiService;
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
