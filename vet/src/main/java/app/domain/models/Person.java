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
@Setter
@Getter
@NoArgsConstructor
/*
*Se crea la clase persona para registrar la informacion general de
*ADMINISTRADOR,MEDICO VETERINARIO,DUEÑO DE MASCOTA Y VENDEDOR
*/

public class Person {
    
    private long idPerson;
    private String name;
    private long document; 
    private long age;
    
    /* public Person(long idPerson, String name, long document, int age) {
        this.idPerson = idPerson;
        this.name = name;
        this.document = document;
        this.age = age;
    }*/
     public long getIdPerson() {
		return idPerson;
	}
	public void setIdPerson(long idPerson) {
		this.idPerson = idPerson;
	}
	public long getDocument() {
		return document;
	}
	public void setDocument(long document) {
		this.document = document;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getAge() {
		return age;
	}
	public void setAge(long age) {
		this.age = age;
	}
    
}
