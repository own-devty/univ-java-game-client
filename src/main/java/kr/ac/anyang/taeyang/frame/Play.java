package kr.ac.anyang.taeyang.frame;

import kr.ac.anyang.taeyang.panel.play_frame.Info;
import kr.ac.anyang.taeyang.panel.play_frame.Omok;
import kr.ac.anyang.taeyang.repository.Mysql;
import kr.ac.anyang.taeyang.utils.FrameHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Play extends JFrame {
    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints constraints = new GridBagConstraints();
    public Play() {
        //TODO DB TEST
        Mysql postgres = new Mysql();
        setLayout(layout);
        FrameHelper.DefaultSetup(this, () -> {
            constraints.fill = GridBagConstraints.BOTH;
            constraints.weightx=4.0;
            constraints.weighty=1.0;
            constraints.gridx = 0;
            constraints.gridy = 0;
            Omok omok = new Omok();
            add(omok, constraints);
            constraints.weightx=1.0;
            constraints.weighty=1.0;
            constraints.gridx = 1;
            constraints.gridy = 0;
            add(new Info(), constraints);
            addMouseListener(new MouseEventHandler(omok));
        });
    }

    class MouseEventHandler extends MouseAdapter {
        private final Omok omok;

        public MouseEventHandler(Omok omok) {
            this.omok = omok;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);

            int x = (int) Math.round(e.getX() / (double) Omok.CELL) - 1;
            int y = (int) Math.round(e.getY() / (double) Omok.CELL) - 2;

            if (x < 0 || x > Omok.SIZE - 1 || y < 0 || y > Omok.SIZE-1) return;

            //이미 놓여진 경우 return
            if (!omok.Map.isEmpty(y, x)) return;

            omok.Map.setStone(y, x);
            omok.repaint();
            short winner = omok.Map.winnerAlgorithm(y,x);
            omok.Map.changeTurn();
            if (winner == omok.Map.BLACK) {
                JOptionPane.showMessageDialog(omok, "흑돌이 이겼습니다.");
                omok.Map.clear();
            }else if (winner == omok.Map.WHITE){
                JOptionPane.showMessageDialog(omok, "백돌이 이겼습니다.");
                omok.Map.clear();
            }
        }
    }
}
