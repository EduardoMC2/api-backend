/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.backend.argentinaprograma.api.backend.dto;

import lombok.Getter;
import lombok.Setter;


@Getter 
@Setter
public class Login {
    private String usernameOrEmail;
    private String password;
     
}


