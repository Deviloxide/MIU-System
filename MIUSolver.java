public class MIUSolver {
    String axiom = "MI";
    String goal;
    String[] rules = {"Mx -> Mxx", "Mx -> MxUx", "MxUy -> Mxy", "Mx -> MxI"};

    // constructor
    public MIUSolver(String goal) {
        this.goal = goal;
    }

    // main method
    public static void main(String[] args) {
        System.out.println("MIU-Solver");
        System.out.println(applyRule("MI", "Mx -> Mxx"));
    }

    // method to check if a string is a theorem
    public boolean isTheorem(String s) {
        return s.equals(goal);
    }

    // method to recursively try to prove a theorem
    public String prove(String s) {
        if (isTheorem(s)) {
            return s;
        } else {
            for (String rule : rules) {
                String result = applyRule(s, rule);
                if (result != null) {
                    String proof = prove(result);
                    if (proof != null) {
                        return proof;
                    }
                }
            }
            return null;
        }
    }

    // method to apply a rule to a string (should handle x as a wildcard)
    public static String applyRule(String s, String rule) {
        String[] ruleParts = rule.split(" -> ");
        String lhs = ruleParts[0];
        String rhs = ruleParts[1];
        if (s.startsWith(lhs)) {
            return rhs + s.substring(lhs.length());
        } else {
            return null;
        }
    }
}
