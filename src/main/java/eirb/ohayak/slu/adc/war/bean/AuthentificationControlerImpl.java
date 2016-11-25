package eirb.ohayak.slu.adc.war.bean;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by mrhyk on 24/11/2016.
 */

public class AuthentificationControlerImpl implements AuthenficationControler {

    private UserDatabase db;

    public AuthentificationControlerImpl(UserDatabase db) {
        this.db = db;
    }

    @Override
    public boolean checkIdentifiers(String login, String pwd) {
        for(User user : db.getAll()) {
            if (user.getLogin().equals(login)
                    && user.getPassword().equals(pwd)) {
                return true;
            }
        }
        return false;
    }
}
