/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.adapters.persons.repository;

import app.adapters.persons.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author berna
 */
/*@Repository*/
public interface PersonRepository extends JpaRepository<PersonEntity, Long>{
    boolean existsByDocument(long document);

    PersonEntity findByDocument(long document);
    
    PersonEntity findByIdPerson(long idPerson);
    
}
