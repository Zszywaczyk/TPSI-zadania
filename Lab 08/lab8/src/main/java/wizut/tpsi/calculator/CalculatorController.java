package wizut.tpsi.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;
    
    @RequestMapping("/")
    public String home() {
        return "index";
    }
    
    @PostMapping("/add")
    public String addNumbers(Model model, CalculatorForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "add";
        }
        int result = calculatorService.add(form.getX(), form.getY());
        
        form.setOperation("+");
        model.addAttribute("result", result);
        return "result";
    }

    @PostMapping("/multiply")
    public String multiplyNumbers(Model model, CalculatorForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "multiply";
        }
        int result = calculatorService.multiply(form.getX(), form.getY());
        
        form.setOperation("*");
        model.addAttribute("result", result);
        return "result";
    }

    @PostMapping("/calculate")
    public String doCalculations(Model model, CalculatorForm form, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "calculate";
        }
        int result = calculatorService.calculate(form.getX(), form.getY(), form.getOperation());
        
        model.addAttribute("result", result);
        
        return "result";
    }

    @GetMapping("/add")
    public String addForm(CalculatorForm form){
        return "add";
    }

    @GetMapping("/multiply")
    public String multiplyForm(CalculatorForm form){
        return "multiply";
    }

    @GetMapping("/calculate")
    public String calculateForm(CalculatorForm form){
        return "calculate";
    }

}
