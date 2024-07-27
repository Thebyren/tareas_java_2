public class Jedi extends Personaje{
    public Jedi(String nombre){
    super(nombre);
    } 
    @Override
    public void usarFuerza(){
        System.out.println(nombre+" usa la fuerza del lado luminoso");
    }
}
