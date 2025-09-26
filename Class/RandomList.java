package Class;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class RandomList{
    private ArrayList<String> randomlist = new ArrayList<>();
    private Random random = new Random();

    private void checkRep(){
        for(int i = 0; i < randomlist.size(); i++){
            if((randomlist.get(i).isBlank()) || (randomlist.get(i) == null)){
                throw new RuntimeException("rep violent: randomlist is null or blank");
            }
            for(int j = i+1 ; j < randomlist.size() ; j++){
                if(randomlist.get(i).equals(randomlist.get(j))){
                    throw new RuntimeException("rep violent: duplicate food name");
                }
            }
        }
    }

    public void addtoList(String name){
        if((!Listcontain(name)) && (!name.isBlank()) && !(name == null)){
            randomlist.add(name);
        }
        checkRep();
    }

    public void removeFormList(int index){
        if(Listcontain(index)){
            randomlist.remove(index);
        }
        checkRep();
    }

    public void removeFormList(String name){
        if(Listcontain(name)){
            for(int i = 0 ; i < randomlist.size() ; i++){
                if(randomlist.get(i).equals(name)){
                    randomlist.remove(i);
                }
            }
        }
        checkRep();
    }

    public void clearList(){
        randomlist.clear();
        checkRep();
    }

    public String getName(int index){
        return randomlist.get(index);
    }

    public int getListLength(){
        return randomlist.size();
    }

    public boolean Listcontain(String name){
        boolean check = false;
        for(int i = 0 ; i < randomlist.size() ;i++ ){
            if(randomlist.get(i).equals(name)){
                check = true;
            }
        }
        return check;
    }

    public boolean Listcontain(int index){
        boolean check = false;
        for(int i = 0 ; i < randomlist.size() ;i++ ){
          if(randomlist.get(index).equals(randomlist.get(i))){
            check = true;
          }
        }
        return check;
    }

    public String listToString(){
        String list = randomlist.toString();
        return list;
    }

    public int getIndexof(String name){
        
        for(int i = 0; i < randomlist.size() ; i++){
            if(randomlist.get(i).equals(name)){
                return i;
            }
        }
        throw new RuntimeException("index of of bound");
    }

    public String getRandom(){
        int random = this.random.nextInt(randomlist.size());
        return randomlist.get(random);
    }


}