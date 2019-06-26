package wizut.tpsi.ogloszenia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import wizut.tpsi.ogloszenia.components.Login;
import wizut.tpsi.ogloszenia.services.UsersService;

@Controller
public class UsersController {

    @Autowired
    Login login;

    @Autowired
    UsersService usersService;

    @PostMapping("/login")
    public String login(Model model, String login, String password){
        this.login.setLoginError(true);
        return "redirect:/1";
    }

}
