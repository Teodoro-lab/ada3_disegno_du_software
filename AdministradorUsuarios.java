public class AdministradorUsuarios {
    private String[] usuariosString;

    public AdministradorUsuarios(String[] usuariosString) {
        this.usuariosString = usuariosString;
    }

    public boolean verificarUsuario(String usuario, String contra){
        for(int i = 0; i < usuariosString.length; i++){
            String[] userInfo = usuariosString[i].split(":");
            if (userInfo[0].equals(usuario) && userInfo[1].equals(contra)){
                return true;
            }
        }
        return false;
    }
    
}
