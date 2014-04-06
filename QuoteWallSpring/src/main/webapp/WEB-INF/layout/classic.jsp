<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>

<%@ include file="taglib.jsp" %>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
</head>
<body>

<!-- Wrap all page content here -->
<div id="wrap">

	<!-- Fixed navbar -->
    <div class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <a href='<spring:url value="/"></spring:url>'>QuoteWall Spring</a>
            </div>

            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Laguages<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="#">Spanish</a>
                            </li>
                            <li>
                               	<a href="#">English</a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li>
                    	<form:form commandName="searchQuoteForm" method="post">
	                        <div class="navbar-form navbar-left" role="search">
	                            <div class="form-group">
	                                <form:input cssClass="form-control" path="author" />
	                            </div>
	                            <input type="submit" value="Search" class="btn btn-default" name="search" />
	                            <input type="submit" value="Reset" class="btn btn-default" name="reset" />
	                        </div>
                        </form:form>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    
    <div class="container">
    	<div class="page-header">
    		<!-- Error messages -->
    	</div>
    	
    	<div class="col-md-9 well">
    		<tiles:insertAttribute name="body" />
    	</div>
    
    	<div class="col-md-3">
	    	<tiles:insertAttribute name="add" />
        </div>
	
	</div>
	
	<div id="footer">
        <div class="container">
            <div class="col-md-2">
                <tiles:insertAttribute name="footer" />
            </div>
        </div>
    </div>
</div>

</body>
</html>