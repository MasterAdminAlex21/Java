package practbanco;
import javax.swing.*;
import java.awt.*;
import javafx.scene.control.TreeItem;

public class UML extends JFrame{
    private String sep="----------------------------------------------------------";
    private JTextArea isr,aho,che,cre,fec,cta,cli;
    public UML(){
        setTitle("Diagrama UML");
        setSize(1000, 800);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE/*HIDE_ON_CLOSE*/);
        setLocation(200,0);
        
        isr=new JTextArea("           <<interface>>\n            IMPUESTOS\n"+sep+"\n+ISRm: double=0.10\n+ISRa: double=0.15\n"+sep+"\n+pagarISRmensual(): void\n+pagarISRanual(): void");
        isr.setSize(145, 130);
        isr.setEditable(false);
        isr.setBackground(Color.GRAY);
        isr.setForeground(Color.CYAN);
        
        aho=new JTextArea("\t           ahorros\n"+sep+sep+"\n-tasa: double\n-id: int\n"+sep+sep+"\n+ahorros(aper: fecha,saldo: double,tasa: double)\n"
                + "+consultar(): double\n+pagarISRmensual(): void\n+pagarISRanual(): void\n+depositar(monto: double): void\n+toString(): String");
        aho.setSize(280,180);
        aho.setEditable(false);
       
        che=new JTextArea("\t    cheques\n"+sep+sep+"\n-sobregiro: double\n-id: int\n"+sep+sep+"\ncheques(saldo: double,sobre: double,ap: fecha)\n+depositar(monto:double): void\n+retirar(monto: double): void\n+consultar(): void\n"
                + "+toString(): String\n-cad(): String");
        che.setSize(270,180);
        che.setEditable(false);
        
        cre=new JTextArea("\t      credito\n"+sep+sep+"\n-tasa: double\n-deficit: double\n-id: int\n"+sep+sep+"\n+credito(saldo: double,tasa: double,ap: fecha)\n+depositar(monto: double):void\n"
                + "+retirar(monto: double): void\n+consultar(): double\n+toString(): String");
        cre.setSize(260, 180);
        cre.setEditable(false);
        
        fec=new JTextArea("\tfecha\n"+sep+sep+"\n-dia: int\n-mes: int\n-año: int\n"+sep+sep+"\n+fecha(d: int,m: int, a: int)\n+obtenerfecha(): fecha\n+establecerfecha(d: int, m: int,a: int)\n+toString(): String");
        fec.setSize(210,160);
        fec.setEditable(false);
        
        cta=new JTextArea("\t     cuenta\n"+sep+sep+"\n#saldo: double\n-apertura: fecha\n#flag: int\n"+sep+sep+"\n+cuenta(nom: String,ap: fecha,saldo: double)\n+cuenta(ap: fecha,saldo: double)\n"
                + "+consultar(): double\n+depositar(monto: double): void\n+retirar(monto: double): void\n+bandera(): int");
        cta.setSize(250, 160);
        cta.setEditable(false);
        
        cli=new JTextArea("\t     cliente\n"+sep+sep+"\n-nombre: String\n-cuentas: ArrayList<cuenta>\n-numCuentas: int\n-numCuenta: String\n"+sep+sep+"\n+cliente(nom: String,ctas: ArrayList<cuentas>)\n"
                + "+agregarCuenta(cta: cuenta): void\n+obtenerCuenta(index: int): cuenta\n+toString(): String\n+nombre(): String\n+exiscta(flag: int): boolean");
        cli.setSize(260, 180);
        cli.setEditable(false);
        
        //auxiliar :v
        JTextArea l1,l2,l3,l4,l5,l6,l7;
       // String aux="⋀ ⋁ ⋏ ▲ ▼ ► ◄ ◆ ◇ Λ ▕ ▔ ▏┌ ┍ ┎ ┏ ┐ ┑ ┒ ┓─ ━ │ ┃ └ ┕ ┖ ┗ ┘ ┙ ┚ ┛";
        
        
        l1=new JTextArea(" |\n | \nV");
        l1.setForeground(Color.black);
        l1.setSize(10, 60);
        l1.setBackground(Color.LIGHT_GRAY);
        
        l2=new JTextArea("\n│");
        l2.setForeground(Color.black);
        l2.setSize(10,50);
        l2.setBackground(Color.lightGray);
        
        l3=new JTextArea("────────────────►");
        l3.setForeground(Color.black);
        l3.setBackground(Color.lightGray);
        l3.setSize(220,15);
        
        l4=new JTextArea("▲\n│\n│\n");
        l4.setForeground(Color.black);
        l4.setBackground(Color.lightGray);
        l4.setSize(10, 50);
        
        l5=new JTextArea("                  ◄──┐\n\t│\n\t│\n\t│\n\t│\n\t│\n\t└───────────┐\n\t\t                   │");
        l5.setForeground(Color.black);
        l5.setBackground(Color.lightGray);
        l5.setSize(300,150);
        
        l6=new JTextArea("◇────────");
        l6.setForeground(Color.black);
        l6.setBackground(Color.lightGray);
        l6.setSize(100, 15);
        
        l7=new JTextArea("◇\n│\n│\n│\n│");
        l7.setForeground(Color.BLACK);
        l7.setBackground(Color.lightGray);
        l7.setSize(10, 50);
        //se agregan al panel :v
        Container pane=getContentPane();
        pane.setLayout(new GroupLayout(pane));
        pane.setBackground(Color.LIGHT_GRAY);
//        pane.setBackground(Color.getHSBColor(1000,1600,1500));
        pane.add(isr).setLocation(70, 600);
        pane.add(aho).setLocation(10, 370);
        pane.add(che).setLocation(350, 430);
        pane.add(cre).setLocation(680, 430);
        pane.add(cta).setLocation(350, 230);
        pane.add(fec).setLocation(680,230);
        pane.add(cli).setLocation(350,00);
        
        //se agregan los labels
        
        pane.add(l1).setLocation(140,550);
        pane.add(l3).setLocation(140, 340);
        pane.add(l2).setLocation(130, 330);
        pane.add(l4).setLocation(480, 390);
        pane.add(l5).setLocation(550, 300);
        pane.add(l6).setLocation(600,270);
        pane.add(l7).setLocation(480, 180);
        setVisible(true);
        
    }
    
    
    
    public static void main(String args[]){
        new UML().setVisible(true);
        
        
    }
}