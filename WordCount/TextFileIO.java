import java.net.URL; 
import java.net.MalformedURLException; 
import java.util.HashMap; 
import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.io.IOException; 
import java.io.FileWriter; 
import java.io.PrintWriter; 

class TextFileIO {
 
    BufferedReader in; 
    HashMap<String, Integer> wordCountMap; 

    public TextFileIO (String urlStr) {
	getBufferedReaderFromURL(urlStr);  
	if (in != null) {
	    try {
		buildWordCountMap(); 
	    } catch (Exception e) {
		System.out.println("Exception while building wordCount map " + e); 
	    }
	}
    }

    private void getBufferedReaderFromURL(String urlStr) {
	
	URL url = null; 

	try {
	    url = new URL(urlStr); 
	} catch (MalformedURLException e) {
	    System.out.println("Invalid URL"); 
	}
	
	if (url != null) {
	    try {
		in = new BufferedReader(new InputStreamReader(url.openStream())); 
	    } catch (IOException e) {
		System.out.println("Error getting BufferedReader from URL"); 
	    }
	}
    }

    private void buildWordCountMap() throws Exception {
    
	wordCountMap = new HashMap<String, Integer>(); 
	String inputLine; 
       
	while ((inputLine = in.readLine()) != null) {
	    
	    String [] splitSentence = inputLine.split("[^a-zA-Z]"); 
	    
	    for (int i = 0; i < splitSentence.length; i++) {
		String word = splitSentence[i].toLowerCase();
		if (!word.equalsIgnoreCase("")) {
		    if (wordCountMap.containsKey(word)) 
			wordCountMap.put(word, wordCountMap.get(word) + 1); 
		    else
			wordCountMap.put(word, 1); 
		}
	    }
	}
	    
	in.close();
    }

    public HashMap<String, Integer> getWordCountMap() {
	return wordCountMap; 
    }
    
    public void createNewTextFile(String urlStr, WordCount [] wordCount) throws Exception {
       	
	getBufferedReaderFromURL(urlStr); 

	PrintWriter outFile = new PrintWriter(new FileWriter("editedFile.txt"));
	String inputLine; 
       
	while ((inputLine = in.readLine()) != null) {
	    
	    String [] splitSentence = inputLine.split("[^a-zA-Z]"); 
	    
	    for (int i = 0; i < splitSentence.length; i++) {
		String word = splitSentence[i].toLowerCase(); 
		if (wordInList(word, wordCount)) {
		    String wordWithSpace = " ".concat(splitSentence[i]); 
		    inputLine = inputLine.replace(wordWithSpace, "");
		}
	    } 
	    
	    outFile.println(inputLine); 
	}
	outFile.close(); 
	System.out.println("Wrote file with removed words to editedFile.txt."); 
    }

    private boolean wordInList(String word, WordCount [] wordCount) {
	
	for (int i = 0; i < wordCount.length; i++) 
	    if (wordCount[i].getWord().equalsIgnoreCase(word))
		return true;

	return false; 
	
    }
}