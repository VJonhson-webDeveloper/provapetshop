package controllers;

import models.Operador;
import play.libs.Crypto;
import play.mvc.Controller;

public class Logins extends Controller {
	
	public static void form() {
		render();
	}
	
	public static void logar(String email, String senha) {

		Operador operador = Operador.find("email = ?1 and senha = ?2", email, Crypto.passwordHash(senha)).first();

		if (operador == null) {
            flash.error("Email ou senha inválidos");
            form();

        } else {
            session.put("operador", operador.email);
            flash.success("Seja bem-vindo!");
			Animais.lista();
            
        } 
		
	}
	
	public static void sair() {
		session.clear();
        flash.success("Você saiu do sistema!");
        form();
	}

}
