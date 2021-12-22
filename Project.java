import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/*
<applet code="Project.class" height=400 width=400></applet>
*/

public class Project extends Applet implements ActionListener,Runnable{
    String n1="";
    int x,y,flag,ch,fon,chfont;
    TextField t1=new TextField(25);
    Label l1=new Label("Enter String");
    Button b1=new Button("Submit");
    public void init(){
        x=100;
        y=200;
        ch=10;
        fon=40;
        chfont=2;
        Thread t=new Thread(this,"My Thread");
        t.start();
        add(l1);
        add(t1);
        add(b1);
        b1.addActionListener(this);
        }
    public void run(){
        while(true){
            x=x+ch;
            fon=fon+(chfont);
            
            if (x>400){
                x=100;
                y=200;
                fon=40;
            }
            
            repaint();
            try{
                Thread.sleep(150);
            }
            catch(InterruptedException ie){
                System.out.println(ie);
            }
        }
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource()==b1 ){
            n1=t1.getText();

        }
    }
    public void paint(Graphics g){
        g.setFont(new Font("Times New Roman", Font.BOLD,fon));
        g.drawString(n1, y, x);
    }

    
}
