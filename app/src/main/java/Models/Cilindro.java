package Models;

public class Cilindro {
    private double radio;
    private  double altura;

    public Cilindro(double altura, double radio) {
        this.altura = altura;
        this.radio = radio;
    }
    public  double CalcularVolumen(){
        return  Math.PI*Math.pow(radio,2)*altura;
    }

    @Override
    public String toString() {
        return "Cilindro de radio " + radio+" y altura "+altura+" tiene volumen "+ CalcularVolumen();
    }
}
