package FreeForm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

@Component
@Repository("usersDao")
public class UsersDaoImpl implements UsersDao {

    private JdbcTemplate jdbcTemplate;

    public UsersDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertUser(String email, String name) {
        String sql = "INSERT INTO users (email, name) VALUES (?, ?)";
        int rows = jdbcTemplate.update(sql,email,name);
        if (rows > 0) {
            System.out.println("Created a new user.");
        } else {
            System.out.println("Failed to create a new user.");
        }
    }
}
