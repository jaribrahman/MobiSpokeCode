import java.util.HashMap;
import java.util.PriorityQueue; 
import java.util.Comparator;  

class FileWordCounter {

    private int k; 
    private WordCount [] WordCountArr; 
    private String urlStr;
    PriorityQueue<WordCount> wordCountQueue; 
    
    public FileWordCounter(int k, String urlStr) {
        this.k = k; 
	this.WordCountArr = new WordCount[k];
	this.urlStr = urlStr;  
	createWordCountHeap(); 
	topKWordCount(); 
    }


    private void createWordCountHeap() {
	
	TextFileIO textFileIO = null; 
	try {
	    textFileIO = new TextFileIO(urlStr); 
	} catch (Exception e) {
	    System.out.println("Exception initializing TextFileIO " + e); 
	}

	HashMap<String, Integer> wordMap = textFileIO.getWordCountMap(); 

	int numWords = wordMap.size(); 
	Comparator<WordCount> comparator = new WordCountComparator(); 
	wordCountQueue = new PriorityQueue<WordCount>(numWords, comparator); 

	for (String key : wordMap.keySet()) {
	    WordCount wc = new WordCount(key, wordMap.get(key)); 
	    wordCountQueue.add(wc); 
	}
    }

    
    private void topKWordCount() {

	for (int i = 0; i < k; i++) {
	    WordCount wc = wordCountQueue.poll(); 
	    WordCountArr[i] = wc;
	}
    }

    public WordCount [] getWordCountArr() {
	return WordCountArr;
    }

    public void writeEditedFile() {
	
	TextFileIO textFileIO = null; 
	try {
	    textFileIO = new TextFileIO(urlStr);
	} catch (Exception e) {
	    System.out.println("Exception initializing TextFileIO " + e);
	}
	try {
	    textFileIO.createNewTextFile(urlStr, WordCountArr); 
	} catch (Exception e) {
	    System.out.println("Exception occurred creating new file with words replaced " + e); 
	}
    }

}