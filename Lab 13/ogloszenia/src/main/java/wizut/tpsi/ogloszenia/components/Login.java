package wizut.tpsi.ogloszenia.components;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.context.annotation.SessionScope;
import wizut.tpsi.ogloszenia.jpa.User;

@SessionScope
@Component
public class Login {

    Boolean isLoginError=false;
    Boolean isLogged;
    User user;

    public Boolean getLogged() {
        return isLogged;
    }

    public void setLogged(Boolean logged) {
        isLogged = logged;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void loginError(Model model){
        if(isLoginError)
        model.addAttribute("loginError", "Zły login lub hasło");

        isLoginError=false;
    }

    public Boolean getLoginError() {
        return isLoginError;
    }

    public void setLoginError(Boolean loginError) {
        isLoginError = loginError;
    }
}
