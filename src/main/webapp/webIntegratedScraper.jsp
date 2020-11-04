<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">

  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- SEO -->
    <meta name="creator" content="Georgios Davakos">
    <meta name="author" content="Georgios Davakos, giorgos_davak@hotmail.com">
    <meta name="description" content="This is Georgios Davakos website">
    <meta name="keywords" content="web-development, blog, computer science, software development">
    <meta name="revised" content="Monday, Nov 2th, 12:00 pm">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/stylesheet.css">
    <!-- Font Awesome -->
    <script src="https://kit.fontawesome.com/2994acdae5.js" crossorigin="anonymous"></script>
    <title>Web Integrated Scraper</title>
  </head>

  <body class="fixed-bottom-lg">
    <div class="container-fluid nav-cont">
      <div class="container">
	<nav class="navbar navbar-expand-md sticky-top">
          <div class="container-fluid">
            <a class="navbar-brand" href="../index.html"><img class="nav-logo" src="../img/Logo-Georg_GD.png"></a>
            <button type="button" class="navbar-toggler custome-toggler" data-toggle="collapse" data-target="#navbar-responsive">
              <span class="navbar-toggler-icon"><i class="fas fa-bars fa-1x"></i></span>
            </button>
            <div class="collapse navbar-collapse" id="navbar-responsive">
              <ul class="navbar-nav ml-auto">
		<li class="nav-item">
                  <a href="../index.html" class="nav-link">Home</a>
		</li>
		<li class="nav-item">
                  <a href="../experiences.html" class="nav-link">Experiences</a>
		</li>
		<li class="nav-item">
                  <a href="../mySkills.html" class="nav-link">Skills</a>
		</li>
		<li class="nav-item">
                  <a href="../projects.html" class="nav-link">Projects</a>
		</li>
		<li class="nav-item">
                  <a href="../contact.html" class="nav-link btn btn-outline-light">Contact Me</a>
		</li>
              </ul>
            </div>
          </div>
	</nav>
      </div>
    </div>

    <h1 class="font-weight-bold text-center mt-4 display-3">Web Integrated<span class="orange">Scraper</span></h1>
    <div class="container mt-3">
      
      <form action="scrap">
	<div class="form-group row">
	  <label for="url" class="col-sm-3 col-form-label">URL: </label>
	  <input class="form-control col-sm-3" type="text" name="url" placeholder="https://foobar.com/"><br>
	</div>
       	<div class="form-group row">
       	  <label for="scrapBy" class="col-sm-3 col-form-label">Scrap by: </label>
       	  <select class="form-control col-sm-3" name="scrapBy">
	    <option value="ById">By Id </option>
	    <option value="ByName">By Name </option>
	    <option value="ByClass">By Class </option>
	    <option value="ByXpath">By Xpath </option>
	  </select><br>
	</div>
	<div class="form-group row">
	  <label for="ByString" class="col-sm-3 col-form-label">Attribute name: </label>
	  <input class="form-control col-sm-3" type="text" name="attributeName" placeholder="Text"><br>
	</div>
	<div class="row">
	  <div class="col-sm-3"></div>
	  <button type="submit" class="btn btn-primary col-sm-3">Scrap</button>
	</div>
      </form>
	
    </div>
    
    <div class="container mt-3">
      <div class="card"> 
	<div class="card-header">
	  The Result:
	</div>
	<div class="card-body">
	  <p class="card-text">
	    ${scrapResult}
	  </p>
	</div>
      </div>
    </div>
    
    <footer class="indigo mt-3 pt-2">

      <div class="container">
	<div class="row text-center d-flex justify-content-center pt-3 text-uppercase">

          <div class="col-md-4 col-lg-2 mb-3">
            <h6 class="font-weight-bold">
              <a href="../index.html"> Home </a>
            </h6>
          </div>
          <div class="col-md-4 col-lg-2 mb-3">
            <h6 class="font-weight-bold">
              <a href="../blog.html"> Blog </a>
            </h6>
          </div>

          <div class="col-md-4 col-lg-2 mb-3">
            <h6 class="font-weight-bold">
              <a href="../experiences.html">Experiences </a>
            </h6>
          </div>

          <div class="col-md-4 col-lg-2 mb-3">
            <h6 class="font-weight-bold">
              <a href="../mySkills.html"> Skills </a>
            </h6>
          </div>

          <div class="col-md-4 col-lg-2 mb-3">
            <h6 class="font-weight-bold">
              <a href="../projects.html"> Projects </a>
            </h6>
          </div>

          <div class="col-md-4 col-lg-2 mb-3">
            <h6 class="font-weight-bold">
              <a class="w-100" href="../contact.html">Contact Me </a>
            </h6>
          </div>

	</div>

	<hr class="rgba-white-light" style="margin: 0 15%;">

	<div class="row justify-content-center">

          <div class="col-auto mt-4">
            <article>
              <address>
		<h6 class="font-weight-bold text-uppercase"> Contact Me </h6>
		Georgios Davakos <br>
		Blodstensvägen 25 <br>
		752 58 UPPSALA <br>
		Sweden <br>
		giorgos_davak@hotmail.com <br>
              </address>
            </article>
          </div>

          <div class="col-auto mt-4 pr-5 text-center">
            <h6 class="font-weight-bold mb-2 text-uppercase">Follow Me</h6>
            <a href="http://www.twitter.com/GDavakos" target="_blank"><i class="fab fa-twitter fa-2x mr-2"></i></a>
            <a href="https://www.linkedin.com/in/georgios-davakos-778858110/" target="_blank"><i class="fab fa-linkedin-in fa-2x ml-2"></i></a>
          </div>

	</div>

      </div>
      <div class="container-fluid py-1 copyrights">
	<p class="text-center mt-1 mb-1"> &copy; 2020 Georgios Davakos, All rights reserved.</p>
      </div>


    </footer>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  </body>

</html>
