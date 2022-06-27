/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.backend.argentinaprograma.api.backend.Repositories;


import ar.com.backend.argentinaprograma.api.backend.Models.Contact;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContactRepository extends JpaRepository<Contact, Long> {

    public List<Contact> findAllByPersonId(Long personId);
    
}
