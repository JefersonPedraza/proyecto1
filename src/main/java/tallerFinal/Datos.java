package tallerFinal;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

public class Datos {
	private String  usuario;
	private String clave;
	private int contador;
	
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
	
	public int getContador() {
		contador++;
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public String getClave() {
		return clave;
	}
	
	public void setClave(String clave) {
		this.clave=clave;
	}

}
