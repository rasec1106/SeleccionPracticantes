package util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {
	
	public static void openFile(String path) throws Exception{
		try {
			if((new File(".\\filesDirectory\\"+path)).exists()) {
				Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+".\\filesDirectory\\"+path);
				p.waitFor();
			}else{
				System.err.println("File does not exist");
				throw new Exception("No existe dicho archivo");
			}
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void copyFile(String from, String to) throws IOException{
		Path src = Paths.get(from);
		Path dest = Paths.get(".\\filesDirectory\\"+to);
		Files.copy(src, dest);
	}
	
	public static File getFile(String path) {
		File file = new File(".\\filesDirectory\\"+path);
		if (file.exists()) return file;
		return null;
	}
}
