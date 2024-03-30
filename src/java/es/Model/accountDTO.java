/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.Model;

import java.io.Serializable;
/**
 *
 * @author nakyumdepzaii
 */
public class accountDTO implements Serializable {
    private int ID;
    private String username;
    private String password;
    private int role;

    public accountDTO() {
    }

    public accountDTO(int ID, String username, String password, int role) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getID() {
        return ID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getRole() {
        return role;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(int role) {
        this.role = role;
    }   
}
