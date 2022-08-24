package com.example.demo.Business;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {

    private String uniqueID;
    private String description;
    private Double amount;
    private String currency;
    private String purpose;
    private Date valueDate;
    private String type;

    Boolean found;

    String from;

    public Transaction(String uniqueID, String description, Double amount, String currency, String purpose, Date valueDate, String type) {
        this.uniqueID = uniqueID;
        this.description = description;
        this.amount = amount;
        this.currency = currency;
        this.purpose = purpose;
        this.valueDate = valueDate;
        this.type = type;
        this.found = false;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Date getValueDate() {
        return valueDate;
    }

    public String getDateString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(valueDate);
        return strDate;
    }

    public void setValueDate(Date valueDate) {
        this.valueDate = valueDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getFound() {
        return found;
    }

    public void setFound(Boolean found) {
        this.found = found;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
