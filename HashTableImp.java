
import java.util.ArrayList;
import java.util.List;

/*********************************************
 * CO322: Data structures and algorithms
 * Implementation of the hashTable
 *********************************************/
class HashTableImp implements HashTable {

    /* Put your code here */
    private Bucket [] bucketArray;
    private int bucketSize=1;
    
    //----------------
    public void insert(String key){
        this.bucketArray[genarateHash(key)].addWordToBucket(key);
       
        
          
    }
    public int search(String key){
        
        return this.bucketArray[genarateHash(key)].getWordCountFromBucket(key);
    }
    
    public void printInfo(){
        for(int i=0;i<bucketSize;i++){
            System.out.println(i+" Bucket Size:"+ this.bucketArray[i].bucketSize + "              \n "+ this.bucketArray[i].words);
        }
    }
    
    public HashTableImp(int buckets) {
        this.bucketSize=buckets;
	// create a open hash table with given number of buckets 
        this.bucketArray= new Bucket [buckets];
        for(int i =0;i<buckets;i++){
            this.bucketArray [i]=new Bucket();
        } 
        
        
    }

    public int genarateHash(String word){
        int hash=0;
        for(int i=0;i<word.length();i++){
            hash+=word.charAt(i);
        }
        
        return word.length()*hash%this.bucketSize;
    }

}// end HashTableImp 



class Bucket{
    List<String> words = new ArrayList<String>();
    
    
    static int maxTableLength=0;
    public int bucketSize=0;
    static int totWord=0;
    
    public void addWordToBucket(String word){
        if(maxTableLength<this.words.size()){
            maxTableLength++;
            
        }
        words.add(word);
        totWord++;
        this.bucketSize++;
    }

    public Bucket() {
        
    }
    
    public int getWordCountFromBucket(String word){
        int count=0;
        System.out.println("Max Size:"+maxTableLength +"  Total Word Count:"+totWord+ " sqrt:"+Math.sqrt(totWord));
        for(int i=0;i<words.size();i++){
            
            if(words.get(i).equals(word)){
                
                count++;
            } else {
            }
        }
        return count;
    }
}