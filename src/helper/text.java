/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import javax.swing.JLabel;

/**
 *
 * @author ADMIN
 */
public class text extends Thread{
    String text="    Loading";
    JLabel lbl;
    int i=1;
    public text(JLabel lbl){
        super();
        this.lbl=lbl;
        this.lbl.setText(text);
    }
    public void run(){
        while(true){
            try {
                Thread.sleep(150);
            } catch (Exception e) {
                e.printStackTrace();
            }
            StringBuilder sb=new StringBuilder();
            sb.append(text.substring(i,text.length()));
            sb.append(text.substring(0, i));
            i=i+1;
            lbl.setText(sb.toString());
            if(i==text.length()){
                i=1;
            }
        }
    }
}
