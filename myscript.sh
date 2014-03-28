#!/bin/bash
for FILE in sm-friends
do
	java Main $FILE.in > $FILE.myout
	diff $FILE.out $FILE.myout
done
