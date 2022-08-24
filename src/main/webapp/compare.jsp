


<!DOCTYPE HTML>
<html>
<head>
    <title>Ready to Compare</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.1.6/css/uikit.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.1.6/js/uikit.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.1.6/js/uikit-icons.min.js"></script>
</head>

<a onclick="history.back()">
    <span style="color: #7e7e7e; background: none; position:absolute; top: 30px; left: 30px" uk-icon="icon: arrow-left; ratio: 2"></span>
</a>

<div class="uk-section uk-section">
    <div class="uk-container uk-container"; style="max-width: 700px">


        <!-- Row -->


        <div class="uk-child-width-expand@s uk-text-center container uk-grid-stack" uk-grid uk-height-match="target: > div > .uk-card">

            <!-- CARD -->
            <div>
                <div class="uk-card-default uk-width-1-1@m" style="border-radius: 10px">
                    <div class="uk-card-header">
                        <div class="uk-grid-small uk-flex-middle" uk-grid>
                            <div class="uk-width-auto">
                                <span style="color: #6fad38" uk-icon="icon: push; ratio: 2"></span>
                            </div>
                            <div class="uk-width-expand">
                                <h4 style="font-size: 18px" class="uk-card-title uk-margin-remove-bottom">Source File</h4>
                                <p class="uk-text-meta uk-margin-remove-top">${originalSourceFileName}</p>
                            </div>
                        </div>
                    </div>
                    <div class="uk-card-body" style="min-height: 20px; text-align: left; padding: 30px">
                        <p><b>Given Name:</b> ${sourceFileName}</p>

                        <p><b>File Format:</b> ${sourceFileFormat}</p>
                    </div>

                </div>
            </div>

            <!-- CARD -->
            <div >
                <div class="uk-card-default uk-width-1-1@m" style="border-radius: 10px">
                    <div class="uk-card-header">
                        <div class="uk-grid-small uk-flex-middle" uk-grid>
                            <div class="uk-width-auto">
                                <span style="color: #ea7c7c" uk-icon="icon: pull; ratio: 2"></span>
                            </div>
                            <div class="uk-width-expand">
                                <h4 style="font-size: 18px" class="uk-card-title uk-margin-remove-bottom">Target File</h4>
                                <p class="uk-text-meta uk-margin-remove-top">${originalTargetFileName}</p>
                            </div>
                        </div>
                    </div>
                    <div class="uk-card-body" style="min-height: 20px; text-align: left; padding: 30px">
                        <p><b>Given Name:</b> ${targetFileName}</p>

                        <p><b>File Format:</b> ${targetFileFormat}</p>
                    </div>

                </div>
            </div>

        </div>

        <div style="padding-bottom: 50px"></div>

        <div  style="text-align: right">
            <div>
            <form method="post">
            <button  class="uk-button uk-button-primary" style="border-radius: 5px">Compare</button>
            </form>
            </div>
        </div>
        <font color="red">${errorMessage}</font>


    </div>





</div>
</div>



<body>

</body>
</html>