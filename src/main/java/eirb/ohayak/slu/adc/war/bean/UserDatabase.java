package eirb.ohayak.slu.adc.war.bean;

import java.util.List;

/**
 * Created by mrhyk on 24/11/2016.
 */


public interface UserDatabase {
    public List<User> getAll();
    public User getByLogin(String login);
    public User addUser(User user);
    public boolean removeUser(User user);
}
