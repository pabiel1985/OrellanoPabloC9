import Interface.ServicioTecnico;

public class EquipoEspecial  extends  AlquilerEquipo implements ServicioTecnico {
    private int nivelServicio;

    public int getNivelServicio() {
        return nivelServicio;
    }

    public void setNivelServicio(int nivelServicio) {
        this.nivelServicio = nivelServicio;
    }

    public EquipoEspecial(String nombre, String equipo, String fecha, int cantidadDias, int nivelServicio) {
        super(nombre, equipo, fecha, cantidadDias);
        this.nivelServicio = nivelServicio;
    }

    @Override
    public double precioAlquiler() {
        return 10000 + (nivelServicio*4000);
    }

    @Override
    public boolean incluyeServcioTecnico() {
        return true;
    }

    @Override
    public String toString() {
        return "EquipoEspecial{" +
                "nivelServicio=" + nivelServicio +
                "} " + super.toString();
    }
}
