//Here is a list of some basic list exercuses to get used to ArrayLists in java
import java.util.*;

//Create a list of favourite cars and print them out (using 2 strings (brand and name) and 2 ints (year and hp))
//Then add or remove some cars and print again
//Then check if a certain car exists
//Order the cars by hp and print
//Reverse the order and print
//Find the longest and shortest names and print
//Insert a car at a specific index 
//Insert a car alphabetically in the list
//Iterate through the list using a for each loop
//Randomly duplicate some cars, print, then remove
//Sort the list in descendong length order and print
//Make a second list of cars and combine the two lists, print
//Filter by brand
//Filter by year range
//Split into 2 lists, pre 2000 and post 2000

//Then define a car class with the above attributes and redo the exercises using objects instead of primitive types
//Store into an arraylist and print the top 5 car by hp
//Search by brand
//Sort by year
//Remove invalid years
//Have methods to edit car attriutes
//Then make a brand list with lists of cars

//Will need to make a car class and brand class first

public class ArrayListsStuff
{
    static class Car
    {
        String brand;
        String model;
        int year;
        int hp;

        public Car(String brand, String model, int year, int hp)
        {
            this.brand = brand;
            this.model = model;
            this.year = year;
            this.hp = hp;
        }

        @Override
        public String toString()
        {
            return brand + ", " + model + " (" + year + ") - " + hp + " HP";
        }
    }
    public static void main(String[] args)
    {
        Map<String, ArrayList<Car>> brands = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("What would you like to do?");
        System.out.println("1: Create an array list");
        System.out.println("2: Print the array list");
        System.out.println("3: Find a specific car");
        System.out.println("4: Add or remove items");
        while(true)
        {
            System.out.println("Enter the number of the operation you want to perform:");
            int choice = scan.nextInt();
            scan.nextLine();
            switch(choice)
            {
                case 1:
                    while(true)
                    {
                        System.out.println("Enter the name for the array list, not capitalised");
                        String arrayName = scan.nextLine();
                        brands.put(arrayName, new ArrayList<Car>());
                        System.out.println("Would you like to make another list? 1 for yes, 0 for no");
                        choice = scan.nextInt();
                        scan.nextLine();
                        if(choice == 0)
                        {
                            break;
                        }
                    }
                break;
                case 2:
                    while(true)
                    {
                        System.out.println("Enter the name for the array list");
                        String arrayName = scan.nextLine();
                        for (Car car : brands.get(arrayName))
                            System.out.println(car.toString());
                        System.out.println("Would you like to print another list? 1 for yes, 0 for no");
                        choice = scan.nextInt();
                        scan.nextLine();
                        if(choice == 0)
                        {
                            break;
                        }
                    }
                break;
                case 4:
                    while(true)
                    {
                        System.out.println("Enter the name of the array list");
                        String arrayName = scan.nextLine();
                        System.out.println("Enter the brand of the car");
                        String brand = scan.nextLine();
                        System.out.println("Enter the name of the car");
                        String name = scan.nextLine();
                        System.out.println("Enter the year of the car");
                        int year = scan.nextInt();
                        scan.nextLine();
                        System.out.println("Enter the horespower of the car");
                        int hp = scan.nextInt();
                        scan.nextLine();
                        brands.get(arrayName).add(new Car(brand, name, year, hp));
                        System.out.println("Would you like to add another car? 1 for yes, 0 for no");
                        choice = scan.nextInt();
                        scan.nextLine();
                        if(choice == 0)
                        {
                            break;
                        }
                    }
            }
        }
    }
}