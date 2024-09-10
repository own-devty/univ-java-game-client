package kr.ac.anyang.taeyang.frame;

import kr.ac.anyang.taeyang.utils.FrameHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Optional;

public class SignUp extends JFrame {
    private JTextField id = new JTextField(12);
    private JPasswordField password = new JPasswordField(12);
    private JTextField nickname = new JTextField(12);
    private JButton backToSignInBtn = new JButton("뒤로가기");
    private JButton signUpBtn = new JButton("등록");
    private JButton imageUploadBtn = new JButton("사진 올리기  ");
    private Optional<Image> image = Optional.empty();

    public SignUp() {
        var idPanel = new JPanel();
        idPanel.add(new JLabel("ID"));
        idPanel.add(id);

        var pwPanel = new JPanel();
        pwPanel.add(new JLabel("PW"));
        pwPanel.add(password);

        var nicknamePanel = new JPanel();
        nicknamePanel.add(new JLabel("별명"));
        nicknamePanel.add(nickname);

        var imagePanel = new JPanel(new BorderLayout());
        var lblPhoto = new JLabel();
        lblPhoto.setIcon(new ImageIcon(image.orElse(new BufferedImage(70,100, BufferedImage.TYPE_INT_BGR))));
        imagePanel.add(lblPhoto, BorderLayout.CENTER);

        JPanel btnGroupPanel = new JPanel();
        btnGroupPanel.add(backToSignInBtn);
        btnGroupPanel.add(signUpBtn);

        JPanel textGroup = new JPanel(new GridLayout(3, 1));
        textGroup.add(idPanel);
        textGroup.add(pwPanel);
        textGroup.add(nicknamePanel);

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(textGroup, BorderLayout.WEST);
        inputPanel.add(imagePanel, BorderLayout.CENTER);

        registerListener();

        setLayout(new BorderLayout());
        FrameHelper.SignUpSetup(this, () -> {
            add(inputPanel, BorderLayout.NORTH);
            add(imageUploadBtn, BorderLayout.CENTER);
            add(btnGroupPanel, BorderLayout.SOUTH);
        });
    }

    private void registerListener(){
        backToSignInBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new SignIn();
            }
        });

        signUpBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!id.getText().toLowerCase().matches("^[a-z]{1}[a-z0-9]{3,10}$")){
                    JOptionPane.showMessageDialog(
                            SignUp.this,
                            "아이디는 영문으로 시작하여 영문과 숫자를 포함한 4~10자리이어야 합니다.",
                            "경고",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (!password.getText().toLowerCase().matches("^[a-z0-9]{6,12}$")){
                    JOptionPane.showMessageDialog(
                            SignUp.this,
                            "비밀번호는 영문과 숫자를 포함하여 6~12자리 입니다.",
                            "경고",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (nickname.getText().trim().isBlank()){
                    JOptionPane.showMessageDialog(
                            SignUp.this,
                            "별명이 공란입니다.",
                            "경고",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (!nickname.getText().matches("^[a-z0-9ㄱ-ㅎ|ㅏ-ㅣ|가-힣]{2,8}$")){
                    JOptionPane.showMessageDialog(
                            SignUp.this,
                            "별명은 특수문자를 제외한 2~8자리입니다.",
                            "경고",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                //TODO: 회원가입 서버로 요청
            }
        });
    }
}

