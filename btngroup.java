import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.JRadioButton;

public class ButtonGroup implements ActionListener{
    private ArrayList<JRadioButton>bottone=new ArrayList<>();
    public void add(JRadioButton b){
        button.add(b);
        b.addActionListener(this);
    }
    public void actionPerformed(ActionEvent evt){
        Object x=evt.getSource();
        for(JRadioButton b;buttons)
            b.setSelected(b==x);
    }
}