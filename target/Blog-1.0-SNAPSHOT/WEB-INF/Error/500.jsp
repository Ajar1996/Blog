<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">

    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <!-- this is needed if you want conditional comments to work -->
    <!-- meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <title>404 - Page not found</title>
    <meta name="description" content="{{DESCRIPTION}}">
    <meta name="viewport" content="width=device-width">

    <meta property="og:title" content="Adrian Roworth" />
    <meta property="og:type" content="website" />

    <meta property="og:site_name" content="Adrian Roworth" />
    <meta property="fb:admins" content="684945520" />

    <meta name="geo.region" content="GB-GLG" />
    <meta name="geo.placename" content="Glasgow" />
    <meta name="geo.position" content="55.858104;-4.278944" />
    <meta name="ICBM" content="55.858104, -4.278944" />




    <style>

        ::-moz-selection {
            background: #b3d4fc;
            text-shadow: none;
        }

        ::selection {
            background: #b3d4fc;
            text-shadow: none;
        }

        html {
            padding: 30px 10px;
            font-size: 20px;
            line-height: 1.4;
            background: #00A;
            -webkit-text-size-adjust: 100%;
            -ms-text-size-adjust: 100%;
            color: #ffffff;
            font-family: courier;
            font-size: 16px;
            text-align: center;
        }
        #page {
            background: #00A;
            -webkit-transition: all 1s ease-in-out;
            -moz-transition: all 1s ease-in-out;
            -o-transition: all 1s ease-in-out;
            -ms-transition: all 1s ease-in-out;
            transition: all 1s ease-in-out;
            -webkit-backface-visibility: hidden;
            -moz-backface-visibility: hidden;
            -ms-backface-visibility: hidden;
            -o-backface-visibility: hidden;
            backface-visibility: hidden;
            -webkit-transform-style: preserve-3d;
            -moz-transform-style: preserve-3d;
            -ms-transform-style: preserve-3d;
            -o-transform-style: preserve-3d;
            position: relative;
            z-index: 1;
            margin: 0 auto;
            width: 800px;
        }
        #page.boom {
            -webkit-transform: rotateY(180deg);
            -moz-transform: rotateY(180deg);
            -ms-transform: rotateY(180deg);
            -o-transform: rotateY(180deg);
            transform: rotateY(180deg);
        }
        #page .main {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            z-index: 1;
            -webkit-backface-visibility: hidden;
            -moz-backface-visibility: hidden;
            -ms-backface-visibility: hidden;
            -o-backface-visibility: hidden;
            backface-visibility: hidden;
        }
        #page .laldy {
            position: absolute;
            z-index: 2;
            top: 0;
            left: 0;
            width: 100%;
            -webkit-transform: rotateY(180deg);
            -moz-transform: rotateY(180deg);
            -ms-transform: rotateY(180deg);
            -o-transform: rotateY(180deg);
            transform: rotateY(180deg);
            -webkit-backface-visibility: hidden;
            -moz-backface-visibility: hidden;
            -ms-backface-visibility: hidden;
            -o-backface-visibility: hidden;
            backface-visibility: hidden;
        }
        .container {
            text-align: left;
        }
        .title {
            background: #FFF;
            color: #00A;
            padding: 2px 8px;
            font-weight: bold;
            margin: 60px 0 0 0;
            display: inline-block;
        }
        p {
            margin: 0;
            padding: 0;
            font-weight: bold;
            line-height: 18px;
            cursor: default;
        }
        p a {
            color: #FFF;
        }
        p img {
            max-width: 100%;
        }
        p.press-key {
            margin: 0 0 10px 0;
            text-align: center;
        }
        .cursor {
            -webkit-animation: cursorblink 1.5s linear 0s infinite;
            -moz-animation: cursorblink 1.5s steps(2, end) infinite;
            -o-animation: cursorblink 1.5s steps(2, end) infinite;
            animation: cursorblink 1.5s steps(2, end) infinite;
        }

        @-webkit-keyframes cursorblink {
            0%   { color: #EEE }
            47%  { color: #FFF }
            50%  { color: #00A }
            97%  { color: #00A }
            100% { color: #FFF }
        }

        #popup {
            position: absolute;
            z-index: 1000;
            top: 50%;
            left: 50%;
            margin: -250px 0 0 -280px;
            padding: 10px;
            display: none;
            background: #0000F7;
        }
        #popup .popup-inner {
            width: 500px;
            height: 350px;
            padding: 20px;
            border: 4px solid #FFF;
            background: #0000F7;
        }
        #popup .popup-inner .title {
            display: inline-block;
            margin: 0 auto;
            background: #0000F7;
            color: #FFF;
            position: relative;
            top: -34px;
        }
        #popup .popup-inner ul {
            list-style-type: none;
        }
        #popup .popup-inner ul li {
            text-align: left;
            position: relative;
        }
        #popup .popup-inner ul li a {
            color: #FFF;
            text-decoration: none;
            cursor: default;
            display: block;
            padding: 3px 0;
        }
        #popup .popup-inner ul li.active {
            background: #FFF;
        }
        #popup .popup-inner ul li.active:before {
            content: '\25B6';
            position: absolute;
            left: -20px;
        }
        #popup .popup-inner ul li.active a {
            color: #0000F7;
            font-weight: bold;
        }
        #popup .popup-inner .key {
            position: absolute;
            bottom: 1px;
            left: 25px;
            background: #0000F7;
            padding: 2px 8px;
        }

        @media all and (max-width: 800px) {
            #page {
                width: 90%;
            }
            #popup {
                margin-left: -230px;
            }
            #popup .popup-inner {
                width: 400px;
            }
        }

        @media all and (max-width: 600px) {
            #popup {
                margin-left: -180px;
            }
            #popup .popup-inner {
                width: 300px;
            }
        }

        @media all and (max-width: 400px) {
            #popup {
                margin-left: -134px;
            }
            #popup .popup-inner {
                width: 200px;
            }
        }

    </style>
