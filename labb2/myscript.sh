 #!/bin/bash
 for FILE in words-10 words-250 words-5757
 do
 	time java Main $FILE.dat $FILE-test.in > $FILE-my.out
 	diff $FILE-my.out $FILE-test.out
 done