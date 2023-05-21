import java.util.*;

public class MIUSolver extends MIU {

    /**
     * The main method
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a MIU theorem: ");
        String theorem = sc.nextLine();
        System.out.print("Enter a number of steps: ");
        int steps = sc.nextInt();
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
        System.out.println();
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
}
