/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.adapters.veterinarians.repository;

import app.adapters.persons.entity.PersonEntity;
import app.adapters.veterinarians.entity.VeterinarianEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author berna
 */
@Repository
public interface VeterinarianRepository extends JpaRepository<VeterinarianEntity,Long>{
    
    // Buscar veterinario por idPerson
    public VeterinarianEntity findByIdPerson(PersonEntity personEntity);
    
    
    // Verificar si ya existe un veterinario con el userName
    boolean existsByUserName(String userName);

    // Buscar veterinario por userName
    public VeterinarianEntity findByUserName(String userName);

}
