package com.example.SpaceXCrewMembers.EntryClass;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import io.reactivex.rxjava3.annotations.NonNull;

@Entity(tableName = "crewMembers")
public class UserModel {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    int key;

    @ColumnInfo(name = "name")
    String name;

    @ColumnInfo(name = "agency")
    String agency;

    @ColumnInfo(name = "image")
    String image;

    @ColumnInfo(name = "wikipedia")
    String wikipedia;

    @ColumnInfo(name = "status")
    String status;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
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
}
