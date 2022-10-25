package Coffee_Machine;

import java.util.Scanner;

public class Coffee_Machine_v3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has:");
        int water = sc.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = sc.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffee = sc.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int cups = sc.nextInt();
        int avaliableCups = 0;
        while (water >= 200 && milk >= 50 && coffee >= 15) {
            avaliableCups++;
            water -= 200;
            milk -= 50;
            coffee -= 15;
        }
        if (avaliableCups > cups) {
            System.out.printf("Yes, I can make that amount of coffee " +
                    "(and even %d more than that)", avaliableCups - cups);
        } else if (avaliableCups == cups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else {
            System.out.printf("No, I can make only %d cup(s) of coffee", avaliableCups);
        }
    }
}
