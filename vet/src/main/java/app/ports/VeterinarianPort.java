/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.ports;

import app.domain.models.Person;
import app.domain.models.Veterinarian;
import java.util.List;

/**
 *
 * @author berna
 */
public interface VeterinarianPort{
    
     // Guardar un veterinario
    public void saveVeterinarian(Veterinarian veterinarian);
    
    // Obtenemos todos las veterinarios registrados
    public List<Veterinarian> getAllVeterinarians(); 
    
    //Creamos este metodo para buscar por el UserName
    public Veterinarian findByUserName(Veterinarian userName); 
 
    //Para realizar la validacion si ya existe el UserName
    public boolean existsByUserName(String userName); 
    
    //Para realizar la busqueda de un veterinario con un idPerson
    public Veterinarian findByIdPerson(Person person);
    
}
