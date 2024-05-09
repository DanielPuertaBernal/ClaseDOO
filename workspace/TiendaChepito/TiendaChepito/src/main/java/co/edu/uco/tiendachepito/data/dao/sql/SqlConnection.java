package co.edu.uco.tiendachepito.data.dao.sql;

import java.sql.Connection;

public class SqlConnection {

	private Connection connection;

	protected SqlConnection(final Connection connection) {
		this.connection = connection;
	}

	private final void setConnection(final Connection connection) {
		if (!SQLHelper.isOpen(connection)) {
			var mensajeUsuario = messageCatalogStrategy.getContenidoMensaje(codigoMensaje.M00002);
			var mensajeTecnico = "No es posible crear DAO deseado, dado que la conexion SQL esta cerrada ;

			throw  new DataTiendaChepitoException(mensajeTecnico,mensajeUsuario)
		}
		this.connection = connection;
	}

	protected final Connection getConnection() {
		return connection;
	}
}
