package com.example.demo.Business;

import java.io.*;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    static String[] supportedFormats = {"csv", "json"};
//
//    public static void old(String[] args) throws ParseException {
//        HashMap<String, String> outputList = getFilesInformation();
//        String sourceFileFormat = outputList.get("sourceFileFormat");
//        String sourceFileLocation = outputList.get("sourceFileLocation");
//        String targetFileFormat = outputList.get("targetFileFormat");
//        String targetFileLocation = outputList.get("targetFileLocation");
//
//        try {
//            ArrayList<Transaction> sourceFileTransactions = fileToTransactions(sourceFileFormat, sourceFileLocation, "SOURCE");
//            ArrayList<Transaction> targetFileTransactions = fileToTransactions(targetFileFormat, targetFileLocation, "TARGET");
//
//            compareTransactions(sourceFileTransactions, targetFileTransactions);
//        } catch (Exception e) {
//            System.out.println("Error occurred while comparing files, please try again");
//        }
//    }

    public static Boolean contains(String[] list, String look) {
        for (String s : list) {
            if (s.equalsIgnoreCase(look)) {
                return true;
            }
        }
        return false;
    }

    public static HashMap<String, String> getFilesInformation() {

        Scanner consoleInput = new Scanner(System.in);

        System.out.println("Enter source file location:");
        String sourceFileLocation = consoleInput.nextLine();
        String sourceFileFormat = getFileFormat("source", consoleInput);

        System.out.println("Enter target file location:");
        String targetFileLocation = consoleInput.nextLine();
        String targetFileFormat = getFileFormat("target", consoleInput);

        HashMap<String, String> output = new HashMap<String, String>();
        output.put("sourceFileFormat", sourceFileFormat);
        output.put("sourceFileLocation", sourceFileLocation);
        output.put("targetFileFormat", targetFileFormat);
        output.put("targetFileLocation", targetFileLocation);

        return output;
    }

    public static String getFileFormat(String type, Scanner consoleInput) {
        System.out.println("Enter " + type + " file format:");
        String fileFormat = consoleInput.nextLine();
        while (!contains(supportedFormats, fileFormat)) {
            System.out.println(type + " file format not supported, Try Again:");
            fileFormat = consoleInput.nextLine();
        }
        return fileFormat;
    }
//
//    public static ArrayList<Transaction> fileToTransactions(String format, String location, String fileFrom) throws ParseException, java.text.ParseException {
//        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
//        if (format.toLowerCase().equals("csv")) {
//            CSVParser csvParser = new CSVParser(location, format, fileFrom);
//            transactions = csvParser.getTransactions();
//        } else {
//            JSONParser jsonParser = new JSONParser(location, format, fileFrom);
//            transactions = jsonParser.getTransactions();
//        }
//        return transactions;
//    }
//
//    public static void compareTransactionFiles(File sourceTransactionFile, File targetTransactionFile) throws IOException {
//
//        ArrayList<Transaction> matchingTransactionList = new ArrayList<Transaction>();
//        ArrayList<Transaction> mismatchingTransactionList = new ArrayList<Transaction>();
//        ArrayList<Transaction> missingTransactionList = new ArrayList<Transaction>();
//
//        for (int i = 0; i < sourceTransactionsList.toArray().length; i++) {
//
//            Transaction currentSourceTransaction = sourceTransactionsList.get(i);
//
//            for (int j = 0; j < targetTransactionsList.toArray().length; j++) {
//                Transaction currentTargetTransaction = targetTransactionsList.get(j);
//                if (currentSourceTransaction.getUniqueID().equals(currentTargetTransaction.getUniqueID())) {
//                    if (currentSourceTransaction.getAmount().equals(currentTargetTransaction.getAmount()) && currentSourceTransaction.currency.equals(currentTargetTransaction.currency) && currentSourceTransaction.valueDate.compareTo(currentTargetTransaction.valueDate) == 0) {
//                        matchingTransactionList.add(currentTargetTransaction);
//                    } else {
//
//                        mismatchingTransactionList.add(currentSourceTransaction);
//                        mismatchingTransactionList.add(currentTargetTransaction);
//                    }
//                    currentTargetTransaction.found = true;
//                    break;
//                }
//                if (j + 1 == targetTransactionsList.toArray().length) {
//                    missingTransactionList.add(currentSourceTransaction);
//                }
//            }
//
//
//        }
//
//        for (int j = 0; j < targetTransactionsList.toArray().length; j++) {
//            Transaction currentTargetTransaction = targetTransactionsList.get(j);
//            if (!currentTargetTransaction.found) {
//                missingTransactionList.add(currentTargetTransaction);
//            }
//        }

//        listToCSV("MatchingTransactions", matchingTransactionList, false);
//        listToCSV("MismatchingTransactions", mismatchingTransactionList, true);
//        listToCSV("MissingTransactions", missingTransactionList, true);

    }
//

