public  class Utilities {
    // Returns the max value in a given array of integers -------------------- VALUE
    public static int findMaxValue(int[] values){
        // return -1 if array is empty
        if(values.length < 1)
            return -1;

        int max = values[0]; // set max to the first value of the array

        // iterate through the array looking for numbers > max
        for(int i = 0; i < values.length; i++){
            if(values[i] >= max)
                max = values[i]; // update max if current number is > max
        }
        return max;
    }

    
    // Returns the max value's INDEX in a given array of integers ------------- INDEX
    public static int findMaxValueIndex(int[] values){
        // return -1 if array is empty
        if(values.length < 1)
            return -1;

        int max = values[0]; // set max to the first value of the array

        int maxIndex = 0; // set index to 0
        // iterate through the array looking for numbers > max
        for(int i = 0; i < values.length; i++){
            if(values[i] >= max){
                max = values[i]; // update max if current number is > max
                maxIndex = i; // set max index to the current index
            }
        }
        return maxIndex;
    }
}
