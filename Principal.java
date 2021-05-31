import java.util.Scanner;
import java.util.Date;
public class Principal{
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
    
        //Declarando tamaño del parqueadero
        System.out.println("¿Cuantos pisos tiene el parqueadero? R/ ");
        int pisos = scan.nextInt();
        System.out.println("¿Cuantos parqueaderos hay por piso? R/");
        int espacios = scan.nextInt();
        
        System.out.println("¿De cuanto es la tarifa de carros por hora? R/ ");
        double tarifaCarros = scan.nextDouble();
        Carro.tarifaCarro = tarifaCarros;
        System.out.println("¿De cuanto es la tarifa de motos por hora? R/ ");
        double tarifaMotos = scan.nextDouble();
        Moto.tarifaMoto = tarifaMotos;
        
        //Configurar los arrays de clases Vehiculo y Sensor
        Vehiculo.vehiculos = new Vehiculo[pisos][espacios];
        Vehiculo.fechas = new Date[pisos][espacios]; //Creando array de todas las fechas
        Sensor.sensores = new Sensor[pisos][espacios];
        //Creando todos los sensores
        for(int x = 0;x < Sensor.sensores.length;x++){
            for(int y = 0;y < Sensor.sensores[x].length;y++){
                Sensor.sensores[x][y] = new Sensor();
            }
        }
        //Calcular la cantidad de parqueaderos y asignar a atributo tamaño en clase Vehiculo
        Vehiculo.tamaño = pisos*espacios;
        
        //Inicio programa (While)
        System.out.println("¿Que deseas hacer? R/");
        int decision = scan.nextInt();
        
        //Variables para decisiones del programa
        int piso;
        int espacio;
        String placa_v;
        String marca_v;
        String color_v;
        int precio_v;
        int tipoV;
        boolean validacion = false;
        
