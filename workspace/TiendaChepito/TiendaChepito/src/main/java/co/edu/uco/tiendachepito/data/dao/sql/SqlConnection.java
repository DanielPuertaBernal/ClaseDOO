package co.edu.uco.tiendachepito.data.dao.sql;

import java.sql.Connection;

import co.edu.uco.tiendachepito.crosscutting.exceptions.custom.DataTiendaChepitoException;
import co.edu.uco.tiendachepito.crosscutting.helpers.SQLHelper;

public class SqlConnection {

	private Connection connection;

	protected SqlConnection(final Connection connection) {
		setConnection(connection);
	}

	private final void setConnection(final Connection connection) {
		if(SQLHelper.isOpen(connection)) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = "No es posible crear el DAO deseado, dado que la conexión SQL esta cerrada";
			throw new DataTiendaChepitoException(mensajeTecnico, mensajeUsuario);
		}
		this.connection = connection;
	}

	protected final Connection getConnection() {
		return connection;
	}
}
