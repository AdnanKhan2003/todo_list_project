# TodoList App

A CLI-based To-Do List application in Java


## Live Demo:

https://github.com/user-attachments/assets/b8ef7bb4-53fb-4c05-be73-ef17b47025a7


## Features:

 - **Add** a To-Do List Item: Allows users to add a new task.
 - **Edit** a To-Do List Item: Allows users to edit the description of an existing task.
 - **Delete** a To-Do List Item: Allows users to delete a task.
 - **Sort** To-Do List: Allows users to sort tasks alphabetically.
 - **View** the To-Do List: After any operation, the updated list is displayed.


## Code Structure

#### I] Task class
#### i. The Task class holds a task description (String description).

```http
  class Task { 
    String description;

    public Task(String description) {
        this.description = description;
    }
  }
```

#### ii. It has a toString() method to print the task.

```http
  class Task {
    String description;
    public Task(String description) { ... }

    @Override
    public String toString() {
        return description;
    }
  }
```

#### II] TodoListApp class:

#### This class handles all the logic of the application.
#### i. It uses an ArrayList called tasks to store all the tasks.


```http
  public class TodoListApp { 
    public static final ArrayList<Task> tasks = new ArrayList<>();

    // ...
  }
```

#### ii. It uses an ArrayList called tasks to store all the tasks.


#### III] Methods:

 | Method | Type     | Description                |
 | :-------- | :------- | :------------------------- |
 | `.showMenu()` | `void` | Displays the menu with options.
 | `.getUserChoice()` | `int` | Reads and returns the user's menu choice.
 | `.addTask()` | `void` | Adds a new task to the list.
 | `.editTask()` | `void` | Edits an existing task by asking the user to select a task and providing a new description.
 | `.deleteTask()` | `void` | Deletes a task from the list.
 | `.sortTasks()` | `void` | Sorts tasks alphabetically by description.
 | `.viewTasks()` | `void` | Adds a new task to the list.

#### Key Points:


#### 1. This program continuously loops, showing the menu until the user chooses to exit (option 6).
#### 2. After every operation (add, edit, delete, or sort), the list of tasks is shown again.
#### 3. Tasks are indexed starting from 1 for better readability.
