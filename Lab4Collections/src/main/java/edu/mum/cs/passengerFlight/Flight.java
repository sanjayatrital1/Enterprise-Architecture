package edu.mum.cs.passengerFlight;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "flight")
public class Flight {
    @Id
    @GeneratedValue
    private long id;
    private String flightNo;
    @OneToMany
    List<Passenger> passengerList = new ArrayList<Passenger>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }
    public void addPassenger(Passenger p){
        passengerList.add(p);
    }
}
