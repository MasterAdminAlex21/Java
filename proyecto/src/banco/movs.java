package banco;
import java.io.*;
import java.util.*;

public class movs{
 private FileWriter esc;
 private FileReader ler;
 private File movi;
 private File escmov;
 public movs(String cliente){
  movi=new File("C:\\Users\\Athena megumi\\Documents\\NetBeansProjects\\proyecto\\src\\clientes\\"+cliente);
  if(!movi.exists()){
   movi.mkdirs();
  }
 }
 
 public void escribir(String cuent,movimientos m){
  escmov=new File(movi+"\\"+cuent+".txt");
  if(!escmov.exists()){
   try{
    escmov.createNewFile();
   }catch(IOException e){
    System.err.println("Error al crear archivo");
   }
  }
  
  try{
   esc=new FileWriter(escmov,true);
   esc.write(m.toString());
   esc.close();
  }catch(IOException e){
   System.err.println("Error al escribir");
  }
 }
 
 public String imprimir(String cuent){
  String cad="";
  try{
   ler=new FileReader(movi+"\\"+cuent+".txt");
   int c=ler.read();
   while(c!=-1){
    cad=cad+(char)c;
    c=ler.read();
   }
  }catch(IOException e){
   System.err.println("Error al leer el archivo");
  }
  return cad;
 }
}//fin clas