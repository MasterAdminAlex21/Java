package proyecto;
import java.awt.*;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.lang.*;
import banco.*;


public class jbanco extends JFrame{
 private hilo h=new hilo();
 
 
    private JButton agcli,ope,buscli;
    private JLabel ban;
    private banco RabuRaibu=new banco("Rabu Raibu");
    
    private jagregar ag=new jagregar();
    private jcliente op=new jcliente();
    private jconsultacli cl=new jconsultacli();
    
    public jbanco(){
        setTitle("BANCO");
        setSize(460,250);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(450, 290);
        
        
        Font pers=new Font("Arial", Font.ITALIC, 24);
        //se crea la etiqueta
        ban=new JLabel(RabuRaibu.nomb());
        ban.setFont(pers);
        ban.setForeground(Color.getHSBColor(100,250,200));
        ban.setSize(200,50);
        
        //creamos los botones
        agcli=new JButton("Agregar \nCliente");
        agcli.setSize(150,40);
        //falta el evt del boton
        
        buscli=new JButton("Consultar \nClientes");
        buscli.setSize(150, 40);
        //evt
        
        ope=new JButton("Operaciones");
        ope.setSize(150, 40);
        //evt
        
        //aqui esta el contenedor
        Container pane=getContentPane();
        pane.setLayout(new GroupLayout(pane));
        
        //se agregan los componentes
        pane.add(ban).setLocation(160,10);
        pane.add(agcli).setLocation(50, 80);
        pane.add(buscli).setLocation(250, 80);
        pane.add(ope).setLocation(150, 150);
        
        //se agregan listener
        agregar call=new agregar();
        agcli.addActionListener(call);
        
        oper callop=new oper();
        ope.addActionListener(callop);
        
        consultarcli concli=new consultarcli();
        buscli.addActionListener(concli);
    }
    
    
     //listener
class agregar implements ActionListener{
    public void actionPerformed(ActionEvent e){
        //agregar cliente
        ag.obtenbanco(RabuRaibu);
        /*new jagregar(RabuRaibu)*/ag.setVisible(true);
        
            
    }
}

class oper implements ActionListener{
    public void actionPerformed(ActionEvent e){
        //operaciones del cliente
        if(RabuRaibu.cli()==0){
         //final JPanel error=new JPanel();
         JOptionPane.showMessageDialog(new JPanel(), "No hay clientes","Error",JOptionPane.ERROR_MESSAGE);
        }else{
         op.obtendatos(RabuRaibu, h);
        /*new jcliente(RabuRaibu,h)*/op.setVisible(true);
        }
    }
}

class consultarcli implements ActionListener{
    public void actionPerformed(ActionEvent e){
        //consutlta los clientes
        if(RabuRaibu.cli()==0){
         //final JPanel error=new JPanel();
         JOptionPane.showMessageDialog(new JPanel(), "No hay clientes que mostrar","Error",JOptionPane.ERROR_MESSAGE);
        }else{
         cl.obtenbanco(RabuRaibu);
         cl.imprimir();
        /*new jconsultacli(RabuRaibu)*/cl.setVisible(true);
        }
    }
}
    
    public static void main(String args[]){
        new jbanco().setVisible(true);
        
    }

} //fin clase