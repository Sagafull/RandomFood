package FoodData;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

import javax.swing.DefaultListModel;

import Class.RandomList;

public class DataMethod {
    private File file;
    private BufferedReader bufferedReader;
    private FileReader fileReader;
    private BufferedWriter bufferedWriter;
    private FileWriter fileWriter;

    

    public void getPreset(RandomList randomList,DefaultListModel dModel,String Listname){
        try {
            file = new File("./FoodData/PresetData/Preset.csv");
            fileReader = new FileReader(file,Charset.forName("UTF8"));
            bufferedReader = new BufferedReader(fileReader);
            String food = "";
            while((food = bufferedReader.readLine()) != null){
               if(food.equals(":"+Listname)){
                while((food = bufferedReader.readLine()) != null && !(food.equals(":END"))){
                    int index = food.indexOf(",");
                    if(!(randomList.Listcontain(food.substring(0,index))) && (index != -1)){
                        randomList.addtoList(food);
                        dModel.addElement(food.substring(0,index));
                    }
                }
               }
            }
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            try{
                bufferedReader.close();
                fileReader.close();
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }

    public void getPreset(RandomList randomList,String Listname){
        try {
            file = new File("./FoodData/PresetData/Preset.csv");
            fileReader = new FileReader(file,Charset.forName("UTF8"));
            bufferedReader = new BufferedReader(fileReader);
            String food = "";
            while((food = bufferedReader.readLine()) != null){
               if(food.equals(":"+Listname)){
                while((food = bufferedReader.readLine()) != null && !(food.equals(":END"))){
                    int index = food.indexOf(",");
                    if(!(randomList.Listcontain(food.substring(0,index))) && (index != -1)){
                        randomList.addtoList(food);
                    }
                }
               }
            }
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            try{
                bufferedReader.close();
                fileReader.close();
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }

    public void removePreset(RandomList randomList,DefaultListModel dModel,String Listname){
        try {
            file = new File("./FoodData/PresetData/Preset.csv");
            fileReader = new FileReader(file,Charset.forName("UTF8"));
            bufferedReader = new BufferedReader(fileReader);
            String food = "";
            while((food = bufferedReader.readLine()) != null){
               if(food.equals(":"+Listname)){
                while((food = bufferedReader.readLine()) != null && !(food.equals(":END"))){
                    int index = food.indexOf(",");
                    System.out.println(randomList.getName(0)+" "+food);
                    for(int i = 0 ; i < randomList.getListLength(); i++){
                        if((randomList.getName(i).equals(food) && (index != -1))){
                            randomList.removeFormList(food);
                            dModel.removeElementAt(dModel.indexOf(food.substring(0, index)));
                        }
                    }
                }
               }
              
            }
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            try{
                bufferedReader.close();
                fileReader.close();
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }

    
}
