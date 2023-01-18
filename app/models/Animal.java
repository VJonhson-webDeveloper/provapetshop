package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.data.validation.InPast;
import play.data.validation.Min;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Animal extends Model {

	@Required(message = "Campo vazio")
	public String nome;

	@Required
	@Min(value = 1)
	public Integer peso;

	@InPast
	public Date dataNascimento;

	@ManyToOne
	public TipoAnimal tipoAnimal;
	
	@Override
	public String toString() {
		return nome;
	}

}
