package controller;

import model.User;
import org.graalvm.compiler.lir.LIRInstruction;
import presistance.UserLoginRepository;

public class LoginUserController {
    UserLoginRepository userLoginRepository;

    public LoginUserController() {
        this.userLoginRepository = new UserLoginRepository();
    }

    public boolean validateUser(User user) {
        User user1 = userLoginRepository.searchUser(user);
        if (user1.getUserEmail()).equals(user.getUserEmail()) && user1.getUserPassword().equals(user.getUserPassword())
        return true;
        else{
            return false;
        }
    }
}

