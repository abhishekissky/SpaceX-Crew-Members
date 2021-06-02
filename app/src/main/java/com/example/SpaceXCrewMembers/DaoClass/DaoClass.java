package com.example.SpaceXCrewMembers.DaoClass;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.SpaceXCrewMembers.EntryClass.UserModel;

import java.util.List;

@Dao
public interface DaoClass {

    @Insert
    void insertAllData(UserModel model);

    @Query("select * from crewMembers")
    List<UserModel>getAllData();

    @Query("delete from crewMembers")
    void deleteData();

}
