# Mini Hospital Emergency Management System

This is a console-based Java application simulating a Mini Hospital Emergency Management System. It uses various fundamental data structures to manage patient records, emergency queues, treatment histories, and patient visits.

## Data Structures Used

1. **Binary Search Tree (BST)**: Used for managing `Patient Records`. The BST allows efficient insertion, search, and deletion using the unique `Patient ID` as the key.
2. **Queue (FIFO)**: Used for the `Emergency Patient Queue`. Ensures that patients arriving at the emergency unit are treated in the order they arrive (First-In, First-Out).
3. **Stack (LIFO)**: Used for the `Treatment History`. Keeps track of the completed treatments in reverse chronological order (Last-In, First-Out), so the most recent treatment is always at the top.
4. **Singly Linked List**: Used for the `Patient Visit History`. Every patient object holds a reference to a linked list tracking their individual previous hospital visits.

## How to Compile and Run

1. Open a terminal or command prompt in the root of the project directory.
2. Compile the Java files:
   ```bash
   javac -d bin src/models/*.java src/datastructures/*.java src/Main.java
   ```
3. Run the application:
   ```bash
   java -cp bin Main
   ```

## Usage

When you run the application, you will be presented with a menu. Follow the on-screen prompts to register patients, manage the emergency queue, complete treatments, and view histories.

## Assignment Video Requirements
For the final submission, you will need to record a 5-10 minute video.
Make sure to demonstrate:
- A brief introduction with your face visible.
- Code explanation of how each data structure (BST, Queue, Stack, Linked List) was implemented.
- System demonstration running the CLI menu.
- Your GitHub commit history (`git log --oneline`).
- A reflection on what you learned.
