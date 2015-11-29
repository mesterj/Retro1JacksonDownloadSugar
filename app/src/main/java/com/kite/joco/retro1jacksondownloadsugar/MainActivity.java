package com.kite.joco.retro1jacksondownloadsugar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.kite.joco.retro1jacksondownloadsugar.entity.Dolgozok;
import com.kite.joco.retro1jacksondownloadsugar.rest.DownloadAPI;
import com.kite.joco.retro1jacksondownloadsugar.rest.ServiceGenerator;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){
        DownloadAPI service = ServiceGenerator.createService(DownloadAPI.class);
       /* service.getAsyncListofNyomtatvany(new Callback<List<Nyomtatvany>>() {
            @Override
            public void success(List<Nyomtatvany> nyomtatvanies, Response response) {
                for (Nyomtatvany ny : nyomtatvanies) {
                    Log.i("Lista ", "kod : " + ny.getNyomtKod() + " nev " + ny.getNyomtNev());
                    ny.save();
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i("Nyomtatvany lista", "sikertelen");
            }
        });*/
        //Log.i("kod",service.toString());
        //List<Nyomtatvany> nyomtatvanyList = service.getListofNyomtatvany();
        //for (Nyomtatvany ny:nyomtatvanyList){
         //   Log.i("Nyomtatvany","Kod " +ny.getNyomtKod());
       // }
        Calendar c = new GregorianCalendar(1970,1,1,10,5);


        Date d = c.getTime();
        //long timestamp = Calendar.getInstance().getTime() / 1000
        long timestamp = c.getTimeInMillis() / 1000;
        Log.i("real timestamp", " " + timestamp);

        service.getDolgozokbyModiTime(timestamp, new Callback<List<Dolgozok>>() {
            @Override
            public void success(List<Dolgozok> dolgozoks, Response response) {
                for (Dolgozok dolgozo : dolgozoks){
                    Log.i("Dolgozok",dolgozo.getNev());
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i("Dolgozok ido szerint","failure" + error.getResponse() + error.getMessage());
            }
        });

    }
}
