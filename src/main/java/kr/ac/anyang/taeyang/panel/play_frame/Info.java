package kr.ac.anyang.taeyang.panel.play_frame;

import kr.ac.anyang.taeyang.panel.play_frame.info_componet.Chat;
import kr.ac.anyang.taeyang.panel.play_frame.info_componet.Profile;
import kr.ac.anyang.taeyang.panel.play_frame.info_componet.RoomButton;
import kr.ac.anyang.taeyang.utils.PanelInfo;

import javax.swing.*;
import java.awt.*;

public class Info extends JPanel {
    private static final int padding = 20;
    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints constraints = new GridBagConstraints();
    public Info() {
        setLayout(layout);
        setPreferredSize(new Dimension(PanelInfo.INFO_WIDTH, PanelInfo.PLAY_HEIGHT));
        setBorder(BorderFactory.createEmptyBorder(padding,padding,padding,padding));
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx=1.0;
        constraints.weighty=1.0;
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(new Profile(), constraints);
        constraints.weightx=1.0;
        constraints.weighty=5.0;
        constraints.gridx = 0;
        constraints.gridy = 1;
        add(new Chat(), constraints);
        constraints.weightx=1.0;
        constraints.weighty=1.0;
        constraints.gridx = 0;
        constraints.gridy = 2;
        add(new RoomButton(), constraints);
    }
}
