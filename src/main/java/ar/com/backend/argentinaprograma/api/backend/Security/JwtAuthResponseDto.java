
package ar.com.backend.argentinaprograma.api.backend.Security;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class JwtAuthResponseDto {
    private String tokenDeAcceso;
    private String tipoDeToken = "Bearer";

    public JwtAuthResponseDto(String tokenDeAcceso) {
        super();
        this.tokenDeAcceso = tokenDeAcceso;
    }

    public JwtAuthResponseDto(String tokenDeAcceso, String tipoDeToken) {
        super();
        this.tokenDeAcceso = tokenDeAcceso;
        this.tipoDeToken = tipoDeToken;
    }
    
}
