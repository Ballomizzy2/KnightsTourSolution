import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class BiasedHeuristicKnightsTour extends KnightsTour {

    Random rand = new Random(); // for handling random next movements

    public BiasedHeuristicKnightsTour(int row, int col){ // constructor
        super(row, col);
    }

    // Check if move is within bounds and unvisited
    boolean isValidMove(int[][] board, int row, int col) {
        return row >= 0 && row < 8 && col >= 0 && col < 8 && board[row][col] == 0;
    }

    // Calculate the accessibility of each move
    int countOnwardMoves(int[][] board, int row, int col) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int newRow = row + V_MOVE[i];
            int newCol = col + H_MOVE[i];
            if (isValidMove(board, newRow, newCol)) {
                count++;
            }
        }
        return count;
    }

    // Perform a tour using a biased heuristic approach
    void biasedHeuristicKnightTour() {
        // initialize row and col
        int row = knightRow;
        int col = knightCol;
        
        board[row][col] = 1;
        int moveCount = 1;

        while (moveCount < 64) {
            ArrayList<int[]> validMoves = new ArrayList<>();

            // Collect valid moves with onward counts
            for (int i = 0; i < 8; i++) {
                int newRow = row + V_MOVE[i];
                int newCol = col + H_MOVE[i];
                if (isValidMove(board, newRow, newCol)) {
                    int onwardMoves = countOnwardMoves(board, newRow, newCol);
                    validMoves.add(new int[]{newRow, newCol, onwardMoves});
                }
            }

            if (!validMoves.isEmpty()) {
                // Sort by least onward moves, then add randomization if tied
                Collections.sort(validMoves, Comparator.comparingInt(a -> a[2]));

                // If there's a tie in the least accessible moves, pick one randomly
                int minAccessibility = validMoves.get(0)[2];
                ArrayList<int[]> tiedMoves = new ArrayList<>();
                for (int[] move : validMoves) {
                    if (move[2] == minAccessibility) {
                        tiedMoves.add(move);
                    } else {
                        break;
                    }
                }

                int[] nextMove = tiedMoves.get(rand.nextInt(tiedMoves.size()));
                row = nextMove[0];
                col = nextMove[1];
                moveCount++;
                board[row][col] = moveCount;

                System.out.println("----Board number " + moveCount);
                printBoard();
            } else {
                // No more valid moves, end the tour
                break;
            }
        }

        System.out.println("Number of moves: " + moveCount + "\n");
    }
}
