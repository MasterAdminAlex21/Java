package banco;

public class ahorros extends cuenta implements impuestos{
    private double tasa;
    private static int id=0;
    private int idah;
    //private movs m;
    
    public ahorros(String nom,fecha aper,double saldo,double tasa){
        super();
        if(tasa>1 || tasa<0) System.err.println("ERROR: porcentaje de tasa incorrecto");
        else{
            apertura=aper;
            this.tasa=tasa;
            id+=1;
            idah=id;
            flag=0;
            this.saldo=saldo;
            m=new movs(nom);
            cta+=1;
            idcta=cta;
            m.escribir("Ahorros "+idcta, new movimientos(aper,"Ahorros "+idcta+"\tApertura",""));
        }
    }
    
   @Override
    public double consultar(fecha f){
     if( f.año()>=apertura.año()){  
       int mens=(12*(f.año()-apertura.año()))+f.mes()-apertura.mes();
        for(int i=0;i<mens;i++){
         m.escribir("Ahorros "+idcta,new movimientos(f,"Interes devengado","+"+(saldo*tasa)));
         saldo=saldo +(saldo*tasa);
         if(saldo>1000) {
          m.escribir("Ahorros "+idcta, new movimientos(f,"Pago ISR mensual","-"+isrmens()));
          pagarISRmensual();
         }
        }
       }
     
     if(apertura.año()<f.año() && apertura.mes()<f.mes()){
      int años=f.año()-apertura.año();
      for(int i=0;i<años;i++){
       if(saldo>5000) {
        m.escribir("Ahorros "+idcta, new movimientos(f,"Pago ISR anual","-"+isran()));
        pagarISRanual();
       }
         else break;
      }
     }
        m.escribir("Ahorros "+idcta, new movimientos(f,"Consulta",""+saldo));
      return saldo;
    }
    
    @Override
    public void pagarISRmensual(){
        saldo=saldo-(saldo*ISRm);
    }
    private double isrmens(){
     return saldo*ISRm;
    }
    @Override
    public void pagarISRanual(){
       saldo=saldo-(saldo*ISRa);
    }
    private double isran(){
     return saldo*ISRa;
    }
    @Override
    public void depositar(double monto,fecha f){
        if(monto< 0);
        else{
            saldo+=monto;
            m.escribir("Ahorros "+idcta, new movimientos(f,"Deposito",""+monto));
        }
    }
    
    @Override
    public void retirar(double monto,fecha f){
        
    }
    
    
    //
        @Override
    public String toString(){
        return "===========\n"+"| AHORROS |\n"+"===========\nNum. Cuenta: "+idcta+"\nSaldo: $"+saldo+"\nTasa: "+(tasa*100)+"%\n";
    }

    public int id(){
     return idah;
    }

    public String leer(){
     return m.imprimir("Ahorros "+idcta);
    }
    
}//fin clase