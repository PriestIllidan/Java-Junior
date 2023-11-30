/*
Напишите программу, которая использует Stream API для обработки списка чисел.
Программа должна вывести на экран среднее значение всех четных чисел в списке.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integerList.add(random.nextInt(10));
        }
        System.out.print(integerList);
        System.out.println();

        List<Integer> listOfEvenNumbers = integerList.stream().filter(number -> number % 2 == 0 && number != 0).toList();
        System.out.println(listOfEvenNumbers);
        System.out.printf("Average = %.2f", listOfEvenNumbers.stream().mapToInt(n -> n).average().getAsDouble());
    }
}