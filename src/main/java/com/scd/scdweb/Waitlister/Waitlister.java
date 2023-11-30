package com.scd.scdweb.Waitlister;

import jakarta.persistence.*;

@Entity
@Table(name = "waitlisters")
public class Waitlister {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userID", nullable = false, unique = true)
    private int id;
    @Column(name = "userEmail", nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    public String getEmail() {
        return this.email;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Waitlister(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }
    public Waitlister(){}

}
