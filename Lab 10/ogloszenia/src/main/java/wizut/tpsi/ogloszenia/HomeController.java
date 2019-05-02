package wizut.tpsi.ogloszenia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import wizut.tpsi.ogloszenia.services.OffersService;

@Controller
public class HomeController {

    @Autowired
    OffersService offersService;

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("producent", offersService.getCarManufacturer(2));
        model.addAttribute("model", offersService.getModel(3));
        return "home";
    }
}
