# Reconciliation system
A console application that handle system files as a communication channel. The application reads two files (CSV and JSON file formats), compares the records of these files and produce result files showing the matched, mismatched and missing records.

## File formats

#### CSV file format 
In this CSV file, the first line is the header names, and the financial transactions starts from the second line with the following fields:
1. **trans unique id**: this field is the transaction *unique identifier*
1. **trans description**: the transaction description
1. **amount**
1. **currecny**: following ISO 4217 alphabetic code
1. **purpose**
1. **value date**: following the format `yyyy-MM-dd`
1. **trans type**: whether the transaction is a credit or debit
example:
```csv
trans unique id,trans description,amount,currecny,purpose,value date,trans type
TR-47884222201,online transfer,140,USD,donation,2020-01-20,D
```
#### JSON file format
The json file consists of an array of transactions with the following properties:
1. **date**: following the format `dd/MM/yyyy`
1. **reference**: this field is the transaction *unique identifier*
1. **amount**
1. **currencyCode**: following ISO 4217 alphabetic code
1. **purpose**

```json
[
  {
    "date": "20/01/2020",
    "reference": "TR-47884222201",
    "amount": "140.00",
    "currencyCode": "USD",
    "purpose": "donation"
  }
]
```
 
#### Result file format
 
The comparison result is written to 3 CSV files with the following details:

###### Matching Transactions file
This file contains all the matching records, with the following details

1. **transaction id**
1. **amount**: formatted with decimal places as per the currency specification (see `E` column in https://en.wikipedia.org/wiki/ISO_4217#Active_codes) 
1. **currency code**: following ISO 4217 alphabetic code
1. **value date**: having the format `yyyy-MM-dd`

###### Mismatching Transactions file
This file contains the records that has been found on both files, but one or more of the financial details (amount, currency and value date) did not match.

1. **found in file**: `SOURCE` for the source record, and `TARGET` for the target record
1. **transaction id**
1. **amount**: formatted with decimal places as per the currency specification (see `E` column in https://en.wikipedia.org/wiki/ISO_4217#Active_codes) 
1. **currency code**: following ISO 4217 alphabetic code
1. **value date**: having the format `yyyy-MM-dd`

###### Missing Transactions file 
This file shows the records that were present in one file but not the other.

1. **found in file**: if present in first file, the value should be `SOURCE`, otherwise `TARGET`
1. **transaction id**
1. **amount**: formatted with decimal places as per the currency specification (see `E` column in https://en.wikipedia.org/wiki/ISO_4217#Active_codes) 
1. **currency code**: following ISO 4217 alphabetic code
1. **value date**: having the format `yyyy-MM-dd` 
