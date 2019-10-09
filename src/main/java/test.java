import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);

        CashSystem lol = new CashSystem();
        lol.transaction(input.next());
    }
}
