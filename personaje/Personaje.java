package personaje;
public class Personaje{
    public String nombre;
    
    public Personaje(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }
    public void usarFuerza(){
        System.out.println(nombre+" esta usando la fuerza.");
    }
}
