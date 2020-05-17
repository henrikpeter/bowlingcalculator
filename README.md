# Bowlingcalculator

This application receives a random number of bowling point 
and a token from [Skat open REST API](http://13.74.31.101/api/points)  
via a get request and then calculates the total score. 
It then gets the total score validated via post request to [Skat open REST API](http://13.74.31.101/api/points)  

In order for the validating to work the token which is received from the get request must be 
provided in the post request.
  
This application is a SpringBootApplication and must be run as such.