package poo;
import java.util.ArrayList;
public class Empresa {
    private String nombre;
    private ArrayList<Empleado> empleados;
    
    public Empresa(String nombre){
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }
    public void agregarEmpleado(Empleado empleado){
        empleados.add(empleado);
    }
    public void mostrarNomina(){
        System.out.println("\nnómina de la empresa: "+ nombre);
        for (Empleado empleado : empleados) {
            if (empleado instanceof Imprimible){
                ((Imprimible) empleado).imprimir();
            }else{
                System.out.println(empleado.toString());
            }
        }
        System.out.println("total de empleados: " + Empleado.getCantidadEmpleados());
    }
}
