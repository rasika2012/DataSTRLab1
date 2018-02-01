
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

public class Engin {
    
    /**
     * @param args the command line arguments
     */
    static HashTableImp map=new HashTableImp(100);
    public static void main(String[] args) throws IOException {
        
        String word = getText();
        List<String>  textList= getWords(word);
        //map.search("i");
        System.out.println(map.search(args[0])); 
        map.printInfo();
    }
    
    public static String getText() throws FileNotFoundException, IOException{
        try (BufferedReader br = new BufferedReader(new FileReader("sample-text1.txt"))) {
             StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append('\r');
                line = br.readLine();
            }
            return sb.toString();
        }
    }
    
    public static List<String> getWords(String text) {
        List<String> words = new ArrayList<String>();
        BreakIterator breakIterator = BreakIterator.getWordInstance();
        breakIterator.setText(text);
        int lastIndex = breakIterator.first();
        while (BreakIterator.DONE != lastIndex) {
            int firstIndex = lastIndex;
            lastIndex = breakIterator.next();
            if (lastIndex != BreakIterator.DONE && (Character.isLowerCase(text.charAt(firstIndex))||Character.isDigit(text.charAt(firstIndex))||Character.isUpperCase(text.charAt(firstIndex)))&& (Character.isLowerCase(text.charAt(lastIndex-1))||Character.isDigit(text.charAt(lastIndex-1))||Character.isUpperCase(text.charAt(lastIndex-1)))) {
            map.insert(text.substring(firstIndex, lastIndex));
            
            //System.out.println(text.substring(firstIndex, lastIndex));
            words.add(text.substring(firstIndex, lastIndex));
        }
    }

    return words;
    }

    
    
    
    
    
}

