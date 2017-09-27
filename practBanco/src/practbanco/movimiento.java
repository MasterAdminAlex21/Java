package practbanco;

public class movimiento{
    private fecha fechamov;
    private String movimiento;
    private String detalle;
    private int tipo;
    public movimiento(fecha mov, int i,String det){
        switch(i){
            case 0:
                movimiento="consulta";
                detalle=det;
            break;
            case 1:
                movimiento="Deposito";
                detalle=det;
            break;
            case 2:
                movimiento="Retiro";
                detalle=det;
            break;
        }
        tipo=i;
        fechamov=mov;
    }
    
    public void estdet(String det){
        detalle=det;
    }
    
   /* public movimiento retmov(){
        return new movimiento(fechamov,tipo); 
    }*/
    
    @Override
    public String toString(){
        return movimiento+"\t"+fechamov+"\t"+detalle+"\n";
    }
}//fin clase