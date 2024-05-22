package co.edu.uco.tiendachepito.business.facade.concrete;

import co.edu.uco.tiendachepito.business.assembler.dto.concrete.CiudadDTODomainAssembler;
import co.edu.uco.tiendachepito.business.facade.RegistrarCiudadFachada;
import co.edu.uco.tiendachepito.business.usecase.RegistrarCiudad;
import co.edu.uco.tiendachepito.crosscutting.exceptions.TiendaChepitoException;
import co.edu.uco.tiendachepito.dto.CiudadDTO;
import co.edu.uco.tiendachepito.data.dao.factory.DAOFactory;
import co.edu.uco.tiendachepito.data.dao.factory.enums.Factory;

public final class RegistarCiudadFachadaImpl implements RegistrarCiduadFachada {

	private DAOFactory factory;
	
	public RegistrarCiudadFachadaImpl() {
		factory = DAOFactory.getFactory(Factory.AZURESQL);
	}
	
	@Override
	public void ejecutar(CiudadDTO ciudad) {
		try {
			factory.iniciarTransaccion();
			
			var ciudadDomain = CiudadDTODomainAssembler.obtenerInstancia().ensamblarDominio(ciudad);
			
			final RegistrarCiudad useCase = new RegistrarCiduadImpl(factory);
			useCase.ejecutar(ciudadDomain);
			
			factory.confirmarTransaccion();
		} catch (final TiendaChepitoException excepcion) {
			factory.cancelarTransaccion();
			throw excepcion;
		} catch (final Exception excepcion) {
			factory.cancelarTransaccion();
			var mensajeUsuario = "Se ha presentado un problema tratando de Registrar la información de la nueva ciudad";
			var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de registrar la información de la nueva ciudad en el método ejecutar de la clase RegistarCiudadFachadaImpl. Por favor revise la traza completa del problema";
		
			throw new BusinessTiendaChepitoException(mensajeTecnico, mensajeUsuario);
		} finally {
			factory.cerrarConexion();
		}
	}
}
