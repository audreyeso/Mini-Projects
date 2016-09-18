package com.test.mini_projects;

/**
 * Created by audreyeso on 9/18/16.
 */
public class Weather {

    private String day;

    private int celcius, fahrenheit, kelvin;
    public Weather(String day, int celcius, int fahrenheit, int kelvin){

        this.day = day;
        this.celcius = celcius;
        this.fahrenheit = fahrenheit;
        this.kelvin = kelvin;

    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getKelvin() {
        return kelvin;
    }

    public void setKelvin(int kelvin) {
        this.kelvin = kelvin;
    }

    public int getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(int fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    public int getCelcius() {
        return celcius;
    }

    public void setCelcius(int celcius) {
        this.celcius = celcius;
    }
}
