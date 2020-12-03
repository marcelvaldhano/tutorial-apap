package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.UserModel;
import apap.tutorial.traveloke.service.HotelService;
import apap.tutorial.traveloke.service.RoleService;
import apap.tutorial.traveloke.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PageController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

//    @Autowired
//    private UserService userService;

    @RequestMapping("/")
    public String home(Model model){
        UserModel user=userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("listRole",roleService.findAll());
        model.addAttribute("Id",user.getRole().getRole());
//        model.addAttribute("listUser",userService.findAll());
        return "home";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/updatePassword")
    private String updatePasswordForm(Model model) {
        model.addAttribute("page", "Update Password");
        return "update-password";
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    public String updatePasswordSubmit(
            @RequestParam("passwordLama") String passwordLama,
            @RequestParam("passwordBaru") String passwordBaru,
            @RequestParam("konfirmasi") String konfirmasi,
            Model model
    ){
        if(!passwordBaru.equals(konfirmasi)){
            return "password-error";
        }
        else{
            UserModel user = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
            userService.updatepassword(user, passwordLama, passwordBaru);
            return "password-done";
        }
    }
}
