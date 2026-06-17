import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Window extends JPanel {

    AttributePanel aPanel = new AttributePanel();
    JScrollPane scrollPane = new JScrollPane(aPanel);

    private JTextField nameField;
    private JList<String> suggestionList;
    private JScrollPane suggestionPane;

    private String storedName = "";
    private List<String> allNames;

    public Window() throws IOException {
        setLayout(null);
        setSize(1370,750);
        setBackground(Color.BLACK);

        scrollPane.setBounds(0,100,1370,650);
        add(scrollPane);

        setFocusable(true);

        // ----------------------------------------------------
        // LOAD NAMES FROM Bleachdle CSV
        // ----------------------------------------------------
        Bleachdle test = new Bleachdle();
        BleachCharacter randomCharacter = test.generateCharacter();

        allNames = test.getAllNames();   // <-- names now come from CSV

        // ----------------------------------------------------
        // NAME INPUT UI
        // ----------------------------------------------------
        JLabel nameLabel = new JLabel("Enter Name:");
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setBounds(20, 20, 100, 25);

        nameField = new JTextField();
        nameField.setBounds(120, 20, 200, 25);

        // suggestion list UI
        suggestionList = new JList<>();
        suggestionPane = new JScrollPane(suggestionList);
        suggestionPane.setBounds(120, 45, 200, 120);
        suggestionPane.setVisible(false);

        // LIVE FILTERING
        nameField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { updateSuggestions(); }
            public void removeUpdate(DocumentEvent e) { updateSuggestions(); }
            public void changedUpdate(DocumentEvent e) { updateSuggestions(); }
        });

        // ENTER KEY STORES NAME
        nameField.addActionListener(e -> {
            storedName = nameField.getText().trim();
            System.out.println("Stored name: " + storedName);
            suggestionPane.setVisible(false);
            BleachCharacter guess = test.getCharacter(storedName);
            aPanel.setAddRow(true);
            aPanel.setAttributes(test.getCharacterStringComparison(guess, randomCharacter));
            aPanel.setColors(test.getCharacterColorComparison(guess, randomCharacter));
            aPanel.repaint();
        });

        // CLICKING A SUGGESTION
        suggestionList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selected = suggestionList.getSelectedValue();
                if (selected != null) {
                    nameField.setText(selected);
                    storedName = selected;
                    suggestionPane.setVisible(false);
                }
            }
        });

        add(nameLabel);
        add(nameField);
        add(suggestionPane);
    }

    // ----------------------------------------------------
    // UPDATE AUTOCOMPLETE SUGGESTIONS
    // ----------------------------------------------------
    private void updateSuggestions() {
        String text = nameField.getText().trim().toLowerCase();

        if (text.isEmpty()) {
            suggestionPane.setVisible(false);
            return;
        }

        List<String> matches = allNames.stream()
                .filter(n -> n.toLowerCase().contains(text))
                .collect(Collectors.toList());

        if (matches.isEmpty()) {
            suggestionPane.setVisible(false);
        } else {
            suggestionList.setListData(matches.toArray(new String[0]));
            suggestionPane.setVisible(true);
        }
    }

    public String getStoredName() {
        return storedName;
    }
}