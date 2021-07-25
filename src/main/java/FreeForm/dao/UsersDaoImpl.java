package FreeForm.dao;

import org.springframework.jdbc.core.JdbcTemplate;

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
