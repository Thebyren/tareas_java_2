import personaje.Jedi;
import personaje.Sith;
import personaje.Personaje;
class EjemploHerencia {
    public static void main(String[] args) {
        Personaje luke = new Jedi("luke skywalker");
        Personaje vader = new Jedi("anakin skywalker");
        
        luke.usarFuerza();
        vader.usarFuerza();
    }
}
