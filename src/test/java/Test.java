import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class Test {
    private MainClass mainClass;

    @BeforeEach
    public void init (){
        mainClass = new MainClass();
    }

    @ParameterizedTest
    @CsvSource({
            "'1,2,3,4,5,6,4,5,5','5,5'",
            "'1,5,6,4,8,9,5,6','8,9,5,6'",
            "'1,2,3,4,5,6,4,5,5','5,5'",
            "'1,2,3,4,5,6,4,5,5','5,5'"
    })
    public void testFirst(String strInput, String strResult){
        String[] str1 = strInput.split(",");
        int[]arrInput = new int[str1.length];

        String[] str2 = strResult.split(",");
        int[]arrResult = new int[str2.length];

        for (int i = 0; i < str1.length; i++){
            arrInput[i]= Integer.parseInt(str1[i]);
        }
        for (int i = 0; i < str2.length; i++){
            arrResult[i]= Integer.parseInt(str2[i]);
        }
        System.out.println(strInput);
        System.out.println(strResult);
        Assertions.assertArrayEquals(arrResult,mainClass.arrayToReturn(arrInput));
    }
    @org.junit.jupiter.api.Test
    public void testFirstException(){
        final int[] arrInput = new int[]{2,3,5,6,5,5};
            Assertions.assertThrows(RuntimeException.class, ()->{mainClass.arrayToReturn(arrInput);});
    }

    @org.junit.jupiter.api.Test
    public void testSecond_1(){
        int[] arrInput = new int[]{1,2,3,4,5,6,4,5,5};
        Assertions.assertTrue(mainClass.arrayToCheck(arrInput));
    }
    @org.junit.jupiter.api.Test
    public void testSecond_2(){
        int[] arrInput = new int[]{1,5,6,4,8,9,5,6};
        Assertions.assertTrue(mainClass.arrayToCheck(arrInput));
    }
    @org.junit.jupiter.api.Test
    public void testSecond_3(){
        int[] arrInput = new int[]{2,3,5,6,5,5};
        Assertions.assertFalse(mainClass.arrayToCheck(arrInput));
    }
}
