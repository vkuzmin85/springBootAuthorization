package ru.netology.springbootuserauthorization.model;


import java.util.Comparator;
import java.util.Objects;

public class User {
    private String user;
    private String password;

    public User(String user, String password){
        this.user =user;
        this.password = password;
    }

    public String getName() {
        return user;
    }

    public String getPassword() {
        return password;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user1 = (User) o;
        return getName().equals(user1.getName()) && getPassword().equals(user1.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPassword());
    }

}

