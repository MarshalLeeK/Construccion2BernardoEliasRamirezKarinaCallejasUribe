/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author berna
 */
@Setter
@Getter
@NoArgsConstructor
public class Veterinarian extends Person{
    private long idVeterinarian;
    private String role; 
    private String userName;    
    private String password; 
    
    public long getIdVeterinarian() {
		return idVeterinarian;
	}
	public void setIdVeterinarian(long idVeterinarian) {
		this.idVeterinarian = idVeterinarian;
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
