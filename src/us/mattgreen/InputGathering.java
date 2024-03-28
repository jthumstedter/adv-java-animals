package us.mattgreen;

import java.util.ArrayList;
import java.util.Scanner;

public class InputGathering {
    public ArrayList<Talkable> GenerateData(ArrayList<Talkable> zoo){
        Scanner scanner = new Scanner(System.in);
        boolean endLoop = false;
        do{
            System.out.println("What kind of animal do you want to make (Type -1 when you are done)");
            System.out.println("1) Cat");
            System.out.println("2) Dog");
            int input = scanner.nextInt();
            switch (input){
                case 1:
                    System.out.print("What is the cat's name: ");
                    String catName = scanner.next();
                    System.out.print("How many mouses has " + catName + " killed: ");
                    int mouseKilled = scanner.nextInt();
                    zoo.add(new Cat(mouseKilled, catName));
                    break;
                case 2:
                    System.out.print("What is the dog's name: ");
                    String dogName = scanner.next();
                    System.out.print("Is " + dogName + " friendly?: ");
                    boolean frendly = scanner.nextBoolean();
                    zoo.add(new Dog(frendly, dogName));
                    break;
                case -1:
                    endLoop = true;
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }while(endLoop);
        return zoo;
    }
}
