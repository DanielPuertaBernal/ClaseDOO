public final  class PaisDTODoaminAssembler implements DTODomainAssembler<PaisDomani, PaisDTO>{
    public final PaisDomain EnsamblerDTO(final PaisDTO dto){
        var paisDTOTMp = objectHelper.getObjetcTHelper().getDefaul(dto, new PaisDTO());
        return PaisDomain.crear(paisDTOTMp.getId(), paisDTOTMp.getNombre());
    }

    public final PaisDTO ensamblarDTO(final PaisDomain dominio){
        var paisDomainTmp = objectHelper.getObjetcTHelper().getDefaul(dominio, new PaisDomain());
        return PaisDTO.build().setId(paisDomainTmp.getId()).setNombre(paisDomainTmp.getNombre());
    }
}