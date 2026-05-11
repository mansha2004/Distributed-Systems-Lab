


public class StringReverseImpl extends StringReversePOA {

    public String reverseString(String str) {

        String rev = "";

        // simple loop (easy to remember)
        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }

        return rev;
    }
}