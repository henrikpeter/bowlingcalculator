# Bowlingcalculator

This application receives a random number of bowling point 
and a token from [Skat open REST API](http://13.74.31.101/api/points)  
via a get request and then calculates the total score. 
It then gets the total score validated via post request to [Skat open REST API](http://13.74.31.101/api/points)  

In order for the validating to work the token which is received from the get request must be 
provided in the post request.

The extra rolls which you get in the 10 and final frame , if you score a spare or strike
are implemented with the the assumption that the last point are as ex. [5,5,7] or [10,3,2]
The application is testet for that kind of input, but is not yet 
received from [Skat open REST API](http://13.74.31.101/api/points)

This application is a SpringBootApplication and must be run as such.