package com.example.demo;

import User.User;
import com.example.demo.Business.Transaction;
import com.example.demo.File.File;

import java.util.ArrayList;
import java.util.Arrays;

public class Config {

    // Database
    public static ArrayList<User> users = new ArrayList<User>(
            Arrays.asList(new User("omar", "123")));
    // Database End

    static private File currentSourceFile = null;
    static private File currentTargetFile = null;
    static private User currentUser = null;

    static private ArrayList<Transaction> matchingTransactionList = null;
    static private ArrayList<Transaction> mismatchingTransactionList = null;
    static private ArrayList<Transaction> missingTransactionList = null;

    public static ArrayList<Transaction> getMatchingTransactionList() {
        return matchingTransactionList;
    }

    public static void setMatchingTransactionList(ArrayList<Transaction> matchingTransactionList) {
        Config.matchingTransactionList = matchingTransactionList;
    }

    public static ArrayList<Transaction> getMismatchingTransactionList() {
        return mismatchingTransactionList;
    }

    public static void setMismatchingTransactionList(ArrayList<Transaction> mismatchingTransactionList) {
        Config.mismatchingTransactionList = mismatchingTransactionList;
    }

    public static ArrayList<Transaction> getMissingTransactionList() {
        return missingTransactionList;
    }

    public static void setMissingTransactionList(ArrayList<Transaction> missingTransactionList) {
        Config.missingTransactionList = missingTransactionList;
    }

    public static File getCurrentSourceFile() {
        return currentSourceFile;
    }

    public static void setCurrentSourceFile(File currentSourceFile) {
        Config.currentSourceFile = currentSourceFile;
    }

    public static File getCurrentTargetFile() {
        return currentTargetFile;
    }

    public static void setCurrentTargetFile(File currentTargetFile) {
        Config.currentTargetFile = currentTargetFile;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User user) {
        Config.currentUser = user;
    }

}
