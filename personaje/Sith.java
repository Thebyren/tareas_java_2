package personaje;

public class Sith extends Personaje{
    public Jedi(String nombre){
    super(nombre);
    } 
    @Override
    public void usarFuerza(){
        System.out.println(nombre+" usa la fuerza del lado oscuro");
    }
}
