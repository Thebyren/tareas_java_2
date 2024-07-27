# tareas_java_2



temporalmente guardado aca para reestructurar posteriormente


```java
class main {
    public static void main(String[] args) {
        
    }
}
// codigo para vehiculos.
class Vehiculo{
    public String marca;
    public String modelo;
    public int fecha;
    public void mostrarDetalles(){
        System.out.println("marca: "+marca);
        System.out.println("modelo: "+modelo);
        System.out.println("fecha: "+fecha);
    }
}

class Coche extends Vehiculo{
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

class Moto extends Vehiculo{
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

// codigo para conductores


class Conductor{
    public String nombre;
    public String licencia;
    
    public void mostrarInformacion(){
        System.out.println("nombre: "+nombre);
        System.out.println("licencia: "+licencia);
    }
}

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

class ConductorCoche extends Conductor{
    
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

```
