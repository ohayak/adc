package eirb.ohayak.slu.adc.war.bean;

import eirb.ohayak.slu.adc.war.annotation.Property;
import eirb.ohayak.slu.adc.war.bean.MeteoProvider;
import eirb.ohayak.slu.adc.war.bean.MeteoProviderGfs;
import eirb.ohayak.slu.adc.war.bean.MeteoProviderWrf;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.New;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

public class MeteoProviderProducer {

    @Inject
    @Property
    private String meteoProviderType;

    @Produces
    @RequestScoped
    public MeteoProvider getMeteoProvider(@New MeteoProviderGfs gfs, @New MeteoProviderWrf wrf){

        switch(meteoProviderType){
            case "ModelGfs":
                return gfs;
            case "ModelWrf":
                return wrf;
            default:
                return null;
        }

    }


}