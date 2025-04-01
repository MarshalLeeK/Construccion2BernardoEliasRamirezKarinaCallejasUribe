/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.adapater.pets.repository;

import app.adapater.pets.entity.PetEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author berna
 */
@Repository
public interface PetRepository extends JpaRepository<PetEntity, Long> {
    boolean existsByDocumentOwner(long documentOwner);
    /*Aqui devolvemos un listado ya que un dueño puede tener una o varias mascotas*/
    public List<PetEntity> findAllByDocumentOwner(long documentOwner);

}

