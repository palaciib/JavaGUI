import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Minimal Java Swing application.
 * 
 * @author Nathan Sprague
 * 
 */
public class GUIDemo extends JFrame
{
    private JPanel panel;
    private JButton biggerButton;
    private JButton smallerButton;
    private JButton doubleButton;

    /**
     * Set up the application.
     */
    public GUIDemo()
    {
	setTitle("Bigger/Smaller/DoubleSize");
        setSize(200, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        biggerButton = new JButton("BIGGER");
        smallerButton = new JButton("SMALLER");
        doubleButton = new JButton("DOUBLE");
        biggerButton.addActionListener(new ButtonHandler());
        smallerButton.addActionListener(new ButtonHandler());
        doubleButton.addActionListener(new ButtonHandler());
        add(panel);
        panel.add(biggerButton);
        panel.add(smallerButton);
        panel.add(doubleButton);
        setVisible(true);
    }

    /**
     * This inner class exists to handle button events. There are other ways
     * this could have been done:
     * 
     * 1. GUIDemo could implement ActionListener itself. 
     * 2. Anonymous inner classes could be used to hand the events.
     */
    private class ButtonHandler implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {
            Dimension size = getSize();

            if (e.getSource().equals(biggerButton))
            {
                setSize(size.width + 10, size.height + 10);
            }
            if (e.getSource().equals(doubleButton))
            {
                setSize(size.width * 2, size.height * 2);
            }
            else
            {
                setSize(size.width - 10, size.height - 10);
            }

        }
    }

    /**
     * Start the app by creating a GUIDemo object.
     */
    public static void main(String[] args)
    {
        GUIDemo app = new GUIDemo();
    }
}
