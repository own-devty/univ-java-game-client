package kr.ac.anyang.taeyang.frame;

import kr.ac.anyang.taeyang.panel.play_frame.Omok;
import kr.ac.anyang.taeyang.utils.FrameHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignIn extends JFrame {
    private JPanel inputPanel = new JPanel();
    private JPanel idPanel = new JPanel();
    private JPanel pwPanel = new JPanel();
    private JPanel btnGroupPanel = new JPanel();
    private JLabel lblID = new JLabel("ID");
    private JTextField id = new JTextField(12);
    private JLabel lblPassword = new JLabel("PW");
    private JPasswordField password = new JPasswordField(12);
    private JButton signInBtn = new JButton("로그인");
    private JButton signUpBtn = new JButton("회원가입");

    public SignIn() {
        idPanel.add(lblID);
        idPanel.add(id);
        pwPanel.add(lblPassword);
        pwPanel.add(password);
        btnGroupPanel.add(signUpBtn);
        btnGroupPanel.add(signInBtn);
        inputPanel.add(idPanel);
        inputPanel.add(pwPanel);
        inputPanel.add(btnGroupPanel);

        registerListener();

        setLayout(new BorderLayout());
        FrameHelper.SignInSetup(this, () -> {
            add(inputPanel, BorderLayout.CENTER);
        });
    }

    private void registerListener() {
        signUpBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new SignUp();
            }
        });

        signInBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (id.getText().isBlank()) {
                    JOptionPane.showMessageDialog(
                            SignIn.this,
                            "아이디칸이 공란입니다.",
                            "경고",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (password.getText().isBlank()) {
                    JOptionPane.showMessageDialog(
                            SignIn.this,
                            "비밀번호칸이 공란입니다.",
                            "경고",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                //TODO: 서버로 id pw 정보 전달
                dispose();
                new Rooms();
            }
        });
    }
}

