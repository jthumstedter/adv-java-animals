package us.mattgreen;

import java.util.ArrayList;
import java.util.Scanner;

public class InputGathering {
    public ArrayList<Talkable> GenerateData(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Talkable> output = new ArrayList<>();
        boolean continueLoop = true;
        int inputAnimal;
        do{
            System.out.println("What kind of animal do you want to make (Type -1 when you are done)");
            System.out.println("1) Cat");
            System.out.println("2) Dog");
            if(scanner.hasNextInt()){
                inputAnimal = scanner.nextInt();
                switch (inputAnimal){
                    case 1:
                        System.out.print("What is the cat's name: ");
                        String catName = scanner.next();
                        boolean validInput;
                        do{
                            System.out.print("How many mouses has " + catName + " killed: ");
                            validInput = scanner.hasNextInt();
                            if(!validInput){
                                System.out.println("Invalid input. Needs to be an integer");
                                scanner.next();
                            }
                        }while(!validInput);
                        int mouseKilled = scanner.nextInt();
                        output.add(new Cat(mouseKilled, catName));
                        break;
                    case 2:
                        System.out.print("What is the dog's name: ");
                        String dogName = scanner.next();
                        System.out.print("Is " + dogName + " friendly? (y/n): ");
                        String friendlyString = scanner.next();
                        boolean friendly = friendlyString.equals("y") || friendlyString.equals("Y");
                        output.add(new Dog(friendly, dogName));
                        break;
                    case -1:
                        continueLoop = false;
                        break;
                    default:
                        System.out.println("Invalid input. Needs to correspond to one of the animals");
                }
            } else{
                scanner.next();
                System.out.println("Invalid input. Needs to be an integer");
            }

        }while(continueLoop);
        return output;
    }
}
