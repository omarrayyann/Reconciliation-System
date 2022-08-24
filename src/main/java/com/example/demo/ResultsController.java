package com.example.demo;

import com.example.demo.File.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.text.ParseException;


@Controller
public class ResultsController {

        @Autowired
        FileService service;

    @RequestMapping(value="/results", method = RequestMethod.GET)
    public String showResultsPage(ModelMap model) throws IOException {


        model.put("matchingTransactions", Config.getMatchingTransactionList());
        model.put("mismatchingTransactions", Config.getMismatchingTransactionList());
        model.put("missingTransactions", Config.getMissingTransactionList());

        service.listToCSV("matching-csv", Config.getMatchingTransactionList(), false);
        service.listToCSV("mismatching-csv", Config.getMismatchingTransactionList(), false);
        service.listToCSV("missing-csv", Config.getMissingTransactionList(), false);

        service.listToJSON("matching-json", Config.getMatchingTransactionList(), false);
        service.listToJSON("mismatching-json", Config.getMismatchingTransactionList(), false);
        service.listToJSON("missing-json", Config.getMissingTransactionList(), false);

        return "results.jsp";
    }

    @RequestMapping(value="/results", method = RequestMethod.POST)
    public String download(ModelMap model) throws ParseException, IOException {

        return "results.jsp";

    }


}