package kr.ac.anyang.taeyang.panel.play_frame;

import kr.ac.anyang.taeyang.panel.play_frame.info_componet.Chat;
import kr.ac.anyang.taeyang.panel.play_frame.info_componet.Profile;
import kr.ac.anyang.taeyang.panel.play_frame.info_componet.RoomButton;
import kr.ac.anyang.taeyang.utils.PanelInfo;

import javax.swing.*;
import java.awt.*;

public class Info extends JPanel {
    private static final int padding = 20;

    public Info() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(PanelInfo.INFO_WIDTH, PanelInfo.PLAY_HEIGHT));
        setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));
        add(new Profile(), BorderLayout.NORTH);
        add(new Chat(), BorderLayout.CENTER);
        add(new RoomButton(), BorderLayout.SOUTH);
    }
}
