import java.util.Scanner;

public class FunWithTGI {
    public static void main(String[] args) {
        System.out.println("Hi there, I can calculate some things.");
        System.out.println("Please DO NOT use this for solving your homework, as this would be plagiarism.");
        System.out.println("I can also not guarantee that this software will not make mistakes!");
        System.out.println("So please choose at which area you would like to calculate stuff:");
        System.out.println("1) two's complement (Zweierkomplement)");
        System.out.println("Please enter a number (Like \"1\")");
        Scanner scanner = new Scanner(System.in);
        char selected = scanner.nextLine().charAt(0);
        switch (selected){
            case '1':
                System.out.println("Selected \"two's complement (Zweierkomplement)\"");
                System.out.println("=====================================================");
                TwosComplement.selection();
        }
    }
}
