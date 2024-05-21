package Examples;

import org.apache.commons.io.FileUtils;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileUtilsExample {
    public static void main(String[] args){
        try{
            usingFileUtils();

        }catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static void usingFileUtils() throws IOException{
        File file=FileUtils.getFile("src/main/resources/Input.txt");
        File tmpDir= FileUtils.getTempDirectory();
        File userDir=FileUtils.getUserDirectory();

        System.out.println(tmpDir.getAbsolutePath());
        System.out.println(userDir.getAbsolutePath());
        //copy file to temp directory
        FileUtils.copyFileToDirectory(file, tmpDir);

        //create a new file
        File newTempFile=FileUtils.getFile(tmpDir, file.getName());

        //get the content
        String data=FileUtils.readFileToString(newTempFile, Charset.defaultCharset());

        //print the content
        System.out.println(data);
    }
}
