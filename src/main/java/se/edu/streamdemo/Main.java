package se.edu.streamdemo;

import se.edu.streamdemo.data.Datamanager;
import se.edu.streamdemo.task.Deadline;
import se.edu.streamdemo.task.Task;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Task manager (using streams)");
        Datamanager dataManager = new Datamanager("./data/data.txt");
        ArrayList<Task> tasksData = dataManager.loadData();

//        System.out.println("Printing all data ...");
//        printAllData(tasksData);
//        printDataWithSteams(tasksData);

//        System.out.println("Printing deadlines ...");
//        printDeadlines(tasksData);
//        printDeadlinesUsingStream(tasksData);

        System.out.println("Total number of deadlines(iterating): " + countDeadlines(tasksData));
        System.out.println("Total number of deadlines(streams): " + countDeadlinesWithSteams(tasksData));


    }

    private static int countDeadlines(ArrayList<Task> tasksData) {
        System.out.println("Counting deadlines with iteration");
        int count = 0;
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                count++;
            }
        }
        return count;
    }

    public static void printAllData(ArrayList<Task> tasksData) {
        System.out.println("Printing data with iteration");
        for (Task t : tasksData) {
            System.out.println(t);
        }
    }

    public static void printDataWithSteams(ArrayList<Task> tasks){
        System.out.println("Printing data with streams");
        tasks.stream()                         //create stream
                .forEach(System.out::println); //terminal operator
    }

    public static void printDeadlines(ArrayList<Task> tasksData) {
        System.out.println("Printing Deadlines with iteration");
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                System.out.println(t);
            }
        }
    }

    public static void printDeadlinesUsingStream(ArrayList<Task> tasks){
        System.out.println("Printing Deadlines with streams");
        tasks.stream()
                .filter(t -> t instanceof Deadline) //lambda function
                .forEach(System.out::println);
    }

    public static int countDeadlinesWithSteams(ArrayList<Task> tasks){
        System.out.println("Counting deadlines with streams");
        return (int)tasks.stream()
                .filter(t -> t instanceof Deadline)
                .count(); //terminal operation; aggregate operation
    }
}
