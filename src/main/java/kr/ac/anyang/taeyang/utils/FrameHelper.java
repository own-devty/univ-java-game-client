package kr.ac.anyang.taeyang.utils;

import kr.ac.anyang.taeyang.panel.play_frame.Omok;

import javax.swing.*;
import java.awt.*;


public class FrameHelper {
    private static final int PLAY_WIDTH = PanelInfo.PLAY_WIDTH + PanelInfo.INFO_WIDTH, PLAY_HEIGHT = Omok.CELL * Omok.SIZE + 56;
    private static final int SIGNIN_WIDTH = 270, SIGNIN_HEIGHT = 160;
    private static final int SIGNUP_WIDTH = 270, SIGNUP_HEIGHT = 200;
    private static final int ROOMS_WIDTH = 270, ROOMS_HEIGHT = 200;

    public interface JFrameHelperInterface {
        void next();
    }

    public static void PlaySetup(JFrame frame, JFrameHelperInterface func) {
        setLayoutSize(frame, PLAY_WIDTH, PLAY_HEIGHT);
        func.next();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void SignInSetup(JFrame frame, JFrameHelperInterface func) {
        setLayoutSize(frame, SIGNIN_WIDTH, SIGNIN_HEIGHT);
        func.next();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void SignUpSetup(JFrame frame, JFrameHelperInterface func) {
        setLayoutSize(frame, SIGNUP_WIDTH, SIGNUP_HEIGHT);
        func.next();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void RoomsSetup(JFrame frame, JFrameHelperInterface func) {
        setLayoutSize(frame, ROOMS_WIDTH, ROOMS_HEIGHT);
        func.next();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static void setLayoutSize(JFrame frame, int width, int height) {
        frame.setSize(width, height);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }
}

