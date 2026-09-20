public class EquipoComun  extends AlquilerEquipo{
 private double precioDiario;

    public double getPrecioDiario() {
        return precioDiario;
    }

    public void setPrecioDiario(double precioDiario) {
        this.precioDiario = precioDiario;
    }

    public EquipoComun(String nombre, String equipo, String fecha, int cantidadDias, double precioDiario) {
        super(nombre, equipo, fecha, cantidadDias);
        this.precioDiario = precioDiario;
    }

    @Override
    public double precioAlquiler() {
        return getCantidadDias() * getPrecioDiario();
    }

    @Override
    public String toString() {
        return "EquipoComun{" +
                "precioDiario=" + precioDiario +
                "} " + super.toString();
    }
}
