import java.io.FileWriter;
import java.sql.SQLOutput;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner myScan = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to Pure Math Club Blurb Writer");
        startMenu();
    }
    public static void startMenu() {
        System.out.println("Choose from the following options:");
        System.out.println("Enter 1 to create a new social event");
        System.out.println("Enter 2 to create a new Prof Talk");
        System.out.println("Enter 3 to create a review session");
        System.out.println("Enter 9 to see credits");
        System.out.println("Enter 0 to exit");
        int option = myScan.nextInt();
        chooseOption(option);
    }
    public static void chooseOption(int optionNum) {
        if (optionNum == 1) {
            newSocialEvent();
        }
        if (optionNum == 2) {
            newProfTalk();
        }
        if (optionNum == 3) {
            newReviewSession();
        }
        if (optionNum == 9) {
            credits();
        }
        if (optionNum == 0) {
            System.out.println("Goodbye");
        }
    }
    public static void newSocialEvent() {
        System.out.println("What date is your event?");
        myScan.nextLine();
        String date = myScan.nextLine();
        System.out.println("What time is your event?");
        String time = myScan.nextLine();
        System.out.println("What room is your event in?");
        String location = myScan.nextLine();
        System.out.println("What is the name of your event?");
        String title = myScan.nextLine();
        System.out.println("Will there be food for members? Type Y or N");
        boolean isFood = processYN(myScan.nextLine());
        System.out.println("Will there be prizes for members? Type Y or N");
        boolean isPrize = processYN(myScan.nextLine());
        System.out.println();
        String blurb = processSocialEvent(date, time, location, title, isFood, isPrize);
        saveFile(title, blurb);
        startMenu();
    }
    public static void newProfTalk() {
        System.out.println("What date is your event?");
        myScan.nextLine();
        String date = myScan.nextLine();
        System.out.println("What time is your event?");
        String time = myScan.nextLine();
        System.out.println("What room is your event in?");
        String location = myScan.nextLine();
        System.out.println("PMath, Amath, or C&O Prof Talk? Type P, A, or C");
        String field = processField(myScan.nextLine());
        System.out.println("Who is the professor? Type full name only.");
        String professor = myScan.nextLine();
        System.out.println("What is the title of the talk?");
        String title = myScan.nextLine();
        System.out.println("What is the abstract?");
        String myAbstract = myScan.nextLine();
        System.out.println("Is there food for members? Type Y or N");
        boolean isFood = processYN(myScan.nextLine());
        String blurb = processProfTalk(date, time, location, field, professor, title, myAbstract, isFood);
        saveFile(title, blurb);
        startMenu();
    }
    public static void newReviewSession() {
        System.out.println("What date is your event?");
        myScan.nextLine();
        String date = myScan.nextLine();
        System.out.println("What time is your event?");
        String time = myScan.nextLine();
        System.out.println("What room is your event in?");
        String location = myScan.nextLine();
        System.out.println("Which course is this review session for?");
        String course = myScan.nextLine();
        System.out.println("Is this for midterm or final review? Type midterm or final");
        String examType = myScan.nextLine();
        String blurb = processReviewSession(date, time, location, course, examType);
        saveFile((course + examType), blurb);
        startMenu();
    }
    public static String processField(String abbreviatedField) {
        if (abbreviatedField.equals("P")) {
            return "PMATH";
        } else if (abbreviatedField.equals("A")) {
            return "AMATH";
        } else if (abbreviatedField.equals("C")) {
            return "C&O";
        } else {
            return "ERROR";
        }
    }
    public static String processSocialEvent
            (String date, String time, String location, String title, boolean isFood, boolean prize) {
        int randomNum = (int)(Math.random() * 101);
        String description = "Discord Message:\n";
        if (randomNum % 2 == 0){
            description += "Hello @everyone! ";
        } else {
            description += "Hi @everyone! ";
        }
        description += "Come join us at " + title + " to [description]! ";
        if (isFood) {
            description += "Food will be provided to members. ";
        }
        if (prize) {
            description += "There will be prizes for members to win! ";
        }
        description += "Bring your friends and have some fun! Hope to see you there!\n";
        description += "Date: " + date + "\n";
        description += "Time: " + time + "\n";
        description += "Location: " + location + "\n";

        System.out.println(description);
        return description;
    }
    public static String processProfTalk
            (String date, String time, String location, String field,
             String professor, String title, String myAbstract, boolean isFood) {
        int randomNum = (int)(Math.random() * 101);
        String description = "Discord Message:\n";
        if (randomNum % 2 == 0){
            description += "Hello @everyone! ";
        } else {
            description += "Hi @everyone! ";
        }
        description += "Our " + field + " Prof Talk with Professor " + professor + " is coming up soon! ";
        description += "The talk is on " + title + ".\n";
        description += "Abstract: " + myAbstract + "\n";
        if (isFood) {
            description += "Food will be provided to members.\n";
        }
        description += "Bring your friends and learn some math! Hope to see you there!\n";
        description += "Date: " + date + "\n";
        description += "Time: " + time + "\n";
        description += "Location: " + location + "\n";
        System.out.println(description);
        return description;
    }
    public static String processReviewSession
            (String date, String time, String location, String course, String examType) {
        int randomNum = (int)(Math.random() * 101);
        String description = "Discord Message:\n";
        if (randomNum % 2 == 0){
            description += "Hello @everyone! ";
        } else {
            description += "Hi @everyone! ";
        }
        description += "Come study with us for the upcoming " + course + " " + examType + "!\n";
        description += "Bring your classmates! Hope to see you there!\n";
        description += "Date: " + date + "\n";
        description += "Time: " + time + "\n";
        description += "Location: " + location + "\n";
        System.out.println(description);
        return description;
    }
    public static void credits() {
        System.out.println("Credits: Created by Jason Tang");
        System.out.println("Fall 2025 - Winter 2026 VP Propaganda of Pure Math Club");
        System.out.println();
        startMenu();
    }
    public static boolean processYN(String yesno) {
        return (yesno.equals("Y") || yesno.equals("y"));
    }
    public static void saveFile(String title, String blurb) {
        System.out.println("Save to file? Type Y or N");
        boolean isSave = processYN(myScan.nextLine());
        if (isSave) {
            processFile(title, blurb);
        }
    }
    public static void processFile(String shortFileName, String description) {
        String longFileName = "C:\\Users\\35jta\\OneDrive\\Documents\\PMC Files\\"
                + shortFileName + ".txt";
        createFile(longFileName);
        writeToFile(longFileName, description);
    }
    public static void createFile(String fileName) {

        try {
            File myObj = new File(fileName);
            if (myObj.createNewFile()) {     // Try to create the file
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
    public static void writeToFile(String fileName, String description) {
        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(description);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}