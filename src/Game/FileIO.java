package Game;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FileIO {
    private Boolean isRecording;
    List<String> lines;
    private String filename;

    public FileIO(String ifilename){
        this.isRecording = false;
        lines = new ArrayList<String>();
        this.filename = ifilename;
    }

    public void setFileName(String iFileName){
        this.filename = iFileName;
    }


    public Boolean GetIsRecording(){
        return this.isRecording;
    }
    public void StartRecording(){
        isRecording = true;
    }
    public void StopRecording(){
        isRecording = false;
    }
    public void Print(String line){
        System.out.println(line);
        if(isRecording){
            lines.add(line);
        }
    }
    public void SaveToFile() throws IOException {
        Path file = Paths.get(filename);
        if(Files.exists(file)){
            Files.delete(file);
            Files.createFile(file);
        }
        if(!lines.isEmpty()){
            Files.write(file, lines, StandardCharsets.UTF_8);
        }
        lines.clear();
        System.out.println("Бій збережено в "+filename);
    }
    public void LoadFromFile() throws IOException {
        Path file = Paths.get(filename);
        lines = Files.readAllLines(file,StandardCharsets.UTF_8);
        for (String line : lines){
            System.out.println(line);
//            try{
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e){
//                System.out.println("got interrupted!");
//            }
        }
    }
}
