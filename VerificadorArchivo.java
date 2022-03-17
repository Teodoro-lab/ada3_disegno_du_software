import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class VerificadorArchivo {

	public boolean verificarExistenciaArchivo(String ruta, String nombre) {
		File FILE = new File(ruta + nombre);
		if (FILE.exists()) {
			return true;
		}
		return false;
	}

	public String[] getContent(String ruta, String nombre){
		File file = new File(ruta + nombre);
		ArrayList<String> content = new ArrayList<>();

		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String st;
			while ((st = br.readLine()) != null)
				content.add(st);
			br.close();
		} catch (FileNotFoundException e){
			System.out.println(e.getMessage());
		} catch (IOException e){
			System.out.println(e.getMessage());
		}

		String[] objects = (String[])content.toArray();
		return objects;
	}

}
