package com.example.david.practicoapiclima;

/**
 * Created by David on 02/11/2017.
 */

public class Clima {
    private float temp;
    private float pressure;
    private float humidity;
    private float temp_min;
    private float temp_max;

    public Clima(){

    }

    public Clima(float temp, float pressure, float humidity,float temp_min, float temp_max) {
        this.temp = temp;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(float temp_min) {
        this.temp_min = temp_min;
    }

    public float getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(float temp_max) {
        this.temp_max = temp_max;
    }
    /*private float temperatura;
    private float presion;
    private float humedad;
    private float minima;
    private float maxima;

    public Clima(){

    }

    public Clima(float temperatura, float presion, float humedad, float minima, float maxima) {
        this.temperatura = temperatura;
        this.presion = presion;
        this.humedad = humedad;
        this.minima = minima;
        this.maxima = maxima;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public float getPresion() {
        return presion;
    }

    public void setPresion(float presion) {
        this.presion = presion;
    }

    public float getHumedad() {
        return humedad;
    }

    public void setHumedad(float humedad) {
        this.humedad = humedad;
    }

    public float getMinima() {
        return minima;
    }

    public void setMinima(float minima) {
        this.minima = minima;
    }

    public float getMaxima() {
        return maxima;
    }

    public void setMaxima(float maxima) {
        this.maxima = maxima;
    }
*/
}
