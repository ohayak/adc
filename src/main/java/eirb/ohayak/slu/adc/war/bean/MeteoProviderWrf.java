package eirb.ohayak.slu.adc.war.bean;

import eirb.ohayak.slu.adc.war.annotation.ModelWrf;

import java.util.Random;

/**
 * Created by mrhyk on 21/11/2016.
 */

@ModelWrf
public class MeteoProviderWrf implements MeteoProvider {

    @Override
    public float getCityTemperature(String city) {
        return (new Random()).nextFloat()*60-30;
    }
}
