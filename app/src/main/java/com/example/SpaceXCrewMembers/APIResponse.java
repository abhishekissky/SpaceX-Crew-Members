package com.example.SpaceXCrewMembers;

import com.example.SpaceXCrewMembers.Models.CrewMembersModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIResponse {


    @GET("/v4/crew")
    Call<List<CrewMembersModel>> getData();


}
