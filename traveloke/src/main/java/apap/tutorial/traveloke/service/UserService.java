package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.RoleModel;
import apap.tutorial.traveloke.model.UserModel;
import apap.tutorial.traveloke.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel addUser(UserModel user);
    String encrypt(String password);
    UserModel findByUsername(String username);
    Boolean validasipassword(String passwordLama, String existPassword);
    void updatepassword(UserModel user, String passwordLama, String passwordBaru);
}
