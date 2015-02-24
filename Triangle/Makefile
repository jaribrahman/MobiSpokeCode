JCC = javac

JFLAGS = -g

default: Triangle.class TriangleTester.class

Triangle.class: Triangle.java
	$(JCC) $(JFLAGS) Triangle.java

TriangleTester.class: TriangleTester.java
	$(JCC) $(JFLAGS) TriangleTester.java

clean: 
	$(RM) *.class