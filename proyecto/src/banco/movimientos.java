package banco;

public class movimientos{
 private fecha mov;
 private String movi;
 private String detalle;
 
 public movimientos(fecha f,String mo,String det){
  mov=f;
  movi=mo;
  detalle=det;
 }
 
 @Override
 public String toString(){
  return mov+"     "+movi+"     "+detalle+"\n";
 }
}//fin clase