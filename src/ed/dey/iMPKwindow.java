package ed.dey;

import javax.swing.*;
import java.awt.*;

public class iMPKwindow extends JFrame {
    private JPanel mainPanel;

    private JPanel headerPanel;
    private JPanel mapPanel;

    public iMPKwindow(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contPaneInit();
        this.setContentPane(mainPanel);
        this.pack();

        this.setVisible(true);
    }

    private void contPaneInit(){
        mainPanel = new JPanel();
        headerPanel = new JPanel();
        mapPanel = new JPanel();
        mainPanel.setSize(700,650);
        this.setMinimumSize(new Dimension(700,650));

        mainPanel.setLayout(new BorderLayout());

        headerPanel.setBackground(Color.RED);
        mapPanel.setBackground(Color.BLUE);

        headerPanel.setPreferredSize(new Dimension(700,150));
        mapPanel.setPreferredSize(new Dimension(700,500));

        mainPanel.add(headerPanel,BorderLayout.NORTH);
        mainPanel.add(mapPanel,BorderLayout.SOUTH);
    }
}
