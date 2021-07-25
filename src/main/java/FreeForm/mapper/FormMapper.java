package FreeForm.mapper;

import FreeForm.entities.Form;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FormMapper implements RowMapper<Form> {

    @Override
    public Form mapRow(ResultSet rs, int rowNum) throws SQLException {
        Form form = new Form();
        form.setFormId(rs.getString("FormId"));
        form.setName(rs.getString("Name"));
        form.setDescription(rs.getString("Description"));
        form.setDateCreated(rs.getDate("DateCreated"));
        return form;
    }

}
