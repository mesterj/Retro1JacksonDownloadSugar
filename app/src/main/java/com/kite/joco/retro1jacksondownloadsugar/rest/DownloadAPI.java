package com.kite.joco.retro1jacksondownloadsugar.rest;

import com.kite.joco.retro1jacksondownloadsugar.entity.Dolgozok;
import com.kite.joco.retro1jacksondownloadsugar.entity.Nyomtatvany;
import com.kite.joco.retro1jacksondownloadsugar.entity.Partner;

import java.util.List;
import java.util.Map;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.mime.TypedFile;

/**
 * Created by Joco on 2015.11.28..
 */
public interface DownloadAPI {

    @GET("/com.joco.nyomtserv2.nyomtatvany")
    public void getAsyncListofNyomtatvany(Callback<List<Nyomtatvany>> callback);

    // Synchronized type of web service client (don't use it !! )
    @GET("/com.joco.nyomtserv2.nyomtatvany")
    public List<Nyomtatvany> getListofNyomtatvany();

//    @GET("/com.joco.nyomtserv2.partner")
//   public void getAsyncListofPartner(Callback<List<Partner>> callback);

    @GET("/entities.partner")
    public void getAsyncListofPartner(Callback<List<Partner>> callback);


    @GET("/com.joco.nyomtserv2.dolgozok")
    public void getAsyncListofDolgozok(Callback<List<Dolgozok>> callback);

    // File küldés
    @Multipart
    @POST("/com.joco.nyomtserv2.sajatservices/upload")
    void upload(@Part("file") TypedFile file,Callback<String> cb);

    // dat -hoz adat küldés map-ban
    @FormUrlEncoded
    @POST("/com.joco.nyomtserv2.sajatservices/upload/map")
    void uploadMap(@FieldMap Map<String,String> map,Callback<String> callback);

    //modifiedTime alapú frissítés a Dolgozok táblán
    @POST("/com.joco.nyomtserv2.sajatservices/dolgozokupdatebytime")
    void getDolgozokbyModiTime(@Body Long d, Callback<List<Dolgozok>> callback);

    //modifiedTime alapú frissítés a Partner táblán
    @POST("/com.joco.nyomtserv2.sajatservices/partnerekupdatebytime")
    void getPartnerByModiDate(@Body Long d, Callback<List<Partner>> callback);

    //modifiedTime alapú frissítés a nyomtatvány Táblán
    @POST("/com.joco.nyomtserv2.sajatservices/nyomtatvanyupdatebytime/{datum}")
    void getNyomtatvanyByModiTime(@Body Long d, Callback<List<Nyomtatvany>> callback);



}
