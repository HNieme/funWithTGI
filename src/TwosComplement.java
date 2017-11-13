import java.util.Scanner;

public class TwosComplement {
    public static void selection(){
        System.out.println("So please choose what you would like to calculate:");
        System.out.println("1) Multiplication:");
        System.out.println("Please enter a number (Like \"1\")");
        Scanner scanner = new Scanner(System.in);
        char selected = scanner.nextLine().charAt(0);
        switch (selected){
            case '1':
                System.out.println("Selected \"1) Multiplication\"");
                System.out.println("=====================================================");
                MultiplikationImZweierkomplement.multiplikation();
        }
    }
}
