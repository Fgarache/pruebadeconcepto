import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Lienzo extends Canvas {
    public static final int X = 8;
    public static final int Y = 8;
    public static final int PERSON=1;
    public final int VOID = 0;
    public static int[][] tab = new int[X][Y];
    public int SEPARATION = 60;

    Image nave = null;

    Lienzo(){
        try {
            nave = ImageIO.read(this.getClass().getResource("NAVE.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        tab[0][7] = PERSON;
    }




    @Override
    public void paint(Graphics g){
        for(int x = 0; x < X; x++ ){
            for(int y = 0; y < Y; y++ ){
                switch (tab[x][y]){
                    case VOID:
                        g.setColor(Color.BLACK);

                        g.drawRect(10 + x * SEPARATION, 10 + y * SEPARATION, SEPARATION,SEPARATION );
                        break;
                    case PERSON:
                        g.setColor(Color.YELLOW);


                        g.drawImage(nave,10 + x * SEPARATION, 10 + y * SEPARATION, SEPARATION,SEPARATION,null );
                        break;
                }
            }
        }
    }
}
