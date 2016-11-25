package eirb.ohayak.slu.adc.war.bean;

import eirb.ohayak.slu.adc.war.annotation.ModelGfs;

import java.util.Random;

/**
 * Created by mrhyk on 21/11/2016.
 */

@ModelGfs
public class MeteoProviderGfs implements MeteoProvider {
    @Override
    public float getCityTemperature(String city) {
        return (new Random()).nextFloat()*60-30;
    }
}
