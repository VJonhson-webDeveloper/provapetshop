package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class TipoAnimal extends Model {
	
	public String nome;

	public String toString () {
		return nome;
	}
}
