import vehiculos.Vehiculo;

public class Moto extends Vehiculo{
    public Moto(String marca, String modelo, int fecha, boolean sidecar){
        this.marca = marca;
        this.modelo = modelo;
        this.fecha = fecha;
        this.sidecar = sidecar;
    }
    
    public boolean sidecar;
    
    @Override
    public void mostrarDetalles(){
        System.out.println("marca: "+marca);
        System.out.println("modelo: "+modelo);
        System.out.println("fecha: "+fecha);
        System.out.println("tiene sidecar: " +sidecar);
    }
}