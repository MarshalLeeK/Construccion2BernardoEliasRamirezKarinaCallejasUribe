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
/*Se crea un objeto en memoria que siempre trae del mismo tipo*/
@Component
public class SimpleValidator {
    
    public String stringValidator(String value, String element) throws Exception{
        if(value==null || value.equals("")){
            throw new Exception(element + "no tiene un valor valido");
        }
        return value;
    }
    
    /*Para caracteres bigInt*/
    public Long longValidator(String value, String element)throws Exception{
		try {
                    return Long.parseLong(stringValidator(value, element));
		}catch(Exception e) {
			throw new Exception(element + " debe ser un valor numérico");
		}
	}
    /*Para enteros,int*/
    public Integer intValidator(String value, String element)throws Exception{
		try {
                    return Integer.parseInt(stringValidator(value, element));
		}catch(Exception e) {
			throw new Exception(element + " debe ser un valor numérico");
		}
	}
    
    /*Para doubles*/
    public Double doubleValidator(String value, String element) throws Exception {
        try {
            return Double.parseDouble(stringValidator(value, element));
        } catch (NumberFormatException e) {
            throw new Exception(element + " debe ser un valor numérico decimal");
        }
    }
    
}
