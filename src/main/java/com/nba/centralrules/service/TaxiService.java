package com.nba.centralrules.service;

import com.nba.centralrules.model.TaxiRide;
import com.nba.centralrules.model.Fare;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TaxiService {

    @Autowired
    private KieContainer kContainer;

    public Long calculateFare(TaxiRide taxiRide, Fare rideFare) {
        KieSession kieSession = kContainer.newKieSession();
        kieSession.setGlobal("rideFare", rideFare);
        kieSession.insert(taxiRide);
        kieSession.fireAllRules();
        kieSession.dispose();

        System.out.println("!! RIDE FARE !! " + rideFare.getTotalFare());
        return rideFare.getTotalFare();
    }

}
