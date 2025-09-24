package FoodData;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Class.RandomList;

public class DataMethod {
    private File file;
    private BufferedReader bufferedReader;
    private FileReader fileReader;
    private BufferedWriter bufferedWriter;
    private FileWriter fileWriter;

    public void getPreset(RandomList randomList,String filename) throws IOException{
        try {
            file = new File("./FoodData/PresetData/"+filename+".csv");
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String food = "";
            while((food = bufferedReader.readLine()) != null){
                randomList.addtoList(food);
                System.out.println(food);
            }
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            bufferedReader.close();
            fileReader.close();
        }
    }

    public void removePreset(RandomList randomList,String filename) throws IOException{
        try{
            file = new File("./FoodData/PresetData/"+filename+".csv");
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String food = "";
            while ((food = bufferedReader.readLine()) != null) {
                if(randomList.Listcontain(food)){
                    randomList.removeFormList(food);
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }finally{
            bufferedReader.close();
            fileReader.close();
        }
    }

    //week 3 things
    
}
