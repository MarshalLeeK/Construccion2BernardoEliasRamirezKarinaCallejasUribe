/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.adapater.pets.entity;

import app.domain.models.Person;
import app.domain.models.Pet;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author berna
 */
@Entity
@Table(name="pet")
public class PetEntity {
   
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idPet")
	private long idPet;
        @Column(name = "documentOwner", nullable = false)
        private long documentOwner;
	@Column(name = "name")
	private String name;
	@Column(name = "age")
	 private int age;
        @Column(name = "breed")
	 private String breed;
        @Column(name = "species")
	 private String species;
        @Column(name = "weight")
	 private double weight;
        @Column(name = "features")
	 private String features;
        

    
     public long getIdPet() {
		return idPet;
	}
	public void setIdPet(long idPet) {
		this.idPet = idPet;
	}
        
        public long getDocumentOwner() {
            return documentOwner;
        }

        public void setDocumentOwner(long documentOwner) {
            this.documentOwner = documentOwner;
        }
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
        
        public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
        
         public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
        
        public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
        
        public String getFeatures() {
		return features;
	}
	public void setFeatures(String features) {
		this.features = features;
	}
}
