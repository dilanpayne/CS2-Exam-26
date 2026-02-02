import com.sun.security.jgss.GSSUtil;

public class House { // opened class called house
    public String message = "A7#q 9mA$%2mn!!8my@4mt^6mh&1mi*3mn(0mgZ9m 4wfymt@7mh# 5ma$2mt!8m mmma%3mk^4me&6ms*1m Q12mm &2-me#7m mc$9mu!5mt@8m 6hM.mt^4mh&6me *3m R7mc@2mh#9me$5me!832ms^4me&6m.";

    MouseFood[] mousePantry; // step 1 of making array called mousePantry

    public static void main(String[] args) { // put psvm
        House place = new House(); // from psvm, I made a new house object (place)
    }

    public House(){ // made a constructor
        System.out.println("Hello, mouse! Get out of my house!"); // test that it is a runnable class by printing this test string

        mousePantry = new MouseFood[18]; // step 2 of making array called mousePantry (makes 18 shelves)

        for (int i = 0; i < mousePantry.length; i++){
            int serve = (int)(Math.random()*200 + 1); // see scrap paper beneath step 6 for thought process!
            int smell = (int)(Math.random()*491 + 10); // see scrap paper beneath step 6 for thought process!
            mousePantry[i] = new MouseFood(serve, smell); // step 3 of making array called mousePantry (fills 18 shelves with stuff)
        }

        displayMousePantry(); // STEP 5, at bottom of House() constructor, calling displayMousePantry() --> beneath for loop making array
        System.out.println("It is " + checkServings() + " that two or more 'servings' numbers are equal."); // STEP 6, at bottom of House() constructor, calls checkServings() method WITHIN a print to print it in a sentence
        System.out.println("The decoded message is '" + decipher(message) + "'"); // STEP 7, at the bottom of House() constructor, cals decipher method, passing message as a parameter. Prints the message as a sentence.
        makeSmells(); // STEP 8, at the bottom of House(), call makeSmells() method
        displayMousePantry(); // STEP 8, calls displayMousePantry() method again to show that the method was successful
    }

    public void displayMousePantry(){ // make new method called displayMousePantry()
        for (int i = 0; i < mousePantry.length; i++){ // looping through elements of mousePantry array. length is 1 longer than pantry starting at 0, so the less than sign helps to exclude nonexistent.
            System.out.println(); // For readability
            System.out.println("Food #" + i); // For readability
            mousePantry[i].printInfo(); // call printInfo() method on every MouseFood object in the pantry array
            System.out.println(); // For readability
        }
    }

    public boolean checkServings(){ // method called checkServings() that returns a boolean
        boolean isSame = false; // boolean to be returned at end, checking if two+ servings are same

        for (int i = 0; i < mousePantry.length; i++){ // looping through all shelves of mousePantry
            for (int j = 0; j < mousePantry.length; j++){ // looping through all shelves of mousePantry a second time using a new integer
                if (mousePantry[i].getServings() == mousePantry[j].getServings() && i != j){ // checking IF the servings of one shelf is the same as the servings value of another shelf AND being sure it isn't just checking the same shelf twice
                    isSame = true; // set boolean to true because we found same stuff
                    System.out.println(); // Readability
                    System.out.println("FOUND SOME SAME STUFF:"); // It will print all this stuff twice, because it finds it when something is i and j
                    System.out.println("i: " + mousePantry[i].getServings());
                    System.out.println("j: " + mousePantry[j].getServings());
                }
            }
        }
        System.out.println(isSame); // my check, not in directions
        return isSame; // returns true if at least two servings numbers are equal. Otherwise, returns false
    }

    public String decipher(String gibberish){ // new method called decipher() that takes a String as parameter and returns a String. Mx. Bradford said it was OK to have "gibberish" as the parameter passed in, just that "message" must be the variable to be decoded
        String decodedString = ""; // empty canvas to string together all the subs into a larger decoded message. String to be returned at end
        int loc = gibberish.indexOf("m"); // finds location of the first "m" starting from index = 0

        while (loc != -1){ // while loop to decode. while the location of m is within string (moving down string until no longer exists)
            if (loc + 1 < gibberish.length() && loc - 1 != gibberish.indexOf("m", loc-2)){ // see front page of instructions for work
                String sub = gibberish.substring(loc+1, loc+2); // finding character one in front of the "m," sandwiching it from front and back (+1 and +2)
//                System.out.println();
//                System.out.println("Index of m for sub:" + loc+1);
//                System.out.println(sub);
                decodedString = decodedString + sub; // adding the character to decodedString
            }
            loc = gibberish.indexOf("m", loc+1); // outside if statement so we don't get stuck, moving to next m (looking for m starting from one past old m)
        }

        System.out.println(decodedString);
        return decodedString; // returns decodedString at the end of the method
    }

    public void makeSmells(){ // new method called makeSmells()
        for (int i = 0; i < mousePantry.length; i++){ // loop through every MouseFood in mousePantry
            mousePantry[i].setSmellFactor((int)(Math.random()*491 + 10)); // DILAN'S STEP 1 (see paper for step 8): reassigns a new smellFactor for every mouse in the array, inclusive 10-500
        }

        displayMousePantry(); // for me, shows me the new reassigned values, which may have identical smells still



//        mousePantry[1].setSmellFactor(2); --> this was my way of checking that it would still work with multiple identical values
//        mousePantry[2].setSmellFactor(2);
//        mousePantry[3].setSmellFactor(3);
//        mousePantry[4].setSmellFactor(3);

        for (int i = 0; i < mousePantry.length; i++){ // similarly to check servings, 2 loops which can check against each other to find identical smellFactors
            for (int j = 0; j < mousePantry.length; j++){
                if (mousePantry[i].getSmellFactor() == mousePantry[j].getSmellFactor() && i != j) { // if two smellFactors from DIFFERENT shelves are the sam
                        System.out.println("Found two same! They are...");
                        System.out.println(mousePantry[i].getSmellFactor() + " AND " + mousePantry[j].getSmellFactor());

                        while(mousePantry[i].getSmellFactor() == mousePantry[j].getSmellFactor()) {
                            mousePantry[i].setSmellFactor((int) (Math.random() * 491 + 10)); // change just one of the smellFactors so that the two will be distinct
                            System.out.println("changed i to " + mousePantry[i].getSmellFactor());
                        }
                    }
                }
            }
        }

    }
