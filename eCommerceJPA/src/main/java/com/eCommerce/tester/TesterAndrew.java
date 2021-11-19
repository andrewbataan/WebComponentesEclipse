package com.eCommerce.tester;

import com.eCommerce.controller.*;
import com.eCommerce.entity.*;

public class TesterAndrew {

	public static void main(String[] args) {
		Usuario user = new Usuario();
		UsuarioController su = new UsuarioController();

		user.setIdUsuario(3);
		user.setNombre("Andrew Nuñez");
		user.setContrasena("1234567890");
		user.setMail("rolando-1998@hotmail.com");
		user.setRolBean(null);

		// su.delete(user);
		// su.insert(user);
		try {
			su.delete(user);
		} catch (GlobalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DataNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}