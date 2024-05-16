public  final class RegistrarCiudadDachadaImpl implements RegistrarCiudadFachada {
    private DAOFactory factory;

    public RegistrarCiudadFachadaImpl(final DAOFactory factory) {
    factory = DAOFactory.getFactoy(DAOFactory.POSTGRESQL);
    }
    public final void ejecutar(final CiudadDTO ciudad) {
        try{
            factory.iniciarTransaccion();
            var ciudadDomain = cuidadDTODomainAssembler.obtenerInstancia().ensamblarDominio(ciudad);
            final registarCiudad useCase = new RegistrarCiudadImpl(factory);
            useCase.ejecutar(ciudadDomain);

            factory.confirmarTransaccion();
        }catch (TiendaChepitoExcepcion exeption){
            factory.cancelarTransaccion();
            throw exeption;
        }catch (final Exception exception){
            factory.cancelarTransaccion();
            var mensajeUsuario = "Se ha presentado error de registrar la ciudad";
            var mensajeTecnico = "se ha presentado un error inisperado al registrar la ciudad";

            throw new BusinessException(mensajeUsuario, mensajeTecnico, exception);

        }finally{
            factory.cerrarConexion();
        }
    }

}