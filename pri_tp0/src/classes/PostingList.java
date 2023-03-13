package classes;

import interfaces.IPostingList;

import java.util.*;

public class PostingList implements IPostingList {
    ArrayList<Integer> posting_list = new ArrayList<>();

    @Override
    public void addValue(int value){
        posting_list.add(value);
    }

    @Override
    public void addValues(ArrayList<Integer> values){
        for (int i = 0; i<values.size(); i++){
            posting_list.add(values.get(i));
        }
    }

    @Override
    public void removeValue(int value){
        posting_list.remove(value);
    }

    @Override
    public ArrayList<Integer> getPosting_list() {
        return posting_list;
    }

    @Override
    public void setPosting_list(ArrayList<Integer> posting_list) {
        this.posting_list = posting_list;
    }
}
