package me.dvsingh.drools;

import me.dvsingh.drools.model.Fare;
import me.dvsingh.drools.model.TaxiRide;
import me.dvsingh.drools.service.TaxiFareConfiguration;
import me.dvsingh.drools.service.TaxiService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DroolDemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(TaxiFareConfiguration.class);
        TaxiService taxiFareCalculatorService = (TaxiService) context.getBean(TaxiService.class);
        TaxiRide taxiRide = new TaxiRide();
        taxiRide.setIsNightSurcharge(false);
        taxiRide.setDistanceInMile(90L);
        Fare rideFare = new Fare();
        taxiFareCalculatorService.calculateFare(taxiRide, rideFare);
    }

}
