import java.util.Arrays;

public class MainClass extends Throwable{
    public int[] arrayToReturn (int[] inputArray){
        int numForCheck = 4;
        int count = 0;
        int position = 0;
        int[] outputArray;

        for (int i = 0; i < inputArray.length; i++){
            if (inputArray[i] == numForCheck){
                count++;
                position = i;
            }
        }
        if (count == 0){
            throw new RuntimeException("В массиве нет числа '4'!");
        } else {
            outputArray = Arrays.copyOfRange(inputArray, position + 1, inputArray.length );
        }
        return outputArray;
    }

    public boolean arrayToCheck (int[] inputArray){
        int numForCheck_1 = 4;
        int numForCheck_2 = 1;

        for (int i = 0; i < inputArray.length; i++){
            if (inputArray[i] == numForCheck_1 || inputArray[i] == numForCheck_2){
               return true;
            }
        }
        return false;
    }




    public static void main(String[] args) {
        MainClass test = new MainClass();
        int [] inp = {3,5,6,5,1,6,7};
        try {
            System.out.println(Arrays.toString(test.arrayToReturn(inp)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(test.arrayToCheck(inp));

    }
}
