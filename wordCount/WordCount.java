package wordCount;

 import java.io.BufferedReader;
 import java.io.DataInputStream;
 import java.io.FileInputStream;
 import java.io.IOException;
 import java.io.InputStreamReader;
 import java.util.ArrayList;
 import java.util.Collections;
 import java.util.Comparator;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import java.util.Map.Entry;
 import java.util.Set;
 import java.util.regex.Pattern;

 /**
  *  @author Gabriela Fundora
  *  @version 1.8
  *  @since 1.5 */
 
 public class WordCount {
 /** *This is a program for calculating word occurrences *@param args */
 public static void main(String args[]) {
	 /** * This is the main method * code execution */
Map<String, Integer> wordMap = buildWordMap("C:\\Users\\gabys\\OneDrive\\Desktop\\words.txt.txt");
/** * @param wordMap This is where we allocate the data from the file to the wordMap */
List<Entry<String, Integer>> list = sortByValueInDecreasingOrder(wordMap);
System.out.println("List of Word Occurrences");
for (Map.Entry<String, Integer> entry : list) {
	if (entry.getValue() > 6  && entry.getKey() != " ") { 
		System.out.println(entry.getKey() + " : " + entry.getValue()); 
		} 
	} 
} 
 public static Map<String, Integer> buildWordMap(String fileName) {
	 /** * This is a method which actually builds word occurrence map * @param fileName */
	 Map<String, Integer> wordMap = new HashMap<>();
	 try (FileInputStream fis = new FileInputStream(fileName);
			 DataInputStream dis = new DataInputStream(fis);
			 BufferedReader br = new BufferedReader(new InputStreamReader(dis))) {
		 Pattern pattern = Pattern.compile("\\s+"); String line = null;
		 while ((line = br.readLine()) != null) {
			 line = line.toLowerCase(); String[] words = pattern.split(line);
			 for (String word : words) {
				 if (wordMap.containsKey(word)) { wordMap.put(word, (wordMap.get(word) + 1));
				 } else { wordMap.put(word, 1); 
				 }
				 } 
			 }
}
	 catch (IOException ioex) { ioex.printStackTrace();
	 } return wordMap;
	 } /** * This method is used to sort the wordMap is descending order * @param wordMap */ 
 
 public static List<Entry<String, Integer>> sortByValueInDecreasingOrder(Map<String, Integer> wordMap) {
	 Set<Entry<String, Integer>> entries = wordMap.entrySet();
	 List<Entry<String, Integer>> list = new ArrayList<>(entries);
	 Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
		 @Override 
public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
	return (o2.getValue()).compareTo(o1.getValue());
			 } 
		 }
	 );
	 return list;
		 } 
 }