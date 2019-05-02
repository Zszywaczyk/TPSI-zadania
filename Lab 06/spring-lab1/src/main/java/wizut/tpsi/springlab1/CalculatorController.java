package wizut.tpsi.springlab1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CalculatorController {
//x=Round(x*10^N)/10^N
    @RequestMapping("/calc")
    public String calc(){
        return "calc";
    }
    @RequestMapping("/calc/compute")
    public String compute(Model model, Integer xvalue, Integer yvalue){
        model.addAttribute("xvalue", xvalue);
        model.addAttribute("yvalue", yvalue);
        model.addAttribute("result", xvalue+yvalue);
        return "compute";
    }
    @RequestMapping("/calc/computeOperation")
    public String compute(Model model, Integer xvalue, Integer yvalue, String operation){
        model.addAttribute("xvalue", xvalue);
        model.addAttribute("yvalue", yvalue);
        String op="{not set}";
        Integer result= null;
        switch (operation) {
            case "dodawanie":
                op = "+";
                result = xvalue + yvalue;
                break;
            case "odejmowanie":
                op = "-";
                result = xvalue - yvalue;
                break;
            case "mnożenie":
                op = "*";
                result = xvalue * yvalue;
                break;
            case "dzielenie":
                op = "/";
                try {
                    result = xvalue / yvalue;
                }catch (ArithmeticException ae){
                    System.out.println("ArithmeticException occured!");
                }
                break;
        }

        model.addAttribute("operation", op);
        model.addAttribute("result", result);
        return "computeOp";
    }
    @RequestMapping("/calc/computeWithClass")
    public String compute(Model model, CalculatorForm calculatorForm){
        //calculatorForm = new CalculatorForm();
        //calculatorForm.initOperationSymbol();
        //calculatorForm.initResult();

        model.addAttribute("calculatorForm", calculatorForm);

        //model.addAttribute("xvalue", xvalue);

        return "computeClass";
    }
}
