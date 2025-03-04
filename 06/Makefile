JAVAC=javac
JAVACFLAGS=-encoding ISO-8859-1
SRCS=*.java
EXEC=Assembler

all: compile

compile:
	$(JAVAC) $(JAVACFLAGS) $(SRCS)
	chmod +x $(EXEC)

clean:
	rm -f *.class *~