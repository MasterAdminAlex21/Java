package proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import banco.*;


public class jconsultar extends JFrame{
 private JLabel cta;
 private JTextField cuenta;
 private JButton buscta;
 private JTextArea cons;
 private cliente cli;
 private hilo fecha;
 
 public jconsultar(/*cliente cl,hilo fec*/){
  setTitle("Consultas");
  setSize(300, 300);
  setResizable(false);
  setLocation(500, 300);
  setDefaultCloseOperation(HIDE_ON_CLOSE);
  //fecha=fec;
  //cli=cl;
  //creacion de los componentes
  cta=new JLabel("Num. cuenta: ");
  cta.setSize(100, 20);
  
  cuenta=new JTextField();
  cuenta.setSize(50,20);
  
  buscta=new JButton("Buscar cuenta");
  buscta.setSize(120, 20);
  
  cons=new JTextArea();
  cons.setSize(270, 240);
  cons.setEditable(false);
  
  
  //se crea el panel
  Container pane=getContentPane();
  pane.setLayout(new GroupLayout(pane));
  
  //se agregan los componentes al panel
 pane.add(cta).setLocation(10,10);
 pane.add(cuenta).setLocation(100, 10);
 pane.add(buscta).setLocation(150, 10);
  pane.add(cons).setLocation(15,30);
  
  buscar b=new buscar();
  buscta.addActionListener(b);
 }
 
 private class buscar implements ActionListener{
  
  public void actionPerformed(ActionEvent e){
   try{
   if(Integer.parseInt(cuenta.getText())>cli.numctas() || Integer.parseInt(cuenta.getText())-1<0){
    JOptionPane.showMessageDialog(new JPanel(), "No existe esa cuenta","Error",JOptionPane.ERROR_MESSAGE);
   }
   else{
    cuenta aux;
    aux=cli.obtenerCuenta(Integer.parseInt(cuenta.getText())-1);
    aux.consultar(fecha.calendario());
    cons.setText(""+aux);
   }
   cuenta.setText("");
   }catch(NumberFormatException err){
    JOptionPane.showMessageDialog(new JPanel(), "Error al buscar cuenta","Error",JOptionPane.ERROR_MESSAGE);
   }
  }
 }
 
 public void obtendatos(cliente cl,hilo fec){
  fecha=fec;
  cli=cl;
 }
 
 public void reinicio(){
  cons.setText("");
 }
 /*
 public static void main(String args[]){
  new jconsultar().setVisible(true);
 }//*/
 
}//fin clase