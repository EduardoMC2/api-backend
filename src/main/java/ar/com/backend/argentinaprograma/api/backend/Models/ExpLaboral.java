
package ar.com.backend.argentinaprograma.api.backend.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "expLaboral")
public class ExpLaboral implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;

    private Short aniocomiezo;
    
    private Short aniofinal;
    
    @Lob 
    private String description;
    
    
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_id", nullable = false)
    @OnDelete(action=OnDeleteAction.NO_ACTION)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Person person;

    
    public Person getPerson() {
        return person;
    }
   

    public void setPerson(Person person) {
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getAniocomiezo() {
        return aniocomiezo;
    }

    public void setAniocomiezo(Short aniocomiezo) {
        this.aniocomiezo = aniocomiezo;
    }

    public Short getAniofinal() {
        return aniofinal;
    }

    public void setAniofinal(Short aniofinal) {
        this.aniofinal = aniofinal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
 
}