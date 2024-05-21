package Activities;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Activity14 {
    public static void main(String[] args){

        try{
            File file =new File("src/main/resources/newfile.txt");
            boolean fStatus=file.createNewFile();
            if(fStatus){
                System.out.println("File created successfully");

            }else{
                System.out.println("File already exists at this path");
            }
            //get the file object
            File fileUtil= FileUtils.getFile("src/main/resources/newfile.txt");
            //read file
            System.out.println("Data in file:"+FileUtils.readFileToString(fileUtil,"newfile.txt"));

            //create directory
            File destDir=new File("resources");

            //copy file to directory
            FileUtils.copyFileToDirectory(file, destDir);

            //get file from new directory
            File newFile=FileUtils.getFile(destDir,"newfile.txt");

            //read data from file
            String newFileData=FileUtils.readFileToString(newFile,"UFT8");

            //print it
            System.out.println("Data in new File:"+newFileData);
        }catch (IOException errMessage){
            System.out.println(errMessage);
        }
    }
}
