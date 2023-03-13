package interfaces;

import java.util.ArrayList;

public interface IDictionary {
    public void createDict(String key, IPostingList List);
    public void removeItem(String key);
    public void deleteDict();
    public void search(String key);
    public ArrayList<Integer> searchIntersection(String key, String key1);
    public void search(ArrayList<String> keys);
    public void searchIntersections(ArrayList<String> keys);

}
