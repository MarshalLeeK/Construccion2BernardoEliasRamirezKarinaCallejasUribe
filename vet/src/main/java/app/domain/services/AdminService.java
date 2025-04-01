/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.domain.services;


import app.domain.models.Person;
import app.domain.models.Pet;
import app.domain.models.Veterinarian;


import app.ports.PersonPort;
import app.ports.PetPort;
import app.ports.VeterinarianPort;


import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 *
 * @author berna
 */
@Setter
@Getter
@NoArgsConstructor
@Service
public class AdminService {
    @Autowired
    private PersonPort personPort;
    @Autowired
    private PetPort petPort;
    @Autowired
    private VeterinarianPort veterinarianPort;
     
    /* MÉTODOS PARA EL CONTROL DE PERSONAS */
     public void registerPerson(Person person)throws Exception{
        if(person==null){
            throw new Exception("No se permiten los datos nulos");
            }
            if (personPort.existPerson(person.getDocument())){
            throw new Exception("ya existe una persona con esa cedula");
            }
            if (person.getDocument()<=0){
               throw new Exception("El documento debe ser un numero valido");
            }
            personPort.savePerson(person);
     }
     
     /* MÉTODOS PARA EL CONTROL DE MASCOTAS */
 
     /*Registramos mascotas*/
     public void registerPet(Pet pet) throws Exception {
            if (pet == null) {
            throw new Exception("No se permiten datos nulos");
         }
            if (!personPort.existPerson(pet.getDocumentOwner())) {
            throw new Exception("No existe una persona registrada con esta cédula");
            }
            petPort.savePet(pet);
       }
     /*Listamos todas las  mascotas*/
     public List<Pet> getAllPets() {
        return petPort.getAllPets();
     }
     
     /*Listamos todas las mascotas asociadas a un dueño*/
     public List<Pet> getPetsByOwner(long documentOwner) throws Exception {
        if (!personPort.existPerson(documentOwner)) {
            throw new Exception("No existe un dueño registrado con esa cédula");
        }
        /*Generamos este caso solo cuando existe una cedula registrada como persona pero no tiene ninguna mascota asociada*/
        List<Pet> pets = petPort.getPetsByOwner(documentOwner);
        if (pets.isEmpty()) {
            throw new Exception("El dueño no tiene mascotas registradas");
        }
        return pets;
     }
     
     /* MÉTODOS PARA EL CONTROL DE VETERINARIOS */
    
     // Registrar veterinario
     public void registerVeterinarian(Veterinarian veterinarian) throws Exception {
        if (veterinarian == null) {
            throw new Exception("No se pueden dejar campos nulos");
        }

        // Verificamos si ya existe un veterinario con el mismo nombre de usuario
        if (veterinarianPort.existsByUserName(veterinarian.getUserName())) {
            throw new Exception("Ya existe un veterinario con ese nombre de usuario");
        }

        // Verificamos si ya existe una persona con la cédula del veterinario
        if (!personPort.existPerson(veterinarian.getDocument())) {
            throw new Exception("No existe una persona con esa cédula");
        }

        // Registramos el veterinario
        veterinarianPort.saveVeterinarian(veterinarian);
     }

        // Listar todos los veterinarios
      public List<Veterinarian> getAllVeterinarians() {
            return veterinarianPort.getAllVeterinarians();
      }
     
     
    
   
}
