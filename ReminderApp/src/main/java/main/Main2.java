package main;

import model.User;
import presistance.UserRepository;

public class Main2 {

    public static void main(String[] args) {

        User user1 = new User();
        user1.setUserEmail("jonas@gmail.com");
        user1.setUserPassword("12345");
        user1.setUserFirstName("Joonas");
        user1.setUserLastName("Pranstibel");

        UserRepository addToDatabase = new UserRepository();
        addToDatabase.saveUser(user1);


    }
}
