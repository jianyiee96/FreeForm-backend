package FreeForm.dao;

import FreeForm.entities.Form;

import java.util.List;

public interface FormDao {

    public List<Form> retrieveAllForms();

    public void createNewForm(String name, String description);

}
