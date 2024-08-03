package vehiculos;

public class Vehiculo{
    public String marca;
    public String modelo;
    public int fecha;
    public void mostrarDetalles(){
        System.out.println("marca: "+marca);
        System.out.println("modelo: "+modelo);
        System.out.println("fecha: "+fecha);
    }
}