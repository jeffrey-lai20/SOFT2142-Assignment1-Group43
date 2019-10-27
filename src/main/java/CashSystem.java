import java.util.*;

public class CashSystem {


    public void cashInput(double cost){
        System.out.print("\nYour total value is : $"+ cost);
        Scanner user= new Scanner(System.in);
        double inputtedVal = 0;
        while((Math.round(inputtedVal * 10) / 10.0)<cost){
            cashChoiceText();
            String input = user.nextLine();
            if(input.equals("9")){
                System.out.print("Transaction cancelled. See you next time!\n");
                return;
            }
            List<Integer> userInput = inputChecker(input);
            inputtedVal += cashHandler(userInput);
            if(inputtedVal>=cost||(Math.round(inputtedVal * 10) / 10.0)>=cost){
                changeSystem(cost,inputtedVal);
            }
            else{
                System.out.print("Total inputted cash value:"+Math.round(inputtedVal * 10) / 10.0+"\n");;
                System.out.print("Remaining value:");
                System.out.printf("%.1f",(cost - inputtedVal));
            }
        }
    }
    //prints out input menu
    void cashChoiceText(){
        System.out.print("\nPlease choose the note or coin value,\n");
        System.out.print("Followed by the amount to be inputted:\n");
        System.out.print("(E.g. 1 10 = $200 inputted )\n");
        System.out.print("    1. $20 note\n");
        System.out.print("    2. $10 note\n");
        System.out.print("    3.  $5 note\n");
        System.out.print("    4.  $2 coin\n");
        System.out.print("    5.  $1 coin\n");
        System.out.print("    6. 50c coin\n");
        System.out.print("    7. 20c coin\n");
        System.out.print("    8. 10c coin\n");
        System.out.print("    9. Cancel Transaction\n");
    }

    //check if input is valid
    List<Integer> inputChecker(String input){
        String[] splitter = input.split(" ");
        List<Integer> finalList = new ArrayList<>();
        try{
            finalList.add(Integer.parseInt(splitter[0]));
            finalList.add(Integer.parseInt(splitter[1]));
            return finalList;
        }catch (Exception e){
            System.out.println("Error input please check again.");
            System.out.println("Please make sure only input number in the following format:");
            System.out.println("<cash><space><amount>");
        }
        List<Integer> emptyList = new ArrayList<>();
        emptyList.add(0);
        emptyList.add(0);
        return emptyList;
    }

    //Determines the user input value
    double cashHandler(List<Integer> choice){
        switch (choice.get(0)){
           case 1 :
                return 20*choice.get(1);
            case 2 :
                return 10*choice.get(1);
            case 3 :
                return 5*choice.get(1);
            case 4 :
                return 2*choice.get(1);
            case 5 :
                return choice.get(1);
            case 6 :
                return 0.5*choice.get(1);
            case 7 :
                return 0.2*choice.get(1);
            case 8 :
                return 0.1*choice.get(1);
            case 9:

                return -1;
            default:
                System.out.println("Invalid input, please make sure to input the given choice.");
               return 0;
        }
    }

    //manages the change to user
    double changeSystem(double cost, double inputCash){
        double changeValue= inputCash - cost;
        changeValue = Math.round(changeValue * 10) / 10.0;
         if(changeValue>=20){
            moreThan20(changeValue);
        }
        else if(changeValue>=10){
            moreThan10(changeValue);
        }
        else if(changeValue>=5){
            moreThan5(changeValue);
        }
        else if(changeValue>=2){
            moreThan2(changeValue);
        }
        else if(changeValue>=1){
            moreThan1(changeValue);
        }
        else if (changeValue>=0.5){
            moreThan05(changeValue);
        }
        else if(changeValue>=0.2){
            moreThan02(changeValue);
        }
        else if(changeValue>=0.1){
            moreThan01(changeValue);
        }
        else{
            changeValue=0.0;
         }
        System.out.print("Thank you for purchasing!\n");
        System.out.print("Please collect your change: $"+changeValue+"\n");
        return changeValue;
    }

