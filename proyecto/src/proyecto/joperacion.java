package proyecto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import banco.*;

public class joperacion extends JFrame{
 private JButton agcta,tras,cons,movs,edoctas;
    private JTextField nom;
    private cliente client;
    private hilo h;
    
    private joper op=new joper();
    private jmovimientos mov=new jmovimientos();
    private jagcta agc=new jagcta();
    private jconsultar consul=new jconsultar();
    private edoResultados res=new edoResultados();
    
    public joperacion(/*cliente cli,hilo calen*/){
        setTitle("Cliente");
        setSize(367, 200);
        setLocation(500, 300);
        setResizable(false);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        //client=cli;
        //h=calen;
        
        
        //creacion de los componentes        
        tras=new JButton("Trasacciones");
        tras.setSize(125, 30);
        
        movs=new JButton("Movimientos");
        movs.setSize(125, 30);
        
        agcta=new JButton("Agregar Cuenta");
        agcta.setSize(125, 30);
        
        cons=new JButton("Consultar saldo");
        cons.setSize(125,30);
        
        edoctas=new JButton("Estados de cuentas");
        edoctas.setSize(160,30);
        
        //se crea el panel
        Container pane=getContentPane();
        pane.setLayout(new GroupLayout(pane));
        
        //se agregan al panel
        pane.add(agcta).setLocation(40, 20);
        pane.add(tras).setLocation(40,70);
        pane.add(cons).setLocation(200, 20);
        pane.add(movs).setLocation(200, 70);
        pane.add(edoctas).setLocation(105,120);
        //se agregan los listener
        tra tr=new tra();
        tras.addActionListener(tr);
        
        movi mo=new movi();
        movs.addActionListener(mo);
        
        ag agctal=new ag();
        agcta.addActionListener(agctal);
        
        cons consul=new cons();
        cons.addActionListener(consul);
        
        edo resu=new edo();
        edoctas.addActionListener(resu);
    }
    
class tra implements ActionListener{
    public void actionPerformed(ActionEvent e){
        //trasacciones
        if(client.numctas()==0){
         JOptionPane.showMessageDialog(new JPanel(), "No hay cuentas para realizar accion","Error",JOptionPane.ERROR_MESSAGE);
        }else{
        op.obtendatos(client, h);
        op.setVisible(true);
        }
    }
}


class movi implements ActionListener{
 public void actionPerformed(ActionEvent e){
  //movimientos
  if(client.numctas()==0){
   JOptionPane.showMessageDialog(new JPanel(), "No hay cuentas que mostrar","Error",JOptionPane.ERROR_MESSAGE);
  }else{
  mov.obtencliente(client);
  mov.reiniciar();
  mov.setVisible(true);
  }
 }
}

class ag implements ActionListener{
 public void actionPerformed(ActionEvent e){
  //agregar cuenta
  
  agc.obtendatos(client,h);
  agc.setVisible(true);
 }
}

class cons implements ActionListener{
 public void actionPerformed(ActionEvent e){
  //consultar saldos
  if(client.numctas()==0){
   JOptionPane.showMessageDialog(new JPanel(), "No hay cuentas que mostrar","Error",JOptionPane.ERROR_MESSAGE);
  }else{
  consul.obtendatos(client,h);
  consul.reinicio();
  consul.setVisible(true);
  }
 }
}

class edo implements ActionListener{
 public void actionPerformed(ActionEvent e){
   if(client.numctas()==0){
   JOptionPane.showMessageDialog(new JPanel(), "No hay cuentas que mostrar","Error",JOptionPane.ERROR_MESSAGE);
  }else{
  res.obtencliente(client);
  res.imprimir();
  res.setVisible(true);
  }
 }
}

public void obtendatos(cliente cli,hilo f){
 client=cli;
 h=f;
 
}
    /*
    public static void main(String args[]){
        new joperacion().setVisible(true);
    }//*/
    
}//fin clase

