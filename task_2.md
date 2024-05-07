# The Secret Diary - Part 2

## Problem Statement

DFCorp would like to introduce a new option for Users to change the type of lock they use to protect their diary.  The original prototype only supported a numeric lock, but now they would like to support a password lock as well. This password lock will allow a user to set a password and then use that password to unlock the diary.

---

## Task 2

- From the Problem Statement above, create User Stories to describe the required functionality of the Secret Diary
- With these User Stories, add them to your Kanban board
- From the User Stories, identify the Objects and Messages that will make up the system and generate Domain Models
  - Ensure that you are following the *Single Responsibility Principle* for each block of code
- Test-Drive the creation of the prototype based on your User Stories, decoupling any of the code as necessary

---

## Additional Requirements

DFCorp would like you to add the following functionality to the prototype:

- The user should be able to set a password/pin when the lock is created
- The user should be able to change the password/pin, confirming the entry and saving the new password/pin to a file
- The user should be able to delete an entry in the diary
- The password or pin should be stored in a file and loaded in when the application starts
  - This file should contain a default password and pin that is used until the user changes the password/pin
- The diary entries should be stored in a file and loaded in when the application starts

For each of these, create a User Story, Domain Model and test-drive the development of the functionality.

---

## Crib Code

### Obtaining User Input in a Console Application

In a **Java** console application, you can use the `Scanner` class from the `java.util` package to get user input. Here's a basic example:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your input: ");
        String input = scanner.nextLine();

        System.out.println("You entered: " + input);

        scanner.close();
    }
}
```

In this code, a `Scanner` object is created to read the input from `System.in` (the keyboard). The `nextLine` method is used to get the user input as a string. Once the input is obtained, it's printed to the console. Finally, the `Scanner` is closed using the `close` method.

---

### Outputting Data to a File from a Console Application

In a **Java** console application, you can use the `PrintWriter` class to write an `ArrayList` to a text file. Here's an example:

```java
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("item1");
        list.add("item2");
        list.add("item3");

        try (PrintWriter out = new PrintWriter("output.txt")) {
            for (String item : list) {
                out.println(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

In this code, an `ArrayList` of strings is created and populated with some items. A `PrintWriter` is then used to write each item in the `ArrayList` to a new line in a file named `output.txt`. If an `IOException` is caught, the stack trace is printed to the console.

---

### Reading Data from a File in a Console Application

In **Java**, you can use the `Scanner` class along with an `ArrayList` to read data from a text file into an `ArrayList`. Here's an example:

```java
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("input.txt"))) {
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Print the ArrayList to verify the contents
        for (String item : list) {
            System.out.println(item);
        }
    }
}
```

In this code, an `ArrayList` of strings is created. A `Scanner` is then used to read each line from a file named `input.txt` and add it to the `ArrayList`. If a `FileNotFoundException` is caught, the stack trace is printed to the console. Finally, the contents of the `ArrayList` are printed to the console to verify that the data was read correctly.

Back to [Part 1](README.md)
