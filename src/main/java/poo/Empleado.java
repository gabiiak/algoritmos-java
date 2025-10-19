package poo;

public abstract class Empleado {
    protected int dni;
    protected String nombre;
    protected double sueldoBase;
    protected double sueldoFinal;
    protected static int cantEmpleados = 0;

    public Empleado(){} //constructor vacío
    public Empleado(int dni, String nombre, double sueldoBase){
        this.dni = dni;
        this.nombre = nombre;
        this.sueldoBase = sueldoBase;
        cantEmpleados++;
    }//constructor  
    
    //getters y setters
    public int getDni(){
        return dni;
    }
    public void setDni(int dni){
        this.dni = dni;
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public double getSueldoBase(){
        return sueldoBase;
    }
    public void setSueldoBase(double sueldoBase){
        this.sueldoBase = sueldoBase;
    }
    public static int getCantidadEmpleados(){return cantEmpleados;}

    public abstract double calcularSueldoFinal();
    @Override
    public String toString(){
        return "NOMBRE: " + nombre + " | SUELDO BASE: " + sueldoBase;
    };
}
