package Coffee_Machine;

import java.util.Scanner;

public class Coffee_Machine_v2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Write how many cups of coffee you will need: ");
        int cups = sc.nextInt();
        System.out.printf("""
                For %d cups of coffee you will need:
                %d ml of water
                %d ml of milk
                %d g of coffee beans""", cups, cups * 200, cups * 50, cups * 15);
    }
}