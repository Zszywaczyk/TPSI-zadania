package wizut.tpsi.springlab1;

import javax.annotation.PostConstruct;

public class CalculatorForm {
    private Double valueX;
    private Double valueY;
    private String operation;
    private String operationSymbol;
    private String result;

    public CalculatorForm(){
    }
    public void init(){
        initOperationSymbol();
        initResult();
    }

    public CalculatorForm(Double valueX, Double valueY, String operation) {
        this.valueX = valueX;
        this.valueY = valueY;
        this.operation = operation;
        /*innitttOperationSymbol();
        innitttResult();*/
    }

    public Double getValueX() {
        return valueX;
    }

    public String getOperationSymbol() {
        return operationSymbol;
    }

    public void initOperationSymbol() {
        switch (operation) {
            case "dodawanie":
                operationSymbol = "+";
                break;
            case "odejmowanie":
                operationSymbol = "-";
                break;
            case "mnożenie":
                operationSymbol = "*";
                break;
            case "dzielenie":
                operationSymbol = "/";
                break;

                default:
                    operationSymbol = "<not set>";
        }
    }

    public void initResult() {
        if(valueX!=null && valueY!=null){
            Double temp=null;
            switch (operation) {
                case "dodawanie":
                    temp = valueX + valueY;
                    temp = Math.round(temp*100.0)/100.0;
                    result = temp.toString();
                    break;
                case "odejmowanie":
                    temp = valueX - valueY;
                    temp = Math.round(temp*100.0)/100.0;
                    result = temp.toString();
                    break;
                case "mnożenie":
                    temp = valueX * valueY;
                    temp = Math.round(temp*100.0)/100.0;
                    result = temp.toString();
                    break;
                case "dzielenie":
                    if(valueY != 0) {
                        temp = valueX / valueY;
                        temp = Math.round(temp*100.0)/100.0;
                        result = temp.toString();
                    }
                    else {
                        result = "Error: dzielenie przez zero";
                    }
                    break;
                default:
                    result = "<not set>";
            }
        }
        else {
            result = "<not set>";
        }
    }

    public void setValueX(Double valueX) {
        this.valueX = valueX;
        initResult();
    }

    public Double getValueY() {
        return valueY;
    }

    public void setValueY(Double valueY) {
        this.valueY = valueY;
        initResult();
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
        initOperationSymbol();
    }

    public String getResult() {
        return result;
    }
}
