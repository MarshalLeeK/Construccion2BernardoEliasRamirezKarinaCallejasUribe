/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.adapater.pets;

import app.adapater.pets.entity.PetEntity;
import app.adapater.pets.repository.PetRepository;
import app.adapters.persons.repository.PersonRepository;
import app.domain.models.Pet;
import app.ports.PetPort;
import java.util.List;
import java.util.stream.Collectors;
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
@Service
public class PetAdapter implements PetPort {
    
     private final PetRepository petRepository;
     private final PersonRepository personRepository;  // Agregamos el repositorio de Person
    @Autowired
     public PetAdapter(PetRepository petRepository,PersonRepository personRepository) {
        this.petRepository = petRepository;
        this.personRepository = personRepository;
    }

    @Override
    public boolean ownerHasPets(long documentOwner) {
      return petRepository.existsByDocumentOwner(documentOwner);
    }

    @Override
    public void savePet(Pet pet) {
       // Validamos si la cedula que asignaremos como dueño está registrada en la tabla Person
        if (!personRepository.existsByDocument(pet.getDocumentOwner())) {
            throw new IllegalArgumentException("El dueno con esta cedula no esta registrado en el sistema");
        }
 
                PetEntity petEntity = petAdapter(pet);
		petRepository.save(petEntity);
		pet.setIdPet(petEntity.getIdPet());
        }

    @Override
    public List<Pet> getAllPets() {
      return petRepository.findAll()
                .stream()
                .map(this::petAdapter)
                .collect(Collectors.toList());  
    }

    @Override
    public List<Pet> getPetsByOwner(long documentOwner) {
           return petRepository.findAllByDocumentOwner(documentOwner)
                .stream()
                .map(this::petAdapter)
                .collect(Collectors.toList()); 
    }
    
 
    private PetEntity petAdapter(Pet pet) {
                PetEntity petEntity = new PetEntity();
		petEntity.setIdPet(pet.getIdPet());
		petEntity.setDocumentOwner(pet.getDocumentOwner());
		petEntity.setName(pet.getName());
		petEntity.setAge(pet.getAge());
                petEntity.setBreed(pet.getBreed());
                petEntity.setSpecies(pet.getSpecies());
                petEntity.setWeight(pet.getWeight());
                petEntity.setFeatures(pet.getFeatures());
		return petEntity;
    }
    
    private Pet petAdapter(PetEntity petEntity) {
    Pet pet = new Pet();
    pet.setIdPet(petEntity.getIdPet());
    pet.setDocumentOwner(petEntity.getDocumentOwner());
    pet.setName(petEntity.getName());
    pet.setAge(petEntity.getAge());
    pet.setBreed(petEntity.getBreed());
    pet.setSpecies(petEntity.getSpecies());
    pet.setWeight(petEntity.getWeight());
    pet.setFeatures(petEntity.getFeatures());
    return pet;
}

    
}
