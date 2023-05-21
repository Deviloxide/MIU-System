import java.util.*;

public class MIUGenerator extends MIU {

    /**
     * The main method
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a MIU theorem: ");
        String theorem = sc.nextLine();
        TreeSet<String> theorems = generateTheorems(theorem);
        System.out.println("New Theorems: " + theorems);
        System.out.println();
    }

    /**
     * A helper method to generate all possible theorems that can be produced from a given theorem
     * by applying any of the four rules
     * @param s the theorem
     * @return a set of all possible theorems
     */
    public static TreeSet<String> generateTheorems(String s) {
        TreeSet<String> result = new TreeSet<>();
        String r1 = applyRule1(s);
        String r2 = applyRule2(s);
        String[] r3 = applyRule3(s);
        String[] r4 = applyRule4(s);
        if (r1 != null) {
            System.out.println("Applying rule 1: " + r1);
            result.add(r1);
        }
        System.out.println("Applying rule 2: " + r2);
        result.add(r2);
        if (r3 != null) {
            StringBuilder temp = new StringBuilder();
            Set<String> set = new TreeSet<>();
            Collections.addAll(set, r3);
            for (String theorem1 : set) {
                temp.append(theorem1).append(" ");
                result.add(theorem1);
            }
            System.out.println("Applying rule 3: " + temp);
        }
        if (r4 != null) {
            StringBuilder temp = new StringBuilder();
            Set<String> set = new TreeSet<>();
            Collections.addAll(set, r4);
            for (String theorem2 : set) {
                temp.append(theorem2).append(" ");
                result.add(theorem2);
            }
            System.out.println("Applying rule 4: " + temp);
        }
        return result;
    }
}
