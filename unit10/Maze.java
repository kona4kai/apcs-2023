import java.util.Arrays;
import java.util.stream.Collectors;

public class Maze {
    private boolean solution;
    private char[][] maze;

    /**
     * Instantiates a Maze instance based on the provided arguments
     * 
     * @param rows the number of rows
     * @param cols the number of columns
     * @param line the values to be placed in the maze.
     */
    public Maze(int rows, int cols, String line) {
        this.maze = new char[rows][cols];
        for(int i = 0; i < rows*cols; i++) {
            this.maze[i/cols][i%cols] = line.charAt(i);
        }
    }

    /**
     * @return the starting coordinates as "r c"
     */
    public String getStart() { /* Not shown, plz ignore implementation */
        int z = Arrays.stream(maze).map(String::new).collect(Collectors.joining("")).indexOf('@');
        return "" + z / maze[0].length + " " + z % maze[0].length;
    }

    /**
     * @return the ending coordinates as "r c"
     */
    public String getEnd() { /* Not shown, plz ignore implementation */
        int z = Arrays.stream(maze).map(String::new).collect(Collectors.joining("")).indexOf('$');
        return "" + z / maze[0].length + " " + z % maze[0].length;
    }

    /**
     * Uses recursion to see if the maze has a solution or not.
     * 
     * Suggested algorithm:
     * if R and C are in bounds and spot is !#
     * - if you are at $:
     * - - set has a solution
     * - else:
     * - - mark spot as checked
     * - - recur up
     * - - recur down
     * - - recur left
     * - - recur right
     * 
     * @param r current row index
     * @param c current column index
     */
    private void check(int r, int c) {
        if(r >= 0 && c >= 0 && maze.length > r && maze.length > c && maze[r][c] != '#' && maze[r][c] != '!') {
            if(maze[r][c] == '$') {
                this.solution = true;
            } else {
                maze[r][c] = '!';
                check(r-1, c);
                check(r+1, c);
                check(r, c-1);
                check(r, c+1);
            }
        }
    }

    /**
     * Determines if there is a solution (a path of '.') for this maze.
     * 
     * @return true if the maze has a path from Start (@) to End ($).
     */
    public boolean hasSolution() {
        String start = getStart();
        check(start.charAt(0), (int)start.charAt(0)); // TODO fix wrong input values

        int rows = maze.length;
        int columns = maze[0].length;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if(this.maze[i][i] == '!')
                    this.maze[i][i] = '.';
            }
        }
        
        System.out.println("This maze has a solution: " + this.solution);
        return this.solution;
    }

    // HINT overriding toString may be handy. :)

    public static void check(boolean test) throws AssertionError {
        if (!test)
            throw new AssertionError("sad panda");
    }

    public static void main(String[] args) {
        Maze example = new Maze(3, 3, "#.@.....$");
        check(example.hasSolution());

        Maze case1 = new Maze(5, 7, ".#.#....#.#.##@.....$#...#.##..#...");
        check(case1.hasSolution());

        Maze case2 = new Maze(4, 4, ".#.$.##..##.@..#");
        check(!case2.hasSolution());

        Maze test = new Maze(3, 3, "#.@.....$");
        check(test.hasSolution());

        test = new Maze(3, 3, "##@#####$");
        check(!test.hasSolution());

        test = new Maze(3, 3, "##@#..#.$");
        check(test.hasSolution());

        test = new Maze(3, 3, "#.@#.##.$");
        check(test.hasSolution());

        test = new Maze(3, 3, "##@#.##.$");
        check(!test.hasSolution());

        System.out.println("Happy Panda! \uD83D\uDC3C");

    }

}
