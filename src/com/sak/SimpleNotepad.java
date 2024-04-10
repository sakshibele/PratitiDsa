package com.sak;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SimpleNotepad {

    private JTextArea textArea;
    private Map<String, String> wordCorrections;
    private Set<String> dictionary;

    public SimpleNotepad() {
        JFrame frame = new JFrame("Simple Notepad");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Initialize word corrections
        initializeWordCorrections();
        
        // Load dictionary
        loadDictionary();

        // Button for correcting text
        JButton correctButton = new JButton("Correct Text");
        correctButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                correctText();
            }
        });
        frame.add(correctButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void initializeWordCorrections() {
        // Define word corrections
        wordCorrections = new HashMap<>();
        wordCorrections.put("teh", "the");
        wordCorrections.put("writting", "writing");
        // Add more corrections as needed
    }
    
    private void loadDictionary() {
        // Load dictionary from file or define it manually
        // For simplicity, let's define a basic dictionary here
        dictionary = Set.of("the", "quick", "brown", "fox", "jumps", "over", "lazy", "dog");
    }

    private void correctText() {
        String text = textArea.getText();
        String[] words = text.split("\\s+");
        StringBuilder correctedText = new StringBuilder();
        for (String word : words) {
            String correctedWord = word;
            if (!dictionary.contains(word.toLowerCase())) {
                correctedWord = wordCorrections.getOrDefault(word.toLowerCase(), word);
            }
            correctedText.append(correctedWord).append(" ");
        }
        textArea.setText(correctedText.toString().trim());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SimpleNotepad();
            }
        });
    }
}
