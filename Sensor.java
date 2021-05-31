
public class Sensor{
    //Atributos
    public static Sensor[][] sensores;
    private int estado; //Estado del sensor, 0=libre, 1=ocupado
     
    //Metodo Constructor
    public Sensor(){
        
    }
    public Sensor(int estado){
        this.estado = estado;
    }
    
    //Set y Get
    public void setEstado(int ocupacion){
        this.estado = ocupacion;
    }
    public int getEstado(){
        return this.estado;
    }
    
    //Metodos
    //Metodo de instancia (Sensor unico)
    public String toString(){
        String estadoString = "Libre";
        if (this.estado == 0){
            estadoString = "libre";
        }
        else if(this.estado == 1){
            estadoString = "ocupado";
        }
        return estadoString;
    }
    
    //Metodos de Clase
    //Metodo que retorna String indicando los espacios libres
    public static String sensorLibre(){
        String sensoreslibresString = "";
        for(int piso = 0;piso<sensores.length;piso++){
            sensoreslibresString += "\n[P" + (piso + 1) + "]";
            for(int sensor = 0;sensor<sensores[piso].length;sensor++){
                if(sensores[piso][sensor].getEstado() == 0){
                    sensoreslibresString += " Espacio " + (sensor + 1) + ", ";
                }
            }
        }
        return sensoreslibresString;
    }
    //Metodo que retorna String con el estado de todos los sensores
    public static String sensoresEstados(){
        String sensoresString = "";
        for(int piso = 0;piso<sensores.length;piso++){
            sensoresString += "\n[Piso " + (piso + 1) + "]";
            for(int sensor = 0; sensor<sensores[piso].length;sensor++){
                sensoresString += "[Sensor " + (sensor + 1) + "] esta " + sensores[piso][sensor].toString() + " ";
            }
        }
        return sensoresString;
    }
}