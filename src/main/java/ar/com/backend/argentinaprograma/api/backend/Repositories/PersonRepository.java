/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.backend.argentinaprograma.api.backend.Repositories;

import ar.com.backend.argentinaprograma.api.backend.Models.Person;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    public abstract ArrayList<Person> findByApellido(String apellido);
}
