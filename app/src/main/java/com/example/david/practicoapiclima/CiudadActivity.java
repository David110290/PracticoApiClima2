package com.example.david.practicoapiclima;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CiudadActivity extends AppCompatActivity {
    private int id;
    TextView txtCiudad;
    TextView txtTemperatura;
    TextView txtMaxima;
    TextView txtMinima;
    TextView txtHumedad;
    TextView txtPresion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciudad);

        Bundle extras = getIntent().getExtras();
        id=extras.getInt("ID");

        txtCiudad = (TextView) findViewById(R.id.txtCiudad);
        txtTemperatura = (TextView) findViewById(R.id.txtTemperatura);
        txtMaxima = (TextView) findViewById(R.id.txtMaxima);
        txtMinima = (TextView) findViewById(R.id.txtMinima);
        txtHumedad = (TextView) findViewById(R.id.txtHumedad);
        txtPresion = (TextView) findViewById(R.id.txtPresion);

        final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
        final String KEY_API = "a97ef7e691c61fb0fdf8843d67b6475e";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ClimaCiudad service = retrofit.create(ClimaCiudad.class);
        Call<City> cityCall = service.getCity(id, KEY_API, "metric", "es");

        cityCall.enqueue(new Callback<City>() {
            @Override
            public void onResponse(Call<City> call, Response<City> response) {
                City city = response.body();

                txtCiudad.setText(String.valueOf(city.getName()));
                txtTemperatura.setText(String.valueOf(city.getClima().getTemp())+" C°");
                txtMaxima.setText(String.valueOf(city.getClima().getTemp_max())+" C°");
                txtMinima.setText(String.valueOf(city.getClima().getTemp_min())+" C°");
                txtHumedad.setText(String.valueOf(city.getClima().getHumidity())+" %");
                txtPresion.setText(String.valueOf(city.getClima().getPressure())+" HPA");
            }

            @Override
            public void onFailure(Call<City> call, Throwable t) {
                Toast.makeText(CiudadActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
