import java.util.Date;
public class PDate{
    public static void main(String []args){
        Date fechaStandard = new Date();
        System.out.println("Fecha Actual: " + fechaStandard);
        Date fecha2 = new Date(120, 11, 21, 12, 45, 11);
        System.out.println("Fecha creada: " + fecha2);
        //Año
        System.out.println("Año: " + (fecha2.getYear()+1900) );
        //Mes
        System.out.println("Mes: " + (fecha2.getMonth()+1) );
        //Dia
        System.out.println("Dia: " + fecha2.getDate() );
        //Dia de la semana
        System.out.println("Dia de la semana: " + fecha2.getDay() );
        //Hora
        System.out.println("Hora: " + fecha2.getHours() );
        //Minutos
        System.out.println("Minutos: " + fecha2.getMinutes() );
        //Segundos
        System.out.println("Segundos: " + fecha2.getSeconds() );
        
        //Validacion after
        System.out.println(fechaStandard.after(fecha2)); System.out.println(fecha2.before(fechaStandard));
    }
}