package com.example.david.practicoapiclima;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
/**
 * Created by David on 02/11/2017.
 */

public interface ClimaCiudad {
    @GET("weather")
    Call<City> getCity(@Query("id") int idCity, @Query("appid") String key, @Query("units") String value, @Query("lang") String lang);
}
