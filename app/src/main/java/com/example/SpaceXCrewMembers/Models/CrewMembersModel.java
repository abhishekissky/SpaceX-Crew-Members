package com.example.SpaceXCrewMembers.Models;

public class CrewMembersModel {

    String name;
    String agency;
    String image;
    String wikipedia;
    String status;
    String id;

    public CrewMembersModel(String name, String agency, String image, String wikipedia) {
        this.name = name;
        this.agency = agency;
        this.image = image;
        this.wikipedia = wikipedia;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CrewMembersModel{" +
                "name='" + name + '\'' +
                ", agency='" + agency + '\'' +
                ", image='" + image + '\'' +
                ", wikipedia='" + wikipedia + '\'' +
                '}';
    }
}
