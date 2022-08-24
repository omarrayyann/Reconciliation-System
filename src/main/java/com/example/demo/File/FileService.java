package com.example.demo.File;

import com.example.demo.Business.Parser;
import com.example.demo.Business.Transaction;
import com.example.demo.Config;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@Service
public class FileService {

    public String uploadFile(String name, String format, MultipartFile file, String type, ArrayList<String> lines) {

        if(name.isEmpty()){
            return "Enter a source name";
        }
        if(file.isEmpty()){
            return "Upload a file";
        }

        File currentFile = new File(name, format, file, lines, type);

        if (type.equals("Source")){
            Config.setCurrentSourceFile(currentFile);
        }
        else{
            Config.setCurrentTargetFile(currentFile);
        }

        return "Success";

    }


    public static void compareTransactionFiles(File sourceTransactionFile, File targetTransactionFile) throws IOException, ParseException {

        ArrayList<Transaction> matchingTransactionList = new ArrayList<Transaction>();
        ArrayList<Transaction> mismatchingTransactionList = new ArrayList<Transaction>();
        ArrayList<Transaction> missingTransactionList = new ArrayList<Transaction>();

        Parser parser = new Parser(Config.getCurrentSourceFile());
        ArrayList<Transaction> sourceTransactionsList = parser.getTransactions();

        parser = new Parser(Config.getCurrentTargetFile());
        ArrayList<Transaction> targetTransactionsList = parser.getTransactions();

        for (int i = 0; i < sourceTransactionsList.toArray().length; i++) {

            Transaction currentSourceTransaction = sourceTransactionsList.get(i);

            for (int j = 0; j < targetTransactionsList.toArray().length; j++) {
                Transaction currentTargetTransaction = targetTransactionsList.get(j);
                if (currentSourceTransaction.getUniqueID().equals(currentTargetTransaction.getUniqueID())) {
                    if (currentSourceTransaction.getAmount().equals(currentTargetTransaction.getAmount()) && currentSourceTransaction.getCurrency().equals(currentTargetTransaction.getCurrency()) && currentSourceTransaction.getValueDate().compareTo(currentTargetTransaction.getValueDate()) == 0) {
                        matchingTransactionList.add(currentTargetTransaction);
                    } else {

                        mismatchingTransactionList.add(currentSourceTransaction);
                        mismatchingTransactionList.add(currentTargetTransaction);
                    }
                    currentTargetTransaction.setFound(true);
                    break;
                }
                if (j + 1 == targetTransactionsList.toArray().length) {
                    missingTransactionList.add(currentSourceTransaction);
                }
            }


        }

        for (int j = 0; j < targetTransactionsList.toArray().length; j++) {
            Transaction currentTargetTransaction = targetTransactionsList.get(j);
            if (!currentTargetTransaction.getFound()) {
                missingTransactionList.add(currentTargetTransaction);
            }
        }

        Config.setMatchingTransactionList(matchingTransactionList);
        Config.setMismatchingTransactionList(mismatchingTransactionList);
        Config.setMissingTransactionList(missingTransactionList);

    }

    public static void listToCSV(String fileName, ArrayList<Transaction> transactions, Boolean showKind) throws IOException {

        java.io.File matchingFile = new java.io.File("src/main/webapp/files/" + fileName + ".csv");
        FileWriter fileWriter = new FileWriter(matchingFile);
        StringBuilder line = new StringBuilder();
        if (showKind) {
            line.append("found in file,");
        }
        line.append("transaction id,amount,currency code,value date\n");
        fileWriter.write(line.toString());

        for (Transaction transaction : transactions) {
            line = new StringBuilder();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String strDate = dateFormat.format(transaction.getValueDate());
            if (showKind) {
                line.append(transaction.getFrom() + ",");
            }
            line.append(transaction.getUniqueID() + "," + transaction.getAmount() + "," + transaction.getCurrency() + "," + strDate);
            line.append("\n");
            fileWriter.write(line.toString());
        }
        fileWriter.close();
    }


    public static void listToJSON(String fileName, ArrayList<Transaction> transactions, Boolean showKind) throws IOException {


        JSONArray jsonArray = new JSONArray();

        for (Transaction transaction : transactions) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("uniqueID", transaction.getUniqueID());
            jsonObject.put("amount", transaction.getAmount().toString());
            jsonObject.put("currencyCode", transaction.getCurrency());
            jsonObject.put("purpose", transaction.getDescription());
            jsonArray.add(jsonObject);
        }

        java.io.File matchingFile = new java.io.File("src/main/webapp/files/" + fileName + ".json");
        FileWriter fileWriter = new FileWriter(matchingFile);
        fileWriter.write(jsonArray.toJSONString());
        fileWriter.close();
    }

    }