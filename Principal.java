import java.util.Scanner;
public class Principal{
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
    
        //Declarando tamaño del parqueadero
        System.out.println("¿Cuantos pisos tiene el parqueadero? R/ ");
        int pisos = scan.nextInt();
        System.out.println("¿Cuantos parqueaderos hay por piso? R/");
        int espacios = scan.nextInt();
        
        //Configurar los arrays de clases Vehiculo y Sensor
        Vehiculo.vehiculos = new Vehiculo[pisos][espacios];
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
                            Vehiculo.vehiculos[piso-1][espacio-1] = new Vehiculo(placa_v, marca_v, color_v);
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
                            System.out.println("Ingresa el valor de tu carro R/");
                            precio_v = scan.nextInt();
                            Vehiculo.vehiculos[piso-1][espacio-1] = new Vehiculo(placa_v, marca_v, color_v, precio_v);
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
                default:
                    System.out.println("Comando incorrecto");
                    break;
            }
            System.out.println("¿Ahora que deseas hacer? R/");
            decision = scan.nextInt();
        }
        System.out.println("Saliendo... ");
    }
}