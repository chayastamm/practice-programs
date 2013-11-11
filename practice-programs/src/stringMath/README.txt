This code is written in Java version 7, and could be run on any java platform (I used Eclipse).
The program should be run from the class StringMathMain.

The complexity of this program is not significantly more than o(N), the length of time it takes to iterate 
through the string. 

The code works as follows:

The string received is looped through character by character. When an operand is found, the previous characters are parsed 
into an integer, and are either added or subtracted from the sum integer, depending on the previously found operand. The 
character after an operand is automatically a part of the next integer, which allows the function to work with negatives. 
I chose to code the program this way because it only loops through the string once, returns results quickly, and is fairly 
straightforward. 

