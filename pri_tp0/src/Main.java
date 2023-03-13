import interfaces.IDictionary;
import interfaces.IPostingList;
import classes.Dictionary;
import classes.PostingList;

import java.util.*;

public class Main {
    public static void main(String[] args){

        IDictionary map = new Dictionary();
        IPostingList posting = new PostingList();
        posting.addValue(1);
        posting.addValue(2);
        posting.addValue(3);
        posting.addValue(4);
        posting.addValue(7);
        posting.addValue(10);
        map.createDict("Jose",posting);
        //-----------
        IPostingList posting1 = new PostingList();
        posting1.addValue(1);
        posting1.addValue(3);
        posting1.addValue(5);
        posting1.addValue(7);
        posting1.addValue(10);
        map.createDict("Luisa",posting1);
        //-----------
        IPostingList posting3 = new PostingList();
        posting3.addValue(1);
        posting3.addValue(4);
        posting3.addValue(5);
        posting3.addValue(7);
        posting3.addValue(9);
        posting3.addValue(10);
        map.createDict("Miguel",posting3);
        //-----------
        IPostingList posting2 = new PostingList();
        ArrayList<Integer> docs = new ArrayList<>();
        docs.add(1);
        docs.add(2);
        docs.add(6);
        docs.add(9);
        docs.add(10);
        posting2.addValues(docs);
        map.createDict("Santos",posting2);
        //-----------
        map.search("Santos");
        map.search("Jose");
        map.search("Luisa");
        map.search("Miguel");
        //-----------
        map.searchIntersection("Jose","Luisa");
        //-----------
        ArrayList<String> search = new ArrayList<>();
        search.add("Jose");
        search.add("Luisa");
//        map.search(search);
        search.add("Luis");
        search.add("Santos");
        search.add("Miguel");
        System.out.println("\n\n");
        map.searchIntersections(search);

    }
}
