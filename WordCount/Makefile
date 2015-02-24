JCC = javac

JFLAGS = -g

default: WordCount.class WordCountComparator.class TextFileIO.class FileWordCounter.class WordCountTester.class

WordCount.class: WordCount.java
	$(JCC) $(JFLAGS) WordCount.java

WordCountComparator.class: WordCountComparator.java
	$(JCC) $(JFLAGS) WordCountComparator.java

TextFileIO.class: TextFileIO.java
	$(JCC) $(JFLAGS) TextFileIO.java

FileWordCounter.class: FileWordCounter.java
	$(JCC) $(JFLAGS) FileWordCounter.java

WordCountTester.class: WordCountTester.java
	$(JCC) $(JFLAGS) WordCountTester.java

clean: 
	$(RM) *.class