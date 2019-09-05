<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
 <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <meta content="width=device-width, initial-scale=1" name="viewport">
    <meta content="Bodo - Simple One Page Personal" name="description">
    <meta content="BdgPixel" name="author">
<title>Insert title here</title>
<link href="images/favicon.ico" rel="shortcut icon">
    
    <!--styles-->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/owl.carousel.css" rel="stylesheet">
    <link href="css/owl.theme.css" rel="stylesheet">
    <link href="css/magnific-popup.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/responsive.css" rel="stylesheet">
    
    <!--fonts google-->
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,700' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto:400,300,500,700' rel='stylesheet' type='text/css'>
</head>

<div id="preloader">
      <div id="status">
        <img alt="logo" src="images/biglogo.png">
      </div>
    </div>
    
   <div class="header">
     <div class="for-sticky">
       <!--LOGO-->
       <div class="col-md-2 col-xs-6 logo">
         <a href="default.jsp"><img alt="logo" class="logo-nav" src="images/biglogo.png"></a>
       </div>
       <!--/.LOGO END-->
     </div>
     <div class="menu-wrap">
        <nav class="menu">
          <div class="menu-list">
            
          </div>
        </nav>
        <button class="close-button" id="close-button">Close Menu</button>
      </div>
     <button class="menu-button" id="open-button">
      </button><!--/.for-sticky-->
   </div>
  
   <div class="content-wrap">
      <!--CONTENT-->
      <div class="content">
   <form id="home">
          <div class="container">
            <div class="row">
              <div class="wrap-hero-content">
                  <div class="hero-content">
                    <h1>Hello, ${User.name}!</h1>
                    <br>
                    <span class="typed"></span>
                  </div>
              </div>
              <div class="mouse-icon margin-20">
                
              </div>
            </div>
            </div>
          </form>

<section class="grey-bg mar-tm-10" id="work" style = "margin-bottom: 0px; padding-bottom: 60px">

<div>
   <div style="float: left;">
<form action="Home" method="post" style="width: 494px; margin-left: 100px">
	 <section id="contact" class="white-bg" style="height: 300px; ">
          <div class="container">
            <div class="row">
				<textarea id="txtarea" name="Text" cols="30" rows="1" style="width: 493px; margin: 0px -1px 0px 0px; height: 87px;" readonly>	
				${textValue}				
				</textarea>
			
	<br><input type="button" value="9" onclick="showtext(9)" style="width: 100px; margin-left: 40px">
	<input type="button" value="8" onclick="showtext(8)" style="width: 100px;">
	<input type="button" value="7" onclick="showtext(7)"style="width: 100px;">
	<input type="button" value="+" onclick="showtext('+')" style="width: 100px;">
	<br><input type="button" value="6" onclick="showtext(6)" style="width: 100px; margin-left: 40px">
	<input type="button" value="5" onclick="showtext(5)" style="width: 100px;">
	<input type="button" value="4" onclick="showtext(4)" style="width: 100px;">
	<input type="button" value="-" onclick="showtext('-')" style="width: 100px;">
	<br><input type="button" value="3" onclick="showtext(3)" style="width: 100px; margin-left: 40px">
	<input type="button" value="2" onclick="showtext(2)" style="width: 100px;">
	<input type="button" value="1" onclick="showtext(1)" style="width: 100px;">
	<input type="button" value="*" onclick="showtext('*')" style="width: 100px;">
	<br><input type="button" value="000" onclick="showtext('000')" style="width: 100px; margin-left: 40px">
	<input type="button" value="0" onclick="showtext(0)" style="width: 100px;">
	<input type="button" value="." onclick="showtext('.')" style="width: 100px;">
	<input type="button" value="/" onclick="showtext('/')" style="width: 100px;">
	<br><input name = "submit" type="submit" value="=" onclick="summary();" style="width: 204px; margin-left: 40px">
	<input type="button" value="Clear" onclick="clearChar();" style="width: 100px;">
	<input type="button" value="Clear all" onclick="clearContents();" style="width: 100px;">
	</div>
			</div>
			</section>
			</form>
			
			</div>
  			 <div style="float: right; height: 432px;width: 468px;width: 468px; margin-right: 150px;">
  			 
			<section id="contact" class="white-bg" style="height: 432px;width: 468px;width: 468px;">
          <div class="container">
            <div class="row">		
            	<textarea disabled id="txtarea" name="Text" cols="60" rows="1" style="width: 468px; height: 220px;" readonly>
            		<c:forEach items="${answer}" var="item">	
  						Date:<c:out value="${item.date}"></c:out> - 
  		 					 <c:out value="${item.operation}"></c:out>
					</c:forEach>
            	</textarea>
			<!-- This is the HTML Part -->
			<form action="Home" method="post" style="width: 109px; ">
				<input name = "logout" type="submit" value="logout" style="width: 87px; height: 40px">
			</form>
            </div>
        	</div>	       	       	
        	</section>	
        	</div>
			</div>	
			
			<footer style="
    height: 200px;
">
			<div class="footer-bottom" style="
    height: 260px;
    margin-top: 700px;
    border-top-width: 800px;
">
            <div class="container">
              <div class="row">
                <img src="images/bottomlog.png" alt="logo bottom" class="center-block">
              </div>
            </div>
          </div>
        </footer>	

</section>
        </div>
        </div>
        
        <script src="js/jquery-1.9.1.min.js" type="text/javascript"></script>
    <script src="js/jquery.appear.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
    <script src="js/classie.js" type="text/javascript"></script>
    <script src="js/owl.carousel.min.js" type="text/javascript"></script>
    <script src="js/jquery.magnific-popup.min.js" type="text/javascript"></script>
    <script src="js/masonry.pkgd.min.js" type="text/javascript"></script>
    <script src="js/masonry.js" type="text/javascript"></script>
    <script src="js/smooth-scroll.min.js" type="text/javascript"></script>
    <script src="js/typed.js" type="text/javascript"></script>
    <script src="js/main.js" type="text/javascript"></script>
<script>
    function showtext(text){
	    var text = text;
		var showarea = document.getElementById("txtarea");
		showarea.innerHTML+=text;
	}
</script>
<script>
function refreshPage(){
    window.location.reload();
} 
</script>
<script>
	function summary(){
		var showarea = document.getElementById("txtarea");
    	var text = document.getElementById('txtarea').value;
		let value = eval(text);
		showarea.innerHTML = text.replace(/^\n*/,'').replace(/\n*$/,'') + ' = ' + value;
		alert("Clear all for next operation");
	}
</script>
<script>
	function clearChar(){
		var showarea = document.getElementById("txtarea");
		showarea.innerHTML = document.getElementById('txtarea').value.slice(0, -1);
	}
</script>
<script>
	function clearContents() {
		var showarea = document.getElementById("txtarea");
		showarea.innerHTML = "";
	}
</script>
</body>
</html>