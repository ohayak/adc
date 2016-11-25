package eirb.ohayak.slu.adc.war.bean;

import javax.inject.Inject;
import java.util.Random;

/**
 * Created by mrhyk on 14/11/2016.
 */
public interface MeteoProvider {
    public float getCityTemperature(String city);
}
