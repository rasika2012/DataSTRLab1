
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

public class lab1 {
    static Hashtable< String,Integer> source = new Hashtable<String,Integer>();
    static HashMap<String,Integer> map = new HashMap(source);
    static int wordCount=0,total=0,mean=0,sqrTot=0,deviation=0;
        

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String word = getText();
        for(int i=0;i<word.length();i++){
            
        }
        List<String>  textList= getWords(word);
        
        Object[] arr=map.keySet().toArray();
        for(int j=0;j<arr.length;j++){
            int k=1;
            String wordMost="";
        for(int i=0;i<arr.length;i++){
            if(map.get(arr[i])>k){
                k=map.get(arr[i]);
                wordMost=arr[i].toString();
            }
        }
        map.put(wordMost,0);
        if(wordMost!=""){
            wordCount++;
        total=total+k;
        sqrTot=sqrTot+k*k;
        
        System.out.println(k+" "+wordMost);
        
        drawGraph((int) Math.round(Math.sqrt(k)));
        drawGraph(wordMost.length());
        }
        
        
        
        }
        System.out.println("Word  Count: "+wordCount);
        System.out.println("Word Total: "+total);
        System.out.println("Word sqrTot: "+Math.sqrt(total));
        System.out.println("Word Mean: "+wordCount/wordCount);
        System.out.println("Word deviation: "+wordCount);
        
        System.out.print(textList.get(0));
    }
    static void drawGraph(int value){
        for(int i=0;i<value;i++)System.out.print("~");
        System.out.println("");
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
                if(map.get(text.substring(firstIndex, lastIndex))==null){
                    map.put(text.substring(firstIndex, lastIndex), 1);
                }else{
                    int i=map.get(text.substring(firstIndex, lastIndex));
                    map.put(text.substring(firstIndex, lastIndex), i +1);
                }
            words.add(text.substring(firstIndex, lastIndex));
        }
    }

    return words;
    }

    
    
    
    
    
}

