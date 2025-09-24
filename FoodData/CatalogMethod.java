package FoodData;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Class.RandomList;

public class CatalogMethod {
    private ArrayList<String> catalogname = new ArrayList<>();
    private File file;
    private BufferedReader bufferedReader;
    private FileReader fileReader;
    private BufferedWriter bufferedWriter;
    private FileWriter fileWriter;

    public CatalogMethod(){
        InstallCatalogNameList();
    }

    public void InstallCatalogNameList(){
        file = new File("./FoodData/CatalogData/");
        File allfile[] = file.listFiles();
        if(allfile.length != 0){
            for(int i = 0 ; i < allfile.length ; i++){
                int index = allfile[i].getName().indexOf(".");
                if(index != -1){
                    catalogname.add(allfile[i].getName().substring(0, index));
                }
            }
        }
    }

    public String getCatalogName(int index){
        return catalogname.get(index);
    }

    public int getCatalogListLength(){
        return catalogname.size();
    }

    public void getCatalog(RandomList randomList,String catalogname){
        try {
            file = new File("./FoodData/CatalogData/"+catalogname+".csv");
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String food = "";
            while((food = bufferedReader.readLine()) != null){
                randomList.addtoList(food);
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

    

    public void removeCatalog(RandomList randomList,String catalogname){
        try{
            file = new File("./FoodData/CatalogData/"+catalogname+".csv");
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
            try{
                bufferedReader.close();
                fileReader.close();
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }

    public void createCatalog(RandomList randomList, String catalogname){
        try{
            file = new File("./FoodData/CatalogData/"+catalogname+".csv");
            file.createNewFile();
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            
                for(int i = 0; i < randomList.getListLength(); i++){
                    bufferedWriter.write(randomList.getName(i));
                    bufferedWriter.write("\n");
                }
            InstallCatalogNameList();
             
        }catch(Exception e){
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

    public void deleteCatalog(String catalogname){
        try{
            if(catalogExits(catalogname)){
                file = new File("./FoodData/CatalogData/"+catalogname+".csv");
                file.delete();
                InstallCatalogNameList();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public boolean catalogExits(String catalogname){
        boolean check = false;
        file = new File("./FoodData/CatalogData/");
        File allfile[] = file.listFiles();
        for(int i = 0; i < allfile.length; i++){
            if(allfile[i].getName().equals(catalogname+".csv")){
                check = true;
            }
        }
        return check;
    }
}
