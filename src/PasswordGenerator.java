import java.util.*;
import java.io.*;

public class PasswordGenerator {
  public static void main(String[] args) throws IOException {
    // Load the input file into a list of strings
    List<String> input = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
      String line;
      while ((line = reader.readLine()) != null) {
        input.add(line);
      }
    }

    // Create a HashMap of replacement words
    Map<String, String> replacements = new HashMap<>();
    replacements.put("apple", "Appl3");
    replacements.put("banana", "B@n@n@");
    replacements.put("cherry", "Ch3rry");
    replacements.put("and","&");
    replacements.put("with","w/");
    replacements.put("without","wo/");
    replacements.put("love you","lu");
    replacements.put("you","u");
    replacements.put("You","U");
    replacements.put("whatever","w/e");
    replacements.put("You my queen","Ymq");
    replacements.put("everything", "evth");
    replacements.put("right now", "rn");
    replacements.put("Right now", "rn");

    // Create a Scanner object for user input
    Scanner scanner = new Scanner(System.in);

    // Display the menu and process user input
    while (true) {
      System.out.println("Menu:");
      System.out.println("1. Generate password");
      System.out.println("2. Add new acronym to HashMap");
      System.out.println("3. Quit program");

      int choice = scanner.nextInt();
      scanner.nextLine(); // consume the newline character

      switch (choice) {
        case 1:
          // Select a random string from the input list and replace some words
          Random rand = new Random();
          String selected = input.get(rand.nextInt(input.size()));
          for (String key : replacements.keySet()) {
            selected = selected.replaceAll(key, replacements.get(key));
          }

          // Output the resulting password
          System.out.println("Generated password: " + selected);
          break;

        case 2:
          // Prompt the user for a new acronym and replacement value
          System.out.print("Enter new acronym: ");
          String acronym = scanner.nextLine();
          System.out.print("Enter replacement value: ");
          String replacement = scanner.nextLine();

          // Add the new acronym and replacement value to the HashMap
          replacements.put(acronym, replacement);
          System.out.println("Acronym added to HashMap.");
          break;

        case 3:
          // Quit the program
          System.out.println("Exiting program...");
          System.exit(0);

        default:
          // Invalid input, display an error message and loop back to the menu
          System.out.println("Invalid input, please try again.");
          break;
      }
    }
  }
}
