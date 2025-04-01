/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.adapters.persons;

import app.adapters.persons.entity.PersonEntity;
import app.adapters.persons.repository.PersonRepository;
import app.domain.models.Person;
import app.ports.PersonPort;
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
public class PersonAdapter implements PersonPort{
    /*@Autowired
    private PersonRepository personRepository;
    */
    
    private final PersonRepository personRepository;
    @Autowired
     public PersonAdapter(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public boolean existPerson(long document) {
      return personRepository.existsByDocument(document);
    }
    

    @Override
	public void savePerson(Person person) {
		PersonEntity personEntity = personAdapter(person);
		personRepository.save(personEntity);
		person.setIdPerson(personEntity.getIdPerson());
	}


    /*@Override
    public Person findByDocument(long document) {
        PersonEntity personEntity = personRepository.findByDocument(document);
	return personAdapter(personEntity);
     
    }*/
        
    @Override
    public Person findByDocument(long document) {
        PersonEntity personEntity = personRepository.findByDocument(document);
	return personEntity!=null?personAdapter(personEntity):null;
     
    }
    

    

    private Person personAdapter(PersonEntity personEntity) {
     Person person= new Person();
     person.setIdPerson(personEntity.getIdPerson());
     person.setDocument(personEntity.getDocument());
     person.setName(personEntity.getName());
     person.setAge(personEntity.getAge());
     return person;
    }
    
    
    private PersonEntity personAdapter(Person person) {
		PersonEntity personEntity = new PersonEntity();
		personEntity.setIdPerson(person.getIdPerson());
		personEntity.setDocument(person.getDocument());
		personEntity.setName(person.getName());
		personEntity.setAge(person.getAge());
		return personEntity;
	}

    @Override
    public Person findByIdPerson(long idPerson) {
      PersonEntity personEntity = personRepository.findByDocument(idPerson);
	return personEntity!=null?personAdapter(personEntity):null;
    }
    
    
    
    
}
