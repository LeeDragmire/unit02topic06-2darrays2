public class SelfAvoidingWalk {
    public static void printPathLengths(int n, int nTrials) {
        
        int pathLengthEscape = 0;
        int successfulEscape = 0;
        int pathLengthDeadEnd = 0;
        int pathLength = 0;
        int deadEndProb = 0;

        for (int trials = 0; trials < nTrials; trials++) {
            boolean[][] grid = new boolean[n][n];
            pathLength = 0;            
            int x = n / 2;
            int y = n / 2;
            while (x >= 0 && x < n && y >= 0 && y < n &&
             grid[x][y] == false) {
                grid[x][y] = true;
                pathLength++;
                int rand = (int)(Math.random() * 4);
                switch(rand) {
                    case 0: x = x + 1; break; // right
                    case 1: x = x - 1; break; // left
                    case 2: y = y + 1; break; // down
                    default: y = y - 1; break; // up
                }  
                
            }
            if (x < 0 || x >= n || y < 0 || y >= n) {
                pathLengthEscape += pathLength;
                successfulEscape++;
            } else {
                pathLengthDeadEnd += pathLength;
                deadEndProb++;
            }
    
        } 
        System.out.println("the average path length is " + 
        (double) (pathLengthDeadEnd + pathLengthEscape) / nTrials);
        System.out.println("the average path length for escaping is " + 
        (double) pathLengthEscape / successfulEscape);
        System.out.println("the average path length for a dead end is " + 
        (double) pathLengthDeadEnd / deadEndProb);
        System.out.println("dead end probability is " + (double) deadEndProb / nTrials);
        
    }

    public static double deadEndRectangleArea(int n, int nTrials) {
        double totalArea = 0;

        for (int trials = 0; trials < nTrials; trials++) {
            boolean[][] grid = new boolean[n][n];
            int x = n / 2;
            int y = n / 2;
            int minX = x;
            int maxX = x;
            int minY = y;
            int maxY = y;
            while (x >= 0 && x < n && y >= 0 && y < n &&
             grid[x][y] == false) {
                grid[x][y] = true;
                int rand = (int)(Math.random() * 4);
                switch(rand) {
                    case 0: x = x + 1; break; // right
                    case 1: x = x - 1; break; // left
                    case 2: y = y + 1; break; // down
                    default: y = y - 1; break; // up
                }
                if (x >= maxX) {
                    maxX = x;
                } 
                if (x <= minX) {
                    minX = x;
                }
                if (y >= maxY) {
                    maxY = y;
                } 
                if (y <= minY) {
                    minY = y;
                }
                
                
            }

            
            double area = 0;
            if (x < 0 || x >= n || y < 0 || y >= n) {
            } else {
                area = (maxX - minX) * (maxY - minY);
            }
            totalArea += area;
            
        }
        return (totalArea / nTrials);
    }
    public static void main(String[] args) {
        // printPathLengths(5, 1000000);

        System.out.println("average rectangle size is " + 
            deadEndRectangleArea(20, 100000));
    }
}
