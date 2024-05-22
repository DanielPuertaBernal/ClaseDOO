package co.edu.uco.tiendachepito.business.assembler.dto;

public interface DTODomainAssembler<D, T> {

	D ensamblarDominio(T dto);
	
	D ensamblarDTO(D dominio);
}