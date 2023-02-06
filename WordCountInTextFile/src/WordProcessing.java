import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class WordProcessing {
	private TreeMap<String, Integer> map = null;
	private String filename;
	public WordProcessing(String filename) {
		this.filename = filename;
		map = new TreeMap<String, Integer>();
	}
	
	
	public  TreeMap<String, Integer> getWordCount() throws FileNotFoundException {
		if (map.isEmpty()) {
			parseWord();
		}
		return map;
	}


	private void parseWord() throws FileNotFoundException {
		Scanner txtFile = new Scanner(new File(filename));
		while(txtFile.hasNext()) {
			String word = txtFile.next();
			int count = 1;
			if (map.containsKey(word)) {
			 count = map.get(word) + 1;
				
			}
			map.put(word,  count);
		}
		txtFile.close();
	}
}
