package proyecto;
import javax.swing.*;
import java.awt.*;
import banco.*;

public class edoResultados extends JFrame{
 private JTextArea res;
 private JScrollPane vert;
 private cliente cl;
 
 public edoResultados(/*cliente cli*/){
  setTitle("Estados de Cuentas");
  setSize(560, 500);
  setLocation(300,150);
  setDefaultCloseOperation(HIDE_ON_CLOSE);
  
  //se crean los componentes
  res=new JTextArea();
  res.setSize(700, 400);
  res.setEditable(false);
  
  vert=new JScrollPane(res,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
  vert.setBounds(new Rectangle(20,20,500,420));
  
  //se crea el panel
  Container pane=getContentPane();
  pane.setLayout(new GroupLayout(pane));
  
  //se agregan al panel
  pane.add(vert).setLocation(25,25);
  
  
 }
 
 public void obtencliente(cliente cli){
  cl=cli;
 }
 
 public void imprimir(){
  res.setText("");
  res.setText(cl.reportarEdosCtas());
 }
 /*
 public static void main(String args[]){
  new edoResultados().setVisible(true);
 }//*/
}
