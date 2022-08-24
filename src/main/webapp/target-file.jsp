<!DOCTYPE HTML>
<html>
<head>
    <title>Target Upload</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.1.6/css/uikit.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.1.6/js/uikit.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.1.6/js/uikit-icons.min.js"></script>

</head>
<body>

<a onclick="history.back()">
    <span style="color: #7e7e7e; background: none; position:absolute; top: 30px; left: 30px" uk-icon="icon: arrow-left; ratio: 2"></span>
</a>


<div class="uk-section uk-section-muted uk-flex uk-flex-middle" uk-height-viewport>
    <div class="uk-width-1-1">
        <div class="uk-container">
            <div class="uk-grid-margin uk-grid uk-grid-stack" uk-grid>
                <div class="uk-width-1-1@m">
                    <div class="uk-margin uk-width-large uk-margin-auto uk-card uk-card-default uk-card-body uk-box-shadow-large" style="border-radius: 15px">
                        <h3 class="uk-card-title uk-text-center" style="font-weight: 400; padding: 10px">Target Upload</h3>
                        <form method="post" enctype="multipart/form-data">

                            <div class="uk-margin">
                                <div class="uk-inline uk-width-1-1">
                                    <span class="uk-form-icon" uk-icon="icon: file-text"></span>
                                    <input  value="${name}" style="border-radius: 10px"  name="targetFileName" placeholder="Target Name" class="uk-input uk-form-large" type="text">
                                </div>
                            </div>
                            <div class="uk-margin">
                                <div class="uk-inline uk-width-1-1">
                                    <div class="uk-margin">
                                        <span class="uk-form-icon" style="margin-bottom: 20px" uk-icon="icon: database"></span>
                                        <select name="targetFileFormat"  style="border-radius: 10px; height: 55px; padding-left: 40px" ; class="uk-select">
                                            <option>CSV</option>
                                            <option>JSON</option>
                                        </select>
                                    </div></div>
<%--                                <div style="width:72%" class="uk-inline uk-width-1-1">--%>
<%--                                    <input id="fileupload" type="file" name="fileupload" />--%>
<%--                                    <button type="button" id="upload-button" onclick="uploadFile()"> Upload </button>--%>
<%--                                </div>--%>

                                <div class="js-upload uk-placeholder uk-text-center" style="margin-top: 0px; border-radius: 10px">
                                    <span uk-icon="icon: cloud-upload"></span>
                                    <span class="uk-text-middle"> Upload your source file by dropping it here or by</span>
                                    <div uk-form-custom>
                                        <input onchange="load()" id="upload-select" name="file" type="file">
                                        <span class="uk-link">selecting it</span>
                                    </div>
                                </div>

                                <progress id="js-progressbar" class="uk-progress" value="0" max="100" hidden></progress>


                                <script>

                                    function load() {
                                        var bar = document.getElementById('js-progressbar');

                                        bar.removeAttribute('hidden');
                                        bar.max = 100;
                                        bar.value = 0;

                                        setTimeout(function(){

                                            bar.value = 30;
                                        }, 300);

                                        setTimeout(function(){

                                            bar.value = 50;
                                        }, 300);

                                        setTimeout(function(){

                                            bar.value = 80;
                                        }, 300);

                                        setTimeout(function(){

                                            bar.value = 100;
                                        }, 300);


                                        // bar.setAttribute('hidden', 'hidden');
                                    }
                                </script>

                            </div>
                            <div class="uk-margin">
                                <button class="uk-button uk-button-primary uk-button-large uk-width-1-1" style="border-radius: 10px">Continue</button>
                            </div>
                        </form>
                        <font color="red" style="text-align: center">${errorMessage}</font>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</form>




<script>
    async function uploadFile() {
        let formData = new FormData();
        formData.append("file", fileupload.files[0]);
        let response = await fetch('/upload', {
            method: "POST",
            body: formData
        });

        if (response.status == 200) {
            alert("File successfully uploaded.");
        }
    }
</script>


</body>
</html>