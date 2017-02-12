package com.akashmadhusudan.concertlib.model;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Concert {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;
    @Version
    private Long version;
    @NotNull
    @Size(min = 2, max = 20)
    private String artistName;
    @NotNull
    @Size(min = 2, max = 30)
    private String venue;
    private String dateAndTime;


    protected Concert(){
        id = null;
    }

    public Concert(String artistName, String venue, String dateAndTime) {
        this();
        this.artistName = artistName;
        this.venue = venue;
        this.dateAndTime = dateAndTime;
    }


    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }
}
