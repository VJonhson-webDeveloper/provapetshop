package controllers;

import java.util.List;

import play.cache.Cache;
import play.data.validation.Valid;
import play.libs.Crypto;
import models.Animal;
import models.TipoAnimal;
import play.mvc.Controller;
import play.mvc.With;
import security.Seguranca;

@With(Seguranca.class)
public class Animais extends Controller {
	
	public static void form() {
		Animal animal = (Animal) Cache.get("animal");
		Cache.clear();

		List<TipoAnimal> tipos = TipoAnimal.findAll();
		render(tipos, animal);
	}
	
	public static void lista() {
		List<Animal> animais = Animal.findAll();
		render(animais);
	}

	public static void salvar(@Valid Animal animal) {
		//se houve algum erro ao tentar salvar
        if (validation.hasErrors()) {

            //guarde as mensagens de erro e exiba no formulario
            validation.keep();
			params.flash();
            flash.error("Falha ao salvar os seus dados.");

            Cache.set("animal", animal);
            form();
        }

		Long qtd = Animal.count("nome = ?1", animal.nome);
		if (qtd == 0) {
            animal.save();
            flash.success("Cadastro realizado com sucesso!");

		} else {
			flash.error("Animal já cadastrado, tente novamente!");
			Cache.set("animal", animal);
		}
		form();
	}
	
	public static void deletar(Long id) {
		Animal animal = Animal.findById(id);
		animal.delete();
	}
}
