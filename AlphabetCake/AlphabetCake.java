import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class AlphabetCake{
  URL inputPath, outputPath;
  BufferedReader br = null;
  FileWriter out = null;
  ArrayList<String> data;

  public AlphabetCake(){
    inputPath = getClass().getResource("A-small-practice.in");
    outputPath = getClass().getResource("alphabet-cake.out");
  }

  public void readData(){
    try{
      br = new BufferedReader(new FileReader(inputPath.getPath()));
      String strLine;
      data = new ArrayList();
      while ((strLine = br.readLine()) != null) {
        data.add(strLine);
      }
      br.close();
    }catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void parse(){
    try{
      int testCase = 1;
      int i = 1; //for traversing whole input file from start to end except first line of input file
      int R, C; //Rows and Columns in gridc
      StringBuilder sb = new StringBuilder();
      StringBuilder noQuestionMark = new StringBuilder();
      StringBuilder temp = new StringBuilder();
      Random random = new Random();
      String[] _RandC;
      // char[][] matrix; //uncommented
      out = new FileWriter(outputPath.getPath());

      while (data.size() > i) {
        out.write("case #"+testCase+":"+System.getProperty("line.separator"));
        testCase++;
        sb.append(data.get(i++));
        _RandC = sb.toString().split(" ");
        // R = Character.getNumericValue((char)sb.charAt(0));
        R=Integer.parseInt(_RandC[0]);
        C=Integer.parseInt(_RandC[1]);
        // System.out.println("R = "+R+"\nC = "+C);
        // matrix = new char[R][C];//uncommented
        sb.setLength(0);

        for (int _R=0; _R < R; _R++) {
          sb.append(data.get(i++));
          for (int _C=0; _C<C; _C++) {
            if (sb.charAt(_C) != '?') {
              noQuestionMark.append(sb.charAt(_C));
            }
            temp.append(sb.charAt(_C));
            // matrix[_R][_C] = sb.charAt(_C);//uncommented
          }
          sb.setLength(0);
        }
        // System.out.println(Arrays.deepToString(matrix));//uncommented

        for (int a=0; a<temp.length(); a++ ) {
          if (temp.charAt(a) == '?') {
            temp.setCharAt(a, noQuestionMark.charAt(random.nextInt(noQuestionMark.length())));
          }
        }

        for (int b=0; b<temp.length(); b++) {
          sb.append(temp.charAt(b));
          if (sb.length()%C == 0) {
            // System.out.println(sb);
            out.write(sb.toString()+System.getProperty("line.separator"));
            sb.setLength(0);
          }
        }
        temp.setLength(0);
        // System.out.println(Arrays.deepToString(matrix));//uncommented
      }
      out.close();
    }catch(Exception e){
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    AlphabetCake cake = new AlphabetCake();
    cake.readData();
    cake.parse();
  }
}
