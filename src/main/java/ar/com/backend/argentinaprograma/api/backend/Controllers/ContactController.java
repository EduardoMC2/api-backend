
package ar.com.backend.argentinaprograma.api.backend.Controllers;

import ar.com.backend.argentinaprograma.api.backend.Models.Contact;
import ar.com.backend.argentinaprograma.api.backend.Models.Person;
import ar.com.backend.argentinaprograma.api.backend.Services.ContactService;
import ar.com.backend.argentinaprograma.api.backend.Services.PersonService;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/contacto") 
public class ContactController {
    
    @Autowired
    PersonService personService;
    
    @Autowired
    ContactService contactService;

    @GetMapping("/all")
    public ResponseEntity<List<Contact>> getAllContact() {
        List<Contact> contactoList = contactService.getAllContact();
        return new ResponseEntity<>(contactoList, HttpStatus.OK);
    }
    @GetMapping("/query")
    public ArrayList <Person> getPersonByEmail(@RequestParam("email") String email){
        return personService.getPersonByEmail(email);
    }
    @PostMapping("/person/{person_Id}")
    public ResponseEntity<Contact> createContact(@PathVariable(value = "person_Id") Long personId, @RequestBody Contact contactRequest) {
        Person p = personService.findById(personId);
        contactRequest.setPerson(p);
        Contact newContact = contactService.save(contactRequest);
        return new ResponseEntity<>(newContact, HttpStatus.CREATED);
        
    }
    
    @PutMapping("/{Id}")
    public ResponseEntity<Contact> updateComment(@PathVariable("Id") long Id, @RequestBody Contact contactRequest) {
        Contact contact = contactService.getContactByID(Id);
        contact.setPerson(contactRequest.getPerson());
        contactRequest.setId(contact.getId());
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true).setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.map(contactRequest, contact);

        return new ResponseEntity<>(contactService.save(contact), HttpStatus.OK);
    }
    @DeleteMapping("/{Id}")
    public ResponseEntity<HttpStatus> deleteContact(@PathVariable("Id") long Id) {
        contactService.deleteById(Id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
