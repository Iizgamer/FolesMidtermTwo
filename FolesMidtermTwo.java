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
        boolean classChoiceLoop = true;
        boolean userResponseLoop = true;
        int genderChoice = 0;
        int classChoice = 0;
        int userMaxHP = 0;
        int userATK = 0;
        int userResponse = 0;
        String subjectPronoun = "";
        String objectPronoun = "";
        String possessivePronoun = "";
        String isOrAre = "";
        String userClass = "";

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

        System.out.println("Alright, and last question: which class would you like? (1: Warrior - High Defense, Low Attack | 2: Ranger - Medium Defense, Medium Attack | 3: Mage - Low Defense, High Attack)");
        while (classChoiceLoop) {
            try {
                classChoice = input.nextInt();
                if (classChoice == 1 || classChoice == 2 || classChoice == 3) {
                    classChoiceLoop = false;
                } else {
                    throw new InvalidClass();
                }
            } catch (Exception e) {
                System.out.println("It appears you've input an invalid answer! Please try again.");
                input.nextLine();
            }
        }

        switch (classChoice) {
            case 1 -> {userClass = "Warrior"; userMaxHP = 125; userATK = 15;}
            case 2 -> {userClass = "Ranger"; userMaxHP = 100; userATK = 25;}
            case 3 -> {userClass = "Mage"; userMaxHP = 75; userATK = 35;}
        }

        Player player = new Player(name);

        System.out.println("Alright, and with that, let's get this game started!");
        input.nextLine();
        System.out.println(name + " is a " + userClass + " in the wonderful land of Jwetmalf. " + upperFirst(subjectPronoun) + " " + isOrAre + " tasked with protecting Princess Figas, the fairest in the land.");
        input.nextLine();
        System.out.println("Princess Figas: \"" + name + "! I demand you to go out and attack the opposing kingdom!\"");
        input.nextLine();
        System.out.println("How do you respond?\n1: Absolutely, madam! I shall be back before sundown! | 2: No brah, I ain't doin' allat.");
        
        while (userResponseLoop) {
            try {
                userResponse = input.nextInt();
                if (userResponse == 1 || userResponse == 2) {
                    userResponseLoop = false;
                } else {
                    throw new InvalidResponse();
                }
            } catch (Exception e) {
                System.out.println("Princess Figas: \"What? Speak up, " + name + "!\"");
                input.nextLine();
            }
        }
        userResponseLoop = true;

        switch (userResponse) {
            case 1 -> System.out.println(name + ": \"Absolutely, madam! I shall be back before sundown!\"\n\nPrincess Figas: \"Good! Now go!\"");
            case 2 -> System.out.println(name + ": \"No brah, I ain't doin' allat.\"\n\nPrincess Figas: \"What?! How dare you go against my decree! Go now or it shall be off with your head!\"");
        }

        input.nextLine(); input.nextLine(); // can't explain why I need two input.nextLine()s but I do, so here it is.

        System.out.println(name + " decides to head off to Plumaland, the enemy's capital. Whether or not it was according to " + possessivePronoun + " own will does not matter, as " + subjectPronoun + " would've eventually gone anyways.");

        input.nextLine();

        System.out.println("After a day's travel, " + name + " arrives in Plumaland, a singular castle lies waiting for " + name + ". Suddenly, the drawbridge lowers...");
        input.nextLine();
        System.out.println("...and keeps lowering...");
        input.nextLine();
        System.out.println("...and keeps lowering...");
        input.nextLine(); input.nextLine(); input.nextLine();
        System.out.println("They really should invest into a quicker drawbridge.");
        input.nextLine();
        System.out.println("Suddenly-\nSir Yonaza: \"Halt! Your travels and life end here!\"");
        input.nextLine();
        System.out.println("Standing on the otherside of the drawbridge stands Sir Yonaza, the knight of this castle. He draws his blade, preparing to duel.");
        input.nextLine();
        System.out.println("How will you respond?\n1: Prepare to face my wrath! | 2: Dude, I don't even wanna fight.");
        while (userResponseLoop) {
            try {
                userResponse = input.nextInt();
                if (userResponse == 1 || userResponse == 2) {
                    userResponseLoop = false;
                } else {
                    throw new InvalidResponse();
                }
            } catch (Exception e) {
                System.out.println("Sir Yonaza: \"What? Speak up chum!\"");
                input.nextLine();
            }
        }

        switch (userResponse) {
            case 1 -> System.out.println(name + ": \"Prepare to face my wrath!\"\n\nSir Yonaza: \"It shall be you facing the wrath!\"");
            case 2 -> System.out.println(name + ": \"Dude, I don't even wanna fight.\"\n\nSir Yonaza: \"Your tricks shall not deceive me! Prepare for battle, fool!\"");
        }

        input.nextLine(); input.nextLine();

        System.out.println("BATTLE START!");

        input.nextLine();

        tutorialBattle(input, name, userMaxHP, userATK, "Sir Yonaza", 100, 10);
    }

    /**
     * Literally just capitalizes the first letter of the word.
     * @param word the word to be capitalized
     * @return the word with a capitalized first letter
     */
    public static String upperFirst(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    public static void tutorialBattle(Scanner input, String playerName, int playerHP, int playerATK, String enemyName, int enemyHP, int enemyATK) {
        int turnSelection = 0;
        boolean turnSelectionLoop = true;

        System.out.println("\nSir Yonaza: \"Halt! You don't even know how to fight, do you? I shall not fight a defenseless fool!\"");
        input.nextLine();
        System.out.println("HP: " + playerHP + " | EHP: " + enemyHP + "\n1: Attack\n2: Item\n3: Other Actions\n\nSir Yonaza: \"This is your turn menu! Notice your three options: attacking, items, or other actions!\"");
        input.nextLine();
        System.out.println("Sir Yonaza: \"First, attacking! The only action you should be worried about! Attacking is how you cut down your enemies, reducing their HP until EHP equals 0!\"");
        input.nextLine();
        System.out.println("Sir Yonaza: \"Next, items! You shall never touch items! Only weaklings use items in the midst of battle! But, if you're willing to be humiliated, items can be used to heal you during battle or can be used to boost stats during battle, such as attack.\"");
        input.nextLine();
        System.out.println("Sir Yonaza: \"Finally, other actions! Although attacking should always be your first option, you may use other actions to intimidate your opponent and ONLY to intimidate your opponent! Every other option is useless and shouldn't be touched! Don't even consider it!\"");
        input.nextLine();
        System.out.println("Sir Yonaza: \"Now, prepare to die!\"");
        input.nextLine();

        // god this is gonna take forever
        System.out.println("BATTLE START! (for real this time)");
        input.nextLine();
        while (playerHP > 0 && enemyHP > 0) {
            System.out.println("HP: " + playerHP + " | EHP: " + enemyHP + "\n1: Attack\n2: Item\n3: Other Actions");
            while (turnSelectionLoop) {
                try {
                    turnSelection = input.nextInt();
                    if (turnSelection == 1 || turnSelection == 2 || turnSelection == 3) {
                        turnSelectionLoop = false;
                    } else {
                        throw new InvalidTurnSelection();
                    }
                } catch (Exception e) {
                    System.out.println("Incorrect turn selection received! Please try again!");
                    input.nextLine();
                }
            }
            turnSelectionLoop = true;
            if (turnSelection == 1) {
                // start programming back here
            }
        }

    }
}

class Player {
    String name;

    Player(String name) {
        this.name = name;
    }
}

class Enemy {
    String name;

    Enemy(String name) {
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

class InvalidClass extends Exception {
    public InvalidClass() {
        super();
    }

    public InvalidClass(String message) {
        super(message);
    }
}

class InvalidResponse extends Exception {
    public InvalidResponse() {
        super();
    }

    public InvalidResponse(String message) {
        super(message);
    }
}

class InvalidTurnSelection extends Exception {
    public InvalidTurnSelection() {
        super();
    }

    public InvalidTurnSelection(String message) {
        super(message);
    }
}