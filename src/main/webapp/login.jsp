


<!DOCTYPE HTML>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.1.6/css/uikit.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.1.6/js/uikit.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.1.6/js/uikit-icons.min.js"></script>
</head>
<body>

<div class="uk-section uk-section-muted uk-flex uk-flex-middle" uk-height-viewport>
    <div class="uk-width-1-1">
        <div class="uk-container">
            <div class="uk-grid-margin uk-grid uk-grid-stack" uk-grid>
                <div class="uk-width-1-1@m">
                    <div class="uk-margin uk-width-large uk-margin-auto uk-card uk-card-default uk-card-body uk-box-shadow-large" style="border-radius: 15px">
                        <h3 class="uk-card-title uk-text-center" style="font-weight: 400; padding: 10px">Reconciliation System</h3>
                        <form method="post">
                            <div class="uk-margin">
                                <div class="uk-inline uk-width-1-1">
                                    <span class="uk-form-icon" uk-icon="icon: user"></span>
                                    <input value="${username}" style="border-radius: 10px" name="username" placeholder="Username" class="uk-input uk-form-large" type="text">
                                </div>
                            </div>
                            <div class="uk-margin">
                                <div class="uk-inline uk-width-1-1">
                                    <span class="uk-form-icon" uk-icon="icon: lock"></span>
                                    <input style="border-radius: 10px" name="password" placeholder="Password" class="uk-input uk-form-large" type="password">
                                </div>
                            </div>
                            <div class="uk-margin">
                                <button class="uk-button uk-button-primary uk-button-large uk-width-1-1" style="border-radius: 10px">Login</button>
                            </div>
                        </form>
                        <font color="red">${errorMessage}
                        </font>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</form>
</body>
</html>