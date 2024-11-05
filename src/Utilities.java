public  class Utilities {
    public static int findMaxValue(int[] values){
        if(values.length <= 1)
            return -1;
        int max = values[0];

        for(int i = 0; i < values.length; i++){
            if(values[i] >= max)
                max = values[i];
        }
        return max;
    }

    public static int findMaxValueIndex(int[] values){
        if(values.length <= 1)
            return -1;
        int max = values[0];
        int index = 0;
        for(int i = 0; i < values.length; i++){
            if(values[i] >= max){
                max = values[i];
                index = i;
            }
        }
        return index;
    }
}
