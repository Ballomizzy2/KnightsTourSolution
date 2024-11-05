

public class BasicKnightRunner {
    // Main function to execute the tour and display the result
    public static void main(String[] args) {    
        // Running a basic heuristic tour
        System.out.println("-Basic Heuristic Tour-");
        KnightsTour tour = new KnightsTour(3,3);
        tour.runTour();
        tour.printBoard();

        // Running a tour with my new "Biased Heuristic" Tour
        System.out.println("-Biased Heuristic Tour-");
        BiasedHeuristicKnightsTour biasedHeuristicKnightsTour = new BiasedHeuristicKnightsTour(3, 3);
        biasedHeuristicKnightsTour.biasedHeuristicKnightTour();

        // Running a random tour
        System.out.println("-Random Tour-");
        RandomTour randTour = new RandomTour(3,3);
        randTour.runRandomTour();
        randTour.printBoard();

        // Simulating 64 tours, one for each square on the board
        System.out.println("-Each square Tour-");
        LargeTourSimulator tourSimulator = new LargeTourSimulator();
        tourSimulator.simulate64Tours();

        // Simulate 100 tours
        System.out.println("-100 Tours-");
        LargeTourSimulator tourSimulator100 = new LargeTourSimulator();
        tourSimulator100.simulateNumerousRandomTours(100);

        // Simulate 1000 tours
        System.out.println("-1000 Tours-");
        LargeTourSimulator tourSimulator1000 = new LargeTourSimulator();
        tourSimulator1000.simulateNumerousRandomTours(1000);

        // Simulate until success -- 
        //for the record it took 5,438,775 random tours to reach a complete full tour which was fun to watch

        //-------Remove the comments below to run the "Never Give Up" Tour ----------\\
        // System.out.println("-Never Give Up Tour-");
        // NeverGiveUpTour neverGiveUpTour = new NeverGiveUpTour();
        // neverGiveUpTour.simulateUntilVictory();
    }

}
