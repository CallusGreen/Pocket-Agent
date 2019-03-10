package com.example.testandroidapplication.helper;



import org.json.JSONException;
import org.json.JSONObject;


import com.example.testandroidapplication.objects.Artist;

import java.util.HashMap;
import java.util.Map;

public class WebClientMethods {

    private static final String KEY_USER_ID = "User_Id";
    private static final String KEY_USER_NAME = "User_Name";
    private static final String KEY_EMAIL = "Email";
    private static final String KEY_PASSWORD = "Password";
    private static final String KEY_DATA = "data";

    private static final String BASE_URL = "http://40414669.wdd.napier.ac.uk/inc/";


    public String createUserAccount(String userName, String userEmail, String userPassword) {
        HttpJsonParser httpJsonParser = new HttpJsonParser();
        Map<String, String> httpParams = new HashMap<>();
        httpParams.put(KEY_USER_NAME, userName);
        httpParams.put(KEY_EMAIL, userEmail);
        httpParams.put(KEY_PASSWORD, userPassword);
        JSONObject jsonObject = httpJsonParser.makeHttpRequest(
                BASE_URL + "createUser.php", "POST", httpParams);
        try {
            return jsonObject.getString("success");
        } catch (JSONException e) {
            e.printStackTrace();
            return e.getMessage();

        }
    }


     public ArtistResult readArtistProfile(){
         HttpJsonParser httpJsonParser = new HttpJsonParser();
         Map<String, String> httpParams = new HashMap<>();
         httpParams.put(KEY_USER_ID, "5");

         JSONObject jsonObject = httpJsonParser.makeHttpRequest(
                 BASE_URL + "readArtistProfile.php", "GET", httpParams);

    try {
        JSONObject user = jsonObject.getJSONObject(KEY_DATA);
        Artist artist = Artist.fromJson(user);
        return ArtistResult.success(artist);


    } catch (JSONException e) {
        return ArtistResult.failure();
    }

     }



     }


