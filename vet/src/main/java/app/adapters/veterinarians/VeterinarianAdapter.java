/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.adapters.veterinarians;

import app.adapters.persons.entity.PersonEntity;
import app.adapters.veterinarians.entity.VeterinarianEntity;
import app.adapters.veterinarians.repository.VeterinarianRepository;
import app.domain.models.Person;
import app.domain.models.Veterinarian;
import app.ports.VeterinarianPort;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
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
public class VeterinarianAdapter implements VeterinarianPort{
    
    @Autowired
     private VeterinarianRepository veterinarianRepository;
  
     
     /*public VeterinarianAdapter(VeterinarianRepository veterinarianRepository) {
        this.veterinarianRepository = veterinarianRepository;
    }*/
     
    
    /*Para Saber si ya existe el userName indicado*/
    @Override
    public boolean existsByUserName(String userName) {
        return veterinarianRepository.existsByUserName(userName);
     }
 
     
    @Override
	public Veterinarian findByUserName(Veterinarian veterinarian) {
		VeterinarianEntity veterinarianEntity = veterinarianRepository.findByUserName(veterinarian.getUserName());
		if (veterinarianEntity == null){
			return null;
		}
		return veterinarianAdapter(veterinarianEntity);
	}
        
     @Override
        public Veterinarian findByIdPerson(Person person) {
            PersonEntity personEntity = personAdapter(person);
            VeterinarianEntity veterinarianEntity = veterinarianRepository.findByIdPerson(personEntity);

            if (veterinarianEntity == null) {
                return null;
            }
            return veterinarianAdapter(veterinarianEntity);
        }
        
    @Override
    public void saveVeterinarian(Veterinarian veterinarian) {
        VeterinarianEntity veterinarianEntity = veterinarianEntityAdapter(veterinarian);
        veterinarianRepository.save(veterinarianEntity);
        veterinarian.setIdVeterinarian(veterinarianEntity.getIdVeterinarian());
    }

        
    @Override
    public List<Veterinarian> getAllVeterinarians() {
        List<VeterinarianEntity> veterinarianEntities = veterinarianRepository.findAll();
        return veterinarianEntities.stream()
                .map(this::veterinarianAdapter)
                .collect(Collectors.toList());
    }
    
 
 /*Convertir los datos del VeterinarianAdadpter en VeterinarianEntity*/
      private Veterinarian veterinarianAdapter(VeterinarianEntity veterinarianEntity) {
        Veterinarian veterinarian = new Veterinarian();
        veterinarian.setIdVeterinarian(veterinarianEntity.getIdVeterinarian());
        veterinarian.setUserName(veterinarianEntity.getUserName());
        veterinarian.setPassword(veterinarianEntity.getPassword());
        veterinarian.setRole(veterinarianEntity.getRole());
        veterinarian.setIdPerson(veterinarianEntity.getIdPerson().getIdPerson());
        return veterinarian;
    }

    private VeterinarianEntity veterinarianEntityAdapter(Veterinarian veterinarian) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setIdPerson(veterinarian.getIdPerson());
        VeterinarianEntity veterinarianEntity = new VeterinarianEntity();
        veterinarianEntity.setIdPerson(personEntity);
        veterinarianEntity.setUserName(veterinarian.getUserName());
        veterinarianEntity.setPassword(veterinarian.getPassword());
        veterinarianEntity.setRole(veterinarian.getRole());
        return veterinarianEntity;
    }

    private PersonEntity personAdapter(Person person) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setIdPerson(person.getIdPerson());
        personEntity.setDocument(person.getDocument());
		personEntity.setName(person.getName());
		personEntity.setAge(person.getAge());
        return personEntity;
    }
}