    //calculates the value of inputted change
    private void moreThan20(double cost){
        double numberOf20Notes = Math.floor(cost/20);
        double remainingCost = cost%20;

        double numberOf10Notes = Math.floor((remainingCost)/10);
        remainingCost = remainingCost%10;

        double numberOf5Notes =  Math.floor((remainingCost)/5);
        remainingCost = remainingCost%5;

        double numberOf2Coins =  Math.floor((remainingCost)/2);
        remainingCost = remainingCost%2;

        double numberOf1Coins =  Math.floor((remainingCost)/1);
        remainingCost =remainingCost%1;

        double numberOf5Cents =  Math.floor((remainingCost)/0.5);
        remainingCost = remainingCost%0.5;

        double numberOf2Cents =  Math.floor((remainingCost)/0.2);
        remainingCost = remainingCost%0.2;

        double numberOf1Cents =  Math.floor((remainingCost)/0.1);

        System.out.println("$20:"+ numberOf20Notes);
        System.out.println("$10:"+ numberOf10Notes);
        System.out.println("$5:"+ numberOf5Notes);
        System.out.println("$2:"+ numberOf2Coins);
        System.out.println("$1:"+ numberOf1Coins);
        System.out.println("$0.5:"+ numberOf5Cents);
        System.out.println("$0.2:"+ numberOf2Cents);
        System.out.println("$0.1:"+ numberOf1Cents);
    }
    private void moreThan10(double cost){

        double numberOf10Notes = Math.floor((cost)/10);
        double remainingCost = cost%10;

        double numberOf5Notes =  Math.floor((remainingCost)/5);
        remainingCost = remainingCost%5;

        double numberOf2Coins =  Math.floor((remainingCost)/2);
        remainingCost = remainingCost%2;

        double numberOf1Coins =  Math.floor((remainingCost)/1);
        remainingCost =remainingCost%1;

        double numberOf5Cents =  Math.floor((remainingCost)/0.5);
        remainingCost = remainingCost%0.5;

        double numberOf2Cents =  Math.floor((remainingCost)/0.2);
        remainingCost = remainingCost%0.2;

        double numberOf1Cents =  Math.floor((remainingCost)/0.1);

        System.out.println("$10:"+ numberOf10Notes);
        System.out.println("$5:"+ numberOf5Notes);
        System.out.println("$2:"+ numberOf2Coins);
        System.out.println("$1:"+ numberOf1Coins);
        System.out.println("$0.5:"+ numberOf5Cents);
        System.out.println("$0.2:"+ numberOf2Cents);
        System.out.println("$0.1:"+ numberOf1Cents);
    }
    private void moreThan5(double cost){
        double numberOf5Notes =  Math.floor((cost)/5);
        double remainingCost = cost%5;

        double numberOf2Coins =  Math.floor((remainingCost)/2);
        remainingCost = remainingCost%2;

        double numberOf1Coins =  Math.floor((remainingCost)/1);
        remainingCost =remainingCost%1;

        double numberOf5Cents =  Math.floor((remainingCost)/0.5);
        remainingCost = remainingCost%0.5;

        double numberOf2Cents =  Math.floor((remainingCost)/0.2);
        remainingCost = remainingCost%0.2;

        double numberOf1Cents =  Math.floor((remainingCost)/0.1);
        System.out.println("$5:"+ numberOf5Notes);
        System.out.println("$2:"+ numberOf2Coins);
        System.out.println("$1:"+ numberOf1Coins);
        System.out.println("$0.5:"+ numberOf5Cents);
        System.out.println("$0.2:"+ numberOf2Cents);
        System.out.println("$0.1:"+ numberOf1Cents);
    }
    private void moreThan2(double cost){

        double numberOf2Coins =  Math.floor((cost)/2);
        double remainingCost = cost%2;

        double numberOf1Coins =  Math.floor((remainingCost)/1);
        remainingCost =remainingCost%1;

        double numberOf5Cents =  Math.floor((remainingCost)/0.5);
        remainingCost = remainingCost%0.5;

        double numberOf2Cents =  Math.floor((remainingCost)/0.2);
        remainingCost = remainingCost%0.2;

        double numberOf1Cents =  Math.floor((remainingCost)/0.1);

        System.out.println("$2:"+ numberOf2Coins);
        System.out.println("$1:"+ numberOf1Coins);
        System.out.println("$0.5:"+ numberOf5Cents);
        System.out.println("$0.2:"+ numberOf2Cents);
        System.out.println("$0.1:"+ numberOf1Cents);
    }
    private void moreThan1(double cost){
        double numberOf1Coins =  Math.floor((cost)/1);
        double remainingCost =cost%1;

        double numberOf5Cents =  Math.floor((remainingCost)/0.5);
        remainingCost = remainingCost%0.5;

        double numberOf2Cents =  Math.floor((remainingCost)/0.2);
        remainingCost = remainingCost%0.2;

        double numberOf1Cents =  Math.floor((remainingCost)/0.1);

        System.out.println("$1:"+ numberOf1Coins);
        System.out.println("$0.5:"+ numberOf5Cents);
        System.out.println("$0.2:"+ numberOf2Cents);
        System.out.println("$0.1:"+ numberOf1Cents);
    }
    private void moreThan05(double cost){
        double numberOf5Cents =  Math.floor((cost)/0.5);
        double remainingCost = cost%0.5;

        double numberOf2Cents =  Math.floor((remainingCost)/0.2);
        remainingCost = remainingCost%0.2;

        double numberOf1Cents =  Math.floor((remainingCost)/0.1);

        System.out.println("$0.5:"+ numberOf5Cents);
        System.out.println("$0.2:"+ numberOf2Cents);
        System.out.println("$0.1:"+ numberOf1Cents);
    }
    private void moreThan02(double cost){
        double numberOf2Cents =  Math.floor((cost)/0.2);
        double remainingCost = cost%0.2;
        double numberOf1Cents =  Math.floor((remainingCost)/0.1);

        System.out.println("$0.2:"+ numberOf2Cents);
        System.out.println("$0.1:"+ numberOf1Cents);
    }
    private void moreThan01(double cost){
        double numberOf1Cents = cost/0.1;
        System.out.println("$0.1:"+ numberOf1Cents);
    }


}
