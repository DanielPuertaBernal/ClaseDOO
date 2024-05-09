package co.edu.uco.tiendachepito.crosscutting.exceptions.custom;

import co.edu.uco.tiendachepito.crosscutting.exceptions.TiendaChepitoException;
import co.edu.uco.tiendachepito.crosscutting.exceptions.enums.Lugar;

public class DataTiendaChepitoException extends TiendaChepitoException{
	
	private static final long serialVersionUID = 1L;

	public DataTiendaChepitoException(final String mensajeUsuario) {
		super(mensajeUsuario, Lugar.DATA);
	}

	public DataTiendaChepitoException(final String mensajeTecnico, final String mensajeUsuario, final Throwable excepcionRaiz) {
		super(mensajeTecnico, mensajeUsuario, Lugar.DATA, excepcionRaiz);
	}
	
}