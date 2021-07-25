package FreeForm.rest;

import FreeForm.dao.FormDaoImpl;
import FreeForm.dao.UsersDaoImpl;
import FreeForm.entities.Form;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FormController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

     @GetMapping("/retrieveAllForms")
     ResponseEntity<List<Form>> retrieveAllForms() {
        System.out.println("retrieveAllForms called");

        FormDaoImpl dao = new FormDaoImpl(jdbcTemplate);
        List<Form> forms = dao.retrieveAllForms();

        return ResponseEntity.ok(forms);
    }

    @PutMapping("/createNewForm")
    ResponseEntity createNewForm(@RequestBody Form newForm) {
        System.out.println("createNewForm called");

        FormDaoImpl dao = new FormDaoImpl(jdbcTemplate);
        try {
            dao.createNewForm(newForm.getName(),newForm.getDescription());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

}
