package FreeForm.rest;

import FreeForm.dao.UsersDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/users")
    String users() {
        System.out.println("Users called");

        String email = "jyjy@hotmail.com";
        String name = "Jian Yiee Jian Yiee";

        UsersDaoImpl us = new UsersDaoImpl(jdbcTemplate);
        us.insertUser(email,name);

        return "OK!";
    }


}
