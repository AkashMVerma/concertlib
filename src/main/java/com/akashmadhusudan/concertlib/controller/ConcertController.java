package com.akashmadhusudan.concertlib.controller;

import com.akashmadhusudan.concertlib.data.ConcertRepository;
import com.akashmadhusudan.concertlib.model.Concert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ConcertController {

    @Autowired
    private final ConcertRepository concertRepository;

    public ConcertController(ConcertRepository concertRepository) {
        this.concertRepository = concertRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/concerts", method = RequestMethod.GET)
    public String listOfConcerts(ModelMap modelMap) {
        modelMap.put("concerts", concertRepository.findAll());

        return "concerts";
    }

    @RequestMapping(value = "/concerts/{id}", method = RequestMethod.GET)
    public String returnConcertById(@PathVariable Long id, ModelMap modelMap) {
        modelMap.put("concerts", concertRepository.findOne(id));

        return "concerts";
    }

    @RequestMapping(value = "/concerts", params = {"q"}, method = RequestMethod.GET)
    public String searchConcert(@RequestParam(value = "q") String query, ModelMap modelMap) {
        List<Concert> concertList = (List<Concert>) concertRepository.findAll();
        ArrayList<Concert> concerts = new ArrayList<>();
        for (Concert concert : concertList) {
            if (concert.getArtistName().toLowerCase().contains(query.toLowerCase()) ||
                    concert.getVenue().toLowerCase().contains(query.toLowerCase())) {
                concerts.add(concert);
            }
            modelMap.put("concerts", concerts);
        }
        return "concerts";

    }


}
