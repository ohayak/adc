package com.groupeonepoint.enseirb.war.hello;

import java.util.Random;

/**
 * Created by mrhyk on 14/11/2016.
 */
public class MeteoProvider {
	
	private final Random rand = new Random();
    public float getCityTemperature(String city) {
        return rand.nextFloat()*60-30;
    }
}
