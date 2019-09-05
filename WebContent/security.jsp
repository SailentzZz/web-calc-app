<%@ page language="java" contentType="text/html" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <meta content="width=device-width, initial-scale=1" name="viewport">
    <meta content="Bodo - Simple One Page Personal" name="description">
    <meta content="BdgPixel" name="author">
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
<title>Insert title here</title>
</head>
<body>
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
   <form action="Security" method ="post" id="home">
          <div class="container">
            <div class="row">
              <div class="wrap-hero-content">
                  <div class="hero-content">
                  
                    <h1>LogIn</h1>
                    <br>
                    <section id="contact" class="white-bg">
	                    <div class="container">
            			<div class="row">
							<font color=red>${Errors.EmailErr}</font>
							Email: <input type="text" name="email" style = "text-transform: none"><br><br>
							<br><br><input type="submit" value="Submit">           				             		
						</div>
             			</div>		
             		</section>		            		          					            
                  </div>
              </div>
            </div>
            </div>
            </form>
            <form method="get" action="Login"> 
		             			<section id="contact" class="white-bg">
			                    <div class="container">
		            			<div class="row">       				
										<input type="submit" value="Login">							
								</div>
		             			</div>		
		             			</section>
					</form> 
             		
             		<form method="get" action="Registration">
             		<section id="contact" class="white-bg">
		                    <div class="container">
	            			<div class="row">   								
								    <input type="submit" value="Registration">
							</div>
	             			</div>		
	             			</section>
	             			</form>
	             			
	             	<form method="get" action="Home">
             		<section id="contact" class="white-bg">
		                    <div class="container">
	            			<div class="row">   								
								    <input type="submit" value="Home">
							</div>
	             			</div>		
	             			</section>
	             			</form>
	<footer style="
    height: 200px;
">
			<div class="footer-bottom" style="
    height: 260px;
    margin-top: 0px;
    border-top-width: 800px;
">
            <div class="container">
              <div class="row">
                <img src="images/bottomlog.png" alt="logo bottom" class="center-block">
              </div>
            </div>
          </div>
        </footer>
          </div>
          </div>         		
             		
             		
</body>

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
</html>