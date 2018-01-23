package core.util;

import core.conexion.MyBatisConnection;
import core.dao.UsuarioDao;
import core.vo.Usuario;

public class LoginUser {

    public LoginUser() {

    }

    public Usuario iniciarSession(String nombreUsuario, String clave) throws Myexception {
        UsuarioDao usuarioDAO = new UsuarioDao(MyBatisConnection.getSqlSessionFactory());
        Usuario usuario = new Usuario();
        usuario.setNombre(nombreUsuario);
        usuario.setPassword(clave);
        usuario = usuarioDAO.login(usuario);
        if (usuario == null)
            throw new Myexception("No existe el usuario");
        else
            return usuario;
    }
}