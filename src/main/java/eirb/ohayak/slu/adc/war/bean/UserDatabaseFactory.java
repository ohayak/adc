package eirb.ohayak.slu.adc.war.bean;

import javax.enterprise.inject.Produces;

/**
 * Created by mrhyk on 25/11/2016.
 */
public class UserDatabaseFactory {

    private static UserDatabase db;

    @Produces
    public static UserDatabase getInstance() {
        if (db == null) {
            db = new UserDatabaseListe();
        }
        return db;
    }
}
