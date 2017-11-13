public class CharArray {
    public static String toString(char[] chars){
        String s = "";
        for (char c: chars) {
            s = c + s;
        }
        return s;
    }
}
