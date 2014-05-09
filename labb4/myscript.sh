#!bin/bash
for FILE in testfiler/*.tsp
do
	java Main $FILE >> lab4.myout
done