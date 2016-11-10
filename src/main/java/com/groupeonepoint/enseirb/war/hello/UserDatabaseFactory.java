package com.groupeonepoint.enseirb.war.hello;

public class UserDatabaseFactory {

	private static UserDatabase userDb;
	
	public static UserDatabase getInstance(){
		if(userDb == null){
			userDb = new UserDatabase();
		}
		return userDb;
	}
	
	
}
