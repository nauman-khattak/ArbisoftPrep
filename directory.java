
import java.io.IOException;
import java.io.File;
import java.util.Arrays;
import java.io.FileFilter;

public class directory{
  public static void main(String[] args) throws IOException{
    File file = new File("E:/");
    FileFilter fileFilter = new FileFilter(){
      public boolean accept(File file){
        return file.isFile() || file.isDirectory();
      }
    };
    // String[] paths = file.list();
    File[] files = file.listFiles();
    // System.out.println(Arrays.asList(files)); //printing paths of files/directories stored in File[] files
    for (File f : files) {
      if (f.isDirectory()) {
        System.out.print("Directory -> ");
      } else if (f.isFile()) {
        System.out.print("File -> ");
      }
      System.out.println(f.getAbsolutePath());
    }
    // System.out.println(Arrays.asList(paths));
  }
}
