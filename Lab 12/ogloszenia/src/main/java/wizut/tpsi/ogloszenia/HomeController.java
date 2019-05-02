package wizut.tpsi.ogloszenia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import wizut.tpsi.ogloszenia.jpa.*;
import wizut.tpsi.ogloszenia.services.OffersService;
import wizut.tpsi.ogloszenia.web.OfferFilter;

import javax.validation.Valid;
import java.util.List;
@SuppressWarnings("Duplicates")
@Controller
public class HomeController {

    @Autowired
    OffersService offersService;

    @GetMapping("/")
    public String home(Model model, OfferFilter offerFilter){
        List<CarManufacturer> carManufacturers = offersService.getCarManufacturers();
        List<CarModel> carModels = offersService.getCarModels();

        List<Offer> offers;

        if(offerFilter.getManufacturerId()==null && offerFilter.getModelId()==null){    //pierwsze ladowanie
            offers = offersService.getOffers(offerFilter);
            carModels=null;
        }
        else if(offerFilter.getManufacturerId()!=null && offerFilter.getModelId()==null){     //wybrano tylko marke
            offers = offersService.getOffers(offerFilter);
            carModels = offersService.getCarModels(offerFilter.getManufacturerId());
        }
        else if(offerFilter.getManufacturerId()!=null && offerFilter.getModelId()!=null){
            offers= offersService.getOffers(offerFilter);
            carModels = offersService.getCarModels(offerFilter.getManufacturerId());
        }
        else {
            offers = offersService.getOffers(offerFilter);
            carModels=null;
        }


        List<FuelType> fuelTypes = offersService.getFuelTypes();



        List<BodyStyle> bodyStyles = offersService.getBodyStyles();


        model.addAttribute("offerFilter", offerFilter);

        model.addAttribute("fuelTypes", fuelTypes);
        model.addAttribute("carManufacturers",carManufacturers);
        model.addAttribute("carModels",carModels);
        model.addAttribute("offers", offers);



        return "offersList";
    }

    @GetMapping("/offer/{id}")
    public String offerDetails(Model model, @PathVariable("id") Integer id){
        Offer offer = offersService.getOffer(id);
        model.addAttribute("offer", offer);
        return "offerDetails";
    }

    @GetMapping("/newoffer")
    public String newOfferForm(Model model, Offer offer){

        List<CarModel> carModels = offersService.getCarModels();
        List<BodyStyle> bodyStyles = offersService.getBodyStyles();
        List<FuelType> fuelTypes = offersService.getFuelTypes();

        model.addAttribute("carModels", carModels);
        model.addAttribute("bodyStyles", bodyStyles);
        model.addAttribute("fuelTypes", fuelTypes);

        return "offerForm";
    }


    @PostMapping("/newoffer")
    public String saveNewOffer(Model model, @Valid Offer offer, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            List<CarModel> carModels = offersService.getCarModels();
            List<BodyStyle> bodyStyles = offersService.getBodyStyles();
            List<FuelType> fuelTypes = offersService.getFuelTypes();

            model.addAttribute("carModels", carModels);
            model.addAttribute("bodyStyles", bodyStyles);
            model.addAttribute("fuelTypes", fuelTypes);

            return "offerForm";
        }
        offer = offersService.createOffer(offer);

        return "redirect:/offer/" + offer.getId();
    }



}
