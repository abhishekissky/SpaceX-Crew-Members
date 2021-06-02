package com.example.SpaceXCrewMembers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.SpaceXCrewMembers.EntryClass.UserModel;
import com.example.SpaceXCrewMembers.Models.CrewMembersModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button deleteBtn,refreshBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        deleteBtn = findViewById(R.id.deleteBtn);
        //hello there
        refreshBtn = findViewById(R.id.refreshBTn);
        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseClass.getDatabase(getApplicationContext()).getDao().deleteData();
                getData(1);
            }
        });

        //comment
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteData();
                getAdapterData();
                Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
            }
        });
        Log.v("Database!232",DatabaseClass.getDatabase(getApplicationContext()).getDao().getAllData().toString());
        if(DatabaseClass.getDatabase(getApplicationContext()).getDao().getAllData()==null||DatabaseClass.getDatabase(getApplicationContext()).getDao().getAllData().isEmpty()){
            getData(2);
        }else {
            getAdapterData();
        }

    }

    private void deleteData() {
        DatabaseClass.getDatabase(getApplicationContext()).getDao().deleteData();
    }

    private void getData(int a) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.spacexdata.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIResponse apiResponse = retrofit.create(APIResponse.class);

        apiResponse.getData().enqueue(new Callback<List<CrewMembersModel>>() {
            @Override
            public void onResponse(Call<List<CrewMembersModel>> call, Response<List<CrewMembersModel>> response) {

                List<CrewMembersModel> crewMembersModel =  response.body();
//                getAdapterData(crewMembersModel);
                for (CrewMembersModel crewMembersModel1: crewMembersModel){

                    String name = crewMembersModel1.getName();
                    String agency = crewMembersModel1.getAgency();
                    String image = crewMembersModel1.getImage();
                    String wikipedia = crewMembersModel1.getWikipedia();
                    String status = crewMembersModel1.getStatus();



                    saveData(name,agency,image,wikipedia,status);
                }


                    getAdapterData();

                Toast.makeText(MainActivity.this, "Data Successfully Added", Toast.LENGTH_SHORT).show();

                Log.v("Response",crewMembersModel.toString());
            }

            @Override
            public void onFailure(Call<List<CrewMembersModel>> call, Throwable t) {

            }
        });

    }

    private void saveData(String name, String agency, String image, String wikipedia, String status) {

        if(name!=null&& agency!=null&& image!=null&&wikipedia!=null&& status!=null){
            UserModel userModel = new UserModel();
            userModel.setName(name);
            userModel.setAgency(agency);
            userModel.setImage(image);
            userModel.setWikipedia(wikipedia);
            userModel.setStatus(status);

            DatabaseClass.getDatabase(MainActivity.this).getDao().insertAllData(userModel);
        }




    }

    public void getAdapterData(){
        Adapter adapter = new Adapter(DatabaseClass.getDatabase(getApplicationContext()).getDao().getAllData(),this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }


    @Override
    protected void onStart() {
        super.onStart();
        getAdapterData();
    }
}