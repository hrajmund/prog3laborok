import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;
public class CaesarFrame extends JFrame{
    private final JPanel upperPanel;
    private final JPanel lowerPanel;
    private JComboBox<Object> alphabetLetters;
    private final JTextField input;
    private final JTextField output;
    private final JButton convertButton;
    private final JLabel lowerPanelWord;

    CaesarFrame(){
        super("SwingLab");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,110);
        setResizable(false);
        Object[] alphabet = new Object[26];

        for(int i = 'A'; i <= 'Z'; i++)
            alphabet[i - 'A'] = (char) i;

        upperPanel = new JPanel(new FlowLayout());
        lowerPanel = new JPanel(new BorderLayout());
        alphabetLetters = new JComboBox<>();
        convertButton = new JButton("Code!");

        input = new JTextField(20);
        input.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        output = new JTextField();
        lowerPanelWord = new JLabel("Output");

        upperPanel.add(alphabetLetters);
        upperPanel.add(input);
        upperPanel.add(convertButton);

        lowerPanel.add(lowerPanelWord, BorderLayout.WEST);
        lowerPanel.add(output);

        this.add(upperPanel);
        this.add(lowerPanel);

        this.setLocationRelativeTo(null);
    }
}
