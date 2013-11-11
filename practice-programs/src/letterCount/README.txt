This code is written in Java version 7, and could be run on any java platform (I used Eclipse).
The program should be run from the class LetterCountMain

The complexity of this program is not significantly more than o(N), the length of time it takes to iterate through the string. 

The code works as follows:

The class contains an integer array of 256. The string received is looped through character by character,
and the corresponding integer in the array is incremented. For example, if the first letter is ‘a’, the 97th spot on the 
array is incremented to 1. The toString method goes through the array in the ranges of a-z and A-Z, and gets the number 
corresponding to each letter, if there are more than 0 occurrences. 
I chose this method because it is extremely quick, and takes almost no more time than iterating through the string.
I did try to program this using a HashMap, which is nearly as quick. It takes a little more time because it requires a 
few more lines of code, as determined by the test code which I am including in this package. 
