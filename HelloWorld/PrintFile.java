import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.NumberFormatException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class PrintFile{

  URL url1, url2;
  BufferedReader br = null;
  FileWriter out = null;
  ArrayList<Integer> data;
  int totalTestCases;

  public PrintFile(){
      url1 = getClass().getResource("input.in");
      url2 = getClass().getResource("output.out");
  }

  public void readAndStore(){
    try{
      br = new BufferedReader(new FileReader(url1.getPath()));
      data = new ArrayList();
      String strLine;
      while ((strLine = br.readLine()) != null) {
        // if (Character.isDigit((char)a)) {
        //    data.add((char)a);
          data.add(Integer.parseInt(strLine));
        // }
      }
      System.out.println(Arrays.toString(data.toArray()));
      br.close();
    }catch(FileNotFoundException e){
      System.out.println("No such file exists");
      e.printStackTrace();
    }catch(NumberFormatException e){
      System.out.println("Cannot convert your input to int");
      e.printStackTrace();
    }catch(IOException e){
      System.out.println("No file to read data from");
      e.printStackTrace();
    }catch(NullPointerException e){
      System.out.println("Path is pointing to null");
      e.printStackTrace();
    }
  }

  public void write(){
    totalTestCases = data.get(0);
    try {
      out = new FileWriter(url2.getPath());
      int temp;
      for (int i=1 ; i<=totalTestCases ; i++) {
        for (int j= 0; j< data.get(i); j++) {
          out.write("Hello World"+System.getProperty("line.separator"));
        }
        if (i == totalTestCases) {
          continue; //continue statement skips the below portion of the loop it lies in. It jumps to the next iteration
        }
        out.write(System.getProperty("line.separator"));
      }
      out.close();
    }catch(FileNotFoundException e){
      System.out.println("No such file exists");
      e.printStackTrace();
    }catch(NumberFormatException e){
      e.printStackTrace();
    }catch(IOException e){
      System.out.println("No file to write data to");
      e.printStackTrace();
    }catch(NullPointerException e){
      System.out.println("Path is pointing to null");
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    PrintFile P = new PrintFile();
    P.readAndStore();
    P.write();
  }
}
