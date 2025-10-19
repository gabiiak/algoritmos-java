package poo;
import java.util.ArrayList;
import java.util.Scanner;
public class EmpleadoMain{
    public static Scanner teclado;
    public static ArrayList<Empleado> listaEmpleados;

    public static void cargaEmpleadosHora(){ //métodos para ingresar empleados por teclado
        System.out.println("-------Empleados por Hora-------");
        System.out.println("cuántos empleados por hora desea ingresar? :");
        int cant = teclado.nextInt();
        for (int i = 0; i < cant; i++){
            System.out.println("ingresando el empleado n° " + (i + 1));
            System.out.print("DNI: ");
            int dni = teclado.nextInt();
            teclado.nextLine(); //limpieza de buffer
            System.out.print("NOMBRE: ");
            String nombre = teclado.nextLine();
            System.out.print("SUELDO BASE: ");
            double sueldoBase = teclado.nextDouble();
            System.out.print("HORAS TRABAJADAS: ");
            int horasTrabajadas = teclado.nextInt();
            System.out.print("VALOR POR HORA: ");
            double valorHora = teclado.nextDouble();
            Empleado empHora = new EmpleadoPorHora(dni, nombre, sueldoBase, horasTrabajadas, valorHora);
            listaEmpleados.add(empHora);
        }
    }
    public static void cargaEmpleadosAsalariados(){//métodos para ingresar empleados por teclado
        System.out.println("-------Empleados Asalariados-------");
        System.out.println("cuántos empleados por hora desea ingresar? :");
        int cant = teclado.nextInt();
        for (int i = 0; i < cant; i++){
            System.out.println("ingresando el empleado n° " + (i + 1));
            System.out.print("DNI: ");
            int dni = teclado.nextInt();
            teclado.nextLine(); //limpieza de buffer
            System.out.print("NOMBRE: ");
            String nombre = teclado.nextLine();
            System.out.print("SUELDO BASE: ");
            double sueldoBase = teclado.nextDouble();
            System.out.print("BONO MENSUAL: ");
            double bonoMensual = teclado.nextDouble();
            Empleado empSal = new EmpleadoAsalariado(dni, nombre, sueldoBase, bonoMensual);
            listaEmpleados.add(empSal);
        }
    }

    public static void imprimir(){
        System.out.println("-------Lista de empleados-------");
        for (Empleado empleado : listaEmpleados) {
            System.out.println(empleado.toString());
        }
        System.out.println("-------Cantidad de empleados-------");
        System.out.println(Empleado.cantEmpleados);
    }
    
    public static void main(String [] args){
        //teclado = new Scanner(System.in);
        //listaEmpleados = new ArrayList<>();
        //cargaEmpleadosHora();
        //cargaEmpleadosAsalariados();
        //imprimir();
        Empresa empresa = new Empresa("empresaX");
        Empleado e1 = new EmpleadoPorHora(12, "Ana", 50000, 20, 1000);
        Empleado e2 = new EmpleadoAsalariado(15, "Luis", 70000, 15000);
        Empleado e3 = new EmpleadoPorHora(54, "Carlos", 45000, 10, 1200);
        
        empresa.agregarEmpleado(e1);
        empresa.agregarEmpleado(e2);
        empresa.agregarEmpleado(e3);
        empresa.mostrarNomina();
    }
}
