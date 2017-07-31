package u4_finalproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
//Maanav Dalal
//July 25th, 2016
//Final Project - Linear Equations lesson
//A display of all I've learned this course!

public final class U4_FinalProject {

    Scanner reader = new Scanner(System.in);  // Reading from System.in > declared globally

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new U4_FinalProject(); //Project initialized
    }

    public U4_FinalProject() {
        System.out.println("Linear Equations - A Comprehensive Guide");//Intro
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Instructions(); //Instructions method, printing out instructions
        int choice = 0; //User choice
        do {
            System.out.println("\nMAIN MENU");
            System.out.println("=========");
            System.out.println("1. Lessons");
            System.out.println("2. Linear Equation calculator");
            System.out.println("3. Graphing");
            System.out.println("4. Sample Questions");
            System.out.println("5. Test your understanding!");
            System.out.println("6. Exit \n");
            decider(); //Method for user's choice
        } while (choice != 6); //While loop stopping condition
        closing();
    }

    public void Instructions() { // Instructions method
        printSlow("Hello and welcome to a lesson on linear equations!");
        printSlow("You're probably here right now because of one of the following reasons:");
        printSlow("1. You didn't enjoy the way your teacher taught this unit");
        printSlow("2. You want more practise on this unit because of a quiz or test");
        printSlow("3. You heard grade 9 math would be hard, so you've decided to practise in advancce");
        printSlow("4. You have absolutely nothing better to do!");
        printSlow("In any of these cases, this program is here to fulfill all your needs, and teach you in the process!");
        printSlow("Type anything below to continue:");
        String temp = reader.next(); // For spacing and so the user isn't overwhelmed
    }

    public void decider() {
        int choice = 0;//user choice
        while (choice <= 0 && choice != 6) { //Try catch for user input. Keeps asking until user inputs in a valid number
            try {
                System.out.print("Please enter your selection: ");
                choice = reader.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Try again - you must input a number");
                reader.nextLine();//For spacing
            }
        }
        switch (choice) //switch is set up for int category - user's input
        {
            case 1: //if int choice = 1
                Lessons(); //lessons method
                break;
            case 2: //if int choice = 2
                linCalc(); // linear calculation method
                break;
            case 3: //if int choice = 3
                Graphing(); // Graphing method 
                break;
            case 4: //if int choice = 4
                SampleQs(); // Randomly generated sample questions method
                break;
            case 5: //if int choice = 5
                Test(); // Final test
                break;
            default: //else
                System.out.println("Error-Pick a number between 1-6");
                decider(); //reset back to decider

        }
    }

    public void Lessons() {
        System.out.println("Lessons");//Types of lessons included
        System.out.println("=======");
        System.out.println("Here, you may choose a lesson to learn. ");
        printSlow("Pick between the following lessons:");
        printSlow("1. What is a linear function?");
        printSlow("2. Parts of a linear equation");
        printSlow("3. Calculating Slope");
        printSlow("4. Graphing and Transformations");
        printSlow("5. Extracting Useful info from word problems");
        printSlow("6. Back to previous menu");
        lessonsDecider(); // User can choose which one they want to go over
    }

    public void lessonsDecider() {
        int choice = 0; // User choice
        while (choice <= 0) { // while loop for user lesson choice
            try { // try catch statement for no invalid input
                System.out.print("Please enter your lesson selection: ");
                choice = reader.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Try again - you must input a number");
                reader.nextLine();
            }
        }
        switch (choice) //switch is set up for int category
        {
            case 1: //if int choice = 1
                linearFunctionLesson(); // go into first lesson
                break;
            case 2: //if int choice = 2
                linearEqnParts(); //second lesson on equation parts 
                break;
            case 3: //if int choice = 3
                linearSlopeCalc();//third lesson on slope calculation
                break;
            case 4: //if int choice = 4
                linearGraphing(); // fourth lesson on graphing
                break;
            case 5: //if int choice = 5
                linearWordProbs();//word problems practise questions
                break;
            case 6:
                decider(); // if they want to go back
                break;
            default:
                System.out.println("Error-Pick a number between 1-6");
                lessonsDecider(); //Picks again if invalid input

        }
    }

    public void linearFunctionLesson() { //lesson
        printSlower("\nWelcome to your lesson on what exactly a linear function is.");
        printSlower("\nSimply put, a linear function is a set of values with the same rate of change.");
        printSlower("Basically, that means that at whatever rate the x value of a function increases by 1, the y value increases by a fixed value");
        printSlower("To put that into perspective, since that may be confusing, here is a chard to show you what that means: \n");
        System.out.println("x-Value| y-Value");//Draws chart with values up to 5
        for (int i = 1; i <= 5; i++) {
            System.out.println("   " + i + "   |   " + ((5 * i) + 3));
        }
        printSlower("As you can see, the increment is always the same - the y value goes up by 5 each time.");
        printSlower("This is one of the three things to look for while evaluating if a function is linear or not (The change of the y is a constant).\n");
        printSlower("Another thing on your checklist to identify a linear function is the amount of variables and their powers.");
        printSlower("A fully formed linear function will only have 2 variables with no exponents (powers).");
        printSlower("An example is the equation of the function we printed out earlier: y = 5x +3");
        printSlower("The only exception to this is if a third variable is known or constant, for example the symbol for pi: π\n");
        printSlower("The final thing to look for while determining wether a function is linear or not is if it would graph to a straight line");
        printSlower("This can be determined by the increment of values as seen above, but can also be determined by graphing the values on a chart");
        printSlower("View the graph (pop-up) of this y = 5x+3 below, to see that it is a line, then type something below to continue");
        graph5x(); //Prints out graph
        reader.next();
        printSlower("With these three steps, you can identify any linear equation!");
        printSlower("Lesson 1 Complete, good job!\n");
        printSlow("Type anything below to continue:");
        String temp = reader.next();//For better spacing 
        Lessons(); //back to lessons directory
    }

    public void linearEqnParts() {//lesson which teaches about all the parts of a linear equation
        printSlower("\nWelcome to a lesson about the parts of a linear equation, and its general form!\n");
        printSlower("A linear equation is a way to represent a linear function.");
        printSlower("The general form (also known as Slope-intercept form)of a linear function is y = mx+b, where\n");
        printSlower("The 'y' represents the y value, or what you're solving for.");
        printSlower("The 'x' represents the x value, or what you're often plugging in to solve for y.");
        printSlower("The 'm' represents the slope, or rate of change. Lesson 3 teaches you how to solve or figure this out given two points, or a graph.");
        printSlower("The 'b' represents the y intercept, or where the graph intersects the y axis. \nA simple way to think about this is how much the graph has been shifted either up, or down.");
        printSlower("\nWhen solving for any given value, 3 of these 4 must be known (or for x and y, decided). \nFor example, to solve for b (the y intercept), you must know a point (x, y), and the slope (m).");
        printSlower("Congratulations, you now understand the parts of a linear equation and how to slove for any variable!");
        printSlower("Lesson 2 Complete, good job!\n");
        printSlow("Type anything below to continue:");
        String temp = reader.next();
        Lessons();
    }

    public void linearSlopeCalc() { //teaches how to calculate slope
        printSlower("\nWelcome to a lesson about the slope, or 'm' of a linear function (or equation).");
        printSlower("Here, you will learn to understand what it means, and how to calculate it.");
        printSlower("\nSlope is also known as rate of change, or the rate at which a function advances. ");
        printSlower("It can be positive or negative, representing either an increase (positive) or decrease (negative).");
        printSlower("A positive slope will mean the function will move to the right in an upwards direction (diaginal): /");
        printSlower("A negative slope will mean the function will move to the right in a downwards direction (diaginal): \\ ");//traingle unicode to show delta, or change in
        printSlower("\nTo calculate this with two points, you use " + ((char) 9650) + "y / " + ((char) 9650) + "x. This is also known as y₂-y₁/x₂-x₁.");
        printSlower("Input the first point's x and y under y₁ and x₁, and point 2's x and y under y₂ and x₂. Subtract, and you've left with the rate of change.");
        printSlower("This works because the function is linear, and the rate of change is always constant, so the difference of the two points will produce the rate of change.");
        printSlower("An example of this is by being given the points (5,2) and (10,4). Using our formula, it is 10-5/4-2, or 5/2 (2.5).");
        printSlower("\nThat... is all you need to know about slope! That's what it is, and how you can calculate, it! How it can be used will be covered in lesson 4.");
        printSlower("Lesson 3 Complete, good job!\n");
        printSlow("Type anything below to continue:");
        String temp = reader.next(); //For better spacing
        Lessons();

    }

    public void linearGraphing() { //How to graph a linear function, with slope and y intercept
        printSlower("\nWelcome to your second last lesson - Graphing linear equations!");
        printSlower("\nNow that we know what all the variables and what they mean, and also how to figure out ones we don't know,\n we should learn to make graphs from these equations to solve problems!");
        printSlower("Starting with the base function, y = x, where solving y is as easy as looking at x, and base points are as follows:");
        printSlower("(0,0),(1,1),(2,2), and onwards");
        printSlower("We can transform this based on our slope and b value to accurately graph the function.\n");
        printSlower("So using any base equation (y = 5x+3, for example), we must plug in x to get our y, and follow BEDMAS");
        printSlower("so for x = 7, y = 5(7)+3, or y = 38.");
        printSlower("To graph properly, we must have at least one more point, so let's use x = 2 (therefore y = 5(2)+3, or y = 13).");
        printSlower("Having now plotted these two points, since we know the equation is linear (or must be a straight line), we may connect them with a straight line.");
        printSlower("\nAlternatively, you can locate the y-intercept (or 'b'), and use the slope.");
        printSlower("So, if the y intercept is 5 (creating a point of 0,5), and the slope was 5/2,\n you would go up 5, and then right 2 and make your next point at (10,2).");
        printSlower("\nNow, you know how to effectively use the slope and y-intercept to graph a function!");
        printSlower("Lesson 4 Complete, good job!\n");
        printSlow("Type anything below to continue:");
        String temp = reader.next();//for spacing
        Lessons();
    }

    public void linearWordProbs() { //How to solve linear word problems
        printSlower("Welcome to your final lesson - Making equations from word problems!");
        printSlower("Now that you understand linear functions and equations, their uses, and how they work, you may be tested on them.");
        printSlower("This lesson is to help you be prepared when that happens!");
        printSlower("\nThere are many things to consider while being presented a problem, so below are all the terms that could represent all the variables:");
        printSlower("Y-Intercept, or 'b': since this point is at x = 0, it can also be known as the starting, when purchased, things that have already be done, etc.");
        printSlower("Slope, or 'm': rate of change, rise / run, increase by, how many points / things an action is worth, etc.");
        printSlower("\nWith this information, you should be able to understand all the information being given to you in a linear word problem");
        printSlower("Bonus tip: remember that if given two linear equations, you can isolate a variable in one,\n then substitute the value for it into the other equation where that variable appears.");
        printSlower("\nCongratulations! You've completed the lesson on linear word problems - you should now be ready for any upcoming tests!");
        printSlower("I reccommend you now move on to the practise / test to test your knowledge.");
        printSlower("Lesson 5 Complete, good job!\n");
        String temp = reader.next();//for spacing
        Lessons();
    }

    public void graph5x() { //Swing to show an image that is of a graph > JOptionPane widget
        JOptionPane.showMessageDialog(null, createImageIcon("graph.png"), "y = 5x+3", JOptionPane.INFORMATION_MESSAGE);
    }

    public void linCalc() {//Directory for calculator 
        System.out.println("Linear equation calculator");
        System.out.println("=============================");
        printSlow("Here, you may calculate multiple things about a linear equation:");
        printSlow("1. Y Calculator");
        printSlow("2. Slope Calculator");
        printSlow("3. X Calculator");
        printSlow("4. Y intercept Calculator");
        printSlow("5. Back");
        linDecider();//to the decided for linear equations 
    }

    public void linDecider() {
        int choice = 0;//user choice
        while (choice <= 0) {//Try catch for user's choice of calculator
            try {
                System.out.print("Please enter your choice of calculator: ");
                choice = reader.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Try again - you must input a number");
                reader.nextLine();
            }
        }
        if (choice == 1) {
            yCalc();//calculator for y 
        } else if (choice == 2) {
            mCalc();//calculator for m
        } else if (choice == 3) {
            xCalc();//calculator for x
        } else if (choice == 4) {
            yIntCalc();//yInteger calculator
        } else if (choice == 5) {
            decider();//else they go back to the main menu
        } else {
            System.out.println("Try again - pick a number between 1-5."); //else invalid input
        }
    }

    public void yCalc() {//solving for y with the other 3 variables
        System.out.println("Below, enter variables to solve for y:");
        System.out.println("Enter the x-Value:");
        int xVal = reader.nextInt();
        System.out.println("Enter the m-Value(slope):");
        int mVal = reader.nextInt();
        System.out.println("Enter the b-Value:");
        int bVal = reader.nextInt();
        System.out.println("Y Value: " + mVal * xVal + bVal); //calc to get y
    }

    public void xCalc() {//solving for x with the other 3 variables
        System.out.println("Below, enter variables to solve for x:");
        System.out.println("Enter the m-Value:");
        int mVal = reader.nextInt();
        System.out.println("Enter the y-Value:");
        int yVal = reader.nextInt();
        System.out.println("Enter the b-Value:");
        int bVal = reader.nextInt();
        System.out.println("X Value: " + (yVal - bVal) / mVal); //calc to get x
    }

    public void mCalc() {//solving for slope with the other 3 variables
        System.out.println("Below, enter variables to solve for m:");
        System.out.println("Enter the x-Value:");
        int xVal = reader.nextInt();
        System.out.println("Enter the y-Value:");
        int yVal = reader.nextInt();
        System.out.println("Enter the b-Value:");
        int bVal = reader.nextInt();
        System.out.println("M Value(slope): " + (yVal - bVal) / xVal); //calc to get slope
    }

    public void yIntCalc() {//solving for y intercept given other 3 variables
        System.out.println("Below, enter variables to solve for the y-intercept:");
        System.out.println("Enter the x-Value:");
        int xVal = reader.nextInt();
        System.out.println("Enter the y-Value:");
        int yVal = reader.nextInt();
        System.out.println("Enter the m-Value:");
        int mVal = reader.nextInt();
        System.out.println("B(Y-Intercept) Value: " + (-1 * ((mVal * xVal) - yVal))); //calc to get b 
    }

    public void Graphing() { //the method for graphing given a slope, y intercept, and positive or negative
        System.out.println("Graphing!");
        System.out.println("Here, you can input values (no slopes other than one), and draw out a graph on a 10x10 grid!");
        System.out.println("Please only use integer values in your input.");
        System.out.println("Enter the b value below: (between -5 and 5)");
        int bVal = reader.nextInt(); //asks for y intercept 
        System.out.println("Is the equation's co-efficient positive or negative? (enter true or false)");
        boolean posNeg = reader.nextBoolean(); //asks if positive or negative
        if (posNeg) { //if it's positive, use grid 1 method (for positive slope)
            grid(bVal);
        } else { //else use grid 2 method (for negative slope)
            grid2(bVal);
        }
    }

    public void grid(int bVal) {
        int x = 0;//x value, not modified because slope would look messy (otherwise it'd be x*mVal)
        int y = 10 - bVal; //takes into account vertical shift (y intercept)
        System.out.println("   -5|-4|-3|-2|-1|+0|+1|+2|+3|+4|+5 "); //prints out title 
        System.out.println("------------------------------------");//header
        for (int i = 0; i < 11; i++) //repeats loop 11 times (-5 to +5). Nested for loop to draw both parts of the grid.
        {
            if (i - 6 < 0) { //to get 5-0 descending
                System.out.print("+");//Prints out positive value of y axis
                System.out.print(Math.abs(i - 5));
                System.out.print("| ");
            } else {
                System.out.print("-" + (i - 5) + "| "); //-1 to -5 descending   
            }
            for (int j = 0; j < 11; j++)//repeats loop 11 times (-5 to +5)
            {
                if (i == x && j == y) {
                    System.out.print("/| ");//if the slope matches with the position, print out a piece of the line
                    y--; //subtracts one from y to approach the next place to draw a slash(-5,5 going to -4,4 on the grid)
                    x++; //adds one to x to approach next place to draw
                } else//blank spot in grid
                {
                    System.out.print(" | ");
                }

            }
            System.out.println();//space
            System.out.println("------------------------------------"); //bottom
        }
    }

    public void grid2(int bVal) {
        int x = 0;//x value, not modified because slope would look messy (otherwise it'd be x*mVal)
        int y = 0 + bVal; //takes into account vertical shift (y intercept)
        System.out.println("   -5|-4|-3|-2|-1|+0|+1|+2|+3|+4|+5 "); //prints out title 
        System.out.println("------------------------------------");//header
        for (int i = 0; i < 11; i++) //repeats loop 11 times (-5 to +5). Nested for loop to draw both parts of the grid.
        {
            if (i - 6 < 0) { //to get 5-0 descending
                System.out.print("+");//Prints out positive value of y axis
                System.out.print(Math.abs(i - 5));
                System.out.print("| ");
            } else {
                System.out.print("-" + (i - 5) + "| "); //-1 to -5 descending   
            }
            for (int j = 0; j < 11; j++)//repeats loop 11 times (-5 to +5)
            {
                if (i == x && j == y) {
                    System.out.print("\\| ");//if the slope matches with the position, print out a piece of the line
                    y++; //adds one from y to approach the next place to draw a slash (5,5 going to 4,4 on the grid)
                    x++; //adds one to x to approach next place to draw
                } else//blank spot in grid
                {
                    System.out.print(" | ");
                }

            }
            System.out.println();//space
            System.out.println("------------------------------------"); //bottom
        }
    }

    public void Test() {
        ArrayList<String> TestQs = new ArrayList<>(); //initialize list
        initQuestions(TestQs);//add questions to the list (out of this method for simplicity and to prevent cheating)
        int score = 0;//user score, goes up as they get questions right
        for (int i = 0; i < 15; i += 3) { //runs 5 times, for a total of 5 questons
            System.out.println("Problem: " + TestQs.get(i)); //gives problem, first of 3 in the array (1-3 is for first question, 4-6 is for second, etc.)
            System.out.println("\nQuestion: " + TestQs.get(i + 1)); //gives question, second place in the array
            System.out.println("Enter your answer: ");
            String uAns = reader.next(); //gets user answer
            if (uAns.equals(TestQs.get(i + 2))) { //gets correct answer as string (third place in the array), compares to user answer
                System.out.println("Good job, you got it right!\n");
                score++; //score added if it's right
            } else { //wrong
                System.out.println("Sorry, the correct answer was: " + (TestQs.get(i + 2))); //prints out answer for user
            }
        }
        System.out.println("Your final test score was: " + score + "/5.\n");
        String temp = reader.next();//for spacing
        decider();//back to menu
    }

    public void initQuestions(ArrayList<String> sampleQs) { //initializes all of the questions for the array. First = Problem, Second = Question, Third = Answer
        Collections.addAll(sampleQs, "Last month, Margo bought a tree that grows 2.5cm each day. \nIt was 5 cm tall when she bought it and now it is 65cm tall.", "Find the number of days Margo has owned the plant.", "24");
        Collections.addAll(sampleQs, "MacDonald had a farm with a certain number of orange trees. He had to cut down 5 trees to control insects.\n Each of the remaining trees produced 210 oranges, producing a toral harvest of 41790 oranges.", "How many trees did MacDonald's farm have initially?", "204");
        Collections.addAll(sampleQs, "Kim and Cyndi are starting a business tutoring students in math. \nThey rent an office for $400 per month and charge $40 per hour per student.", "If they have 15 students each for one hour per week how much profit do they make together in a month? (assume 4 weeks per month)", "4400");
        Collections.addAll(sampleQs, "Many counties in Florida missed many school days in the fall of 2004 due to hurricanes that year. A solution for how to make up those days was to add time to each school day for a portion of the year. It was decided that in order to make up a 6 hour school day, 10 minutes would be added to each day.", "How many extended days would be needed to make up 3 school days?", "108");
        Collections.addAll(sampleQs, "Lin is tracking the progress of her plant's growth. Today the plant is 7cm high. The plant grows 1.5 cm per day.", "What will be the height of the plant after 20 days?", "37");
    }

    public void SampleQs() {// leads to random questions, asks user for how many they want to do
        System.out.println("\nHere, you will find randomly made questions, answer them with either a whole number, or a fraction");
        System.out.println("Choose the amount of questions you want to answer: ");
        int qAmt = reader.nextInt();
        for (int i = 0; i < qAmt; i++) // runs random question generator 'qAmt' times
        {
            randomLinGenerator();
        }
    }

    public void randomLinGenerator() { //randomly picks one of 3 types of questions, and solves it. Gives user the chance to answer, and compares
        int choice = (int) Math.ceil(Math.random() * 3);
        int x, y, m, b;
        if (choice == 1) {//Solve for Y
            x = (int) Math.ceil(Math.random() * 100); //random numbers from 1-100 generated here for values
            m = (int) Math.ceil(Math.random() * 100);
            b = (int) Math.ceil(Math.random() * 100);
            int ans = (m * x + b); //solving for the missing variable
            System.out.println("\nx value: " + x);
            System.out.println("m value(slope): " + m);
            System.out.println("b value: " + b);
            System.out.println("Enter the y value:");
            int uAns = reader.nextInt();
            if (uAns == ans) {
                System.out.println("Good Job!");
            } else {
                System.out.println("Sorry, that's wrong! The correct answer was " + ans + ".");
            }
        } else if (choice == 2) {//Solve for X
            y = (int) Math.ceil(Math.random() * 100);//random numbers from 1-100 generated here for values
            m = (int) Math.ceil(Math.random() * 100);
            b = (int) Math.ceil(Math.random() * 100);
            int ans = ((y - b) / m);//solving for the missing variable
            System.out.println(ans);
            System.out.println("\ny value: " + y);
            System.out.println("m value(slope): " + m);
            System.out.println("b value: " + b);
            System.out.println("Enter the x value's numerator (just the number if it's a whole number):");//user's answer to be divided
            int uAns1 = reader.nextInt(); //Ints used here instead of double to avoid errors (doubles were rounding weirdly)
            System.out.println("Enter the x value's denominator ('1' if it's a whole number):");//denominator to divide by
            int uAns2 = reader.nextInt();//Ints used here instead of double to avoid errors (doubles were rounding weirdly)
            int uAns = uAns1 / uAns2;//compared
            if (uAns == ans)//if same, then this
            {
                System.out.println("Good Job!");
            } else//else this
            {
                System.out.println("Sorry, that's wrong! The correct answer was " + ans + ".");
            }
        } else {//Solve for M, or slope
            y = (int) Math.ceil(Math.random() * 100);//random numbers from 1-100 generated here for values
            x = (int) Math.ceil(Math.random() * 100);
            b = (int) Math.ceil(Math.random() * 100);
            int ans = ((y - b) / x);//solving for the missing variable
            System.out.println("\ny value: " + y);
            System.out.println("x value: " + x);
            System.out.println("b value: " + b);
            System.out.println("Enter the m value's numerator (just the number if it's a whole number):"); //user's answer to be divided
            int uAns1 = reader.nextInt(); //Ints used here instead of double to avoid errors (doubles were rounding weirdly)
            System.out.println("Enter the m value's denominator ('1' if it's a whole number):"); //denominator to divide by
            int uAns2 = reader.nextInt(); //Ints used here instead of double to avoid errors (doubles were rounding weirdly)
            int uAns = uAns1 / uAns2; //compared
            if (uAns == ans)//if same, then this
            {
                System.out.println("Good Job!");
            } else//else this
            {
                System.out.println("Sorry, that's wrong! The correct answer was " + ans + ".");
            }
        }

    }

    public void printSlow(String s) {//printSlow method > to print lines slowly for easier user consumption
        for (int i = 0; i < s.length(); i++) {
            System.out.print("" + s.charAt(i)); //splits string into single chars, prints each with some delay
            try { //try
                Thread.sleep(1); //wait some time to print 
            } catch (InterruptedException m) { //catch any exceptions
                ;
            }
        }
        System.out.println();//finish the line
    }

    public void printSlower(String s) {//printSlower method > to print lines slowly for easier user consumption (for even slower text)
        for (int i = 0; i < s.length(); i++) {
            System.out.print("" + s.charAt(i));//splits string into single chars, prints each with some delay
            try {
                Thread.sleep(1);//wait some time to print 
            } catch (InterruptedException m) { //catch any exceptions
                ;
            }
        }
        System.out.println();//finish the line
    }

    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = U4_FinalProject.class.getResource(path); //finds image
        if (imgURL != null) {
            return new ImageIcon(imgURL); //to find image for later use (to place in string)
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
