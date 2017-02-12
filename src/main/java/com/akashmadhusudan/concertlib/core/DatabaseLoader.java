package com.akashmadhusudan.concertlib.core;

import com.akashmadhusudan.concertlib.data.ConcertRepository;
import com.akashmadhusudan.concertlib.model.Concert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class DatabaseLoader implements ApplicationRunner {

    private final ConcertRepository concertRepository;

    @Autowired
    public DatabaseLoader(ConcertRepository concertRepository) {
        this.concertRepository = concertRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Concert> concertList = Arrays.asList(
                new Concert("Martin Garixx", "Leuven - Oude Markt", "12th March @ 6PM"),
                new Concert("David Guetta", "Antwerp - Sportpaleis", "25th March @ 9PM"),
                new Concert("Rihanna", "Brussels - Vorst Nationaal", "20th April @ 6PM"),
                new Concert("Kanye West", "Antwerp - Sportpaleis", "15th July @ 2PM"),
                new Concert("Linkin Park", "Ghent - Vooruit", "20th August @ 10PM"),
                new Concert("Daler Mehndi", "Ghent - Vooruit", "15th September @ 5PM"),
                new Concert("Bazart", "Brussels - Ancienne Belgique", "13th June @ 7PM"),
                new Concert("Stromae", "Leuven - Oude Markt", "7th November 2017"));

        concertRepository.save(concertList);

    }

}
