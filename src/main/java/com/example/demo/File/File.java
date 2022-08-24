package com.example.demo.File;

import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

public class File {

    String name;
    String format;
    String fileFrom;


    MultipartFile file;

    ArrayList<String> lines;

    public File(String name, String format, MultipartFile file, ArrayList<String> lines, String fileFrom) {
        this.name = name;
        this.format = format;
        this.file = file;
        this.lines = lines;
        this.fileFrom = fileFrom;
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public ArrayList<String> getLines() {
        return lines;
    }

    public void setLines(ArrayList<String> lines) {
        this.lines = lines;
    }

    public String getFileFrom() {
        return fileFrom;
    }

    public void setFileFrom(String fileFrom) {
        this.fileFrom = fileFrom;
    }
}

