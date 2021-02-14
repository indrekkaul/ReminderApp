package controller;

import model.Staff;
import persistence.RepositoryLoginStaff;

public class LoginStaffController {
    RepositoryLoginStaff repositoryLoginStaff;

    public LoginStaffController(RepositoryLoginStaff repositoryLoginStaff) {
        this.repositoryLoginStaff = new RepositoryLoginStaff();
    }

    public boolean validateStaff(Staff staff) {
        Staff staff1 = repositoryLoginStaff.searchUser(staff);
        if (staff1.getUsername().equals(staff.getUsername()) && staff1.getPassword().equals(staff.getPassword()))
            return true;
        else {
            return false;
        }
    }
}





