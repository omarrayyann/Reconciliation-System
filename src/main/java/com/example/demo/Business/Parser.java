package com.example.demo.Business;

import com.example.demo.File.File;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.multipart.MultipartFile;


import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Parser {

    protected File file;
    protected String format;
    protected String fileFrom;
    protected ArrayList<String> lines;

    ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    public Parser(File file) {
        this.file = file;
        this.format = file.getFormat();
        this.fileFrom = file.getFileFrom();
        this.lines = file.getLines();

    }


    public ArrayList<Transaction> getTransactions() throws ParseException {

        transactions = new ArrayList<Transaction>();

        if (format.equalsIgnoreCase("CSV")) {

            for (int i = 1; i < lines.size(); i++) {
                String[] line = lines.get(i).split(",");
                if(line.length==7){
                String uniqueID = line[0];
                String description = line[1];
                Double amount = Double.valueOf(line[2]);
                String currency = line[3];
                String purpose = line[4];
                String stringValueDate = line[5];
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date valueDate = formatter.parse(stringValueDate);
                String type = line[6];
                Transaction transaction = new Transaction(uniqueID, description, amount, currency, purpose, valueDate, type);
                transaction.from = fileFrom;
                transactions.add(transaction);
            }}
        }
        else if (format.equalsIgnoreCase("JSON")) {

            String jsonString = lines.stream().map(Object::toString)
                    .collect(Collectors.joining(""));


            JSONArray jsonArr = new JSONArray(jsonString);

            for (int i = 0; i < jsonArr.length(); i++)
            {
                JSONObject jsonObj = jsonArr.getJSONObject(i);
                Transaction transaction = parseTransactionObject(jsonObj);
                transactions.add(transaction);
            }

//                System.out.println("--");
//                System.out.println(lines.get(i));
//                System.out.println("--");
//
//                try {
//                    JSONObject jsonObject = new JSONObject("{\"phonetype\":\"N95\",\"cat\":\"WP\"}");
//                }catch (JSONException err){
//                    Log.d("Error", err.toString());
//                }


        }

        return transactions;


    }


    private static Transaction parseTransactionObject(JSONObject transaction) throws java.text.ParseException {
        String uniqueID = (String) transaction.get("reference");
        String amountString = (String) transaction.get("amount");
        Double amount = Double.valueOf(amountString);
        String dateString = (String) transaction.get("date");

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date valueDate = formatter.parse(dateString);

        String currencyCode = (String) transaction.get("currencyCode");

        String purpose = (String) transaction.get("purpose");

        Transaction newTransaction = new Transaction(uniqueID, "", amount, currencyCode, purpose, valueDate, "");
        return newTransaction;
    }


}