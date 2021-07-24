package FreeForm;

import FreeForm.dao.UsersDao;
import FreeForm.dao.UsersDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;;

@SpringBootApplication
public class FreeFormApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(FreeFormApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String email = "1111@hotmail.com";
		String name = "11111";

		UsersDaoImpl us = new UsersDaoImpl(jdbcTemplate);
		us.insertUser(email,name);
	}

}
