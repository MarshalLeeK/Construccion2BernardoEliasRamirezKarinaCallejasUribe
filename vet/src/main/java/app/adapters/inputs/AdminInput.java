/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.adapters.inputs;

import app.adapters.inputs.utils.PersonValidator;
import app.adapters.inputs.utils.PetValidator;
import app.adapters.inputs.utils.Utils;
import app.adapters.inputs.utils.VeterinarianValidator;
import app.domain.models.Person;
import app.domain.models.Pet;
import app.domain.models.Veterinarian;
import app.ports.InputPort;
import app.ports.PersonPort;
import app.ports.PetPort;
import app.ports.VeterinarianPort;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author berna
 */
@Setter
@Getter
@NoArgsConstructor
@Component
public class AdminInput{
    @Autowired
    private PersonValidator personValidator;
    @Autowired
    private PersonPort personPort;
     
    @Autowired
    private PetValidator petValidator;
     @Autowired
    private PetPort petPort;
     
     @Autowired
    private VeterinarianValidator veterinarianValidator;
    @Autowired
    private VeterinarianPort veterinarianPort;
     
    private final String MENU= "Ingrese la opcion:"
            +"\n 1.Registrar personas."
            +"\n 2.Registrar mascotas."
            + "\n 3.Listado mascotas."
            + "\n 4.Registrar veterinario."
            + "\n 5.Listado de Veterinarios Registrados."
            + "\n 6.Registrar orden."
            + "\n 7.Ver Ordenes."
            + "\n 8.Ver historial Clinico."
            + "\n 9.Registrar vendedor.";
            
