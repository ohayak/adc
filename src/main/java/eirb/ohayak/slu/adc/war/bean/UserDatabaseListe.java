package eirb.ohayak.slu.adc.war.bean;

import javax.enterprise.context.ApplicationScoped;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrhyk on 07/11/2016.
 */

@ApplicationScoped
public class UserDatabaseListe extends ArrayList<User> implements UserDatabase {
    private static final long serialVersionUID = 1L;


    public UserDatabaseListe() {
        super();
        this.add(new User("user","user","user","user"));
        this.add(new User("admin","admin","admin","admin"));
    }

    @Override
    public List<User> getAll() {
        return this;
    }

    @Override
    public User getByLogin(String login) {
        for (User user : this) {
            if(user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User addUser(User user) {
        this.add(user);
        return user;
    }

    @Override
    public boolean removeUser(User user) {
        return this.remove(user);
    }
}


