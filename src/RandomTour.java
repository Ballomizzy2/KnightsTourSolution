import java.util.List;

public class RandomTour extends KnightsTour{ // Base this class off the Basic Knight Tours class

    // Constructor initializes the chessboard and starting position
    public RandomTour(int row, int col) {
        super(row, col);
    }
    
    public boolean runRandomTour(){ // run a random tour
        boolean moveMade = true;
        while(moveMade && moveNum < 65){ // basically move 64 times making random moves
            int move = pickRandomMove(); // get a random move
            if(move>=0){
                makeMove(move);
            }else{
                moveMade = false;
            }
        }
        return moveMade;
    }

    public int runRandomTourInt(){ // run a random tour - return the length of the tour
        boolean moveMade = true;
        while(moveMade && moveNum < 65){ // basically move 64 times making random moves
            int move = pickRandomMove(); // get a random move
            if(move>=0){
                makeMove(move);
            }else{
                moveMade = false;
            }
        }
        return moveNum;
    }

    protected int pickRandomMove(){ // helps with selecting a random move based off possible moves
        List<Integer> moves = getAvailableMoves(); // get all the available moves
        if(moves.size() > 0){ // if there is at least a move, choose one of them at random
            int rand = (int)(Math.random() * moves.size());
            return moves.get(rand);
        }
        return - 1; // if there are no available moves, return
    }
    
}
