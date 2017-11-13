import java.util.Scanner;

public class MultiplikationImZweierkomplement {
    public static void multiplikation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter first number (factor)");
        String os1 = scanner.nextLine();
        System.out.println("Please enter second number (factor)");
        String os2 = scanner.nextLine();
        //Convert to char-Array
        char[] s1 = os1.toCharArray();
        char[] s2 = os2.toCharArray();
        // hier [0] MSB

        if (!validitycheck(s1, s2)){
            return;
        }



        // Erweiterung der Faktoren
        char[] z1 = expandFactor(s1);
        char[] z2 = expandFactor(s2);

        System.out.println(
                "\n\n" +
                        "To archieve a correct multiplication we have to expand the numbers to double their size, " +
                        "filling up the added Bits with the value of MSB:"
        );
        System.out.println(os1 + " --> " + CharArray.toString(z1));
        System.out.println(os2 + " --> " + CharArray.toString(z2));
        System.out.println("\n\n");


        // Ausgabe der obersten Zeile
        System.out.println("\033[4m" + CharArray.toString(z1) + " * " + CharArray.toString(z2));
        // Rechenblock
        char[][] addition = generateCharMatrix(z1, z2);
        //BERECHNUNG

        String[] product = calculate(addition);
        System.out.println("\033[0m" + product[0]);
        System.out.println("\n\nThe result is " + product[1]);
        System.out.println("\n... DONE!");



    }

    private static char[][] generateCharMatrix(char[] z1, char[] z2) {
        char[][] addition = new char[z2.length][z1.length];
        // Zeilen
        for (int i = 0; i <= addition.length - 1; i++) {
            for (int j = addition[0].length - 1; j >= 0; j--) {
                if (j < (i)){// wird mit jeder Zeile eines mehr
                    addition[i][j] = '0';
                } else {
                    addition[i][j] = (z2[i] == '1' ? z1[j - (i)]: '0');
                }

            }
            // Ausgabe der Zeilen
            if (i == (addition.length - 1)){
                System.out.println("\033[4m" + CharArray.toString(addition[i]));
            } else {
                System.out.println("\033[4m" + CharArray.toString(addition[i]));
            }
        }
        return addition;
    }

    /**
     * @return [0] is full String, [1] is the real result
     */
    private static String[] calculate(char[][] addition) {
        int sum = 0;
        String[] product = {"", ""};
        for (int waagrecht = 0; waagrecht <= (addition[0].length - 1); waagrecht++) {
            for (int senkrecht = 0; senkrecht <= (addition.length - 1); senkrecht++) {
                if (addition[senkrecht][waagrecht] == '1'){
                    sum += 1;
                }
            }
            product[0] = ((sum % 2) == 1 ? '1' : '0') + product[0];
            sum = (sum / 2);
        }

        for (int i = (product[0].length() / 2); i < product[0].length(); i++) {
            product[1] = product[0].charAt(i) + product[1];
        }
        return product;
    }

    private static char[] expandFactor(char[] originalFactor) {
        char[] expandedFactor = new char[originalFactor.length * 2];
        // Faktor z1
        // hier [0] = LSB
        for (int i = expandedFactor.length - 1; i >= 0; i--) {
            if (i >= originalFactor.length){
                expandedFactor[i] = originalFactor[0]; // in s1 [0] = MSB, in z1 LSB
            } else {
                expandedFactor[i] = (char) originalFactor[originalFactor.length - 1 - i];
                // 10  to 0        0   to 10
                // MSB to LSB      MSB to LSB
            }
        }
        return expandedFactor;
    }

    private static boolean validitycheck(char[] s1, char[] s2) {
        //Check if everything is ok:
        if (s1.length != s2.length){
            System.err.println("Numbers must be the same lenght!");
            return false;
        }
        for (char c: s1) {
            if (!(c == '0' || c == '1')){
                System.err.println("Numbers must not contain other symbols than '0' and '1'");
                return false;
            }
        }
        for (char c: s2) {
            if (!(c == '0' || c == '1')){
                System.err.println("Numbers must not contain other symbols than '0' and '1'");
                return false;
            }
        }
        return true;
    }
}
