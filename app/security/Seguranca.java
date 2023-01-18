package security;

import play.mvc.Before;

import controllers.Logins;
import play.mvc.Controller;

public class Seguranca extends Controller {
    @Before
    static void checarLogin() {
        if (session.get("operador") == null) {
            flash.error("É necessário se autenticar no sistema!");
            Logins.form();

        }
    }
}
