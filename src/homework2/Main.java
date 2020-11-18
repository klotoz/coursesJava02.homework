package homework2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


            int sum = 0;
            int row;
            int column;
            Scanner sc = new Scanner(System.in);



            System.out.println("Введите параметры для двумерного массива. Выберите размер строки и столбца:");
            row = sc.nextInt();
            column = sc.nextInt();
            String[][] arr = new String[row][column];

            try {
                iniArray(arr, sc, row, column);
            } catch (MyArraySizeException e) {
                e.printStackTrace();
                return;
            }
            for (int i = 0; i < arr.length; i++)
                for (int j = 0; j < arr[i].length; j++) {
                    try {
                        int sumArr = Integer.parseInt(arr[i][j]);
                        sum += sumArr;
                    } catch (RuntimeException e) {
                        throw new MyArrayDataException("в ячейке [" + i + "],[" + j + "] находится тип отличный от int." );
                    }
                }
            System.out.println("Сумма массива = " + sum);

    }

        public static void  iniArray(String[][] array, Scanner sc, int row, int col) {

            if (row != 4 || col != 4) {
                throw new MyArraySizeException("Массив может быть размером 4х4, иначе никак.");
            }
            System.out.println("Введите содержимое массива 4х4: ");
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = sc.next();
                }
            }
            System.out.println(Arrays.deepToString(array));

        }







}
