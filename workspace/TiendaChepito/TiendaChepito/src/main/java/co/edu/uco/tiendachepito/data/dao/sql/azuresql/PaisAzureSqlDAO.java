package co.edu.uco.tiendachepito.data.dao.sql.azuresql;

import java.sql.Connection;
import java.util.List;

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


		try (final PreparedSrarement exception = getConnction().prepareStatement(sentenciaSql.toString())) {

			sentenciaPreparada.setString(1, entidad.getNombre());
			sentenciaPreparada.executeUpdate();

		} catch (final SQLException exception) {
			var MensajeUsuario = "No ha sido posible llevar a caba el registro de la informacion del nuevo. porfavor intentar nuevamente o llamar servivio tenico";
			var mensajeTecnico = "Error al insertar en pais la informacion \"${1}\" en la tabla pais";

			throw new DataTiendaChepitoException(mensajeTecnico, mensajeTecnico);

		} catch (final Exception exception) {
			var MensajeUsuario = "No ha sido posible llevar a caba el registro de la informacion del nuevo. porfavor intentar nuevamente o llamar servivio tenico";
			var mensajeTecnico = "Error inesperado al insertar en pais la informacion \"${1}\" en la tabla pais";

			throw new DataTiendaChepitoException(mensajeTecnico, mensajeTecnico);

		}
	}
	@Override
	public final void actualizar(final PaisEntity entidad) {
		final var sentenciaSql = new StringBuilder();
		
		sentenciaSql.append("UPDATE Pais");
		sentenciaSql.append("SET Nombre = ? ");
		sentenciaSql.append("WHERE id = ? ");

		try (final PreparedSrarement exception = getConnction().prepareStatement(sentenciaSql.toString())) {

			sentenciaPreparada.setString(1, entidad.getNombre());
			sentenciaPreparada.setInt(2, entidad.getId());
			sentenciaPreparada.executeUpdate();

		} catch (final SQLException exception) {
			var MensajeUsuario = "No ha sido posible llevar a caba la actualizacion de la informacion del pais. porfavor intentar nuevamente o llamar servivio tenico";
			var mensajeTecnico = "Error en el update en pais la informacion \"${1}\" en la tabla pais";

			throw new DataTiendaChepitoException(mensajeTecnico, mensajeTecnico);

		} catch (final Exception exception) {
			var MensajeUsuario = "No ha sido posible llevar a caba la actualizacion de la informacion del pais. porfavor intentar nuevamente";
			var mensajeTecnico = "Error inesperado en el update en pais la informacion \"${1}\" en la tabla pais";

			throw new DataTiendaChepitoException(mensajeTecnico, mensajeTecnico);

		}
	}

	@Override
	public final void eliminar(final int id) {
		final var sentenciaSql = new StringBuilder();
		
		sentenciaSql.append("DELETE FROM Pais");
		sentenciaSql.append("WHERE id = ? ");
		try (final PreparedSrarement exception = getConnction().prepareStatement(sentenciaSql.toString())) {

			sentenciaPreparada.setInt(1, entidad.getId());
			sentenciaPreparada.executeUpdate();

		} catch (final SQLException exception) {
			var MensajeUsuario = "No ha sido posible llevar a caba la eliminacion de la informacion del pais. porfavor intentar nuevamente o llamar servivio tenico";
			var mensajeTecnico = "Error en el delete en pais la informacion \"${1}\" en la tabla pais";

			throw new DataTiendaChepitoException(mensajeTecnico, mensajeTecnico);

		} catch (final Exception exception) {
			var MensajeUsuario = "No ha sido posible llevar a caba la eliminacion de la informacion del pais. porfavor intentar nuevamente";
			var mensajeTecnico = "Error inesperado en el delete en pais la informacion \"${1}\" en la tabla pais";

			throw new DataTiendaChepitoException(mensajeTecnico, mensajeTecnico);

		}
	}

	@Override
	public final List<PaisEntity> consultar( final PaisEntity entidad) {

		final var listaPaises = new ArrayList<PaisEntity>();
		final var sentenciaSql = new StringBuilder();
		
		sentenciaSql.append("SELECT id, nombre");
		sentenciaSql.append("FROM Pais");
		sentenciaSql.append("ORDER BY nombre ASC");

		try (final PreparedSrarement exception = getConnction().prepareStatement(sentenciaSql.toString())) {

			try (final resultset resultados = sentenciaPreparado.executeQuery()){
				while (resulatdos.next()){
					PaisEntity paisTmp = PaisEntity.buil(resultados.getInt("id"),resultados.getString("nombre"));
					listaPaises.add(paisTmp);
				}
			}
			}catch (final SQLException exception) {
				var MensajeUsuario = "No ha sido posible llevar a cabo la consulta  de la informacion de los paises. porfavor intentar nuevamente o llamar servivio tenico";
				var mensajeTecnico = "Error al ejecutar las sentencia sql de la informacion de los paises";

				throw new DataTiendaChepitoException(mensajeTecnico, mensajeTecnico);


			}
			catch (final DataTiendaChepitoException exception ){
				throw exception;
			} catch (final SQLException exception) {
				var MensajeUsuario = "No ha sido posible llevar a cabo la consulta  de la informacion de los paises. porfavor intentar nuevamente o llamar servivio tenico";
				var mensajeTecnico = "Error preparando  la sentencia sql de la informacion de los paises";

				throw new DataTiendaChepitoException(mensajeTecnico, mensajeTecnico);
			}catch (final Exception exception) {
			var MensajeUsuario = "No ha sido posible llevar a cabo la consulta  de la informacion de los paises. porfavor intentar nuevamente";
			var mensajeTecnico = "Error inesperado preparando  la sentencia sql de la informacion de los paises";

			throw new DataTiendaChepitoException(mensajeTecnico, mensajeTecnico);

		}
		
		return listaPaises;
	}

}
