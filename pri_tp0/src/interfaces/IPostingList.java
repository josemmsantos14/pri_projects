package interfaces;

import java.util.ArrayList;

public interface IPostingList {

    public void addValue(int a);
    public void removeValue(int a);
    public ArrayList<Integer> getPosting_list();
    public void setPosting_list(ArrayList<Integer> posting_list);
    public void addValues(ArrayList<Integer> values);
}