    public void menu(){
        System.out.println(MENU);
        String option = Utils.getReader().nextLine();
         switch (option){
            case "1" -> {
                 try {
			this.createPerson();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
            }
            case "2" -> {
                 try {
			this.createPet();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
            }
            case "3" -> {
                 try {
			this.listAllPets();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
            }
             case "4" -> {
                 try {
			this.createVeterinarian();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
            }
             
             case "5" -> {
                 try {
			this.listAllVeterinarians();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
            }
          
         default -> System.out.println("opcion no valida");
     }
        
    }

    private void createPerson() throws Exception {
        System.out.println("Ingrese el nombre de la persona");
        String name=personValidator.nameValidator(Utils.getReader().nextLine());
        System.out.println("ingrese el documento de la persona");
	long document = personValidator.documentValidator(Utils.getReader().nextLine());
        System.out.println("ingrese la edad de  la persona");
	long age = personValidator.ageValidator(Utils.getReader().nextLine());
        Person person=new Person();
        person.setDocument(document);
        person.setName(name);
        person.setAge(age);
        personPort.savePerson(person);
        System.out.println("✅ Persona registrada con éxito.");  
     }
    
    
     private void createPet() throws Exception {
        System.out.println("ingrese el documento del dueño de la mascota");
	long documentOwner = petValidator.documentOwnerValidator(Utils.getReader().nextLine());

      // Validamos si el dueño existe antes de registrar la mascota
        if (!personPort.existPerson(documentOwner)) {
            throw new Exception("No existe una persona con ese documento.");
        }  
        
        System.out.println("Ingrese el nombre de la mascota");
        String name=petValidator.nameValidator(Utils.getReader().nextLine());
        System.out.println("ingrese la edad de  la mascota");
	int age = petValidator.ageValidator(Utils.getReader().nextLine());
        System.out.println("ingrese la raza de la mascota");
	String breed = petValidator.breedValidator(Utils.getReader().nextLine());
        System.out.println("ingrese la especie de la mascota");
	String species = petValidator.speciesValidator(Utils.getReader().nextLine());
        System.out.println("ingrese el peso de la mascota");
	Double weight = petValidator.weightValidator(Utils.getReader().nextLine());
        System.out.println("ingrese las caracteristicas de la mascota (Color,Altura,etc)");
	String features = petValidator.featuresValidator(Utils.getReader().nextLine());
        Pet pet=new Pet();
        pet.setDocumentOwner(documentOwner);
        pet.setName(name);
        pet.setAge(age);
        pet.setBreed(breed);
        pet.setSpecies(species);
        pet.setWeight(weight);
        pet.setFeatures(features);
        petPort.savePet(pet);
        System.out.println("✅ Mascota registrada con éxito.");  
     }

    private void listAllPets() throws Exception {
        // Creamos una lista para llamar todas las mascotas registradas
        //Esta lista se conecta con la interface PetPort que contiene el llamado de este metodo
         List<Pet> pets = petPort.getAllPets();

        // Validamos que primero si existan mascotas registradas en nuestra base de datos
        if (pets.isEmpty()) {
            System.out.println("No hay mascotas registradas en el sistema.");
        } else {
            System.out.println("Listado de todas las mascotas registradas:");
            for (Pet pet : pets) {
                System.out.println("ID: " + pet.getIdPet());
                System.out.println("Dueño (Documento): " + pet.getDocumentOwner());
                System.out.println("Nombre: " + pet.getName());
                System.out.println("Edad: " + pet.getAge());
                System.out.println("Raza: " + pet.getBreed());
                System.out.println("Especie: " + pet.getSpecies());
                System.out.println("Peso: " + pet.getWeight() + " kg");
                System.out.println("Características: " + pet.getFeatures());
                System.out.println("\n------------------------------------");
            }
          }
    }
    
    private void createVeterinarian() throws Exception {
        // Solicitar documento del veterinario (cédula)
        System.out.println("Ingrese el documento del veterinario");
        long document = personValidator.documentValidator(Utils.getReader().nextLine());

        // Buscar la persona en la base de datos Person con el documento proporcionado
        Person person = personPort.findByDocument(document);

        // Verificamos si la persona existe, es decir si esta registrada en nuestra base de datos Person
        if (person == null) {
            throw new Exception("No existe una persona con ese documento."
            +"\nAntes de registrar un veterinario debe ser registrado como persona");
        }
    
        System.out.println("la cedula se encuentra asociada al ID: " + person.getIdPerson());

        // Obtener el idPerson relacionado de la persona registrada
        long idPerson = person.getIdPerson();

        
        System.out.println("Ingrese el usuario para el Veterinario");
        String userName = veterinarianValidator.userNameValidator(Utils.getReader().nextLine());
        System.out.println("Ingrese la contraseña para el veterinario");
        String password = veterinarianValidator.passwordValidator(Utils.getReader().nextLine());
        Veterinarian veterinarian = new Veterinarian();
        // Asignamnos el idPerson de Person al veterinario
        veterinarian.setIdPerson(idPerson);
        veterinarian.setUserName(userName);
        veterinarian.setPassword(password);
        veterinarian.setRole("Veterinario");
      
        veterinarianPort.saveVeterinarian(veterinarian);

        System.out.println("✅ Veterinario registrado con éxito.");
    }
    
    
    private void listAllVeterinarians() throws Exception {
        /*Creamos una lista para llamar todos los veterinarios registrados
        Esta lista se conecta con la interface VeterinarianPort que contiene el llamado de este metodo*/
         List<Veterinarian> vets = veterinarianPort.getAllVeterinarians();

        // Validamos que primero si existan veterinarios registrados en nuestra base de datos
        if (vets.isEmpty()) {
            System.out.println("No hay veterinarios registrados en el sistema.");
        } else {
            System.out.println("Listado de todaos los veterinarios registrados:");
            for (Veterinarian veterinarian : vets) {
                System.out.println("ID: " + veterinarian.getIdVeterinarian());
                System.out.println("IdPerson " + veterinarian.getIdPerson());
                System.out.println("UserName: " + veterinarian.getUserName());
                System.out.println("Password: " + " ************ ");
                System.out.println("Rol: " + veterinarian.getRole());
                System.out.println("\n------------------------------------");
            }
          }
    }
    
    
}
