import java.util.*;

public class CashSystem {
    private double change;
    private double inputtedCash;
    public boolean cashInput(double cost){
        System.out.print("\nThe total cost is : $"+ cost);
        Scanner user= new Scanner(System.in);
        double inputtedVal = 0;
        while(inputtedVal<cost){
            cashChoiceText();
            String input = user.nextLine();
            if(input.equalsIgnoreCase("cancel")){
                System.out.print("Transaction cancelled. See you next time!\n");
                return false;
            }
            double userInput = inputChecker(input);
            inputtedVal += userInput;
            if(inputtedVal>=cost||(Math.round(inputtedVal * 10) / 10.0)>=cost){
                changeSystem(cost,inputtedVal);
                return true;
            }
            else{
                System.out.print("Total inputted cash value:"+Math.round(inputtedVal * 10) / 10.0+"\n");;
                System.out.print("Remaining value:");
                System.out.printf("%.1f",(cost - inputtedVal));
            }
        }
        return false;
    }
    //prints out input menu
    void cashChoiceText(){
        System.out.println("\nPlease enter the amount of cash to be inputted:" );
    }

    //check if input is valid
    double  inputChecker(String input){
        try{
            double finalInput= Double.parseDouble(input);
            return finalInput;
        }catch (Exception e){
            System.out.println("Error input please check again.");
            System.out.println("Please make sure only input number.");
            return 0;
        }
    }

    //manages the change to user
    double changeSystem(double cost, double inputCash){
        double changeValue= inputCash - cost;
        changeValue = Math.round(changeValue * 10) / 10.0;
        System.out.print("Thank you for purchasing !\n");
        System.out.print("Please collect your change: $"+changeValue+" and receipt.\n");
        this.change= changeValue;
        this.inputtedCash = inputCash;
        // System.exit(0);
        return changeValue;
    }

    double getChange(){
        return this.change;
    }
    double getInputtedCash(){
        return this.inputtedCash;
    }
}
