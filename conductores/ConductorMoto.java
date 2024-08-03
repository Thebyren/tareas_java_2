import conductores.Conductor;

class ConductorMoto extends Conductor{
    
    public ConductorMoto(String nombre, String licencia, boolean licenciaMoto){
        this.nombre = nombre;
        this.licencia = licencia;
        this.licenciaMoto = licenciaMoto;
    }
    
    public boolean licenciaMoto;

    @Override
    public void mostrarInformacion(){
        System.out.println("nombre: " + nombre);
        System.out.println("licencia: " + licencia);
        System.out.println("tiene licencia moto: " + licenciaMoto);
        
    }
}