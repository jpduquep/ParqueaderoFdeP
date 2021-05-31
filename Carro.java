import java.util.Date;
public class Carro extends Vehiculo{
    public static double tarifaCarro;
    
    public Carro(String placa, String marca, String color, int tipoV){
        super(placa, marca, color, 30000000, tipoV);
    }
    public Carro(String placa, String marca, String color, int valor, int tipoV){
        super(placa,marca,color,valor,tipoV);
    }
    
    @Override
    public String toString(){
        String str;
        str = super.toString();
        str = "CARRO(" + str + ")";
        return str;
    }
    
    @Override
    public double cobrar(){
        double tarifa = 0;
        Date fechaActual = new Date();
        
        //Año diferente
        if(fechaActual.getYear()!=super.getFecha().getYear()){
            tarifa = -1;
        }
        //Mes diferente
        else if(fechaActual.getMonth()!=super.getFecha().getMonth()){
            tarifa = -1;
        }
        // Dia diferente
        else if(fechaActual.getDate()!=super.getFecha().getDate()){
            tarifa = ((60 - super.getFecha().getSeconds()) + (fechaActual.getSeconds())) * (tarifaCarro/3600);
            tarifa += ((60-super.getFecha().getMinutes() + fechaActual.getMinutes())-1) * (tarifaCarro/60);
            tarifa += ((24-super.getFecha().getHours() + fechaActual.getHours())-1) * tarifaCarro;
            tarifa += ((fechaActual.getDate() - super.getFecha().getDate())-1) * (tarifaCarro*24);
        }
        //Mas de 1 hora
        else if(fechaActual.getHours()!=super.getFecha().getHours()){
            tarifa = ((60 - super.getFecha().getSeconds()) + (fechaActual.getSeconds())) * (tarifaCarro/3600);
            tarifa += ((60-super.getFecha().getMinutes() + fechaActual.getMinutes())-1) * (tarifaCarro/60);
            tarifa += ((fechaActual.getHours() - super.getFecha().getHours())-1) * tarifaCarro;
        }
        //Mas de 1 minuto
        else if(fechaActual.getMinutes()!=super.getFecha().getMinutes()){
            tarifa = ((60 - super.getFecha().getSeconds()) + (fechaActual.getSeconds())) * (tarifaCarro/3600);
            tarifa += ((fechaActual.getMinutes() - super.getFecha().getMinutes())-1) * (tarifaCarro/60);
        }
        else{
            tarifa = (fechaActual.getSeconds() - super.getFecha().getSeconds())*(tarifaCarro/3600);
        }
        return tarifa;
    }
}