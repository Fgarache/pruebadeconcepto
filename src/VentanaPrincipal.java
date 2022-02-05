import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class VentanaPrincipal extends JFrame implements KeyListener {

    private Lienzo lienzo = null;

    int posx = 0;
    int posy = 7;

    VentanaPrincipal(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(500,550);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.BLACK);
        this.setVisible(true);
        this.addKeyListener(this);

        lienzo = new Lienzo();
        lienzo.setBounds(10,10,(int)this.getSize().getWidth() - 20,(int)this.getSize().getHeight() - 20);
        lienzo.setBackground(Color.BLUE);
        lienzo.setVisible(true);
        this.add(lienzo);


    }
    public static void main(String args[]){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal();

            };
        });
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //JOptionPane.showMessageDialog(this,String.format("la tecla es: %d",e.getKeyCode()));
        switch (e.getKeyCode()){

            case KeyEvent.VK_UP:
                moveUp();
                break;

            case KeyEvent.VK_DOWN:
                moveDown();
                break;

            case KeyEvent.VK_RIGHT:
                movering();
                break;
            case KeyEvent.VK_LEFT:
                moveleft();

        }
        lienzo.repaint();
    }

    private void moveleft() {
        lienzo.tab [posx][posy]=0;
        if (posx==0){
            posx=7;
        }else {
            posx -= 1;
        }
        Lienzo.tab[posx][posy] = Lienzo.PERSON;
        return;
    }

    private void movering() {
        lienzo.tab [posx][posy]=0;
        if (posx==7){
            posx=0;
        }else {
            posx += 1;
        }
        Lienzo.tab[posx][posy] = Lienzo.PERSON;
        return;
    }

    private void moveDown() {
        Lienzo.tab[posx][posy] = 0;
        if(posy == 7){
            posy =0;
        }else{
            posy += 1;
        }
        Lienzo.tab[posx][posy] =  Lienzo.PERSON;
    }

    private void moveUp() {
        Lienzo.tab[posx][posy] = 0;
        if(posy == 0){
            posy =7;
        }else{
            posy -= 1;
        }
        Lienzo.tab[posx][posy] =  Lienzo.PERSON;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
