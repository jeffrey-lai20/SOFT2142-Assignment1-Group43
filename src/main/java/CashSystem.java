import java.util.HashMap;
import java.util.Map;

public class CashSystem {
    private Map<String,Double> notes =new HashMap<>();
    private Map<String,Double> coins =new HashMap<>();

    public CashSystem(){}
    private void notesInitialization(){
        notes.put("$5",5.0);
        notes.put("$10",10.0);
        notes.put("$20",20.0);
    }
    private void coinsInitialization(){
        coins.put("10c",0.1);
        coins.put("20c",0.2);
        coins.put("50c",0.5);
        coins.put("$1",1.0);
        coins.put("$2",2.0);
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
