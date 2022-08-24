<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE HTML>
<html>
<head>
    <title>Results</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.1.6/css/uikit.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.1.6/js/uikit.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.1.6/js/uikit-icons.min.js"></script>
</head>



<a onclick="history.back()">
    <span style="color: #7e7e7e; background: none; position:absolute; top: 30px; left: 30px" uk-icon="icon: arrow-left; ratio: 2"></span>
</a>


<div class="uk-section uk-section" style="padding-top: 10px">
    <div class="uk-container uk-container"; style="max-width: 900px">

        <!--        <ul uk-tab>-->
        <!--            <li class="uk-active"><a href="#">Match</a></li>-->
        <!--            <li><a href="#">Mismatch</a></li>-->
        <!--            <li><a href="#">Missing</a></li>-->
        <!--        </ul>-->



        <div class="uk-container uk-container-center">
            <h3 class="uk-margin-top">Processed Transactions</h3>
            <ul class="uk-tab" data-uk-tab="{connect:'#my-id'}">
                <li ><a href="#">Match</a></li>
                <li><a href="#">Mismatch</a></li>
                <li><a href="#">Missing</a></li>
            </ul>
            <ul id="my-id" class="uk-switcher uk-margin">
                <li>
                    <div class="uk-overflow-auto">
                        <table class="uk-table uk-table-small uk-table-divider">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Transaction ID</th>
                                <th>Amount</th>
                                <th>Currency</th>
                                <th>Value Date</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:set var="index" value="${loop.index}" />
                            <c:forEach var="transaction" items="${matchingTransactions}">
                                <c:set var="index" value="${index + 1}" />
                                <tr>
                                    <td>${index}</td>
                                    <td>${transaction.getUniqueID()}</td>
                                    <td>${transaction.getAmount()}</td>
                                    <td>${transaction.getCurrency()}</td>
                                    <td>${transaction.getDateString()}</td>

                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>

                    <ul class="uk-iconnav uk-iconnav-vertical" style="float: right; margin-top: 20px">
                        <li>
                            <button  class="uk-button uk-button-secondary" style="border-radius: 5px; padding-right: 15px; padding-left: 15px" >  <a style="color: white" href="/new-comparison">Compare Another</a></button>
                            <button class="uk-button uk-button-primary" style="border-radius: 5px;" type="button">Download</button>
                            <div uk-dropdown="mode: click" >
                                <ul class="uk-nav uk-dropdown-nav">
                                    <li><a href="files/matching-csv.csv" download>CSV</a></li>
                                    <li><a href="files/matching-json.json" download>JSON</a></li>

                                </ul>
                            </div>


                        </li>
                    </ul>
                </li>
                <li>
                    <div class="uk-overflow-auto">
                        <table class="uk-table uk-table-small uk-table-divider">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Transaction ID</th>
                                <th>Amount</th>
                                <th>Currency</th>
                                <th>Value Date</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:set var="index" value="${loop.index}" />
                            <c:forEach var="transaction" items="${mismatchingTransactions}">
                                <c:set var="index" value="${index + 1}" />

                                <tr>
                                    <td>${index}</td>
                                    <td>${transaction.getUniqueID()}</td>
                                    <td>${transaction.getAmount()}</td>
                                    <td>${transaction.getCurrency()}</td>
                                    <td>${transaction.getDateString()}</td>

                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>
                    <ul class="uk-iconnav uk-iconnav-vertical" style="float: right; margin-top: 20px">
                        <li>
                            <button  class="uk-button uk-button-secondary" style="border-radius: 5px; padding-right: 15px; padding-left: 15px" >  <a style="color: white" href="/new-comparison">Compare Another</a></button>
                            <button class="uk-button uk-button-primary" style="border-radius: 5px;" type="button">Download</button>
                            <div uk-dropdown="mode: click" >
                                <ul class="uk-nav uk-dropdown-nav">
                                    <li><a href="files/mismatching-csv.csv" download>CSV</a></li>
                                    <li><a href="files/mismatching-json.json" download>JSON</a></li>
                                </ul>
                            </div>


                        </li>
                    </ul>

                </li>
                <li>
                    <div class="uk-overflow-auto">
                        <table class="uk-table uk-table-small uk-table-divider">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Transaction ID</th>
                                <th>Amount</th>
                                <th>Currency</th>
                                <th>Value Date</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:set var="index" value="${loop.index}" />
                            <c:forEach var="transaction" items="${missingTransactions}">
                                <c:set var="index" value="${index + 1}" />

                                <tr>
                                    <td>${index}</td>
                                    <td>${transaction.getUniqueID()}</td>
                                    <td>${transaction.getAmount()}</td>
                                    <td>${transaction.getCurrency()}</td>
                                    <td>${transaction.getDateString()}</td>

                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>

                    <ul class="uk-iconnav uk-iconnav-vertical" style="float: right; margin-top: 20px">
                        <li>
                            <button  class="uk-button uk-button-secondary" style="border-radius: 5px; padding-right: 15px; padding-left: 15px" >  <a style="color: white" href="/new-comparison">Compare Another</a></button>
                            <button class="uk-button uk-button-primary" style="border-radius: 5px;" type="button">Download</button>
                            <div uk-dropdown="mode: click" >
                                <ul class="uk-nav uk-dropdown-nav">
                                    <li><a href="files/missing-csv.csv" download>CSV</a></li>
                                    <li><a href="files/missing-json.json" download>JSON</a></li>
                                </ul>
                            </div>


                        </li>
                    </ul>
                </li>
            </ul>

            <!--        Matching Transactions: ${numberOfMatchingTransactions};-->
            <!--        Missing Transactions: ${numberOfMissingTransactions};-->
            <!--        Mismatching Transactions: ${numberOfMismatchingTransactions};-->





        </div>
    </div>




    <body>

    </body>
</html>