import Enum.Estado;

import java.util.Objects;

public abstract class AlquilerEquipo implements Comparable<AlquilerEquipo> {
    private int numero;
    private static int nuevoNumero = 1;
    private String nombreCliente;
    private String equipo;
    private String fecha;
    private int cantidadDias;
    private Estado estado = Estado.PENDIENTE;

    public int getNumero() {
        return numero;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantidadDias() {
        return cantidadDias;
    }

    public void setCantidadDias(int cantidadDias) {
        this.cantidadDias = cantidadDias;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public AlquilerEquipo(String nombre, String equipo, String fecha, int cantidadDias) {
        this.numero = nuevoNumero++;
        this.nombreCliente = nombre;
        this.equipo = equipo;
        this.fecha = fecha;
        this.cantidadDias = cantidadDias;
    }

    public double precioAlquiler() {
        return 0;
    }

    @Override
    public String toString() {
        return "AlquilerEquipo{" +
                "numero=" + numero +
                ", nombre='" + nombreCliente + '\'' +
                ", equipo='" + equipo + '\'' +
                ", fecha='" + fecha + '\'' +
                ", cantidadDias=" + cantidadDias +
                ", estado=" + estado +
                ", precioAlquiler=" + precioAlquiler() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof AlquilerEquipo that)) return false;
        return Objects.equals(nombreCliente, that.nombreCliente) && Objects.equals(equipo, that.equipo) && Objects.equals(fecha, that.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreCliente, equipo, fecha);
    }


    @Override
    public int compareTo(AlquilerEquipo o) {
        return Double.compare(o.precioAlquiler(), precioAlquiler());
    }
}
