package Class;

import java.io.IOException;
import java.util.stream.Stream;

import javax.xml.crypto.Data;

import FoodData.DataMethod;

import FoodData.CatalogMethod;
import UI.Catalog;

public class Class_test {
    static int Passed;
    static int Failed;
    
    public void check(String name,Boolean condition){
        if(condition){
            System.out.println(name + "Passed");
            Passed++;
        }
        else{
            System.out.println(name + "Failed");
            Failed++;
        }
    }

    public static void main(String[] args) throws IOException{
        RandomList randomlist = new RandomList();
        DataMethod dataMethod = new DataMethod();
        CatalogMethod catalogmethod = new CatalogMethod();
        dataMethod.getPreset(randomlist, "JapaneseFood");
        dataMethod.getPreset(randomlist, "ThaiFood");
        dataMethod.removePreset(randomlist, "JapaneseFood");
        System.out.println(randomlist.listToString());
        dataMethod.getPreset(randomlist, "ChineseFood");
        System.out.println(randomlist.listToString());

     

        


       
       
    }
}
