package co.edu.uco.tiendachepito.business.assembler.entity.concrete;

import co.edu.uco.tiendachepito.business.assembler.entity.EntityDomainAssembler;
import co.edu.uco.tiendachepito.business.domain.DepartamentoDomain;
import co.edu.uco.tiendachepito.crosscutting.helpers.ObjectHelper;
import co.edu.uco.tiendachepito.entity.DepartamentoEntity;

public class DepartamentoEntityDomainAssembler implements EntityDomainAssembler<DepartamentoDomain, DepartamentoEntity> {
	
	private DepartamentoEntityDomainAssembler() {
		super();
	}
	
	public static final EntityDomainAssembler<DepartamentoDomain, DepartamentoEntity> obtenerInstancia() {
		return instancia;
	}
	
	@Override
	public final DepartamentoDomain ensamblarDominio(final DepartamentoEntity entidad) {
		var departamentoEntityTmp = ObjectHelper.getObjectHelper().getDefault(entidad, DepartamentoEntity);
		var 
	}

}