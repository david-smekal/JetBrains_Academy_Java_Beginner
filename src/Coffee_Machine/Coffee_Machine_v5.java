package Coffee_Machine;

import java.util.Scanner;

public class Coffee_Machine_v5 {
    static final Scanner sc = new Scanner(System.in);
    static int water = 400;
    static int milk = 540;
    static int coffeeBeans = 120;
    static int disposableCups = 9;
    static int money = 550;

    public static void main(String[] args) {
        String input;
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            input = sc.nextLine();
            switch (input) {
                case "buy" -> buy();
                case "fill" -> fill();
                case "take" -> take();
                case "remaining" -> printStats();
            }
        } while (!input.equals("exit"));
    }
    public static void printStats() {
        System.out.printf("""
                \nThe coffee machine has:
                %d ml of water
                %d ml of milk
                %d g of coffee beans
                %d disposable cups
                $%d of money
                \n""", water, milk, coffeeBeans, disposableCups, money);
    }
    public static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String option = sc.nextLine();
        switch (option) {
            case "back" -> {}
            case "1" -> {
                if (water < 250) {
                    System.out.println("Sorry, not enough water!\n");
                } else if (coffeeBeans < 16) {
                    System.out.println("Sorry, not enough Coffee Beans!\n");
                } else if (disposableCups < 1) {
                    System.out.println("Sorry, not enough disposable Cups!\n");
                } else {
                    System.out.println("I have enough resources, making you a coffee!\n");
                    water -= 250;
                    coffeeBeans -= 16;
                    disposableCups--;
                    money += 4;
                }
            }
            case "2" -> {
                if (water < 350) {
                    System.out.println("Sorry, not enough water!\n");
                } else if (milk < 75) {
                    System.out.println("Sorry, not enough milk!\n");
                } else if (coffeeBeans < 20) {
                    System.out.println("Sorry, not enough Coffee Beans!\n");
                } else if (disposableCups < 1) {
                    System.out.println("Sorry, not enough disposable Cups!\n");
                } else {
                    System.out.println("I have enough resources, making you a coffee!\n");
                    water -= 350;
                    milk -= 75;
                    coffeeBeans -= 20;
                    disposableCups--;
                    money += 7;
                }
            }
            case "3" -> {
                if (water < 200) {
                    System.out.println("Sorry, not enough water!\n");
                } else if (milk < 100) {
                    System.out.println("Sorry, not enough milk!\n");
                } else if (coffeeBeans < 12) {
                    System.out.println("Sorry, not enough Coffee Beans!\n");
                } else if (disposableCups < 1) {
                    System.out.println("Sorry, not enough disposable Cups!\n");
                } else {
                    System.out.println("I have enough resources, making you a coffee!\n");
                    water -= 200;
                    milk -= 100;
                    coffeeBeans -= 12;
                    disposableCups--;
                    money += 6;
                }
            }
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