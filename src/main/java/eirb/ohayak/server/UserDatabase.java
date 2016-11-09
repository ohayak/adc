package eirb.ohayak.server;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrhyk on 07/11/2016.
 */
public class UserDatabase extends ArrayList<User> {
    private final String FILE_NAME = "users.txt";
    private String filePath;

    public UserDatabase() {
        super();
        filePath = this.getClass().getClassLoader().getResource(FILE_NAME).getPath();
        System.out.println(filePath);
        populateDatabase(filePath);
    }

    private List<User> populateDatabase(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            while (br.ready()) {
                String line = br.readLine();
                String[] content = line.split(",");
                this.add(new User(content[0], content[1], content[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return this;
        }
    }

    public void addUser(User user) {
        this.add(user);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write(user.getFirstName()+","+user.getLastName()+","+user.getCity()+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
