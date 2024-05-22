package co.edu.uco.tiendachepito.data.dao.factory;

import co.edu.uco.tiendachepito.crosscutting.exceptions.custom.DataTiendaChepitoException;
import co.edu.uco.tiendachepito.data.dao.CiudadDAO;
import co.edu.uco.tiendachepito.data.dao.DepartamentoDAO;
import co.edu.uco.tiendachepito.data.dao.PaisDAO;
import co.edu.uco.tiendachepito.data.dao.factory.sql.azuresql.AzureSqlDAOFactory;

public abstract class DAOFactory {
	
	public static final DAOFactory getFactory(final Factory factory) {
		switch (factory) {
		case AZURE_SQL: {
			
			return new AzureSqlDAOFactory();
		}
		case SQL_SERVER: {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = "No existe configurada una factoria de datos SQL SERVER";
			
			throw new DataTiendaChepitoException(mensajeTecnico, mensajeUsuario);
		}
		case POSTGRESQL: {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = "No existe configurada una factoria de datos SQL SERVER";
			
			throw new DataTiendaChepitoException(mensajeTecnico, mensajeUsuario);
		}
		case ORCLE: {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = "No existe configurada una factoria de datos SQL SERVER";
			
			throw new DataTiendaChepitoException(mensajeTecnico, mensajeUsuario);
		}
		case MYSQL: {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = "No existe configurada una factoria de datos SQL SERVER";
			
			throw new DataTiendaChepitoException(mensajeTecnico, mensajeUsuario);
		}
		default:
			return new AzureSqlDAOFactory();
		}
		return null;
	}
	
	protected abstract void obtenerConexion();
	
	public abstract void iniciarTransaccion();
	
	public abstract void confirmarTransaccion();
	
	public abstract void cancelarTransaccion();
	
	public abstract void cerrarConexion();
	
	public abstract PaisDAO getPaisDAO();
	
	public abstract DepartamentoDAO getDepartamentoDAO();
	
	public abstract CiudadDAO getCiudadDAO();
	
	public static void main(String[] args) {
		DAOFactory.getFactory(Factory.AZURE_SQL).getPaisDAO().crear(null);
		System.out.println("Creé");
		DAOFactory.getFactory(Factory.AZURE_SQL).getPaisDAO().actualizar(null);
		DAOFactory.getFactory(Factory.AZURE_SQL).getPaisDAO().eliminar(null);
		List<PaisEntity> resultados = DAOFactory.getFactory(Factory.AZURE_SQL).getPaisDAO().consultar(null);
		
	}
}