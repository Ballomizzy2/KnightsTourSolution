import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnightsTour {
    protected static final int SIZE = 8; // Size of the chessboard (8x8)
    protected static int[][] board; // Chessboard to track the knight's moves

    // Possible moves of a knight in chess (relative to current position)
    protected static final int[] H_MOVE = {2, 1, -1, -2, -2, -1, 1, 2};
    protected static final int[] V_MOVE = {-1, -2, -2, -1, 1, 2, 2, 1};

    protected static int knightRow; // Current row of the knight
    protected static int knightCol; // Current column of the knight
    protected int moveNum = 1; // Move counter

    // Constructor initializes the chessboard and starting position
    public KnightsTour(int row, int col) {
        board = new int[SIZE][SIZE];
        knightRow = row;
        knightCol = col;
        board[knightRow][knightCol] = moveNum; // Mark the starting position
    }

    
    // Run the Knight's Tour using the look-ahead heuristic
    public boolean runTour() {
        // Run the heristic tour function 
        HeuristicTour hTour = new HeuristicTour(knightRow, knightCol);
        return hTour.runHeristicTour(); 
    }

    // Make the selected move on the board and update the knight's position
    public void makeMove(int move) {
        knightRow += V_MOVE[move]; // Update row position
        knightCol += H_MOVE[move]; // Update column position
        moveNum++; // Increment move counter
        board[knightRow][knightCol] = moveNum; // Mark the new position on the board
    }

    // Get all valid moves from the knight's current position
    public List<Integer> getAvailableMoves() {
        return getAvailableMoves(knightRow, knightCol);
    }

    // Get all valid moves from a specific position (used in look-ahead)
    public List<Integer> getAvailableMoves(int row, int col) {
        List<Integer> moves = new ArrayList<>();
        for (int i = 0; i < H_MOVE.length; i++) {
            int newRow = row + V_MOVE[i];
            int newCol = col + H_MOVE[i];
            if (isValidMove(newRow, newCol)) {
                moves.add(i); // Add the move if it's valid
            }
        }
        return moves;
    }

    // Check if the move is within board bounds and the square is unvisited
    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == 0;
    }

    // Print the board showing the knight's path through each move
    public void printBoard() {
        for (int[] row : board) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("\n");
    }

    public void resetBoard() // Helps to reset the board variables
    {
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                board[i][j] = 0;
            }
        }
    }
}

