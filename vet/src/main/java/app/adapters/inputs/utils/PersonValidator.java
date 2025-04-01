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
public class PersonValidator extends SimpleValidator{
    public String nameValidator(String value) throws Exception{
        return stringValidator(value,"nombre de la persona");
    }
    
    public long documentValidator(String value)throws Exception {
		return longValidator(value, " numero de documento ");
	}
    public long ageValidator(String value)throws Exception{
        return longValidator(value, " edad de la persona ");
    }
}
