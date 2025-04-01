/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.domain.models;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
       
/**
 *
 * @author berna
 */
/**
 * Este modelo de dominio es para representar una mascota.
 * No tiene anotaciones de persistencia, ya que se usa en la capa de dominio.
 * La encargada de la persistencia de datos con la Base de datos es la PetEntity
 */
@Setter
@Getter
@NoArgsConstructor
public class Pet{
    
    private long idPet;
    private long documentOwner;
    private String name;
    private int age;
    private String breed;     
    private String species;   
    private double weight;    
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
