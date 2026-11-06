/* 
    I have only used resources indicated that are allowable. The work submitted is my, and only my work.
    Signature: Nicholas Foles
    Date: 11/6/2026
*/

/*

    Notes for self:
    use input.nextLine() with no variable equal to it to delay messages
    lock in

*/

import java.util.Scanner;

public class FolesMidtermTwo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean genderChoiceLoop = true;
        int genderChoice = 0;
        String subjectPronoun = "";
        String objectPronoun = "";
        String possessivePronoun = "";
        String isOrAre = "";

        System.out.println("Welcome to Foles RPG (name still a work in progress). What name will you have for this RPG?");
        String name = input.nextLine();

        System.out.println("Hello, " + name + "! Now, what gender would you prefer for this RPG? (1: He/Him | 2: She/Her | 3: They/Them)");
        while (genderChoiceLoop) {
            try {
                genderChoice = input.nextInt();
                if (genderChoice == 1 || genderChoice == 2 || genderChoice == 3) {
                    genderChoiceLoop = false;
                } else {
                    throw new InvalidPronouns();
                }
            } catch (Exception e) {
                System.out.println("It appears you've input an invalid answer! Please try again.");
                input.nextLine();
            }
        }

        switch (genderChoice) {
            case 1 -> {subjectPronoun = "he"; objectPronoun = "him"; possessivePronoun = "his"; isOrAre = "is";}
            case 2 -> {subjectPronoun = "she"; objectPronoun = "her"; possessivePronoun = "her"; isOrAre = "is";}
            case 3 -> {subjectPronoun = "they"; objectPronoun = "them"; possessivePronoun = "their"; isOrAre = "are";}
        }
    }

    /**
     * Literally just capitalizes the first letter of the word.
     * @param word the word to be capitalized
     * @return the word with a capitalized first letter
     */
    public static String capFirstLetter(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
}

class Player {
    String name;

    Player(String name) {
        this.name = name;
    }
}

class InvalidPronouns extends Exception {
    public InvalidPronouns() {
        super();
    }

    public InvalidPronouns(String message) {
        super(message);
    }
}