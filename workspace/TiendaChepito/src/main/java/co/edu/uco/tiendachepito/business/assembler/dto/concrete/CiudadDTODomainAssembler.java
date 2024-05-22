package co.edu.uco.tiendachepito.business.assembler.dto.concrete;

import co.edu.uco.tiendachepito.business.assembler.dto.DTODomainAssembler;
import co.edu.uco.tiendachepito.business.domain.CiudadDomain;
import co.edu.uco.tiendachepito.crosscutting.helpers.ObjectHelper;
import co.edu.uco.tiendachepito.dto.CiudadDTO;

public class CiudadDTODomainAssembler implements DTODomainAssembler<CiudadDomain, CiudadDTO> {
	
	private static final 
	
	@Override
	public final CiudadDomain ensamblarDominio(final CiudadDTO dto) {
		var ciudadDtoTmp = ObjectHelper.getObjectHelper().getDefault(dto, new CiudadDTO());
		var departamentoDomain = departamentoAssembler.ensamblarDominio(ciudadDtoTmp.getDepartamento());
		return CiudadDomain.crear()ciudadDtoTmp.getId(), ciudadDtoTmp.getNombre(), departamentoDomain);
	}
	
	@Override
	public final 

}
