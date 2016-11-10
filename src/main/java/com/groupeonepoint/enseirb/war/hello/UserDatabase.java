package com.groupeonepoint.enseirb.war.hello;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrhyk on 07/11/2016.
 */
public class UserDatabase extends ArrayList<User> {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String FILE_NAME = "users.txt";
    private String filePath;

    public UserDatabase() {
        super();
        UserDatabase.class.getResource("UserDatabase.class");
        filePath = this.getClass().getClassLoader().getResource(FILE_NAME).getPath();
        populateDatabase(filePath);
    }

    @SuppressWarnings("finally")
	private List<User> populateDatabase(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
        	while (br.ready()) {
                String line = br.readLine();
                String[] content = line.split(",");
                this.add(new User(content[0], content[1]));   
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return this;
        }
    }

    public void addUser(User user) {
        this.add(user);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath,true))) {
            bw.write(user.getPrenom()+","+user.getNom()+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


