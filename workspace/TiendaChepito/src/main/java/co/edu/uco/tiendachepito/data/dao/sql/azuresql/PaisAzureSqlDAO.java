package co.edu.uco.tiendachepito.data.dao.sql.azuresql;

import java.sql.Connection;
import java.util.List;

import ch.qos.logback.core.util.COWArrayList;
import co.edu.uco.tiendachepito.crosscutting.exceptions.custom.DataTiendaChepitoException;
import co.edu.uco.tiendachepito.data.dao.PaisDAO;
import co.edu.uco.tiendachepito.data.dao.sql.SqlConnection;
import co.edu.uco.tiendachepito.entity.PaisEntity;

public final class PaisAzureSqlDAO extends SqlConnection implements PaisDAO {
	
	public PaisAzureSqlDAO(final Connection connection) {
		super(connection);
	}

	@Override
	public final void crear(final PaisEntity entidad) {
		final var sentenciaSql = new StringBuilder();
		
		sentenciaSql.append("INSERT INTO Pais(Nombre) ");
		sentenciaSql.append("VALUES (?)");
		
		try(final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())) {
			sentenciaPreparada.setString(1, entidad.getNombre());
			sentenciaPreparada.excecuteUpdate();
		} catch(final SQLException exception) {
			var mensajeUsuario = "No ha sido posible llevar a cabo el registro de la información del nuevo Páis. Por favor intente de nuevo y en caso de persistir el problema, comuníquese con el administrador de la aplicación de la Tienda Chepito";
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00023, entidad.getNombre());
			
			throw new DataTiendaChepitoException(mensajeTecnico, mensajeUsuario, exception);
		} catch(final Exception exception) {
			var mensajeUsuario = "No ha sido posible llevar a cabo el registro de la información del nuevo Páis. Por favor intente de nuevo y en caso de persistir el problema, comuníquese con el administrador de la aplicación de la Tienda Chepito";
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00024, entidad.getNombre());
			
			throw new DataTiendaChepitoException(mensajeTecnico, mensajeUsuario, exception);
		}
	}

	@Override
	public final void actualizar(final PaisEntity entidad) {
		final var sentenciaSql = new StringBuilder();
		
		sentenciaSql.append("UPDATE Pais");
		sentenciaSql.append("SET Nombre = ? ");
		sentenciaSql.append("WHERE id = ? ");
		
		try(final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())) {
			sentenciaPreparada.setString(1, entidad.getNombre());
			sentenciaPreparada.setInt(2, entidad.getId());
			sentenciaPreparada.excecuteUpdate();
		} catch(final SQLException exception) {
			var mensajeUsuario = "No ha sido posible llevar a cabo el registro de la información del nuevo Páis. Por favor intente de nuevo y en caso de persistir el problema, comuníquese con el administrador de la aplicación de la Tienda Chepito";
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00025, entidad.getNombre());
			
			throw new DataTiendaChepitoException(mensajeTecnico, mensajeUsuario, exception);
		} catch(final Exception exception) {
			var mensajeUsuario = "No ha sido posible llevar a cabo el registro de la información del nuevo Páis. Por favor intente de nuevo y en caso de persistir el problema, comuníquese con el administrador de la aplicación de la Tienda Chepito";
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00024, entidad.getNombre());
			
			throw new DataTiendaChepitoException(mensajeTecnico, mensajeUsuario, exception);
		}
	}

	@Override
	public final void eliminar(final int id) {
		final var sentenciaSql = new StringBuilder();
		
		sentenciaSql.append("DELETE FROM Pais ");
		sentenciaSql.append("WHERE id = ? ");
		
		try(final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())) {
			sentenciaPreparada.setInt(1, entidad.getId());
			sentenciaPreparada.excecuteUpdate();
		} catch(final SQLException exception) {
			var mensajeUsuario = "No ha sido posible llevar a cabo el registro de la información del nuevo Páis. Por favor intente de nuevo y en caso de persistir el problema, comuníquese con el administrador de la aplicación de la Tienda Chepito";
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00023, entidad.getNombre());
			
			throw new DataTiendaChepitoException(mensajeTecnico, mensajeUsuario, exception);
		} catch(final Exception exception) {
			var mensajeUsuario = "No ha sido posible llevar a cabo el registro de la información del nuevo Páis. Por favor intente de nuevo y en caso de persistir el problema, comuníquese con el administrador de la aplicación de la Tienda Chepito";
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00024, entidad.getNombre());
			
			throw new DataTiendaChepitoException(mensajeTecnico, mensajeUsuario, exception);
		}
	}

	@Override
	public final List<PaisEntity> consultar(final PaisEntity entidad) {
		final var listaPaises = vew ArrayList<PaisEntity>();
		final var sentenciaSql = new StringBuilder();
		
		sentenciaSql.append("SELECT id, nombre ");
		sentenciaSql.append("FROM Pais ");
		sentenciaSql.append("ORDER BY nombre ASC ");
		
		try(final ResultSet resultados = sentenciaPreparada.executeQuery()) {
			
			while(resultados.next()) {
				PaisEntity paisTmp = new PaisEntity.build(resultados.getInt("id"), resultados.getString("nombre"));
				listaPaises.add(paisTmp);
			}
			
		} catch(final DataTiendaChepitoException exception) {
			throw exception;
		} catch(final SQLException exception) {
			var mensajeUsuario = "No ha sido posible llevar a cabo la consulta de la información del nuevo Páis. Por favor intente de nuevo y en caso de persistir el problema, comuníquese con el administrador de la aplicación de la Tienda Chepito";
			var mensajeTecnico = "Se ha presentado un problema ejecutando la sentencia SQL de consulta de los países en la base de datos Azure SQL";
			
			throw new DataTiendaChepitoException(mensajeTecnico, mensajeUsuario, exception);
		} catch(final Exception exception) {
			var mensajeUsuario = "No ha sido posible llevar a cabo el registro de la información del nuevo Páis. Por favor intente de nuevo y en caso de persistir el problema, comuníquese con el administrador de la aplicación de la Tienda Chepito";
			var mensajeTecnico = "Se ha presentado un problema preparando la sentencia SQL de la base de datos Azure SQL";
			
			throw new DataTiendaChepitoException(mensajeTecnico, mensajeUsuario, exception);
		}
		
		return listaPaises;
	}

}
