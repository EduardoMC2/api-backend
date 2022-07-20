
package ar.com.backend.argentinaprograma.api.backend.dto;

import lombok.Getter;
import lombok.Setter;


@Getter 
@Setter
public class Login {
    private String usernameOrEmail;
    private String password;
     



  public String getUserName() {
        return usernameOrEmail;
    }

    public void setUserName(String usernameOrEmail) {
        this.usernameOrEmail = usernameOrEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

}