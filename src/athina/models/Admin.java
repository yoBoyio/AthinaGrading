/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package athina.models;

/**
 *
 * @author dimi44
 */
public class Admin extends  User{
     public Admin(String username, String password, String firstName, String lastName,String email) {
        super(username, password, firstName, lastName,email);
    }
    
    
}
