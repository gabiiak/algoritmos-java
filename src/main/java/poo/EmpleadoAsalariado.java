package poo;


public class EmpleadoAsalariado extends Empleado implements Imprimible{
    private double bonoMensual;

    public EmpleadoAsalariado(){}//constructor vacío
    public EmpleadoAsalariado(int dni, String nombre, double sueldoBase, double bonoMensual){
        super(dni, nombre, sueldoBase);
        this.bonoMensual = bonoMensual;
    }

    @Override
    public double calcularSueldoFinal() {
        /*sueldoFinal = sueldoBase + bonoMensual;
        return sueldoFinal;*/
        return getSueldoBase() + bonoMensual;
    }

    /*@Override
    public String toString() {
        return "NOMBRE: " + nombre + " | SUELDO FINAL: " + calcularSueldoFinal();
    }*/
    @Override
    public void imprimir(){
        System.out.println("\nempleadoSalario: " + toString() + " | BONO MENSUAL: " + bonoMensual + " | SUELDO FINAL: " + calcularSueldoFinal());
    }

}
