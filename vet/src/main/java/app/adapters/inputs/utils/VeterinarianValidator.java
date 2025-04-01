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
public class VeterinarianValidator extends SimpleValidator{
    
    public long idPersonValidator(String value)throws Exception {
	return longValidator(value, " idPerson de Veterinario ");
    }
    
    public String userNameValidator(String value) throws Exception{
        return stringValidator(value, " nombre de usuario ");
    }
    
    public String passwordValidator(String value) throws Exception{
        return stringValidator(value, " contraseña de usuario ");
    }
    
}
