package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Operador extends Model {
	
	public String nome;
	public String email;
	public String senha;

}
