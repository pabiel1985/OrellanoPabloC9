import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import Enum.Estado;

public class GestorEquipos {
   public List<AlquilerEquipo> listaEquipos;

    public GestorEquipos() {
        listaEquipos = new ArrayList<>();
    }

    public boolean nuevoEquipo(AlquilerEquipo alquiler){
        if(!listaEquipos.contains(alquiler)){
            listaEquipos.add(alquiler);
        }
        return false;
    }

    public AlquilerEquipo buscarEquipo(int id){
        AlquilerEquipo alquiler = null;
        for(AlquilerEquipo estado : listaEquipos){
            if(estado.getNumero() == id){
               alquiler = estado;
               break;
            }
        }
        return alquiler;
    }

   public boolean cambiarEstado(int id, Estado estado){
        boolean cambiado = false;
        for(AlquilerEquipo equipo : listaEquipos){
            if(equipo.getNumero() == id){
                equipo.setEstado(estado);
                cambiado = true;
                break;
            }
        }
        return cambiado;
   }

   public ArrayList<AlquilerEquipo> buscarPorEstado(Estado estado){
        ArrayList<AlquilerEquipo> alquileres = new ArrayList<>();
        for(AlquilerEquipo estado1 : listaEquipos){
            if(estado1.getEstado() == estado){
                alquileres.add(estado1);
            }
        }
        return alquileres;
   }

   public double sumarAlquileres(){
        double sumarAlquileres = 0;
        for(AlquilerEquipo estado1 : listaEquipos){
            sumarAlquileres += estado1.precioAlquiler();
        }
        return sumarAlquileres;
   }

   public AlquilerEquipo buscarElMayor(){
        return  Collections.max(listaEquipos);
   }

   public ArrayList<AlquilerEquipo> ordenarPorMayor(){
        ArrayList<AlquilerEquipo> alquileres = new ArrayList<>(listaEquipos);
        Collections.sort(alquileres);
        return alquileres;
   }
}
