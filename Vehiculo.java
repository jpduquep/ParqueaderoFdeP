import java.util.Date;
import java.io.FileWriter;
import java.io.IOException;
public class Vehiculo{
    //Atributos
    
    //Atributo estaticos (los mismos para todos en la clase)
    public static Vehiculo[][] vehiculos; //"Edificio" pisos = filas, espacio = columna
    public static Date[][] fechas;
    public static int tamaño; //Total parqueaderos en el edificio
    public static int cantidad = 0; //Carros parqueados en el edificio
    
    //Atributos personales de cada obejto
    private String placa;
    private String marca;
    private String color;
    private int valorComercial;
    private int tipoV;
    private Date fecha;
    
    //Metodos Constructor
    public Vehiculo(){
        
    }
    public Vehiculo(String placa, String marca, String color, int valor, int tipoV){
        this.placa = placa;
        this.marca = marca;
        this.color = color;
        this.valorComercial = valor;
        this.tipoV = tipoV;
        fecha = new Date();
        cantidad++;
    }
    
    //Metodos Set y Get
    
    //fecha
    public Date getFecha(){
        return this.fecha;
    }
    //PLACA
    public void setPlaca(String placa){
        this.placa = placa;
    }
    public String getPlaca(){
        return this.placa;
    }
    //MARCA
    public void setMarca(String marca){
        this.marca = marca;
    }
    public String getMarca(){
        return this.marca;
    }
    //COLOR
    public void setColor(){
        this.color = color;
    }
    public String getColor(){
        return this.color;
    }
    //VALOR COMERCIAL
    public void setValorComercial(int valor){
        this.valorComercial = valor;
    }
    public int getValorComercial(){
        return this.valorComercial;
    }
    
    //Metodo toString (carro unico)
    public String toString(){
        String toStr = "Placa: " + this.placa + ", Marca: " + this.marca + ", Color: " + this.color + ", Valor Comercial: " + this.valorComercial + ", Fecha y Hora de ingreso: " + this.fecha;;
        return toStr;
    }
    
    //Metodo toString estatico (toString para todos los carros)
    public static String toStringVehiculos(){
        String vehiculosparqueados = "";
        int contador_actual = 0;
        for(int piso = 0; piso<vehiculos.length;piso++){
            vehiculosparqueados += "\n[Piso " + (piso+1) + "]"; 
            contador_actual = 0;
            for(int parqueadero = 0; parqueadero<vehiculos[piso].length;parqueadero++){
                if(vehiculos[piso][parqueadero]!=null){
                     vehiculosparqueados += ", parqueadero " + (parqueadero+1) + " tiene (" + vehiculos[piso][parqueadero].toString() + ")";
                    contador_actual++;
                }
            }
            if(contador_actual == 0){
                vehiculosparqueados += " No hay vehiculos en este piso";
            }
        }
        return vehiculosparqueados;
    }
    
    public static String cantidadVehiculos(){
        return "Hay " + cantidad + " Vehiculos parqueados";
    }
    //Buscar carros por colores
    public static String busquedaColor(String colorx){
        String toStringCoincidencias = "No hay coincidencias";
        int contador = 0;
        for(int piso = 0; piso<vehiculos.length; piso++){
            for(int parqueadero = 0; parqueadero<vehiculos[piso].length; parqueadero++){
                if(vehiculos[piso][parqueadero]!=null){
                    String colorVActual = vehiculos[piso][parqueadero].getColor();
                    if((colorVActual.equalsIgnoreCase(colorx)) == true){
                        if(contador == 0){ //
                           toStringCoincidencias = "en \n[piso " + (piso+1) + "][parqueadero " + (parqueadero + 1) + "] con " + vehiculos[piso][parqueadero].toString();
                           contador++;
                        }else{
                            toStringCoincidencias +="\n[piso " + (piso+1) + "][parqueadero " + (parqueadero + 1) + "] con " + vehiculos[piso][parqueadero].toString();
                            contador++;
                        }
                    }
                }
            }
        }
        if(contador == 1){
            toStringCoincidencias = "(" + contador + " Coincidencia) " + toStringCoincidencias;
        }else if(contador!= 0 && contador!= 1){
            toStringCoincidencias = "(" + contador + " Coincidencias) " + toStringCoincidencias;
        }
        return toStringCoincidencias;
    }
    
    public static String ordenarPorValor(){
        Vehiculo[] ordenadosValores = new Vehiculo[cantidad];
        int contadorinterno = 0;
        String ordenados = "";
        for(int x = 0;x<vehiculos.length;x++){
            for(int y = 0; y<vehiculos[x].length;y++){
                if(vehiculos[x][y]!=null){
                    ordenadosValores[contadorinterno] = vehiculos[x][y];
                    contadorinterno++;
                }
            }
        }
        Vehiculo temporal;
        for(int i = 1;i<ordenadosValores.length;i++){
            for(int j = 0; j<ordenadosValores.length-i;j++){
                if(ordenadosValores[j].getValorComercial() > ordenadosValores[j+1].getValorComercial()){
                    temporal = ordenadosValores[j];
                    ordenadosValores[j] = ordenadosValores[j+1];
                    ordenadosValores[j+1] = temporal;
                }
            }
        }
        for(int x = 0;x<ordenadosValores.length;x++){
            ordenados += "\n(" + ordenadosValores[x].toString() + "), ";
        }
        ordenados = "El orden de los carros de menor a mayor valor es: " + ordenados;
        return ordenados;
    }
    
    public double cobrar(){
        double precio = 309;
        return precio;
    }
    
    public static void exportarTXT()throws IOException{
        FileWriter VehiculosParqueados = new FileWriter("C:/Users/");
        VehiculosParqueados.write(Vehiculo.toStringVehiculos());
        
    }
}