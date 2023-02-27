public class Minesweeper {
    public static boolean[][] makeMinesweeperBoard(int m, int n, double p) {
        boolean[][] grid = new boolean[m][n];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                double rand = Math.random();
                if (rand <= p) {
                    grid[i][j] = true;
                }
            }
        }
        return grid;
    }

    public static void printMinesweeperBoard(boolean[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j]) {
                    System.out.print("* ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public static int[][] makeNeighborBoard(boolean[][] a) {
        int grid[][] = new int[a.length][a[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (a[i][j]) {
                    grid[i][j] = -1;
                } else if (i == 0) {
                    if (j == 0) {
                        if (a[i][j+1]) {
                            grid[i][j]++;
                        }
                        if (a[i+1][j]) {
                            grid[i][j]++;
                        }
                        if (a[i+1][j+1]) {
                            grid[i][j]++;
                        }
                    } else if (j == grid[i].length - 1) {
                        if (a[i][j-1]) {
                            grid[i][j]++;
                        }
                        if (a[i][j]) {
                            grid[i][j]++;
                        }
                        if (a[i+1][j]) {
                            grid[i][j]++;
                        }
                        if (a[i+1][j-1]) {
                            grid[i][j]++;
                        }
                    } else {
                        if (a[i][j+1]) {
                            grid[i][j]++;
                        }
                        if (a[i+1][j]) {
                            grid[i][j]++;
                        }
                        if (a[i+1][j+1]) {
                            grid[i][j]++;
                        }
                        if (a[i][j-1]) {
                            grid[i][j]++;
                        }
                        if (a[i+1][j-1]) {
                            grid[i][j]++;
                        }
                    }
                } else if (i == grid.length - 1) {
                    if (j == 0) {
                        if (a[i][j+1]) {
                            grid[i][j]++;
                        }
                        if (a[i-1][j]) {
                            grid[i][j]++;
                        }
                        if (a[i-1][j+1]) {
                            grid[i][j]++;
                        }
                    } else if (j == grid[i].length - 1) {
                        if (a[i][j-1]) {
                            grid[i][j]++;
                        }
                        if (a[i-1][j]) {
                            grid[i][j]++;
                        }
                        if (a[i-1][j-1]) {
                            grid[i][j]++;
                        }
                    } else {
                        if (a[i][j+1]) {
                            grid[i][j]++;
                        }
                        if (a[i-1][j]) {
                            grid[i][j]++;
                        }
                        if (a[i-1][j+1]) {
                            grid[i][j]++;
                        }
                        if (a[i-1][j-1]) {
                            grid[i][j]++;
                        }
                        if (a[i][j-1]) {
                            grid[i][j]++;
                        }
                    }
                } else {
                    if (j == 0) {
                        if (a[i][j+1]) {
                            grid[i][j]++;
                        }
                        if (a[i+1][j]) {
                            grid[i][j]++;
                        }
                        if (a[i+1][j+1]) {
                            grid[i][j]++;
                        }
                        if (a[i-1][j]) {
                            grid[i][j]++;
                        }
                        if (a[i-1][j+1]) {
                            grid[i][j]++;
                        }
                    } else if (j == grid[i].length - 1) {
                        if (a[i][j-1]) {
                            grid[i][j]++;
                        }
                        if (a[i-1][j]) {
                            grid[i][j]++;
                        }
                        if (a[i-1][j-1]) {
                            grid[i][j]++;
                        }
                        if (a[i+1][j]) {
                            grid[i][j]++;
                        }
                        if (a[i+1][j-1]) {
                            grid[i][j]++;
                        }
                    } else {
                        if (a[i][j+1]) {
                            grid[i][j]++;
                        }
                        if (a[i+1][j]) {
                            grid[i][j]++;
                        }
                        if (a[i+1][j+1]) {
                            grid[i][j]++;
                        }
                        if (a[i+1][j-1]) {
                            grid[i][j]++;
                        }
                        if (a[i-1][j]) {
                            grid[i][j]++;
                        }
                        if (a[i-1][j+1]) {
                            grid[i][j]++;
                        }
                        if (a[i-1][j-1]) {
                            grid[i][j]++;
                        }
                        if (a[i][j-1]) {
                            grid[i][j]++;
                        }
                    }
                }
            }
        }
        return grid;
    }

    public static void printNeighborBoard(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == -1) {
                    System.out.print("* ");
                } else {
                    System.out.print(a[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        boolean[][] board = makeMinesweeperBoard(5, 5, .25);
        printMinesweeperBoard(board);
        System.out.println();
        printNeighborBoard(makeNeighborBoard(board));
    }
}
