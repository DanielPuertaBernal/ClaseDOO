public  class CiudadDomain
    private int id;
    private String nombre;
    private DepartamentoDomain departamento;
    private CiudadDomain(final int id, final String nombre, final DepartamentoDomain departamento) {
        setId(id);
        setNombre(nombre);
        setDepartamento(departamento);
    }
    private CiudadDomain() {
        setNombre(TextHelper.EMPTY);
        setDepartamento(DepartamentoDomain.crear());
    }
    public static CiudadDomain crear(final int id, final String nombre, final DepartamentoDomain departamento) {
        return new CiudadDomain(id, nombre, departamento);
    }
    public static final CiudadDomain crear() {
        return new CiudadDomain();
    }
    private final void setId(final int id) {
        this.id = id;
    }
    private final void setNombre(final String nombre) {
        this.nombre = TextHelper.applyTim(nombre);
    }
    private final void setDepartamento(final DepartamentoDomain departamento) {
        this.departamento = textHelper.get;
    }
    public final int getId() {
        return id;
    }
    public final String getNombre() {
        return nombre;
    }
    public final DepartamentoDomain getDepartamento() {
        return departamento;
    }


}