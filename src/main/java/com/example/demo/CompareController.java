package com.example.demo;

import User.User;
import com.example.demo.Business.Parser;
import com.example.demo.Config;
import com.example.demo.File.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;


@Controller
public class CompareController {

        @Autowired
        FileService service;

    @RequestMapping(value="/compare", method = RequestMethod.GET)
    public String showComparePage(ModelMap model){

        model.put("sourceFileName", Config.getCurrentSourceFile().getName());
        model.put("sourceFileFormat", Config.getCurrentSourceFile().getFormat());
        model.put("targetFileName", Config.getCurrentTargetFile().getName());
        model.put("targetFileFormat", Config.getCurrentTargetFile().getFormat());
        model.put("originalSourceFileName", Config.getCurrentSourceFile().getFile().getOriginalFilename());
        model.put("originalTargetFileName", Config.getCurrentTargetFile().getFile().getOriginalFilename());

        return "compare.jsp";
    }

    @RequestMapping(value="/compare", method = RequestMethod.POST)
    public String compareClicked(ModelMap model) throws ParseException, IOException {

        service.compareTransactionFiles(Config.getCurrentSourceFile(), Config.getCurrentTargetFile());

        if (Config.getMismatchingTransactionList() != null && Config.getMatchingTransactionList() != null && Config.getMissingTransactionList() != null){
            return "redirect:/results";
        }
        else{

            model.put("errorMessage", "Error Occurred");
            return "compare.jsp";

        }


    }

}