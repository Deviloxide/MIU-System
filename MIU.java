import java.util.ArrayList;

public class MIU {
    /**
     * A helper method to check if a string ends with "I"
     * @param s the string
     * @return true if the string ends with "I", false otherwise
     */
    public static boolean endsWithI(String s) {
        return s.charAt(s.length() - 1) == 'I';
    }

    /**
     * A helper method to check if a string contains "III"
     * @param s the string
     * @return true if the string contains "III", false otherwise
     */
    public static boolean containsIII(String s) {
        return s.contains("III");
    }

    /**
     * A helper method to check if a string contains "UU"
     * @param s the string
     * @return true if the string contains "UU", false otherwise
     */
    public static boolean containsUU(String s) {
        return s.contains("UU");
    }

    /**
     * A helper method to get the index of all occurrences of a substring in a string
     * @param s the theorem
     * @return an array of indices of all occurrences of the substring
     */
    public static int[] getIndices(String s, String sub) {
        ArrayList<Integer> indices = new ArrayList<>();
        int index = s.indexOf(sub);
        while (index != -1) {
            indices.add(index);
            index = s.indexOf(sub, index + 1);
        }
        int[] result = new int[indices.size()];
        for (int i = 0; i < indices.size(); i++) {
            result[i] = indices.get(i);
        }
        return result;
    }

    /**
     * A helper method to apply rule 1: If the theorem ends with "I", add "U" to the end
     * @param s the theorem
     * @return a string with "U" added to the end, or null if the rule cannot be applied
     */
    public static String applyRule1(String s) {
        if (endsWithI(s)) {
            return s + "U";
        }
        return null;
    }

    /**
     * A helper method to apply rule 2: If the theorem contains "M", add the substring after the
     * first "M" to the end
     * @param s the theorem
     * @return a string with the substring after the first "M" added to the end, or null if the
     * rule cannot be applied
     */
    public static String applyRule2(String s) {
        return s + s.substring(1);
    }

    /**
     * A helper method to apply rule 3: If the theorem contains "III", replace the first
     * occurrence with "U"
     * @param s the theorem
     * @return a string with "III" replaced with "U", or null if the rule cannot be applied
     */
    public static String[] applyRule3(String s) {
        if (containsIII(s)) {
            int[] indices = getIndices(s, "III");
            String[] theorems = new String[indices.length];
            for (int i = 0; i < indices.length; i++) {
                theorems[i] = s.substring(0, indices[i]) + "U" + s.substring(indices[i]
                        + 3);
            }
            return theorems;
        }
        return null;
    }

    /**
     * A helper method to apply rule 4: If the theorem contains "UU"
     * @param s the theorem
     * @return an array of strings with "UU" removed, or null if the rule cannot be applied
     */
    public static String[] applyRule4(String s) {
        if (containsUU(s)) {
            int[] indices = getIndices(s, "UU");
            String[] theorems = new String[indices.length];
            for (int i = 0; i < indices.length; i++) {
                theorems[i] = s.substring(0, indices[i]) + s.substring(indices[i] + 2);
            }
            return theorems;
        }
        return null;
    }
}
