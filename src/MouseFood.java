public class MouseFood { // created new class called MouseFood
    private int servings;
    private int smellFactor;

    public MouseFood(int pServings, int pSmellFactor){ // constructor taking parameter for BOTH private ints and assigning values
        this.servings = pServings;
        this.smellFactor = pSmellFactor;
    }

    // getter and setter for each variable (get has int, set has void) --> four methods below

    public int getServings(){
        return servings;
    }

    public void setServings(int paramServings){
        this.servings = paramServings;
    }

    public int getSmellFactor(){
        return smellFactor;
    }

    public void setSmellFactor(int paramSmellFactor){
        this.smellFactor = paramSmellFactor;
    }

    public void printInfo(){ // printInfo() method to print out values of EACH of object's variables IN READABLE WAY --> not in sentence form
        System.out.println("Servings: " + servings);
        System.out.println("Smell factor: " + smellFactor);
    }
}
