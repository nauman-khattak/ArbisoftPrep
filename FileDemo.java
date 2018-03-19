import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collection;
import java.util.ArrayList;

public class FileDemo{
  File f = null;
  File[] paths;
  FilenameFilter filenameFilter;
  String ext; //user supplied extension
  // String extension; //extension extracted from file in directory
  public FileDemo(String ext){
    this.ext = "."+ext;
  }

  public void storeFileNames() {
    try {
      f = new File("E:/ArbisoftPrep/AlphabetCake");
      filenameFilter = new FilenameFilter(){
        public boolean accept(File dir, String name){
          return name.endsWith(ext);
        }
      };
    }catch (Exception e) {
      e.printStackTrace();
    }
    paths = f.listFiles(filenameFilter);
    System.out.println(Arrays.asList(paths));
    System.out.println(Arrays.asList(f.list())); //contents of directory
  }

  public static void main(String[] args) {
    FileDemo fileDemo = new FileDemo("java");
    fileDemo.storeFileNames();
  }
}
