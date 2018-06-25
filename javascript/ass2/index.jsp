<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="view.Weather"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My MVC Page</title>
</head>
<body>
	<%ArrayList<Weather> weatherList=(ArrayList<Weather>)request.getAttribute("weatherList"); %>
	<form action="WeatherServlet" method = "POST">
		<table border="0">
		  <tr>
		    <td>City</td>
		    <td>
		    	<%if(weatherList != null){ 
		    	%>
		    	<p>
		    		<%weatherList.get(0).getCity(); %> Current Temperature
		    	</p>
		    	<% }%>
		    </td>
		  </tr>
		  <tr>
		  	<td>Select</td>
		  	<td rowspan="4">
		  		<table border="1">
		  			<tr>
		  				<td>Time</td>
		  				<%
		  					if(weatherList != null){
		  					for(int i = 0; i < weatherList.size(); i++){ %>
		  						<td><%=weatherList.get(i).getTime() %></td>
		  				<%}} %>
		  			</tr>
		  			<tr>
		  				<td>Source1</td>
		  				<%
		  					if(weatherList != null){
		  					for(int i = 0; i < weatherList.size(); i++){ %>
		  					<td><%=weatherList.get(i).getFahrenheit() %></td>
		  				<%}} %>
		  			</tr>
		  		</table>
		  	</td>
		  </tr>
		  <tr>
		  	<td>
		    	<input value = "Omaha" name = "city" type = "radio">Omaha</input>
		    	<input value = "Lincoln" name = "city" type = "radio">Lincoln</input>
		    </td>
		  </tr>
		  <tr>
		    <td>Source</td>
		  </tr>
		  <tr>
		  	<td>
		    	<input value = "source1" name = "source" type = "radio">Source1</input>
		    	<input value = "source2" name = "source" type = "radio">Source2</input>
		    </td>
		  </tr>
		  <tr>
		  	<td>
		  		<button type = "submit">Submit</button>
		  	</td>
		  </tr>
		</table>
	</form>
</body>
</html>