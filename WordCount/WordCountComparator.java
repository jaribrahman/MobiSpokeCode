import java.util.Comparator; 

class WordCountComparator implements Comparator<WordCount> {

    public int compare(WordCount wc1, WordCount wc2) {
	return wc2.getCount() - wc1.getCount(); 
    }
}