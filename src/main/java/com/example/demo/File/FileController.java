package com.example.demo.File;

import com.example.demo.Config;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


@Controller
public class FileController {

    private static String UPLOADED_FOLDER = "F://temp//";

    @Autowired
    FileService service;




    @RequestMapping(value="/new-comparison", method = RequestMethod.GET)

    public String newComparison(ModelMap model){

        Config.setCurrentTargetFile(null);
        Config.setCurrentSourceFile(null);

        return "redirect:/source-file";
    }

    @RequestMapping(value="/source-file", method = RequestMethod.GET)

    public String sourceFileUpload(ModelMap model){

        if (Config.getCurrentSourceFile() != null){
            model.put("name", Config.getCurrentSourceFile().getName());}
        else{
            model.put("name", "");
        }
        return "source-file.jsp";
    }


    @RequestMapping(value="/source-file", method = RequestMethod.POST)
    public String sourceFileUpload(ModelMap model, @RequestParam String sourceFileFormat, @RequestParam String sourceFileName, @RequestParam("file") MultipartFile file) throws IOException {


        if (file.isEmpty()) {
            model.put("errorMessage", "Please select a file to upload");
            model.put("name", sourceFileName);
            return "redirect:/target-file";
        }

        String extension = FilenameUtils.getExtension(file.getOriginalFilename());

        if (!extension.equalsIgnoreCase(sourceFileFormat)) {
            model.put("errorMessage", "File format does not match the uploaded file format");
            model.put("name", sourceFileName);
            return "source-file.jsp";
        }


        BufferedReader br;
        ArrayList<String> result = new ArrayList<>();
        try {
            String line;
            InputStream is = file.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        String uploadStatus = service.uploadFile(sourceFileName, sourceFileFormat, file, "Source", result);

        if (uploadStatus != "Success") {
            model.put("errorMessage", uploadStatus);
            model.put("name", sourceFileName);
            return "source-file.jsp";
        }
        else{
            return "redirect:/target-file";
        }



    }



    @RequestMapping(value="/target-file", method = RequestMethod.GET)
    public String targetFileUpload(ModelMap model){

        if (Config.getCurrentTargetFile() != null){
            model.put("name", Config.getCurrentTargetFile().getName());}
        else{
            model.put("name", "");
        }
        return "target-file.jsp";
    }

    @RequestMapping(value="/target-file", method = RequestMethod.POST)
    public String uploadTargetFile(ModelMap model, @RequestParam String targetFileFormat, @RequestParam String targetFileName, @RequestParam("file") MultipartFile file) throws IOException {




        if (file.isEmpty()) {
            model.put("errorMessage", "Please select a file to upload");
            model.put("name", targetFileName);
            return "target-file.jsp";
        }

        String extension = FilenameUtils.getExtension(file.getOriginalFilename());

        if (!extension.equalsIgnoreCase(targetFileFormat)) {
            model.put("errorMessage", "File format does not match the uploaded file format");
            model.put("name", targetFileName);
            return "source-file.jsp";
        }




        BufferedReader br;
        ArrayList<String> result = new ArrayList<>();
        try {

            String line;
            InputStream is = file.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                result.add(line);
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        String uploadStatus = service.uploadFile(targetFileName, targetFileFormat, file, "Target", result);

        if (uploadStatus != "Success") {
            model.put("name", targetFileName);
            return "target-file.jsp";
        }
        else{
            model.put("errorMessage", "");
            return "redirect:/compare";
        }



    }

}