package banco;

public interface impuestos{
    double ISRm=0.10;
    double ISRa=0.15;
    
    public void pagarISRmensual();
    public void pagarISRanual();
}