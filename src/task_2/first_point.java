package task_2;

import java.util.Arrays;

public class first_point {

    public static void Init_Sort(){
        int[] array = {-4,6,1,-8,0,1,2,4,0,9};
        System.out.printf("Сортируемый массив - %s \n", Arrays.toString(array));
        System.out.printf("Отсортированный массив - %s", Arrays.toString(Sort(array)) );
    }

    public static int[] Sort(int[] array){
        int min = array[0],max = array[0];
        for (int i=1;i<array.length;i++){
            if (array[i]<min) min = array[i];
            if (array[i]>max) max = array[i];
        }

        int count=0;
        int buff=min;
        while(buff != max){
            count++;
            buff++;
        }

        int[] buff_array = new int[count+1];
        int[] sort_array = new int[array.length];
        buff=min;
        for (int i=0;i<buff_array.length;i++){
            count=0;
            for (int j=0;j<array.length;j++){
                if (array[j] == buff) count++;
            }
            buff_array[i]=count;
            buff++;
        }

        System.out.println("Буфферный массив - "+ Arrays.toString(buff_array));
        count=0;
        buff=0;
        for (int i=0;i<buff_array.length;i++){
            if (buff_array[i] != 0){
                buff=0;
                while(buff != buff_array[i]) {
                    sort_array[count] = min;
                    count++;
                    buff++;
                }
                min++;
            }else min++;
        }
        return sort_array;
    }

}
