public class DiceRolls {
    private static void printArray(double[] a) {
        String output = "";
        for (double currNum: a) {
            output += currNum + ", ";
        }   
        System.out.println("[" + output.substring(10, output.length() - 2) + "]");
    }
    
    public static void twoD6Probabilities() {
        int[] frequencies = new int[13];

        int[] exactfrequencies = new int[13];

        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                exactfrequencies[i+j]++;
            }
        }

        int nTrials = 10000000;
        for (int trials = 0; trials < nTrials; trials++) {
            int dice1 = (int)(Math.random() * 6) + 1;
            int dice2 = (int)(Math.random() * 6) + 1;
            frequencies[dice1 + dice2]++;
        }

        double[] exactprobabilities = new double[13];
        for (int k = 1; k <= 12; k++) {
            exactprobabilities[k] = (exactfrequencies[k] / 36.0);
        }

        double[] probabilities = new double[13];
        for (int k = 1; k <= 12; k++) {
            probabilities[k] = (double)frequencies[k] / nTrials;
        }
        printArray(exactprobabilities);
        printArray(probabilities);
    }
    public static void main(String[] args) {
        twoD6Probabilities();
    }
}
