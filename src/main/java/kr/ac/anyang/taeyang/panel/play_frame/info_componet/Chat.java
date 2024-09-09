package kr.ac.anyang.taeyang.panel.play_frame.info_componet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chat extends JPanel {
    public Chat() {
        setLayout(new GridLayout(2, 1));

        JPanel chatPanel = new JPanel();
        JTextArea textArea = new JTextArea(40, 15);
        textArea.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        chatPanel.add(scrollPane);
        add(chatPanel);

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("입력"));
        JTextField textField = new JTextField(10);
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField source = (JTextField) e.getSource();
                textArea.append(source.getText() + "\n");
                textField.setText("");

                //TODO: 서버에 채팅 전송
            }
        });
        inputPanel.add(textField);
        inputPanel.add(new Button("전송"));
        add(inputPanel);
    }
}
