package proyecto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import banco.*;

public class joper extends JFrame implements ActionListener{
 private JRadioButton dep,ret;
 private JLabel monto,cta,tipocta;
 private JTextField mon,numcta;
 private JButton aceptar,buscarcta;
 private ButtonGroup gpo;
 private cliente cli;
 private cuenta action;
 private hilo f;
 
 public joper(/*cliente cl,hilo fecha*/){
  setTitle("Trasaccion");
  //setVisible(true);
  setSize(300, 200);
  setLocation(300, 150);
  setDefaultCloseOperation(HIDE_ON_CLOSE);
  setResizable(false);
  //cli=cl;
  //f=fecha;
  
  //se crean los componetes
  dep=new JRadioButton("Depositar",true);
  dep.setSize(80, 15);
  dep.setEnabled(false);
  
  ret=new JRadioButton("Retirar",false);
  ret.setSize(70,15);
  ret.setEnabled(false);
  
  gpo=new ButtonGroup();
  gpo.add(dep);
  gpo.add(ret);
  
  monto=new JLabel("Monto");
  monto.setSize(50,15);
  
  mon=new JTextField();
  mon.setSize(120, 20);
  mon.setEnabled(false);
  
  aceptar=new JButton("Aceptar");
  aceptar.setSize(80,20);
  aceptar.setEnabled(false);
  
  cta=new JLabel("Num. cuenta: ");
  cta.setSize(80, 20);
  
  numcta=new JTextField();
  numcta.setSize(50,20);
  
  buscarcta=new JButton("Buscar cuenta");
  buscarcta.setSize(120,20);
  
  tipocta=new JLabel("tipo");
  tipocta.setSize(100, 20);
  
  //se crea el panel
  Container pane=getContentPane();
  pane.setLayout(new GroupLayout(pane));
  
  //se agregan los componentes
  pane.add(dep).setLocation(110, 30);
  pane.add(ret).setLocation(200, 30);
  pane.add(monto).setLocation(50, 70);
  pane.add(mon).setLocation(100,70);
  pane.add(aceptar).setLocation(100,130);
  
  pane.add(cta).setLocation(10, 5);
  pane.add(numcta).setLocation(100, 5);
  pane.add(buscarcta).setLocation(150,5);
  pane.add(tipocta).setLocation(10,40);

//se agrega el listener
  aceptar.addActionListener(this);
  buscar cta=new buscar();
  buscarcta.addActionListener(cta);
 }
 
 //private class boton implements ActionListener{
  public void actionPerformed(ActionEvent e){
   //accion del boton
   try{
   if(dep.isSelected()==true){//deposito
    action.depositar(Double.parseDouble(mon.getText()), f.calendario());
    JOptionPane.showMessageDialog(new JPanel(), "Accion realizada","OK",JOptionPane.OK_OPTION,new ImageIcon("C:\\Users\\Athena megumi\\Documents\\NetBeansProjects\\proyecto\\src\\imgns\\accepted icon.png"));
    this.setVisible(false);
   }else if(ret.isSelected()==true){//retiro
    if(action instanceof cheques){
     cheques au=(cheques)action;
     if(au.caduco(f.calendario())){
      JOptionPane.showMessageDialog(new JPanel(), "Cuenta de cheques caducada","ERROR",JOptionPane.ERROR_MESSAGE);
     }else{
      if(au.consaux()<Double.parseDouble(mon.getText())){
       JOptionPane.showMessageDialog(new JPanel(), "No hay suficiente saldo","ERROR",JOptionPane.ERROR_MESSAGE);
      }else{
       action.retirar(Double.parseDouble(mon.getText()), f.calendario());
       JOptionPane.showMessageDialog(new JPanel(), "Accion realizada","OK",JOptionPane.OK_OPTION,new ImageIcon("C:\\Users\\Athena megumi\\Documents\\NetBeansProjects\\proyecto\\src\\imgns\\accepted icon.png"));
       this.setVisible(false);
      }
     }
    }else{
    action.retirar(Double.parseDouble(mon.getText()), f.calendario());
    JOptionPane.showMessageDialog(new JPanel(), "Accion realizada","OK",JOptionPane.OK_OPTION,new ImageIcon("C:\\Users\\Athena megumi\\Documents\\NetBeansProjects\\proyecto\\src\\imgns\\accepted icon.png"));
    this.setVisible(false);
    }
   }
   }catch(NumberFormatException err){
    JOptionPane.showMessageDialog(new JPanel(), "Favor de ingresar digitos","ERROR",JOptionPane.ERROR_MESSAGE);
   }
   this.reiniciar();
   //this.hide();
  }
 //}
 
 private class buscar implements ActionListener{
  public void actionPerformed(ActionEvent e){
   try{
   if(Integer.parseInt(numcta.getText())>cli.numctas() || Integer.parseInt(numcta.getText())-1==-1){
    JOptionPane.showMessageDialog(new JPanel(), "No existe esa cuenta","Error",JOptionPane.ERROR_MESSAGE);
   }else if(Integer.parseInt(numcta.getText())<0){
   JOptionPane.showMessageDialog(new JPanel(), "No existen cuentas negativas","Error",JOptionPane.ERROR_MESSAGE);
   }else{
    //mostrar tipo de cuenta
    
    action=cli.obtenerCuenta(Integer.parseInt(numcta.getText())-1);
     //JOptionPane.showMessageDialog(new JPanel(), "No existe esa cuenta","Error",JOptionPane.ERROR_MESSAGE);
    if(action.flag()==0){
     dep.setEnabled(true);
     dep.setSelected(true);
     mon.setEnabled(true);
     aceptar.setEnabled(true);
     tipocta.setText("Ahorros");
     numcta.setEnabled(false);
     buscarcta.setEnabled(false);
    }else if(action.flag()==1){
     dep.setEnabled(true);
     ret.setEnabled(true);
     mon.setEnabled(true);
     aceptar.setEnabled(true);
     tipocta.setText("Cheques");
     numcta.setEnabled(false);
     buscarcta.setEnabled(false);
    }else if(action.flag()==2){
     dep.setEnabled(true);
     ret.setEnabled(true);
     mon.setEnabled(true);
     aceptar.setEnabled(true);
     tipocta.setText("Credito");
     numcta.setEnabled(false);
     buscarcta.setEnabled(false);
     }
    }
   }catch(NumberFormatException err){
   JOptionPane.showMessageDialog(new JPanel(), "Error en la busqueda de cuenta","Error",JOptionPane.ERROR_MESSAGE); 
   }
  }
 }
 
 public void obtendatos(cliente cl,hilo fecha){
  cli=cl;
  f=fecha;
 }
 
 public void reiniciar(){
  dep.setEnabled(false);
  ret.setEnabled(false);
  mon.setEnabled(false);
  aceptar.setEnabled(false);
  numcta.setText("");
  numcta.setEnabled(true);
  buscarcta.setEnabled(true);
  mon.setText("");
 }
 /*
 public static void main(String args[]){
  new joper().setVisible(true);
 }//*/
 
}//fin clase