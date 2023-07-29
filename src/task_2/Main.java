package task_2;

import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        System.out.println("Введите номер пункта из домашнего задания ко второму семинару: ");
        Scanner input = new Scanner(System.in);
        int buff = input.nextInt();
        if (buff == 1) {
            first_point point1 = new first_point();
            point1.Init_Sort();
        }
        else if (buff == 2) {
            second_point point2 = new second_point();
            point2.Init_String();
        }
    }
}