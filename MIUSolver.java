import java.util.*;

public class MIUSolver {

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
     * occurrence
     * @param s the theorem
     * @return a string with the first occurrence of "III" replaced with "U", or null if the
     * rule cannot be applied
     */
    public static String[] applyRule3(String s) {
        if (containsIII(s)) {
            int[] indices = getIndices(s, "III");
            String[] theorems = new String[indices.length];
            for (int i = 0; i < indices.length; i++) {
                theorems[i] = s.substring(0, indices[i]) + "U" + s.substring(indices[i] + 3);
            }
            return theorems;
        }
        return null;
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
     * A helper method to apply rule 4: If the theorem contains "UU", remove the first
     * @param s the theorem
     * @return an array of strings with the first occurrence of "UU" removed, or null if the
     */
    public static String[] applyRule4(String s) {
        if (containsUU(s)) {
            int[] indices = getIndices(s, "III");
            String[] theorems = new String[indices.length];
            for (int i = 0; i < indices.length; i++) {
                theorems[i] = s.substring(0, indices[i]) + s.substring(indices[i] + 2);
            }
            return theorems;
        }
        return null;
    }

    /**
     * A helper method to generate all possible theorems that can be produced from a given theorem
     * by applying any of the four rules
     * @param s the theorem
     * @return a set of all possible theorems
     */
    public static Set<String> generateTheorems(String s) {
        Set<String> result = new HashSet<>();
        String r1 = applyRule1(s);
        String r2 = applyRule2(s);
        String[] r3 = applyRule3(s);
        String[] r4 = applyRule4(s);
        if (r1 != null) result.add(r1);
        result.add(r2);
        if (r3 != null) {
            Collections.addAll(result, r3);
        }
        if (r4 != null) {
            Collections.addAll(result, r4);
        }
        return result;
    }

    /**
     * A method to check if a given theorem can be produced from the initial theorem
     * @param theorem the theorem
     * @param steps the number of steps
     * @return true if the theorem can be produced, false otherwise
     */
    public static boolean isValidTheorem(String theorem, int steps) {
        Set<String> current = new HashSet<>();
        if (theorem.equals("MI")) return true;
        current.add("MI");
        for (int i = 0; i < steps; i++) {
            Set<String> next = new HashSet<>();
            for (String s : current) {
                next.addAll(generateTheorems(s));
            }
            current = next;
            if (current.contains(theorem)) {
                return true;
            }
        }
        return false;
    }

    /**
     * The main method
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a MIU theorem:");
        String theorem = sc.nextLine();
        System.out.println("Enter a number of steps:");
        int steps = sc.nextInt();
        sc.close();
        boolean valid = true;

        if (theorem.charAt(0) != 'M' || theorem.length() < 2) {
            valid = false;
        } else {
            for (int i = 1; i < theorem.length(); i++) {
                if (theorem.charAt(i) != 'M' && theorem.charAt(i) != 'I' && theorem.charAt(i) != 'U') {
                    valid = false;
                    break;
                }
            }
        }

        if (!valid) {
            System.out.println("The theorem is not valid.");
        } else {
            valid = isValidTheorem(theorem, steps);
            if (valid) {
                System.out.println("The theorem is valid.");
            } else {
                System.out.println("The theorem could not be confirmed as valid.");
            }
        }
    }
}
