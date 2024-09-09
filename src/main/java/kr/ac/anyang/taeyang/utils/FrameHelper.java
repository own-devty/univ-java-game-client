package kr.ac.anyang.taeyang.utils;

import kr.ac.anyang.taeyang.panel.play_frame.Omok;

import javax.swing.*;
import java.awt.*;


public class FrameHelper {
    private static final int WIDTH = PanelInfo.PLAY_WIDTH + PanelInfo.INFO_WIDTH, HEIGHT = Omok.CELL * Omok.SIZE + 56;

    public interface JFrameHelperInterface {
        void next();
    }

    public static void DefaultSetup(JFrame frame, JFrameHelperInterface func) {
        frame.setSize(WIDTH, HEIGHT);
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        func.next();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

