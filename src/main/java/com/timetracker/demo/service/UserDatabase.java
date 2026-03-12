package com.timetracker.demo.service;

import com.timetracker.demo.model.User;

import java.util.HashMap;

public class UserDatabase {
    // username and the user
    private HashMap<String, User> users;

    public UserDatabase() {
        this.users = new HashMap<>();
    }

    /**
     * Add a new username to the users list
     * @param username a non-empty string
     * @throws Exception if args are empty
     */
    public void addUser(String username, String password, int type) throws Exception {
        User user = new User(username, password, type);
        users.put(username, user);
    }


    public User getUser(String username) {
        return users.get(username);
    }

    public boolean existsUser(String username) {
        return users.containsKey(username);
    }

    public boolean checkLogin(String username, String password) throws Exception {
        return users.get(username).getPassword().equals(User.hashPassword(password));
    }
}
