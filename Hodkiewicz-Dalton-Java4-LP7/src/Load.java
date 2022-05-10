import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @LP7 Homework example - For creating a directory structure, walking files, printing contents
 * @Contains runnable main method
 * @author dhodk
 *
 */
public class Load {

	public static void main(String[] args) throws IOException {	
		createFile();
		walkPaths();
	}
	
	/**
	 * @Function - Creates a file in the path specified in the charset format provided
	 * @params - empty
	 * @returns- void
	 * 
	 */
	public static void createFile() {
	    Path path = Paths.get("src\\assets\\other3.txt"); // this is the path
	    try(BufferedWriter writer = Files.newBufferedWriter(path, // write in path in charset if doesn't exist
	    		Charset.forName("UTF-16"))){
	    	writer.write("Hello WOrld Again And Again!"); // content to be written
	    }
	    catch(IOException e){ // catches if there is an exception
	    	System.out.println(e);
	    }
	    
	}
	
	/**
	 * @Function - CreateF() - create a directory structure if it doesn't exist
	 * @params - empty
	 * @returns- void
	 */
	public static void createF() {
		
		Path path = Paths.get("tempfiles/assets2/things/nature");
		try {
			Files.createDirectories(path);
		}
		catch(IOException e){
			
		}
	}
	
	/**
	 * @function - void
	 * Walk the paths in the directory provided - goes through child paths
	 * -prints the name and file size
	 * @Throws - inner and outer IOExceptions
	 */
	public static void walkPaths() {
		
		Path tempfiles = Paths.get("tempfiles\\");
		List<Path> myArrayOfFiles = new ArrayList<Path>();
		try {
		  Files.walk(tempfiles)
				.filter(p -> p.toString().endsWith(".txt"))
				.forEach(e -> {
					myArrayOfFiles.add(e);
				});
			myArrayOfFiles.forEach(e -> {
				System.out.println(e.getFileName());
				try {
					System.out.println("This is the file size in bytes: " + Files.size(e));
					System.out.println("This is the file name: " + e.getFileName());
					readFiles(e);
				} catch (IOException z) {
					z.printStackTrace();
				}
			});
		}
		catch(IOException e){
			System.out.println("outer exception caught here");
		}
	
	}
	
	/**
	 * @param path - takes a file path
	 * @throws IOException
	 * @Deliminates by spaces in the line
	 */
	public static void readFiles(Path path) throws IOException{
		try {	
		   
		    System.out.println("This is the absolute path: " + path.toAbsolutePath() +"\n");
		    
		    try(BufferedReader rdr = Files.newBufferedReader(path,
		    		Charset.forName("ISO-8859-1"))){
		    	String line = null;
		    	while((line = rdr.readLine()) != null) {
		    		String parts[] = line.split(" ");
		    	      for(String part: parts) {
		    	            System.out.println(part);
		    	        }
		    	      System.out.println();
		    	}
		    }
		}
		finally{
			
		}
	}

}
