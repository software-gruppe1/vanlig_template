package com.example.software_engineer.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private int serviceQuantity;
    private double totalPrice;
    private String username;
    private String email;
    private ArrayList<Services> services;

    public int getAntallVarer() {return serviceQuantity;}
    public void setAntallVarer(int antallVarer) {this.serviceQuantity = antallVarer;}

    public double getTotalPris() {return totalPrice;}
    public void setTotalPris(double totalPris) {this.totalPrice = totalPris;}

    public String getBrukerNavn() {return username;}
    public void setBrukerNavn(String brukerNavn) {this.username = brukerNavn;}

    public String getEpostAdresse() {return email;}
    public void setEpostAdresse(String epostAdresse) {this.email = epostAdresse;}

    public List<Services> getTjenester() {return services;}
    public void setTjenester(ArrayList<Services> tjenester) {this.services = tjenester;}
}
