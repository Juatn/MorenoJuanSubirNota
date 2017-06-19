package Models;

public class pokemon {
	
	protected String nombre;
	protected int numero;
	protected String evolucion;
	protected String Region;
	protected int tipo;
	protected String comentario;
	
	
	
	public pokemon(String nombre, int numero, String evolucion, String region, int tipo,String comentario) {
		super();
		this.nombre = nombre;
		this.numero = numero;
		this.evolucion = evolucion;
		Region = region;
		this.tipo = tipo;
		this.comentario = comentario;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getNumero() {
		return numero;
	}



	public void setNumero(int numero) {
		this.numero = numero;
	}



	public String getEvolucion() {
		return evolucion;
	}



	public void setEvolucion(String evolucion) {
		this.evolucion = evolucion;
	}



	public String getRegion() {
		return Region;
	}



	public void setRegion(String region) {
		Region = region;
	}



	public int getTipo() {
		return tipo;
	}



	public void setTipo(int tipo) {
		this.tipo = tipo;
	}



	public String getComentario() {
		return comentario;
	}



	public String setComentario(String comentario) {
		return this.comentario = comentario;
	}
	
	
	
	
	
	
	

	
}
