package co.edu.uco.tiendachepito.business.assembler.dto.concrete;

import co.edu.uco.tiendachepito.business.assembler.dto.DTODomainAssembler;
import co.edu.uco.tiendachepito.business.domain.DepartamentoDomain;
import co.edu.uco.tiendachepito.business.domain.PaisDomain;
import co.edu.uco.tiendachepito.crosscutting.helpers.ObjectHelper;
import co.edu.uco.tiendachepito.dto.DepartamentoDTO;
import co.edu.uco.tiendachepito.dto.PaisDTO;

public class DepartamentoDTODomainAssembler implements DTODomainAssembler<D, T> {
	
	private static final DTODomainAssembler<PaisDomain, PaisDTO> paisAssembler = PaisDTODomainAssembler.obtenerInstancia();
	
	private DepartamentoDTODomainAssembler() {
		super();
	}
	
	@Override
	public final DepartamentoDomain ensamblarDominio(final DepartamentoDTO dto) {
		var departamentoDtoTmp = ObjectHelper.getObjectHelper().getDefault(dto, new DepartamentoDTO());
		var paisDomain = paisAssembler.ensamblarDominio(departamentoDtoTmp.getPais());
		return DepartamentoDomain.crear(departamentoDtoTmp.getId(), departamentoDtoTmp.getNombre(), departamentoDtoTmp.getPais());
	}
	
	@Override
	public final DepartamentoDTO ensamblarDTO(final DepartamentoDomain dominio) {
		var departamentoDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, departamentDomainTmp);
		var paisDTO = paisAssembler.ensamblarDTO(departamentDomainTmp.getPais());
		return DepartamentoDTO.build().setId(departamentDomainTmp.getId()).setNombre(departamentDomainTmp.getNombre()).setPais(paisDTO);
	}
}