        while(decision != 0){
            switch(decision){
                case 1:
                    System.out.println("Los siguientes sensores estan libres");
                    System.out.println(Sensor.sensorLibre());
                    break;
                case 2:
                    System.out.println("En que piso deseas parquear (" + pisos + " pisos) R/");
                    piso = scan.nextInt();
                    System.out.println("En que espacio deseas parquear (" + espacios + " parqueaderos por piso) R/");
                    espacio = scan.nextInt();
                    
                    if((piso>pisos||espacio>espacios)||(piso<1||espacio<1)){
                        System.out.println("Este parqueadero no existe!");
                    }
                    else{
                        if(Vehiculo.vehiculos[piso-1][espacio-1]!=null){
                            System.out.println("El parqueadero seleccionado esta ocupado");
                        }
                        else{
                            scan.nextLine();
                            System.out.println("Ingresa tu placa R/");
                            placa_v = scan.nextLine();
                            System.out.println("Ingresa tu marca R/");
                            marca_v = scan.nextLine();
                            System.out.println("Ingresa tu color R/");
                            color_v = scan.nextLine();
                            
                            System.out.println("¿Que tipo de vehiculo vas a parquear? Presiona: \n1-Carro \n2-Moto");
                            tipoV = scan.nextInt();
                            if(tipoV<1 || tipoV>2){
                                System.out.println("Este tipo de vehiculo no esta en nuestra lista!");
                                break;
                            }
                            else if(tipoV==1){
                                Vehiculo.vehiculos[piso-1][espacio-1] = new Carro(placa_v, marca_v, color_v, tipoV);
                            }
                            else if(tipoV==2){
                                Vehiculo.vehiculos[piso-1][espacio-1] = new Moto(placa_v, marca_v, color_v, tipoV);
                            }
                            
                            Sensor.sensores[piso-1][espacio-1].setEstado(1);
                            System.out.println(Vehiculo.vehiculos[piso-1][espacio-1].toString());
                        }
                    }
                    break;
                case 3:
                    System.out.println("En que piso deseas parquear (" + pisos + " pisos) R/");
                    piso = scan.nextInt();
                    System.out.println("En que espacio deseas parquear (" + espacios + " parqueaderos por piso) R/");
                    espacio = scan.nextInt();
                    if((piso>pisos||espacio>espacios)||(piso<1||espacio<1)){
                        System.out.println("Este parqueadero no existe");
                    }
                    else{
                        if(Vehiculo.vehiculos[piso-1][espacio-1]!=null){
                            System.out.println("El parqueadero seleccionado esta ocupado");
                        }
                        else{
                            scan.nextLine();
                            System.out.println("Ingresa tu placa R/");
                            placa_v = scan.nextLine();
                            System.out.println("Ingresa tu marca R/");
                            marca_v = scan.nextLine();
                            System.out.println("Ingresa tu color R/");
                            color_v = scan.nextLine();
                            System.out.println("Ingresa el valor de tu vehiculo R/");
                            precio_v = scan.nextInt();
                            
                            System.out.println("¿Que tipo de vehiculo vas a parquear? Presiona: \n1-Carro \n2-Moto");
                            tipoV = scan.nextInt();
                            if(tipoV<1 || tipoV>2){
                                System.out.println("Este tipo de vehiculo no esta en nuestra lista!");
                                break;
                            }
                            else if(tipoV==1){
                                Vehiculo.vehiculos[piso-1][espacio-1] = new Carro(placa_v, marca_v, color_v,precio_v, tipoV);
                            }
                            else if(tipoV==2){
                                Vehiculo.vehiculos[piso-1][espacio-1] = new Moto(placa_v, marca_v, color_v,precio_v, tipoV);
                            }
                            
                            Sensor.sensores[piso-1][espacio-1].setEstado(1);
                            System.out.println(Vehiculo.vehiculos[piso-1][espacio-1].toString());
                        }
                    }
                    break;
                case 4:
                    System.out.println(Vehiculo.toStringVehiculos());
                    break;
                case 5:
                    System.out.println(Vehiculo.cantidadVehiculos());
                    break;
                case 6:
                    System.out.println("¿De que piso deseas consultar el sensor? (" + pisos + " pisos) R/");
                    piso = scan.nextInt();
                    System.out.println("¿Cual sensor deseas consultar? (" + espacios + " sensores por piso) R/");
                    espacio = scan.nextInt();
                    if((piso>pisos||espacio>espacios)||(piso<1||espacio<1)){
                        System.out.println("Este sensor no existe");
                    }
                    else{
                        System.out.println("[P" + piso + "]" + " Sensor " + espacio + " esta " + Sensor.sensores[piso-1][espacio-1].toString());
                    }
                    break;
                case 7:
                    System.out.println(Sensor.sensoresEstados());
                    break;
                case 8:
                    scan.nextLine();
                    System.out.println("¿Que color esta buscando? R/");
                    String color_busqueda = scan.nextLine();
                    System.out.println(Vehiculo.busquedaColor(color_busqueda));
                    break;
                case 9:
                    System.out.println(Vehiculo.ordenarPorValor());
                    break;
                case 10:
                    System.out.println("¿De que piso deseas desactivar el sensor? (" + pisos + " pisos) R/");
                    piso = scan.nextInt();
                    System.out.println("¿Cual sensor deseas desactivar? (" + espacios + " sensores por piso) R/");
                    espacio = scan.nextInt();
                    if((piso>pisos||espacio>espacios)||(piso<1||espacio<1)){
                        System.out.println("Este sensor no existe");
                    }
                    else if(Vehiculo.vehiculos[piso-1][espacio-1]==null){
                        System.out.println("Este parqueadero esta vacio");
                    }
                    else{
                        Date f1 = new Date();
                        System.out.println(Vehiculo.vehiculos[piso-1][espacio-1].toString() + "Sale a las " + f1);
                        System.out.println("Total a pagar: " + Vehiculo.vehiculos[piso-1][espacio-1].cobrar() + " COP");
                        Vehiculo.vehiculos[piso-1][espacio-1] = null;
                        Sensor.sensores[piso-1][espacio-1].setEstado(0);
                    }
                    break;
                case 11:
                    
                    break;
                default:
                    System.out.println("Comando incorrecto");
                    break;
            }
            System.out.println("\n¿Ahora que deseas hacer? R/");
            decision = scan.nextInt();
        }
        System.out.println("Saliendo... ");
    }
}