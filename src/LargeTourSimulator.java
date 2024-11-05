
// This class helps with simulating large scale tours
public class LargeTourSimulator {
    private static final int SIZE = 8;
    private static final int MAX_N0_OF_TOURS = 10000;

    // Simulate 64 tours starting from each square on the board
    public void simulate64Tours(){
        int tourCount = 1; // keeps a count of all the tours we go through

        for(int i = 0; i < SIZE; i++){ // Loop through each square/cell
            for(int j = 0; j < SIZE; j++)
            {
                KnightsTour tour = new KnightsTour(i, j);
                System.out.println("Tour Number: " + tourCount + " | Starting Position: " + i + ", " + j);
                if (tour.runTour()) {
                    System.out.println("Full tour completed:");
                } else {
                    System.out.println("Tour stopped before visiting all squares.");
                }
                tour.printBoard(); // Display the board after the tour
                tourCount++;
            }
        }
    }

    public void simulateNumerousRandomTours(int numberOfTours){
        if(numberOfTours > MAX_N0_OF_TOURS){
            System.out.println("Cannot simulate over " + MAX_N0_OF_TOURS + " tours :'\'");
            return;
        }
        
        int[] tourLengths = new int[numberOfTours]; // Array to track tour lengths for each iteration

        for(int i = 0; i < numberOfTours; i++){

            // choose a random start position every iteration
            int x = (int)(Math.random() * SIZE); 
            int y = (int)(Math.random() * SIZE);

            RandomTour tour = new RandomTour(x,y);
            System.out.println("Tour Number: " + i + " | Starting Position: " + x + ", " + y);
            tourLengths[i] = tour.runRandomTourInt();
            tour.printBoard(); // Display the board after each tour  
        }

        // Display tour lengths
        System.out.println("Tour Number | Number of Tours");
        System.out.println("-----------------------------");
        for (int i = 0; i < tourLengths.length; i++) {
            if (tourLengths[i] > 0) {
                System.out.printf("%11d | %14d%n", i + 1, tourLengths[i]);
            }
        }
        System.out.println("\n-----------Max Length is: " + Utilities.findMaxValue(tourLengths) + " which is tour " + (int)(Utilities.findMaxValueIndex(tourLengths) + 1));
    }



}
