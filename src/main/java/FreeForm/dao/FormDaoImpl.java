package FreeForm.dao;

import FreeForm.entities.Form;
import FreeForm.mapper.FormMapper;
import FreeForm.utilities.Generator;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;

public class FormDaoImpl implements FormDao {

    private JdbcTemplate jdbcTemplate;

    public FormDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Form> retrieveAllForms() {

        String sql = "SELECT * FROM form";
        List<Form> forms = jdbcTemplate.query(sql, new FormMapper());
        return forms;

    }

    @Override
    public void createNewForm(String name, String description) {

        String sql = "INSERT INTO form(\"FormId\", \"Name\", \"Description\", \"DateCreated\") VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, Generator.generateRandomString(8), name, description, new Date());

    }

}
