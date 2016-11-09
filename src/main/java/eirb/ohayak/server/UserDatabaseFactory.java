package eirb.ohayak.server;

/**
 * Created by mrhyk on 07/11/2016.
 */
public class UserDatabaseFactory {
    private static UserDatabase db;
    public static UserDatabase getInstance() {
        if (db == null) {
            db = new UserDatabase();
        }
        return db;
    }
}
