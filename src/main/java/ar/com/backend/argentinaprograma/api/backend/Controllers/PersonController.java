
package ar.com.backend.argentinaprograma.api.backend.Controllers;

import ar.com.backend.argentinaprograma.api.backend.Models.Person;
import ar.com.backend.argentinaprograma.api.backend.Services.PersonService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/person") 
@CrossOrigin(origins = "http://localhost:4200")
public class PersonController {
    @Autowired
    PersonService personService;
    
    @GetMapping("/all")
    public ArrayList<Person> getAllPersons(){
        return personService.getAllPersons();
    }
    @PostMapping()
    public Person savePerson(@RequestBody Person person){
        return personService.savePerson(person);
        
    }
    @GetMapping("/{Id}")
    public Person getPersonById(@PathVariable("Id")Long Id){
        return personService.getPersonById(Id);
    }

  
    @GetMapping("/query")
    public ArrayList <Person> getPersonByApellido(@RequestParam("apellido") String apellido){
        return personService.getPersonByApellido(apellido);
    }
    @DeleteMapping ("/{Id}")
    public String removePerson(@PathVariable("Id")Long Id){
        if(personService.removePerson(Id)){
            return  "Se eliminĂ³ a la persona escogida por Id "+ Id +"correctamente";
        }else{
            return "La persona no exsite o no pudo ser eliminada";
        }
    }
    
}
