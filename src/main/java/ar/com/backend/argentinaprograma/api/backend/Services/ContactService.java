/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.backend.argentinaprograma.api.backend.Services;


import ar.com.backend.argentinaprograma.api.backend.Models.Contact;
import ar.com.backend.argentinaprograma.api.backend.Repositories.ContactRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    public ArrayList<Contact> getAllContact() {
        return (ArrayList<Contact>) contactRepository.findAll();
    }

    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact getContactByID(Long id) {
        return contactRepository.findById(id).get();
    }

    public boolean deleteById(Long id) {
        try {
            contactRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Contact> getContactByPersonId(Long personId) {
           return contactRepository.findAllByPersonId(personId);
    }

}
