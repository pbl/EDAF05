# Example Makefile for automatic testing of lab solutions in EDAF05
#
# Run 'make test' or 'make testall' to perform the tests.


# Search for .out files:
# Change to make sure the path is where the testdata is stored on your system.
TESTDIR=/home/bl/skola/EDAF05/labb4
OUTS=$(wildcard $(TESTDIR)/*.tsp)


test :
	java   GS  $(TESTDIR)/a280.tsp
	java   GS  $(TESTDIR)/berlin52.tsp


testall :  $(OUTS:.tsp=.test)

%.test : %.tsp
	java  GS  $