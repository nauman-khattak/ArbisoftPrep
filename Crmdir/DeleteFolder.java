import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.NumberFormatException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;
import java.io.FileNotFoundException;

public class DeleteFolder{
  URL input;
  URL output;
  BufferedReader br;
  PrintWriter out;
  StringTokenizer st;

  public DeleteFolder(){
    initialize();
  }
  public void initialize(){
    try {
      input = getClass().getResource("input.in");
      br = new BufferedReader(new FileReader(input.getPath()));

      output = getClass().getResource("output.out");
      out = new PrintWriter(output.getPath());
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  public void readData(){

    /*Sample Input
    3 1
    /Downloads/Music/Picture
    /Downloads/Programs
    /Downloads/Videos
    /Downloads/Movies
    */
    try {
      int pathsTotal;//from above sample input;;;;;pathsTotal = 3
      int deletionPathsTotal;//from above sample input;;;;;deletionPathsTotal = 1
      int count;//total count of folders to be deleted, initially it will be zero
      ArrayList<String> paths, deletionPaths;//drom sample;;;paths = 1st three paths;;;;deletionPaths = last path
      String[] foldersToDelete;//from above sample input;;;;;foldersToDelete = Movies
      ArrayList<String> parentFolder; //This will store only those folders which has childs
      while ((pathsTotal = nextInt()) != 00) {
        count = 0;
        deletionPathsTotal = nextInt();
        System.out.println(pathsTotal+" "+deletionPathsTotal);
        paths = new ArrayList();
        deletionPaths = new ArrayList();
        parentFolder = new ArrayList();

        for (int i = 0; i < pathsTotal ; i++) {
          paths.add(nextToken());
        }
        System.out.println("Paths = "+Arrays.asList(paths));
        for (int j = 0; j < deletionPathsTotal; j++) {
          deletionPaths.add(nextToken());
        }
        System.out.println("deletionPaths = "+Arrays.asList(deletionPaths));

        foldersToDelete = new String[deletionPaths.size()];

        for (int x = 0; x < deletionPathsTotal; x++) {
          foldersToDelete[x] = deletionPaths.get(x).substring(deletionPaths.get(x).lastIndexOf("/")+1);
        }
        System.out.println("FolderstoDelete = "+Arrays.asList(foldersToDelete));

        for (int x = 0;x < deletionPathsTotal; x++) {//iterate over ArrayList deletionPaths;
          for (int y = 0; y < pathsTotal ; y++) {//itereate over ArrayList paths;
            if (paths.get(y).contains(deletionPaths.get(x))) {
              String[] folders = paths.get(y).replaceFirst("^/", "").split("/");//paths.get(z).split("/"); will return leading empty string
              System.out.println("Folders"+Arrays.asList(folders));
              for (int z = 0; z < folders.length; z++) {
                for (int _z = 0; _z < foldersToDelete.length; _z++) {
                  if (folders[z].equals(foldersToDelete[_z])) {
                    if (!parentFolder.contains(foldersToDelete[_z])) {
                      parentFolder.add(foldersToDelete[_z]);
                    }
                    if (folders.length - (z+1) == 0) {
                      if (!parentFolder.contains(foldersToDelete[_z])) {
                        count = count + (folders.length - z);
                        continue;
                      }
                    }
                    count = count + (folders.length - (z + 1));
                  }
                }
              }
            }
          }
        }
        System.out.println("Result = "+(count+parentFolder.size()));
        out.println(count+parentFolder.size());
      }
      out.close();
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  public String nextToken() {
    while (st == null || !st.hasMoreTokens()) {
      String line = null;
      try {
        line = br.readLine();
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
      if (line == null) {
        return null;
      }
      st = new StringTokenizer(line);
    }
    return st.nextToken();
  }

  public int nextInt(){
    return Integer.parseInt(nextToken());
  }

  public static void main(String[] args) {
    new DeleteFolder().readData();
  }
}
