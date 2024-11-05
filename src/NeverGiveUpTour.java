import java.util.ArrayList;

public class NeverGiveUpTour {
    private static final int SIZE = 8;

    public void simulateUntilVictory(){
        
        ArrayList<Integer> tourLengths = new ArrayList<Integer>(); // ArrayList to track tour lengths for each iteration
        int length = 0;
        int count = 0;
        while(length != 64){ // keep running the random tours until we get a lenght of 64

            // choose a random start position every iteration
            int x = (int)(Math.random() * SIZE); 
            int y = (int)(Math.random() * SIZE);

            RandomTour tour = new RandomTour(x,y);
            System.out.println("Tour Number: " + count + " | Starting Position: " + x + ", " + y);
            length = tour.runRandomTourInt(); // run the random tour
            tourLengths.add(length);  

            tour.printBoard(); // Display the board after each tour  

        }

        // Display tour lengths
        System.out.println("Tour Number | Number of Tours");
        System.out.println("-----------------------------");
        for (int i = 0; i < tourLengths.size(); i++) {
            if (tourLengths.get(i) > 0) {
                System.out.printf("%11d | %14d%n", i + 1, tourLengths.get(i));
            }
        }
        System.out.println(" It took " + count + " iterations to reacha full complete tour!");
    }
}
