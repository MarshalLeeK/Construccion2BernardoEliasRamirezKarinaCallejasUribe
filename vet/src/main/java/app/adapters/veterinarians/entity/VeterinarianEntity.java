/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.adapters.veterinarians.entity;

import app.adapters.persons.entity.PersonEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 *
 * @author berna
 */
@Entity
@Table(name="veterinarian")
public class VeterinarianEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idVeterinarian")
    private long idVeterinarian;
    
    @JoinColumn(name="idPerson")
    @OneToOne
    private PersonEntity idPerson;
    
    @Column(name = "userName")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;
    
    
        public long getIdVeterinarian() {
		return idVeterinarian;
	}
	public void setIdVeterinarian(long idVeterinarian) {
		this.idVeterinarian = idVeterinarian;
	}
        public PersonEntity getIdPerson() {
		return idPerson;
	}
	public void setIdPerson(PersonEntity idPerson) {
		this.idPerson = idPerson;
	}
        public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
    
}
