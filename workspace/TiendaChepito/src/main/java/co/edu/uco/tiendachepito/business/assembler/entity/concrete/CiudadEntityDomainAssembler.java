package co.edu.uco.tiendachepito.business.assembler.entity.concrete;

import co.edu.uco.tiendachepito.business.assembler.entity.EntityDomainAssembler;
import co.edu.uco.tiendachepito.business.domain.CiudadDomain;
import co.edu.uco.tiendachepito.crosscutting.helpers.ObjectHelper;
import co.edu.uco.tiendachepito.entity.CiudadEntity;

public class CiudadEntityDomainAssembler implements EntityDomainAssembler<CiudadDomain, CiudadEntity> {
	
	private static final EntityDomainAssembler<CiudadDomain, CiudadEntity> obtenerInstancia() {
		return instancia;
	}
	
	@Override
	public static CiudadDomain ensamblarDominio(final CiudadEntity entidad) {
		var ciudadEntityTmp = ObjectHelper.getObjectHelper().getDefault(entidad, CiudadEntity);
		var departamentoDominio = departamentoAssemblar.ensamblarDominio(ciudadEntityTmp);
		return CiudadDomain.crear(ciudadEntityTmp.getId(), ciudadEntityTmp.getNombre(), departamento);
	}
	
	@Override
	public static CiudadEntity ensamblarEntidad(final CiudadDomain dominio) {
		var ciudadDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, CiudadDomain());
		var departamentoEntity = departamentoAssemblar.ensamblarEntidad
	}
}
