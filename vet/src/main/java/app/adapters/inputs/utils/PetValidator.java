/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.adapters.inputs.utils;

import org.springframework.stereotype.Component;

/**
 *
 * @author berna
 */
@Component
public class PetValidator extends SimpleValidator{
    
    
    public long documentOwnerValidator(String value)throws Exception {
	return longValidator(value, " cedula del dueño ");
    }
    
    public String nameValidator(String value) throws Exception{
        return stringValidator(value,"nombre de la mascota").trim();
    }
    
    public int ageValidator(String value)throws Exception{
        return intValidator(value, " edad de la mascota ");
    }
    
    public String breedValidator(String value) throws Exception{
        return stringValidator(value,"raza de la mascota");
    }
    
    public String speciesValidator(String value) throws Exception{
        return stringValidator(value,"especie de la mascota");
    }
    
    public double weightValidator(String value)throws Exception{
        return doubleValidator(value, " peso de la mascota ");
    }
    
     public String featuresValidator(String value) throws Exception{
        return stringValidator(value,"Caracteristicas de la mascota");
    }
    
}
