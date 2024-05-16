public  class PaisDomani {
    private int id;
    private String nombre;

    private PaisDomani(final int id, final String nombre) {
        setId(id);
        setNombre(nombre);
    }
    private PaisDomani() {
        setNombre(TextHelper.EMPTY);
    }
    public static PaisDomani crear(final int id, final String nombre
        return new PaisDomani(id, nombre);
    }
    public static final PaisDomani crear() {
        return new PaisDomani();
    }
    private final void setId(final int id) {
        this.id = id;
    }
    private final void setNombre(final String nombre) {
        this.nombre = TextHelper.applyTim(nombre);
    }
    public final int getId() {
        return id;
    }
    public final String getNombre() {
        return nombre;
    }PaisDomani.java

}