</head>
<body>

<div id="page">

    <div class="main">

        <span class="title">ERROR</span>
        <div class="container">
            <br />
            <p>A fatal exception 404 has occurred at 0025:C0011ED7 in AR DEV(01). The program you are looking for cannot be found.</p>
            <br />
            <p>* If you came here via a link on this site, then let me <a href="/contact">know</a>.</p>
            <p>* Press 'Back' to restart your computer. You will lose any unsaved information in all applications.</p>
            <br />
            <p class="press-key">Press any key to continue <span class="cursor">_</span></p>
        </div>

    </div>

    <div class="laldy">
        <p>You have discovered the super secret area of the site!</p>
        <br /><br /><br />
        <p><img src="/resource/images/8bitme.png" alt="8-Bit Reb" /></p>
        <p>Love Reb x</p>
    </div>

</div>

<div id="popup">

    <div class="popup-inner">

        <p class="title">What's it gonna be?</p>

        <p>Select one of the following options:</p>

        <ul>

            <li class="active"><a href="javascript: history.back(-1); return false;"> * Go back in my history</a></li>
            <li><a href="#"> * Go to homepage</a></li>
            <li><a> * This option does nothing</a></li>
            <li><a> * ....</a></li>
            <li><a> * Profit???</a></li>

        </ul>

        <p class="key">C=Close, 1..5=Select Option</p>

    </div>

</div>

<script type="text/javascript">

    (function() {

        var popUpVisible = false;
        document.onkeydown = function(e) {

            var keyCode = e.keyCode;
            console.log(e);

            if(keyCode == 82 && !popUpVisible) {
                document.getElementById('page').className = 'boom';
            } else if(keyCode && keyCode != 116 && !popUpVisible) {
                showPopup();
            } else if(keyCode && popUpVisible) {

                window.activeOption = document.getElementsByClassName('active')[0];

                // 38 = up.
                if(keyCode == 38) {

                    if(activeOption.previousElementSibling) {
                        activeOption.previousElementSibling.className = 'active';
                        activeOption.className = '';
                    }
                    // 40 = down.
                } else if(keyCode == 40) {

                    if(activeOption.nextElementSibling) {
                        activeOption.nextElementSibling.className = 'active';
                        activeOption.className = '';
                    }

                    // 67 = C, 27 = Esc.
                } else if(keyCode == 67 || keyCode == 27) {

                    hidePopup();

                    // number keys (1 -5).
                } else if(keyCode >= 49 && keyCode <= 53) {

                    var optionIndex = keyCode - 49;
                    activeOption.className = '';
                    document.getElementsByTagName('li')[optionIndex].className = 'active';

                    // num keys (1 -5).
                } else if(keyCode >= 97 && keyCode <= 101) {

                    var optionIndex = keyCode - 97;
                    activeOption.className = '';
                    document.getElementsByTagName('li')[optionIndex].className = 'active';

                    // 13 == return.
                } else if(keyCode == 13) {

                    document.getElementsByClassName('active')[0].childNodes[0].click();

                }
            }

        };

        function showPopup() {

            var popupEl = document.getElementById('popup');
            popupEl.style.display = 'block';
            popUpVisible = true;

        }

        function hidePopup() {

            var popupEl = document.getElementById('popup');
            popupEl.style.display = 'none';
            popUpVisible = false;

        }

    })()

</script>
</body>
</html>