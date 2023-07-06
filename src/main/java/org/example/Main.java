package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(Objects.requireNonNull(Main.class.getClassLoader().getResourceAsStream("puzzle" + ".txt")));
        String [] command;

        //create root directory
        Directory directoryRoot = new Directory("/",null);
        Directory currentDirectory = directoryRoot;

        //Build directory tree
        while(scanner.hasNextLine()){
            command = scanner.nextLine().split(" ");
            if(command[1].equals("cd")){
                if(!command[2].contains("..")){
                    //create new child directory and set current directory = child
                    Directory newDir = new Directory(command[2], currentDirectory);
                    currentDirectory.getChildDirectories().add(newDir);
                    currentDirectory = newDir;


                } else if(command[2].contains("..")){
                    //set current directory = parent
                    currentDirectory = currentDirectory.getParentDirectory();
                }
            } else if(!command[0].contains("dir") && !command[0].contains("$")){
                //Increment current directory size
                currentDirectory.setSize(Integer.parseInt(command[0]));
            }
        }
        scanner.close();

        System.out.println("Answer to problem 1 is: " + Directory.answer1);
    }
}