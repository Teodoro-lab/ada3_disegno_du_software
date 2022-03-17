import java.util.Scanner;

public class Sistema {
	private AdministradorUsuarios userAdmin;
	private VerificadorArchivo verificadorArchivo = new VerificadorArchivo();

	public Sistema() {
		boolean fileExists = verificarArchivoUsuario();

		if (fileExists) {
			String[] infoUsuarios = verificadorArchivo.getContent("./", "usuarios.txt");
			userAdmin = new AdministradorUsuarios(infoUsuarios);
			mostrarInterfazUsuario();
		} else {
			alertaArchivoUsuariosNoExiste();
		}
	}

	private void alertaArchivoUsuariosNoExiste() {
		System.out.println("No existe archivo de usuarios");
	}

	public boolean verificarArchivoUsuario() {
		String path = "./archivos/";
		String fileName = "usuarios.txt";
		boolean fileExists = verificadorArchivo.verificarExistenciaArchivo(path, fileName);
		return fileExists;
	}

	private void mostrarInterfazUsuario() {
		String[] credencialesUsuario;
		boolean usuarioVerificado;

		do {
			String msg;
			credencialesUsuario = ingresarUsuarioContra();
			usuarioVerificado = verificarUsuarioContra(credencialesUsuario[0], credencialesUsuario[1]);
			msg = usuarioVerificado ? "Inicio de sesión exitoso" : "Contraseña o usuario incorrectos";

			System.out.println(msg);
		} while (!usuarioVerificado);

		mostrarMenu();
	}

	public String[] ingresarUsuarioContra() {
		Scanner sc = new Scanner(System.in);

		// solicitamos nombre de usuario
		System.out.println("Ingrese el usuario:");
		String usuario = sc.next();

		// solicitamos contraseña
		System.out.println("Ingrese el contraseña:");
		String contra = sc.next();
		contra = AES.encrypt(contra, AES.getSecret());

		String[] userInfo = { usuario, contra };
		sc.close();
		return userInfo;
	}

	public boolean verificarUsuarioContra(String usuario, String contra) {
		if (userAdmin.verificarUsuario(usuario, contra)) {
			return true;
		}
		return false;
	}

	public void mostrarMenu() {
		System.out.printf("%s\n%s\n%s\n%s\n",
				"-------Elija la opción-------",
				"1- Crear archivo CSV         ",
				"2- Ingresar calificacion     ",
				"3- Cerrar programa           ");
	}

}
