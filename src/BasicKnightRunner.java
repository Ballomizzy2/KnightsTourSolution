

public class BasicKnightRunner {
    // Main function to execute the tour and display the result
    public static void main(String[] args) {    
        // Running a random tour
        // KnightsTour tour = new KnightsTour(3,3);
        // tour.runTour();
        // tour.printBoard();


        // RandomTour randTour = new RandomTour(3,3);
        // randTour.runRandomTour();
        // randTour.printBoard();
        

        // // Simulating 64 tours, one for each square on the board
        // LargeTourSimulator tourSimulator = new LargeTourSimulator();
        // tourSimulator.simulate64Tours();

        // // Simulate 1000 tours
        // LargeTourSimulator tourSimulator1000 = new LargeTourSimulator();
        // tourSimulator1000.simulateNumerousRandomTours(1000);

        // Simulate until success
        NeverGiveUpTour neverGiveUpTour = new NeverGiveUpTour();
        neverGiveUpTour.simulateUntilVictory();

    }

}
