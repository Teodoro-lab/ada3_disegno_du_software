import java.io.File;

public class VerificadorArchivo {

	public boolean verificarExistenciaArchivo(String ruta, String nombre) {
		File FILE = new File(ruta + nombre);
		if (FILE.exists()) {
			return true;
		}
		return false;
	}

}
