package co.edu.uco.teaskpeak.data.dao.factory.sql.postgressql;

import co.edu.uco.teaskpeak.data.dao.UsuarioDAO;
import co.edu.uco.teaskpeak.data.dao.factory.DAOFactory;
import co.edu.uco.teaskpeak.data.dao.sql.postgressql.UsuarioPostgresSqlDAO;

import java.sql.Connection;
import java.sql.DriverManager;


import java.sql.SQLException;
public class PostgresSqlDAOFactory extends DAOFactory {
	private Connection connection;

	public PostgresSqlDAOFactory() {
		obtenerConexion();
	}

	@Override
	protected void obtenerConexion() {
		try {
			String url = "jdbc:postgresql://postgres:EQunXTxwWasmLkkZDnvVcjtdHdofpaNJ@roundhouse.proxy.rlwy.net:58129/railway";
			String user = "postgres";
			String password = "EQunXTxwWasmLkkZDnvVcjtdHdofpaNJ";
			connection = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void iniciarTransaccion() {
		try {
			if (connection != null) {
				connection.setAutoCommit(false);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void confirmarTransaccion() {
		try {
			if (connection != null) {
				connection.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void cancelarTransaccion() {
		try {
			if (connection != null) {
				connection.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void cerrarConexion() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public UsuarioDAO getUsuarioDAO() {
		return new UsuarioPostgresSqlDAO(connection);
	}
}

//
//    @Override
//    public PaisDAO getPaisDAO() {
//        return new PaisAzureSqlDAO(connection);
//    }
//
//    @Override
//    public DepartamentoAzureSqlDAO getDepartamentoDAO() {
//        return new DepartamentoAzureSqlDAO(connection);
//    }
//
//    @Override
//    public CiudadDAO getCiudadDAO() {
//        return new CiudadAzureSqlDAO(connection);
//    }