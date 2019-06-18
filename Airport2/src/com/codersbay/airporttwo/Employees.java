package com.codersbay.airporttwo;

public class Employees {

    private int personalNumber;
    private String first_name;
    private String last_name;

    private String street;
    private String appartment_number;
    private String zip;

    private String phonenumber;
    private String email;

    public Employees(int personalNumber, String first_name, String last_name, String street, String apartment_number, String zip, String phonenumber, String email) {
        this.setPersonalNumber(personalNumber);
        this.setFirst_name(first_name);
        this.setLast_name(last_name);
        this.setStreet(street);
        this.setAppartment_number(apartment_number);
        this.setZip(zip);
        this.setPhonenumber(phonenumber);
        this.setEmail(email);
    }

    public Employees() {
    }

    public int getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(int personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAppartment_number() {
        return appartment_number;
    }

    public void setAppartment_number(String appartment_number) {
        this.appartment_number = appartment_number;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
