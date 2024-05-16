public  class departamentoDomain {
    private int id;
    private String nombre;
    private

    private DepartamentoDomain(final int id, final String nombre) {
        setId(id);
        setNombre(nombre);
        setPais(pais);
    }
    private departamentoDomain() {
        setNombre(TextHelper.EMPTY);
        setPais(PaisDomani.crear());
    }
    public static departamentoDomain crear(final int id, final String nombre, final PaisDomani pais) {
        return new departamentoDomain(id, nombre, pais);
    }
    public static final departamentoDomain crear() {
        return new departamentoDomain();
    }
    private final void setId(final int id) {
        this.id = id;
    }
    private final void setNombre(final String nombre) {
        this.nombre = TextHelper.applyTim(nombre);
    }
    private final void setPais(final PaisDomani pais) {
        this.pais = pais;
    }
    public final int getId() {
        return id;
    }
    public final String getNombre() {
        return nombre;
    }
    public final PaisDomani getPais() {
        return pais;
    }

}