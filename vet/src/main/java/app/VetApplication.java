package app;

import app.adapters.inputs.AdminInput;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Setter
@Getter
@NoArgsConstructor
public class VetApplication implements CommandLineRunner {

   @Autowired
    private AdminInput adminInput;
    
     /*public VeterinariaApplication(AdminInput adminInput) {
        this.adminInput = adminInput;
    }*/

	public static void main(String[] args) {
		SpringApplication.run(VetApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        adminInput.menu();
     }

}
