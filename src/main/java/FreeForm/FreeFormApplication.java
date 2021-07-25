package FreeForm;

import FreeForm.dao.UsersDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class FreeFormApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(FreeFormApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String email = "jianyiee96@hotmail.com";
		String name = "Jian Yiee";

		UsersDaoImpl us = new UsersDaoImpl(jdbcTemplate);
		us.insertUser(email,name);
	}

}
