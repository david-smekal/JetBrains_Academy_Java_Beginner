package Coffee_Machine;

import java.util.Scanner;

public class Coffee_Machine_v4 {
    static final Scanner sc = new Scanner(System.in);
    static int water = 400;
    static int milk = 540;
    static int coffeeBeans = 120;
    static int disposableCups = 9;
    static int money = 550;
    public static void main(String[] args) {
        printStats();
        System.out.println("\n\nWrite action (buy, fill, take): ");
        String input = sc.nextLine();
        switch (input) {
            case "buy" -> buy();
            case "fill" -> fill();
            case "take" -> take();
            default -> System.out.println("Not an option!");
        }
        printStats();
    }
    public static void printStats() {
        System.out.printf("""
                The coffee machine has:
                %d ml of water
                %d ml of milk
                %d g of coffee beans
                %d disposable cups
                $%d of money""", water, milk, coffeeBeans, disposableCups, money);
    }
    public static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        int option = sc.nextInt();
        System.out.println();
        switch (option) {
            case 1 -> {
                water -= 250;
                coffeeBeans -= 16;
                disposableCups--;
                money += 4;
            }
            case 2 -> {
                water -= 350;
                milk -= 75;
                coffeeBeans -= 20;
                disposableCups--;
                money += 7;
            }
            case 3 -> {
                water -= 200;
                milk -= 100;
                coffeeBeans -= 12;
                disposableCups--;
                money += 6;
            }
            default -> System.out.println("Not an option!");
        }
    }
    public static void fill() {
        System.out.println("Write how many ml of water you want to add: ");
        water += sc.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        milk += sc.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        coffeeBeans += sc.nextInt();
        System.out.println("Write how many disposable cups you want to add: ");
        disposableCups += sc.nextInt();
        System.out.println();
    }
    public static void take() {
        System.out.printf("I gave you $%d\n\n", money);
        money = 0;
    }
}
