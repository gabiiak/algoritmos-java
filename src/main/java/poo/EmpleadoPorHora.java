package poo;

public class EmpleadoPorHora extends Empleado implements Imprimible {

    private int horasTrabajadas;
    private double valorHora;

    

    public EmpleadoPorHora() {} //constructor vacío
    public EmpleadoPorHora(int dni, String nombre, double sueldoBase, int horasTrabajadas, double valorHora){
        super(dni, nombre, sueldoBase);
        this.horasTrabajadas = horasTrabajadas;
        this.valorHora = valorHora;
    }//constructor


    @Override
    public double calcularSueldoFinal() {
        /*sueldoFinal = sueldoBase + (horasTrabajadas * valorHora);
        return sueldoFinal;*/
        return getSueldoBase() + (horasTrabajadas * valorHora);
    }

    /*@Override
    public String toString() {
        return "NOMBRE: " + nombre + " | SUELDO FINAL: " + calcularSueldoFinal();
    }*/
    @Override
    public void imprimir(){
       System.out.println("\nempleadoHora: " + toString() + " | HORAS" +  horasTrabajadas + " | VALOR POR HORA: " + valorHora + " | SUELDO FINAL: " + calcularSueldoFinal() ); 
    }
    
}
