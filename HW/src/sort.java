import java.util.Random;
import java.util.Arrays;
public class sort{
    public static void main(String [] args){
        int [] array = new int [100];
        for (int i =0 ;i<100;i++){
            Random rand = new Random();
            array[i]=rand.nextInt(100);
        }

        for (int i=0 ;i<99;i++){
            if (array[i]>array[i+1]){
                int temp = array[i];
                array[i]=array[i+1];
                array[i+1]=temp;
            }
        }
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
            };
    }
}