import java.util.*;

public class CashSystem {
    private HashMap cash =new HashMap<String, Double>(){{
        {
            put("$5",5.0);
            put("$10",10.0);
            put("$20",20.0);
            put("10c",0.1);
            put("20c",0.2);
            put("50c",0.5);
            put("$1",1.0);
            put("$2",2.0);
        }
    }};

    public CashSystem(){}

    public double cashInput(String input){
        double inputtedVal = 0;
        boolean end = false;
        while(!end){
            System.out.println("Please choose the note or coin value,");
            System.out.println("Followed by the amount of that value after a space:");
            System.out.println("(E.g. 1 10 = $200 inputted )");
            System.out.println("    1. $20 note");
            System.out.println("    2. $10 note");
            System.out.println("    3.  $5 note");
            System.out.println("    4.  $2 coin");
            System.out.println("    5.  $1 coin");
            System.out.println("    6. 50c coin");
            System.out.println("    7. 20c coin");
            System.out.println("    8. 10c coin");
            System.out.println("    9. Finish input.");
            if(cashHandler(inputChecker(input))==-1){
                end = true;
                return inputtedVal;
            }
            inputtedVal+= cashHandler(inputChecker(input));
        }
        return 0;
    }

    private List<Integer> inputChecker(String input){
        String[] splitter = input.split(" ");
        List<Integer> finalList = new ArrayList<>();
        try{
            finalList.add(Integer.parseInt(splitter[0]));
            finalList.add(Integer.parseInt(splitter[1]));
        }catch (Exception e){
            System.out.println("Please make sure only input number in the following format:");
            System.out.println("<cash><space><amount>");
        }
        return null;
    }
    private double cashHandler(List<Integer> choice){
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
                return 1*choice.get(1);
            case 6 :
                return 0.5*choice.get(1);
            case 7 :
                return 0.2*choice.get(1);
            case 8 :
                return 0.1*choice.get(1);
            case 9:
                return -1;
            default:
                System.out.println("Error input please check again.");
        }
        return 0;
    }
    public void cashInputCheck(double cost,double inputCash){
        if(inputCash<cost){
            System.out.println("The cash inputted is not enough.");
            System.out.println("Please enter more coins or notes.");
            System.out.println("Remaining to be paid: "+-(inputCash-cost));
        }
        else{
            changeSystem(cost,inputCash);
        }
    }
    public void transaction(String input){
        double userInput = cashInput(input);
        cashInputCheck(100,userInput);

    }
    public double changeSystem(double cost,double inputCash){

        double changeValue= inputCash- cost;

        System.out.println("Please collect your change:");
        System.out.println("Change value:" +changeValue);
        if(changeValue==0){
            System.out.println("$0");
        }
        else if(changeValue>=20){
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
        else{
            moreThan01(changeValue);
        }
        return changeValue;
    }

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
