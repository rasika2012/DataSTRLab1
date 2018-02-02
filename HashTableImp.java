
import java.util.ArrayList;
import java.util.List;

/*********************************************
 * CO322: Data structures and algorithms
 * Implementation of the hashTable
 *********************************************/
class HashTableImp implements HashTable {

    /* Put your code here */
    private Bucket[] bucketArray;
    private int bucketSize = 1;

    //----------------
    public void insert(String key) {
        this.bucketArray[genarateHash(key)].addWordToBucket(key);


    }

    public int search(String key) {
        return this.bucketArray[genarateHash(key)].wordList.search(key);

    }

    public void printInfo() {
        for (int i = 0; i < bucketSize; i++) {
            System.out.println(i + "," + this.bucketArray[i].bucketSize);
        }
    }

    public HashTableImp(int buckets) {
        this.bucketSize = buckets;
        // create a open hash table with given number of buckets
        this.bucketArray = new Bucket[buckets];
        for (int i = 0; i < buckets; i++) {
            this.bucketArray[i] = new Bucket();
        }
    }

    public int genarateHash(String word) {
        int hash = 7;
        for (int i = 0; i < word.length(); i++) {
            hash =hash*31% this.bucketSize+ word.charAt(i);
        }

        return hash % this.bucketSize;
    }



}// end HashTableImp 


class Bucket {

    ListLinked wordList = new ListLinked();
    static int maxTableLength = 0;
    public int bucketSize = 0;
    static int totWord = 0;

    public void addWordToBucket(String word) {
        if (maxTableLength < this.wordList.getWordTypes()) {
            maxTableLength++;

        }
        wordList.add(word);
        totWord++;
        this.bucketSize = this.wordList.getWordTypes();
    }

    public Bucket() {

    }


}

class ListLinked {
    Obj head = new Obj();
    Obj tmp = head;

    public void add(String word) {
        Obj tmp = this.head;
        while (tmp.add(word) == false) {
            tmp = tmp.next;
        }
    }

    public int search(String word) {
        Obj tmp = this.head;
        if(word==""){
            return 0;
        }
        while (tmp.get(word) == 0 || tmp!=null) {
            if(tmp.next==null)return 0;
            tmp = tmp.next;
        }

        if (tmp.next==null){
            return 0;
        }
        return tmp.count;
    }

    public int getWordTypes() {
        Obj tmp = this.head;
        int count = 0;
        while (tmp.next != null) {
            tmp = tmp.next;
            count++;
        }
        return count;
    }

}


class Obj {
    int wordCount = 0;
    int count = 0;
    String word = "";
    Obj next = null;

    public void Obj() {

    }

    public boolean add(String word) {

        if (this.word.equals("")) {
            this.next = new Obj();
            this.word = word;
            this.count++;
            //wordCount++;

        }

        if (this.word.equals(word)) {
            if (this.next == null) {
                this.next = new Obj();
                this.next.word = word;

            }
            this.count++;
            return true;
        } else {
            return false;
        }
    }

    public int get(String word) {
        if (this.word.equals(word) || !word.equals("")) {
            if (this.next == null) {
                return 0;
            }
            return count;
        } else {
            return 0;
        }
    }


}