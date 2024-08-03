import conductores.Conductor;

public class ConductorCoche extends Conductor{
    
    public ConductorCoche(String nombre, String licencia, boolean licenciaMoto){
        this.nombre = nombre;
        this.licencia = licencia;
        this.experiencia = experiencia;
    }
    
    public int experiencia;

    @Override
    public void mostrarInformacion(){
        System.out.println("nombre: "+nombre);
        System.out.println("licencia: "+licencia);
        System.out.println("tiene licencia moto: "+experiencia);
        
    }
}