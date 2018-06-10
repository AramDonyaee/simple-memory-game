
/*
 *
 * Author: Aram Donyaee
 * Email Address: adonyaee@yahoo.com
 *
 * */



import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.*;
import java.util.List;


public class MemoryGame extends JPanel{


    static private HashMap componentMap;
    static int o;
    static int overalScore;
    static JLabel score = new JLabel("Score: 0/40");



    public static void main(String[] args) {

        JFrame frame = new JFrame();



        frame.setSize(1400,760);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.black);



        int rectWidth = 100;
        int rectHeight = 100;
        int fromLeft = 150;
        int fromTop = 50;


        int rectWidth2 = 100;
        int rectHeight2 = 100;
        int fromLeft2 = 150;
        int fromTop2 = 50;




        File imagesDir = new File("path of your images directory");
        File[] images = imagesDir.listFiles();



        List<File> Selected = new ArrayList<File>();

        while(Selected.size() < 10){
            Random rand = new Random();
            File file = images[rand.nextInt(images.length)];
            if(!Selected.contains(file)){
                Selected.add(file);
            }
        }

        System.out.println(Selected);
        System.out.println(Selected.size());



        List<ImageIcon> icl = new ArrayList<ImageIcon>();

        for(int w=0; w<Selected.size(); w++){
            ImageIcon ic = new ImageIcon(Selected.get(w).toString());
            for(int l=0; l<=3; l++){
                icl.add(ic);
            }
        }
        Collections.shuffle(icl);



        System.out.println(icl.size() + "icl is" + icl);


        List<Icon> memory = new ArrayList<Icon>();

        JButton selectedButtons[];
        selectedButtons = new JButton[2];



        for (o=0; o<40; o++){
            fromLeft += rectWidth + 10;

            if (o==0 || o==10 || o==20 || o==30){
                fromLeft = 150;
                fromTop += rectHeight + 10;
            }



            JButton jok = new JButton();
            jok.setName(String.valueOf(o) +  "jokbutton");
            jok.setBackground(Color.blue);
            jok.setForeground(Color.white);
            jok.setBounds(fromLeft, fromTop, rectWidth, rectHeight);
            jok.setVisible(true);

            jok.setDisabledIcon(icl.get(o));




            jok.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    if(memory.size() == 0){
                        jok.setVisible(false);
                        memory.add(jok.getDisabledIcon());
                        selectedButtons[0] = jok;
                    } else if (memory.size() == 1) {
                        jok.setVisible(false);
                        memory.add(jok.getDisabledIcon());
                        selectedButtons[1] = jok;
                    } else if(memory.size() == 2){
                        if (memory.get(0) == memory.get(1))
                        {
                            memory.clear();
                            overalScore += 2;
                            score.setText("Score: " + overalScore + "/40");
                            System.out.println(overalScore);
                        }
                        else if (memory.get(0)!=memory.get(1))
                        {
                            memory.clear();
                            selectedButtons[0].setVisible(true);
                            selectedButtons[1].setVisible(true);

                        }
                    }
                }
            });



            frame.add(jok);
        }




        for (int o=0; o<40; o++){
            fromLeft2 += rectWidth2 + 10;

            if (o==0 || o==10 || o==20 || o==30){
                fromLeft2 = 150;
                fromTop2 += rectHeight2 + 10;
            }

            JButton jk = new JButton(icl.get(o));
            jk.setName(String.valueOf(o)+ 41);
            jk.setBackground(Color.black);
            jk.setForeground(Color.white);
            jk.setBounds(fromLeft2, fromTop2, rectWidth2, rectHeight2);
            jk.setVisible(true);

            frame.add(jk);


        }







        JLabel jt = new JLabel("Memory Game - Vintage Style! (:");
        jt.setFont(new Font("Sans Serif", Font.BOLD, 25));
        jt.setBounds(150,25,1000,100);
        jt.setForeground(Color.white);


        score.setFont(new Font("Sans Serif", Font.BOLD, 25));
        score.setBounds(1110,25,300,100);
        score.setForeground(Color.yellow);


        frame.add(jt);
        frame.add(score);


//        HashMap componentMap = new HashMap<String, JComponent>();
//        Component[] components = frame.getContentPane().getComponents();
//        for (int i=0; i < components.length; i++) {
//            iconNameMap.put(components[i].getName(), components[i]);
//        }



        frame.setResizable(true);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);


    }

//    static public Component getComponentByName(String name) {
//        if (componentMap.containsKey(name)) {
//            return (Component) componentMap.get(name);
//        }
//        else return null;
//    }


}




