package machine;

import java.util.Scanner;

public class Machine {
    int amountMlWater;
    int amountMlMilk;
    int amountGrCoffee;
    int disposableCups;
    int money;

    public Machine(int amountMlWater, int amountMlMilk, int amountGrCoffee, int disposableCups, int money) {
        this.amountMlWater = amountMlWater;
        this.amountMlMilk = amountMlMilk;
        this.amountGrCoffee = amountGrCoffee;
        this.disposableCups = disposableCups;
        this.money = money;
    }

    public void printInfo() {
        System.out.println("The coffee machine has:");
        System.out.println(amountMlWater + " ml of water");
        System.out.println(amountMlMilk + " ml of milk");
        System.out.println(amountGrCoffee + " g of coffee beans");
        System.out.println(disposableCups + " disposable cups");
        System.out.println("$" + money + " of money");
    }

    public void operation(Command command) {
        switch (command) {
            case buy: {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu::");
                Scanner scanner = new Scanner(System.in);
                switch (CoffeeType.findByCode(scanner.nextLine())) {
                    case latte: {
                        if (disposableCups - 1 >= 0 && amountMlWater - 350 >= 0 && (amountMlMilk - 75 >= 0) && (amountGrCoffee - 20 >= 0)) {
                            amountMlWater -= 350;
                            amountMlMilk -= 75;
                            amountGrCoffee -= 20;
                            disposableCups--;
                            this.money += 7;
                            System.out.println("I have enough resources, making you a coffee!");
                        } else {
                            if (disposableCups - 1 < 0) {
                                System.out.println("Sorry, not enough cups!");
                            }
                            if (amountMlWater - 350 < 0) {
                                System.out.println("Sorry, not enough water!");
                            }
                            if (amountMlMilk - 75 < 0) {
                                System.out.println("Sorry, not enough milk!");
                            }
                            if (amountGrCoffee - 20 < 0) {
                                System.out.println("Sorry, not enough coffee!");
                            }
                        }
                        break;
                    }
                    case espresso: {
                        if (disposableCups - 1 >= 0 && amountMlWater - 250 >= 0 && (amountGrCoffee - 16 >= 0)) {
                            amountMlWater -= 250;
                            amountGrCoffee -= 16;
                            disposableCups--;
                            this.money += 4;
                            System.out.println("I have enough resources, making you a coffee!");
                        } else {
                            if (disposableCups - 1 < 0) {
                                System.out.println("Sorry, not enough cups!");
                            }
                            if (amountMlWater - 250 < 0) {
                                System.out.println("Sorry, not enough water!");
                            }
                            if (amountGrCoffee - 16 < 0) {
                                System.out.println("Sorry, not enough coffee!");
                            }
                        }
                        break;
                    }
                    case cappuccino: {
                        if (disposableCups - 1 >= 0 && amountMlWater - 200 >= 0 && (amountMlMilk - 100 >= 0) && (amountGrCoffee - 12 >= 0)) {
                            amountMlWater -= 200;
                            amountMlMilk -= 100;
                            amountGrCoffee -= 12;
                            disposableCups--;
                            this.money += 6;
                            System.out.println("I have enough resources, making you a coffee!");
                        } else {
                            if (disposableCups - 1 < 0) {
                                System.out.println("Sorry, not enough cups!");
                            }
                            if (amountMlWater - 200 < 0) {
                                System.out.println("Sorry, not enough water!");
                            }
                            if (amountMlMilk - 100 < 0) {
                                System.out.println("Sorry, not enough milk!");
                            }
                            if (amountGrCoffee - 12 < 0) {
                                System.out.println("Sorry, not enough coffee!");
                            }
                        }
                        break;
                    }
                    case exit: {
                        break;
                    }
                }
                break;
            }
            case fill: {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Write how many ml of water you want to add:");
                this.amountMlWater += scanner.nextInt();
                System.out.println("Write how many ml of milk you want to add:");
                this.amountMlMilk += scanner.nextInt();
                System.out.println("Write how many grams of coffee beans you want to add:");
                this.amountGrCoffee += scanner.nextInt();
                System.out.println("Write how many disposable cups of coffee you want to add:");
                this.disposableCups += scanner.nextInt();
                break;
            }
            case take: {
                System.out.println("I gave you $" + money + "");
                money = 0;
                break;
            }
            case remaining: {
                printInfo();
            }
        }
    }

}
