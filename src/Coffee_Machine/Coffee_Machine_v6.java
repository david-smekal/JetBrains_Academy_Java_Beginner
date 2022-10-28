package Coffee_Machine;

import java.util.Scanner;

enum State {
    MENU, BUY, FILL, OFF
}

enum Coffee {
    ESPRESSO, LATTE, CAPPUCCINO, BACK
}

enum Ingredients {
    WATER, MILK, BEANS, CUPS
}

public class Coffee_Machine_v6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Machine cm = new Machine();
        String option;
        do {
            cm.printOptions();
            option = sc.nextLine();
            cm.process(option);
        } while (cm.getState() != State.OFF);
    }
}

class Machine {
    private int water = 400;
    private int milk = 540;
    private int coffeeBeans = 120;
    private int disposableCups = 9;
    private int money = 550;
    private State state = State.MENU;
    private Coffee coffee;
    private Ingredients ingredient = Ingredients.WATER;

    public State getState() {
        return state;
    }

    public void printOptions() {
        if (state == State.MENU) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
        } else if (state == State.BUY) {
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        } else if (state == State.FILL) {
            if (ingredient == Ingredients.WATER) {
                System.out.println("Write how many ml of water you want to add: ");
            } else if (ingredient == Ingredients.MILK) {
                System.out.println("Write how many ml of milk you want to add: ");
            } else if (ingredient == Ingredients.BEANS) {
                System.out.println("Write how many grams of coffee beans you want to add: ");
            } else {
                System.out.println("Write how many disposable cups you want to add: ");
            }
        }
    }

    public void process(String option) {
        if (state == State.MENU) {
            selectOption(option);
        } else if (state == State.BUY) {
            selectCoffee(option);
        } else if (state == State.FILL) {
            fill(option, ingredient);
        }
    }

    private void selectOption(String option) {
        switch (option) {
            case "buy" -> state = State.BUY;
            case "fill" -> state = State.FILL;
            case "take" -> take();
            case "remaining" -> printStats();
            case "exit" -> state = State.OFF;
        }
    }

    private void selectCoffee(String option) {
        switch (option) {
            case "1" -> coffee = Coffee.ESPRESSO;
            case "2" -> coffee = Coffee.LATTE;
            case "3" -> coffee = Coffee.CAPPUCCINO;
            case "back" -> coffee = Coffee.BACK;
        }
        if (coffee != Coffee.BACK) {
            makeCoffee();
        } else {
            this.state = State.MENU;
        }
    }

    private void take() {
        System.out.printf("I gave you $%d\n\n", money);
        this.money = 0;
    }

    private void printStats() {
        System.out.printf("""
                \nThe coffee machine has:
                %d ml of water
                %d ml of milk
                %d g of coffee beans
                %d disposable cups
                $%d of money
                \n""", this.water, this.milk, this.coffeeBeans, this.disposableCups, this.money);
    }

    private void makeCoffee() {
        switch (coffee) {
            case ESPRESSO -> {
                if (checkIngredients(250, 0, 16)) {
                    changeIngredients(250, 0, 16, 4);
                }
            }
            case LATTE -> {
                if (checkIngredients(350, 75, 20)) {
                    changeIngredients(350, 75, 20, 7);
                }
            }
            case CAPPUCCINO -> {
                if (checkIngredients(200, 100, 12)) {
                    changeIngredients(200, 100, 12, 6);
                }
            }
        }
    }

    private boolean checkIngredients(int waterNeeded, int milkNeeded, int coffeeBeansNeeded) {
        if (this.water < waterNeeded) {
            System.out.println("Sorry, not enough water!\n");
            state = State.MENU;
            return false;
        }
        if (this.milk < milkNeeded) {
            System.out.println("Sorry, not enough Milk!\n");
            state = State.MENU;
            return false;
        }
        if (this.coffeeBeans < coffeeBeansNeeded) {
            System.out.println("Sorry, not enough Coffee Beans!\n");
            state = State.MENU;
            return false;
        }
        if (this.disposableCups < 1) {
            System.out.println("Sorry, not enough disposable Cups!\n");
            state = State.MENU;
            return false;
        }
        return true;
    }

    private void changeIngredients(int water, int milk, int coffeeBeans, int money) {
        System.out.println("I have enough resources, making you a coffee!\n");
        this.water -= water;
        this.milk -= milk;
        this.coffeeBeans -= coffeeBeans;
        this.disposableCups--;
        this.money += money;
        this.state = State.MENU;
    }

    private void fill(String amount, Ingredients ingredient) {
        switch (ingredient) {
            case WATER -> {
                this.water += Integer.parseInt(amount);
                this.ingredient = Ingredients.MILK;
            }
            case MILK -> {
                this.milk += Integer.parseInt(amount);
                this.ingredient = Ingredients.BEANS;
            }
            case BEANS -> {
                this.coffeeBeans += Integer.parseInt(amount);
                this.ingredient = Ingredients.CUPS;
            }
            case CUPS -> {
                this.disposableCups += Integer.parseInt(amount);
                this.ingredient = Ingredients.WATER;
                this.state = State.MENU;
            }
        }
    }
}
