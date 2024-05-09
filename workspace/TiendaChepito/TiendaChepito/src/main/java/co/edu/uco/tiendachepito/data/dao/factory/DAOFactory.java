package co.edu.uco.tiendachepito.data.dao.factory;

import co.edu.uco.tiendachepito.data.dao.CiudadDAO;
import co.edu.uco.tiendachepito.data.dao.DepartamentoDAO;
import co.edu.uco.tiendachepito.data.dao.PaisDAO;

public abstract class DAOFactory {

	public static final DAOFactory getFactory(final Factory factory){
		switch (factory)
		case: AZURE_SQL{
			return new AzureSqlDAOFactory();
		}
		case: POSTGRESQL{
			var mensajeUsuario = messageCatalogStrategy.getContenidoMensaje(codigoMensaje.M00002);
			var mensajeTecnico = "No Existe configurada una factoria de datos para una base de datos POSTGRESQL" ;

			throw  new DataTiendaChepitoException(mensajeTecnico,mensajeUsuario);

		}
		case: MYSQL{
			var mensajeUsuario = messageCatalogStrategy.getContenidoMensaje(codigoMensaje.M00002);
			var mensajeTecnico = "No Existe configurada una factoria de datos para una base de datos MYSQL" ;

			throw  new DataTiendaChepitoException(mensajeTecnico,mensajeUsuario);
		}
		case: ORACLE{
			var mensajeUsuario = messageCatalogStrategy.getContenidoMensaje(codigoMensaje.M00002);
			var mensajeTecnico = "No Existe configurada una factoria de datos para una base de datos ORACLE" ;

			throw  new DataTiendaChepitoException(mensajeTecnico,mensajeUsuario);
		}
		default: {
			return new AzureSqlDAOFactory();
		}
	}

	protected abstract void obtenerConexion();

	public abstract void iniciarTransaccion();

	public abstract void confirmarTransaccion();

	public abstract void cancelarTransaccion();

	public abstract void cerrarConexion();

	public abstract PaisDAO getPaisDAO();

	public abstract DepartamentoDAO getDepartamentoDAO();

	public abstract CiudadDAO getCiudadDAO();

}
