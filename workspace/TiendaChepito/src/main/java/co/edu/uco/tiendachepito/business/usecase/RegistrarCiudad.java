public final  class RegistrarCiudadImpl implements RegistarCiudad{
    private final DAOFactory factory;

    public RegistrarCiudadImpl(final DAOFactory factory){
        this.factory = factory;
    }
    public final void ejecutar(final DAOFactory factory){
        //1 validar que los datos datos sean valod a nivel de tipo de dato y longitud
        // obligatoriedad, formato, rango
        //2 validar que la ciudad no exista para el mismo departamento
        validarNoexistecniaCiudad(ciudad.getNombre(), ciudad.getDepartamento().getId());
        //3 registrar la ciudad
        var CiudadEntity = ciudadEntityAssembler.obtenerInstancia().ensamblarEntidad(ciudad);
        factory.getCiudadDAO().crear(ciudadEntity);

    }
    private  void validarNoexistecniaCiudad(string nombre, int departamentoId){
        var departamento = departamentoEntity.bulid(departamentoId);
        var ciudadEntity = ciudadEntity.build(0,nombre,departamento);
        final list<ciudadEntity> resultados = factory.getCiudadDAO().consultar(ciudadEntity);

        if(!resultados.isEmpty()){
            var mensajeUsuario = "La ciudad ya existe siudad con el nombre\"{1}\" en el departamento";
            throw new BusinessException(mensajeUsuario;
        }
}
