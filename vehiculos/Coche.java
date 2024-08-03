import vehiculos.Vehiculo;

public class Coche extends Vehiculo{
    public Coche(String marca, String modelo, int fecha, int noPuertas){
        this.marca = marca;
        this.modelo = modelo;
        this.fecha = fecha;
        this.noPuertas = noPuertas;
    }
    public int noPuertas;
    @Override
    public void mostrarDetalles(){
        System.out.println("marca: "+marca);
        System.out.println("modelo: "+modelo);
        System.out.println("fecha: "+fecha);
        System.out.println("numero de puertas" +noPuertas);
    }
}