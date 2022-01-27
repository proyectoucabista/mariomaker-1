import java.awt.Component;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
// LIBRERIAS

/**
 * Este archivo Se utiliza para abrir, solicitar abrir, guardar, solicitar guardar y leer archivos.
 
 */
public class FileOpener{
	private JFileChooser eleccion;
	private Component component;
	private String ext;
	
	private BufferedReader reader;
	
	/**
	 * Creates a new FileOpener with the parent Component specified
	 * @param component component to be used when displaying the JFileChooser
	 */
	public FileOpener(Component component){
		eleccion = new JFileChooser();
		eleccion.setFileSelectionMode(JFileChooser.FILES_ONLY);
		eleccion.setFileFilter(new CustomFilter("JGameMaker", "JGameMaker Level")); // nombre del juego
		this.component = component;
		ext = "JGameMaker"; // extension del juego
		
	}
	
	/*
	  Pide al usuario que guarde un archivo abriendo un JFileChooser
          return el archivo que se elige, nulo si no se elige ninguno 
	 */
	public File guardarArchivo(){
		if(eleccion == null || component == null)return null;
		File file;
		int returnVal = eleccion.showSaveDialog(eleccion);
		if(returnVal != JFileChooser.APPROVE_OPTION) return null;
		file = eleccion.getSelectedFile();
		String name = file.getPath();
		String ext = '.' + this.ext;
		if(!name.substring(name.length()-ext.length(), name.length()).equals(ext)){
			name += ext;
			file = new File(name);
		}
		return file;
	}
	
	/**
	 * Prompts the user to open a file by opening a JFileChooser
	 * @return the File that is chosen, null if none is chosen
	 */
	public File openFile(){
		if(eleccion == null || component == null)return null;
		File file;
		int returnVal = eleccion.showOpenDialog(component);
		if(returnVal != JFileChooser.APPROVE_OPTION) return null;
		file = eleccion.getSelectedFile();
		try{
			file.createNewFile();
			return file;
		}catch(Exception ex){
			System.err.println("No se puede leer el archivo");
			return null;
		}
	}
	/*
	 Abre un nuevo FileReader para leer el archivo especificado por la ruta
         return verdadero si se puede leer, falso si no
	 */
	public boolean readFile(String path){
		return readFile(new File(path));
	}
	/*
	  Abre un nuevo archivo con FileReader para leer el archivo
          
          return verdadero si se puede leer, falso si no
	 */
	public boolean readFile(File file){
		try{
			reader = new BufferedReader(new FileReader(file));
			return true;
		}catch(FileNotFoundException e){
			reader = null;
			return false;
		}

	}
	
	/*
	  Obtiene la siguiente línea del FileReader después de llamar a readFile
          Return la siguiente línea si se puede leer, nulo si no
	 */
	public String readLine(){
		if(reader == null)return null;
		String str;
		try {
			str = reader.readLine();
		} catch (IOException e) {
			return null;
		}
		return str;
	}
	
	private class CustomFilter extends FileFilter{
		
		private String ext, description;
		
		public CustomFilter(String ext, String description){
			this.ext = '.' + ext; // .JGameMaker
			this.description = description;
		}
		public boolean accept(File file) {
			if(file.isDirectory())
				return true;
			String name = file.getName();
			int length = name.length();
			if(name.substring(length-ext.length(), length).equals(ext)){
				return true;
			}
			return false;
		}

		public String getDescription() {
			return description + " *" + ext;
		}
		
	}
	
}
