/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.backend.argentinaprograma.api.backend.Repositories;

import ar.com.backend.argentinaprograma.api.backend.Models.Education;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education, Long> {

    public List<Education> findAllByPersonId(Long personId);
    
}