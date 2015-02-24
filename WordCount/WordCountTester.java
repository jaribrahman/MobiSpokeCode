class WordCountTester {

    public static void main (String [] args) {

	int k = 10; 
	String url = "http://www.gutenberg.org/cache/epub/11/pg11.txt";
	FileWordCounter fileWC = new FileWordCounter(k, url); 
	
	WordCount [] WCArr = fileWC.getWordCountArr();

	System.out.println("Top " + k + " words and their counts: "); 
	for (int i = 0; i < WCArr.length; i++) 
	    System.out.println("Word: " + WCArr[i].getWord() + ", Count: " + WCArr[i].getCount()); 

	fileWC.writeEditedFile(); 
	
    }

}
