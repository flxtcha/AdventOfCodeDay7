package org.example;

import java.util.ArrayList;

public class Directory {
    private String name;
    private Directory parentDirectory;
    private ArrayList<Directory> childDirectories;
    private Integer size;
    static Integer answer1;

    public Directory(String name, Directory parentDirectory) {

        this.name = name;
        this.parentDirectory = parentDirectory;
        this.childDirectories = new ArrayList<Directory>();
        this.size = 0;
        this.answer1 = 0;
    }
    public Directory(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Directory getParentDirectory() {
        return parentDirectory;
    }

    public void setParentDirectory(Directory parentDirectory) {
        this.parentDirectory = parentDirectory;
    }

    public ArrayList<Directory> getChildDirectories() {
        return childDirectories;
    }

    public void setChildDirectories(ArrayList<Directory> childDirectories) {
        this.childDirectories = childDirectories;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size += size;
    }

    @Override
    public String toString() {
        return "Directory{" +
                "name='" + name + '\'' +
                ", parentDirectory=" + parentDirectory +
                ", childDirectories=" + childDirectories +
                ", size=" + size +
                '}';
    }

    public int totalFileSize() {
        int totalFileSize = this.size;

        //recursively increment totalfilesize on each directory in the tree
        for(Directory child : this.childDirectories) {
            totalFileSize += child.totalFileSize();
        }

        //Increment answer1
        if(totalFileSize <= 100_000) {
            this.answer1 += totalFileSize;
        }

        return totalFileSize;
    }


}
