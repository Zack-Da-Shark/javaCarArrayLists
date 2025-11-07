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
//Sort the list in descendong length order and print
//Make a second list of cars and combine the two lists, print
//Filter by brand
//Filter by year range
//Split into 2 lists, pre 2000 and post 2000
//Store into an arraylist and print the top 5 car by hp
//Search by brand
//Sort by year
//Remove invalid years
//Have methods to edit car attriutes
//Then make a brand list with lists of cars

//Will need to make a car class and brand class first
//Also a table for mapping

public class ArrayListsStuff
{
    static class Car
    {
        //Basic car class
        public String brand;
        public String model;
        public int year;
        public int hp;

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
        boolean valid = true;
        Map<String, ArrayList<Car>> brands = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("What would you like to do?");
        System.out.println("0: Exit program");
        System.out.println("1: Create an array list");
        System.out.println("2: Print the array list");
        System.out.println("3: Find a specific car");
        System.out.println("4: Add items");
        System.out.println("5: Remove items");
        //To be implemented
        System.out.println("6: Order a list");
        System.out.println("7: Insert at a certain index");
        System.out.println("8: Insert a car in an ordered list");
        System.out.println("9: Remove cars with an invalid date/horsepower");
        System.out.println("10: Filter by year range");
        System.out.println("11: Edit a car");
        System.out.println("12: Merge 2 lists");
        System.out.println("13: Delete a list");
        //Below is already implemented
        System.out.println("99: Create an 5 array of 10 cars for debugging and testing");
        /*
        The arrays are as follows
        hatchbacks
        sedans
        luxury
        sports
        electric
        With no caps        
        */
        while(valid)
        {
            //Initialise some variuables that will be very commonly used in the code
            Car temp;
            boolean valid = false;
            int choice = 99;
            int year;
            int hp;
            int index;
            String arrayName;
            String brand;
            String model;
            System.out.println("Enter the number of the operation you want to perform:");
            while(!valid)
            {
                try
                {
                    choice = scan.nextInt();
                    scan.nextLine();
                    valid = true;
                    //Keep looping here until true
                }
                catch(Exception e)
                {    
                    System.out.println("Invalid Input");
                    System.out.println("Try again");
                    choice = scan.nextInt();
                    scan.nextLine();
                }
            }
            switch(choice)
            {
                case 0: valid = false; break;
                case 1:
                    while(true)
                    {
                        //ArrayList Creation
                        System.out.println("Enter the name for the array list, not capitalised");
                        arrayName = scan.nextLine();
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
                        //List printing
                        System.out.println("Enter the name for the array list");
                        arrayName = scan.nextLine();
                        for (Car car : brands.get(arrayName))
                            System.out.println(brands.get(arrayName).indexOf(car) + ". " + car.toString());
                        System.out.println("Would you like to print another list? 1 for yes, 0 for no");
                        choice = scan.nextInt();
                        scan.nextLine();
                        if(choice == 0)
                        {
                            break;
                        }
                    }
                break;
                case 3:
                    while(true)
                    {
                        //List searching
                        int searchNumber;
                        System.out.println("Enter the name of the list to search through");
                        arrayName = scan.nextLine();
                        System.out.println("Enter the attributes to search for: ");
                        System.out.println("Enter the brand");
                        brand = scan.nextLine();
                        System.out.println("Enter the model");
                        model = scan.nextLine();
                        System.out.println("Enter the year");
                        year = scan.nextInt();
                        scan.nextLine();
                        System.out.println("Enter the horsepower");
                        hp = scan.nextInt();
                        scan.nextLine();
                        for (Car car : brands.get(arrayName))
                        {
                            if(car.brand.equals(brand) && car.model.equals(model) && car.year == year && car.hp == hp)
                            {
                                System.out.println(brands.get(arrayName).indexOf(car) + ". " + car.toString());
                            }
                        }
                        System.out.println("Would you like to find another car? 1 for yes, 0 for no");
                        choice = scan.nextInt();
                        scan.nextLine();
                        if(choice == 0)
                        {
                            break;
                        }
                    }
                case 4:
                    while(true)
                    {
                        //List addition
                        System.out.println("Enter the name of the array list");
                        arrayName = scan.nextLine();
                        System.out.println("Enter the brand of the car");
                        brand = scan.nextLine();
                        System.out.println("Enter the name of the car");
                        model = scan.nextLine();
                        System.out.println("Enter the year of the car");
                        year = scan.nextInt();
                        scan.nextLine();
                        System.out.println("Enter the horespower of the car");
                        hp = scan.nextInt();
                        scan.nextLine();
                        brands.get(arrayName).add(new Car(brand, model, year, hp));
                        System.out.println("Would you like to add another car? 1 for yes, 0 for no");
                        choice = scan.nextInt();
                        scan.nextLine();
                        if(choice == 0)
                        {
                            break;
                        }
                    }
                break;
                case 5:
                    while(true)
                    {
                        //List element deletion
                        System.out.println("Enter the name of the array list");
                        arrayName = scan.nextLine();
                        boolean success;
                        System.out.println("0 for deleting via index, 1 for deleting via data");
                        choice = scan.nextInt();
                        scan.nextLine();
                        switch(choice)
                        {
                            case 0:
                                System.out.println("Enter the index of the car");
                                choice = scan.nextInt();
                                scan.nextLine();
                                temp = brands.get(arrayName).get(choice);
                                System.out.println("Removing: " + temp.toString());
                                brands.get(arrayName).remove(choice);
                            break;
                            case 1:
                                System.out.println("Enter the name of the array list");
                                arrayName = scan.nextLine();
                                System.out.println("Enter the brand of the car");
                                brand = scan.nextLine();
                                System.out.println("Enter the name of the car");
                                model = scan.nextLine();
                                System.out.println("Enter the year of the car");
                                year = scan.nextInt();
                                scan.nextLine();
                                System.out.println("Enter the horespower of the car");
                                hp = scan.nextInt();
                                scan.nextLine();
                                for (Car car : brands.get(arrayName))
                                {
                                    if(car.brand.equals(brand) && car.model.equals(model) && car.year == year && car.hp == hp)
                                    {
                                        index = brands.get(arrayName).indexOf(car);
                                        temp = car;
                                        System.out.println("Removing " + car.toString());
                                        brands.get(arrayName).remove(index);
                                    }
                                }
                            break;
                        }
                        System.out.println("Would you like to remove another car? 1 for yes, 0 for no");
                        choice = scan.nextInt();
                        scan.nextLine();
                        if(choice == 0)
                        {
                            break;
                        }
                    }
                break;
                /*
                case 6:
                    //Array sort using bubble sort
                    while(true)
                    {
                        System.out.println("Enter the name of the array list");
                        arrayName = scan.nextLine();
                        System.out.println("Select an attribute to sort by");
                        System.out.println("1: Brand");
                        System.out.println("2: Model");
                        System.out.println("3: Year");
                        System.out.println("4: Horsepower");
                        choice = scan.nextInt();
                        scan.nextLine();
                        switch(choice)
                        {
                            case 1:
                                for(Cars car : brands.get(arrayName))
                                {

                                }
                        }
                        System.out.println("Would you like to sort another list? 1 for yes, 0 for no");
                        choice = scan.nextInt();
                        scan.nextLine();
                        if(choice == 0)
                        {
                            break;
                        }
                    }
                break;
                */
                case 99:
                    //Dummy data creation
                    String debug = "hatchbacks";
                    brands.put(debug, new ArrayList<Car>());
                    brands.get(debug).add(new Car("Toyota", "Corolla", 2018, 132));
                    brands.get(debug).add(new Car("Honda", "Civic", 2020, 158));
                    brands.get(debug).add(new Car("Ford", "Focus", 2017, 160));
                    brands.get(debug).add(new Car("Chevrolet", "Cruze", 2019, 153));
                    brands.get(debug).add(new Car("Nissan", "Sentra", 2021, 149));
                    brands.get(debug).add(new Car("Hyundai", "Elantra", 2020, 147));
                    brands.get(debug).add(new Car("Kia", "Forte", 2021, 147));
                    brands.get(debug).add(new Car("Mazda", "Mazda3", 2019, 186));
                    brands.get(debug).add(new Car("Subaru", "Impreza", 2018, 152));
                    brands.get(debug).add(new Car("Volkswagen", "Jetta", 2022, 158));
                    
                    debug = "sedans";
                    brands.put(debug, new ArrayList<Car>());
                    brands.get(debug).add(new Car("Toyota", "Camry", 2020, 203));
                    brands.get(debug).add(new Car("Honda", "Accord", 2019, 192));
                    brands.get(debug).add(new Car("Nissan", "Altima", 2021, 188));
                    brands.get(debug).add(new Car("Mazda", "Mazda6", 2018, 187));
                    brands.get(debug).add(new Car("Hyundai", "Sonata", 2020, 191));
                    brands.get(debug).add(new Car("Kia", "Optima", 2019, 185));
                    brands.get(debug).add(new Car("Subaru", "Legacy", 2020, 182));
                    brands.get(debug).add(new Car("Chevrolet", "Malibu", 2021, 160));
                    brands.get(debug).add(new Car("Ford", "Fusion", 2019, 181));
                    brands.get(debug).add(new Car("Volkswagen", "Passat", 2020, 174));

                    debug = "luxury";
                    brands.put(debug, new ArrayList<Car>());
                    brands.get(debug).add(new Car("BMW", "3 Series", 2021, 255));
                    brands.get(debug).add(new Car("Audi", "A4", 2020, 201));
                    brands.get(debug).add(new Car("Mercedes-Benz", "C-Class", 2021, 255));
                    brands.get(debug).add(new Car("Lexus", "IS 300", 2020, 241));
                    brands.get(debug).add(new Car("Infiniti", "Q50", 2021, 300));
                    brands.get(debug).add(new Car("Acura", "TLX", 2021, 272));
                    brands.get(debug).add(new Car("Genesis", "G70", 2020, 252));
                    brands.get(debug).add(new Car("Volvo", "S60", 2021, 250));
                    brands.get(debug).add(new Car("Jaguar", "XE", 2019, 247));
                    brands.get(debug).add(new Car("Alfa Romeo", "Giulia", 2020, 280));

                    debug = "sports";
                    brands.put(debug, new ArrayList<Car>());
                    brands.get(debug).add(new Car("Ford", "Mustang", 2021, 450));
                    brands.get(debug).add(new Car("Chevrolet", "Camaro", 2021, 455));
                    brands.get(debug).add(new Car("Dodge", "Challenger", 2020, 375));
                    brands.get(debug).add(new Car("Nissan", "370Z", 2019, 332));
                    brands.get(debug).add(new Car("Toyota", "Supra", 2021, 382));
                    brands.get(debug).add(new Car("BMW", "M4", 2021, 473));
                    brands.get(debug).add(new Car("Audi", "RS5", 2021, 444));
                    brands.get(debug).add(new Car("Mercedes-Benz", "AMG C63", 2020, 469));
                    brands.get(debug).add(new Car("Lexus", "RC F", 2019, 472));
                    brands.get(debug).add(new Car("Porsche", "911 Carrera", 2021, 379));

                    debug = "electric";
                    brands.put(debug, new ArrayList<Car>());
                    brands.get(debug).add(new Car("Tesla", "Model 3", 2021, 450));
                    brands.get(debug).add(new Car("Tesla", "Model S", 2020, 670));
                    brands.get(debug).add(new Car("Tesla", "Model X", 2021, 670));
                    brands.get(debug).add(new Car("Tesla", "Model Y", 2021, 456));
                    brands.get(debug).add(new Car("Rivian", "R1T", 2022, 835));
                    brands.get(debug).add(new Car("Lucid", "Air", 2022, 1080));
                    brands.get(debug).add(new Car("Porsche", "Taycan", 2021, 616));
                    brands.get(debug).add(new Car("BMW", "i4", 2022, 536));
                    brands.get(debug).add(new Car("Hyundai", "Ioniq 5", 2022, 320));
                    brands.get(debug).add(new Car("Kia", "EV6", 2022, 320));
            }
        }
    }
}