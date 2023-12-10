package tuti.desi.entidades;

import org.springframework.stereotype.Component;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
@NotNull
@Component
public class Asiento {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String numero;
	    private boolean disponible;
	    @ManyToOne
	    private Vuelo vuelo;

	public Vuelo getVuelo() {
			return vuelo;
		}


		public void setVuelo(Vuelo vuelo) {
			this.vuelo = vuelo;
		}


	public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getNumero() {
			return numero;
		}


		public void setNumero(String numero) {
			this.numero = numero;
		}


		public boolean isDisponible() {
			return disponible;
		}


		public void setDisponible(boolean disponible) {
			this.disponible = disponible;
		}


	public Asiento() {
	}	
	
	
}
