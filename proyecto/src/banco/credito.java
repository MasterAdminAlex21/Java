package banco;

public class credito extends cuenta{
    private double tasa,deficit;
    private static int id=0;
    private int idcre;
    //private movs m;
    
    public credito(String nom,double saldo,double tasa,fecha ap){
        super();
        if(tasa>1 || tasa<0) System.err.println("ERROR: porcentaje de tasa incorrecto");
        else{
            apertura=ap;
            this.tasa=tasa;
            this.saldo=saldo;
            id+=1;
            idcre=id;
            flag=2;
            m=new movs(nom);
            cta+=1;
            idcta=cta;
            m.escribir("Credito "+idcta, new movimientos(ap,"Credito "+idcta+"\tApertura",""));
        }
    }
    
    @Override
    public void depositar(double monto,fecha f){
        if(deficit==0){
            saldo+=monto;
        }else if(monto<deficit){
            deficit-=monto;
        }else{
            saldo+=(monto-deficit);
            deficit=0;
        }
        if(saldo>0 && f.año()>=apertura.año()){
         int tiem=(12*(f.año()-apertura.año()))+(f.mes()-apertura.mes());
         double inte;
         for(int i=0;i<tiem;i++){
          if(saldo>0){
           inte=saldo*tasa;
           saldo=saldo-inte;
           m.escribir("Credito "+idcta, new movimientos(f,"Interés",""+inte));
          }
         }
        }
        
        m.escribir("Credito "+idcta, new movimientos(f,"Deposito",""+monto));
    }
    
    @Override
    public void retirar(double monto,fecha f){
        if(saldo==0){
            deficit+=monto;
        }else if(saldo>0 && monto<saldo){
            saldo-=monto;
        }else if(monto>saldo){
            deficit+=(monto-saldo);
            saldo=0;
        }
        m.escribir("Credito "+idcta, new movimientos(f,"Retiro",""+monto));
    }
    
    @Override
    public double consultar(fecha f){
     m.escribir("Credito "+idcta, new movimientos(f,"Consulta",""+saldo));
        return saldo-deficit;
    }
    
    public double consulaux(){
     return saldo-deficit;
    }
    
    public void pagointeres(fecha f){
     if(f.año()>=apertura.año()){
      int tiem=(f.año()-apertura.año())*12 + f.mes()-apertura.mes();
      for(int i=0;i<tiem;i++){
       saldo=saldo-(tasa*saldo);
       m.escribir("Credito "+idcta, new movimientos(f,"Pago interes",""+(tasa*saldo)));
      }
     }
    }
    
    @Override
    public String toString(){
        return "===========\n| CREDITO |\n===========\nNum. cuenta: "+idcta+"\nSaldo total: $"+consulaux()+"\nSaldo: $"+saldo+"\nDéficit: $"+deficit+"\n";
    }
    
    public int id(){
     return id;
    }
    
    public String leer(){
     return m.imprimir("Credito "+idcta);
    }
}//fin clase