package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<CafeInvoice> items = new ArrayList<>();
        String response = "";
        ArrayList<Double> taxRates = new ArrayList<>();
        taxRates.add(6.00);
        taxRates.add(5.30);
        taxRates.add(5.75);
        taxRates.add(5.00);
        Random rand = new Random();
        int taxIndex = rand.nextInt(taxRates.size()-1);
    do {
        System.out.println("Enter an item");
        String item = in.nextLine();
        System.out.println("Enter price");
        double price = in.nextDouble();
        System.out.println("Enter quantity");
        int quantity = in.nextInt();
        System.out.println("Is item taxable? true or false");
        boolean taxable = in.nextBoolean();

        items.add(new CafeInvoice(item, price, quantity, taxable));
        System.out.println("Do you want to add another item? yes or no");
        response = in.next();
        in.nextLine();
    }while(!response.equalsIgnoreCase("no"));

    double grandTotal = 0;
    double grandTotal2 = 0;
        System.out.println("Item \t" + "Price\t\t " + "Quantity\t " + "Cost\t " + "Taxable \t ");
        System.out.println("=====================================================================");
        for(CafeInvoice g:items) {
            System.out.print(g.getName() + "\t\t");
            System.out.print("$" + g.getPrice() + "\t\t\t");
            System.out.print(g.getQuantity() + "\t\t");
            System.out.print(g.getCost() + "\t\t");
            System.out.print(g.isTaxable() + "\n");

            grandTotal += g.getCost();

        }
        System.out.printf("Subtotal: " + "$"+"%.2f",grandTotal);System.out.println();


        taxIndex = rand.nextInt(taxRates.size()-1);
        double oneTax = taxRates.get(taxIndex);
        System.out.println("Tax Rate =" + oneTax + "%");

        for(CafeInvoice g: items){
            if(g.isTaxable()==true){
                grandTotal2 += g.getCost();
            }
        }
        double salesTax = (grandTotal2 * (oneTax/100));
        System.out.printf("Sales Tax: " + "$"+"%.2f",salesTax);
        System.out.println();
        System.out.println("=====================================================================");
        double total = grandTotal + salesTax;
        System.out.printf("Total: " + "$"+"%.2f",total);
        }








}
