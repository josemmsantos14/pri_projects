package classes;

import interfaces.IDictionary;
import interfaces.IPostingList;

import java.util.*;

public class Dictionary implements IDictionary {
    HashMap<String, IPostingList> my_dict = new HashMap<String, IPostingList>();

    @Override
    public void createDict(String key, IPostingList posting){
        my_dict.put(key, posting);
    }

    @Override
    public void removeItem(String key){
        my_dict.remove(key);
    }

    @Override
    public void deleteDict(){
        my_dict.clear();
    }

    @Override
    public void search(String key){
        if (my_dict.containsKey(key)){
            System.out.println(key + ": " + my_dict.get(key).getPosting_list());
        }
        else{
            System.out.println("Element not found.");
        }
    }

    @Override
    public ArrayList<Integer> searchIntersection(String key, String key1){
        ArrayList<Integer> intersectDocs = new ArrayList<>();
        if(my_dict.containsKey(key)){
            ArrayList values = my_dict.get(key).getPosting_list();
            ArrayList values1 = my_dict.get(key1).getPosting_list();
//            System.out.println(values);
//            System.out.println(values1);

            int i = 0;
            int j = 0;
            while (values.size() != i && values1.size() != j){
                if ( values.get(i) == values1.get(j)){
                    intersectDocs.add((Integer) values.get(i));
                    i+=1;
                    j+=1;
                }
                else{
                    if( (int)values.get(i) < (int)values1.get(j)){
                        i+=1;
                    }
                    else{
                        j+=1;
                    }
                }
            }
        }
        System.out.printf("The intersection between \"%s\" and \"%s\" is: %s", key, key1, intersectDocs);
        return intersectDocs;
    }

    @Override
    public void search(ArrayList<String> keys){
        for (String key : keys){
            if (my_dict.containsKey(key)){
                System.out.println(key + ": " + my_dict.get(key).getPosting_list());
            }
            else{
                System.out.println("Element not found.");
            }
        }
    }

    public void searchIntersections(ArrayList<String> keys) {
        ArrayList<Integer> intersectDocs = new ArrayList<>();
        ArrayList<ArrayList<Integer>> values = new ArrayList<>();

        for (int i = 0; i < keys.size(); i++) {
            if (my_dict.containsKey(keys.get(i))) {
                values.add(my_dict.get(keys.get(i)).getPosting_list());
            }
            else{
                System.out.printf("The word \"%s\" dont exist in the docs.%n", keys.get(i));
                intersectDocs.add(i);
            }
        }

        for (int i=0; i<intersectDocs.size();i++) {
            keys.remove((int)intersectDocs.get(i));
        }

        for(int n=0; n<values.size(); n++) {
            if(n>=1){
                values.remove(0);
                values.get(0).clear();
                values.get(0).addAll(intersectDocs);
            }
//            System.out.println("\n"+n);
//            System.out.println("intersectDocs: "+intersectDocs);
//            System.out.println("values: "+values);
            intersectDocs.clear();
//            System.out.println("intersectDocs: "+intersectDocs);
//            System.out.println("values1: "+values);
            int i = 0;
            int j = 0;
            while (values.get(0).size() != i && values.get(1).size() != j) {
                if (values.get(0).get(i) == values.get(1).get(j)) {
                    intersectDocs.add((Integer) values.get(0).get(i));
                    i += 1;
                    j += 1;
                } else {
                    if ((int) values.get(0).get(i) < (int) values.get(1).get(j)) {
                        i += 1;
                    } else {
                        j += 1;
                    }
                }
            }
        }
        System.out.printf("The instersection betwwen %s is: %s",keys,intersectDocs);
    }
    @Override
    public String toString() {
        return "classes.Dictionary{" +
                "my_dict=" + my_dict +
                '}';
    }
}
