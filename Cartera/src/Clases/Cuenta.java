package Clases;

public class Cuenta {
    private Double salario;

    public Cuenta(Double salario) {
        this.salario = salario;
    }

    public Double ingresar(double ingreso){
        if (ingreso > 0 && ingreso <= 6000) {
                salario += ingreso;
        }
        return salario;
    }

    public Double retirar(Double retirada){
        if (retirada < salario && retirada > 0 && retirada <= 6000) {
            salario -= retirada;
        }
        return salario;
    }

    public Double[] transferencia(Cuenta dos, Double retirada){
        Double[] salarios = new Double[2];
        if (retirada > 0 && retirada <= 3000) {
                salarios[0] = this.salario - retirada;
                salarios[1] = dos.salario + retirada;
        } else {
            salarios[0] = this.salario;
            salarios[1] = dos.salario;
        }
        return salarios;
    }

    public Double getSalario() {
        return salario;
    }
}
