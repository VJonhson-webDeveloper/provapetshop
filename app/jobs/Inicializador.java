package jobs;

import models.Operador;
import models.TipoAnimal;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.libs.Crypto;

@OnApplicationStart
public class Inicializador extends Job {

	@Override
	public void doJob() throws Exception {
		 if (Operador.count() == 0) {
			 Operador op = new Operador();
			 op.nome = "Bolota";
			 op.email = "bolota@ifrn.edu.br";
			 op.senha = Crypto.passwordHash("ifrn");
			 op.save();
		 }
		 
		 if (TipoAnimal.count() == 0) {
			 TipoAnimal ta1 = new TipoAnimal();
			 ta1.nome = "Cachorro";
			 ta1.save();
			 
			 TipoAnimal ta2 = new TipoAnimal();
			 ta2.nome = "Gato";
			 ta2.save();
			 
			 TipoAnimal ta3 = new TipoAnimal();
			 ta3.nome = "Hamster";
			 ta3.save();
			 
			 TipoAnimal ta4 = new TipoAnimal();
			 ta4.nome = "Periquito";
			 ta4.save();
			 
			 TipoAnimal ta5 = new TipoAnimal();
			 ta5.nome = "Cobra";
			 ta5.save();
		 }
	}
}
