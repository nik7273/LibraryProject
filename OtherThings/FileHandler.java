import java.util.*;
import java.io.*;
import java.*;

public class FileHandler{
   public static String[] readFile(String fileName){
    ArrayList<String> linesArr = new ArrayList<String>();
    int fileLines = 0;
    try{
      
      BufferedReader inputFile = new BufferedReader(new FileReader(fileName), 1024);
      
      String line;
      while ((line = inputFile.readLine()) != null)
      {
        linesArr.add(line);
        fileLines++;
      }
      
      inputFile.close();
    }
    catch(Exception e){
      //System.out.println("ERROR READING");
    }
    
    String[] lines = new String[fileLines];
    int counter = 0;
    for(String line: linesArr){
      lines[counter] = line;
      counter++;
    }
    
    return lines;
  }
  
  public static void writeFile(String fileName, String[] writeInfo){
    try{
      String[] fileInfo = null;
      
      try{
        fileInfo = readFile(fileName);
      }
      catch(Exception e){
        System.out.println("Error: " + e);
      }
      
      PrintWriter outputFile = new PrintWriter(new FileWriter(fileName)); 
      
      ArrayList<String> allInfo = new ArrayList<String>();
      
      for (String info: fileInfo){
        outputFile.println(info);
      }     
      
      for (String info: writeInfo){
        outputFile.println(info);
      }
      
      outputFile.close();
    }
    catch(Exception e){
      System.out.println("ERROR: " + e);
    }
  }
  
  public static void writeFile(String fileName, String writeInfo){
    writeFile(fileName, new String[]{writeInfo});
  }
  
  public static void formatFile(String fileName){
    try{
      PrintWriter outputFile = new PrintWriter(new FileWriter(fileName)); 
      outputFile.close();
    }
    catch(Exception e){
      System.out.println("ERROR: " + e);
    }
  }
  
  public static boolean contains(String[] arr, String val){
    for(String index: arr){
      if (val.equals(index)){
        return true;
      }
    }
    return false;
  }
  
  public static String readLine(String line, int index){
    return line.split(",")[index - 1].trim();
  }
  
  public static int linesInFile(String fileName){
    return readFile(fileName).length;
  }
  
  public static void removeLine(String fileName, int lineNumber){
    String[] fileInfo = readFile(fileName);
    String[] newFileInfo = new String[fileInfo.length - 1];
    
    
    for (int i = 0; i < linesInFile(fileName); i++){
      if (i < lineNumber - 1){
        newFileInfo[i] = fileInfo[i];
      }
      else if (i > lineNumber - 1){
        newFileInfo[i - 1] = fileInfo[i];
      }
    }
    
    formatFile(fileName);
    writeFile(fileName, newFileInfo);
  }
  
  public static void appendToLine(String fileName, String infoToAppend, int lineNumber){
    String[] lines = readFile(fileName);
    
    String lineInfo = lines[lineNumber - 1];
    lineInfo += infoToAppend;
    
    removeLine(fileName, lineNumber);
    writeFile(fileName, lineInfo);
  }
}









