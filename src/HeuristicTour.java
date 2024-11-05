import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HeuristicTour extends KnightsTour{
    
    // Accessibility matrix: each square's value represents how many moves can reach it
    private int[][] accessibility = {
        {2, 3, 4, 4, 4, 4, 3, 2},
        {3, 4, 6, 6, 6, 6, 4, 3},
        {4, 6, 8, 8, 8, 8, 6, 4},
        {4, 6, 8, 8, 8, 8, 6, 4},
        {4, 6, 8, 8, 8, 8, 6, 4},
        {4, 6, 8, 8, 8, 8, 6, 4},
        {3, 4, 6, 6, 6, 6, 4, 3},
        {2, 3, 4, 4, 4, 4, 3, 2}
    };
    
    public HeuristicTour(int row, int col){ // set the constructor to the same as the Basik Knights Tour constructor
        super(row, col);
    }

    // the look-ahead heuristic
    public boolean runHeristicTour() {
        boolean moveMade = true; // Track if a move was made

        // Continue moving until no valid moves are left or the board is complete
        while (moveMade && moveNum < SIZE * SIZE) {
            int nextMove = getBestMove(); // Get the best move based on heuristic
            if (nextMove >= 0) {
                makeMove(nextMove); // Make the selected move
            } else {
                moveMade = false; // No more moves, end the tour
            }
        }
        return moveNum == SIZE * SIZE; // Return true if a full tour is completed
    }

    // Get the best move considering accessibility and look-ahead heuristic
    private int getBestMove() {
        List<Integer> moves = getAvailableMoves(); // Get all valid moves
        if (moves.isEmpty()) return -1; // No valid moves

        // Sort moves based on the look-ahead accessibility (lower is better)
        Collections.sort(moves, Comparator.comparingInt(this::lookAheadAccessibility));
        return moves.get(0); // Return the best move after sorting
    }

    // Look ahead to calculate the accessibility for each potential move
    private int lookAheadAccessibility(int move) {
        int newRow = knightRow + V_MOVE[move];
        int newCol = knightCol + H_MOVE[move];
        List<Integer> futureMoves = getAvailableMoves(newRow, newCol);

        // Get minimum accessibility from all possible future moves
        return futureMoves.stream()
                .mapToInt(nextMove -> accessibility[newRow + V_MOVE[nextMove]][newCol + H_MOVE[nextMove]])
                .min()
                .orElse(Integer.MAX_VALUE);
    }

    // Make the selected move on the board and update the knight's position
    public void makeMove(int move) {
            knightRow += V_MOVE[move]; // Update row position
            knightCol += H_MOVE[move]; // Update column position
            moveNum++; // Increment move counter
            board[knightRow][knightCol] = moveNum; // Mark the new position on the board

        // Set accessibility of the visited square to max to prevent revisiting
        accessibility[knightRow][knightCol] = Integer.MAX_VALUE;
    }
}
