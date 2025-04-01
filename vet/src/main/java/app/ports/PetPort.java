/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.ports;

import app.domain.models.Pet;
import java.util.List;

/**
 *
 * @author berna
 */
public interface PetPort {
   
    public boolean ownerHasPets(long documentOwner);  // Verifica si un dueño tiene mascotas registradas
    public void savePet(Pet pet);  // Guardamos una mascota,esta es la misma opcion que usamos en el Person
    public List<Pet> getAllPets(); // Obtenemos todas las mascotas registradas, aqui se hace sin un dueño especifico
    public List<Pet> getPetsByOwner(long documentOwner); // Obtenemos todas las mascotas registradas para un dueño
    
}


    

    