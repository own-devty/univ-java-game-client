package kr.ac.anyang.taeyang.panel.play_frame.info_componet;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Optional;

public class Profile extends JPanel {
    private static int border = 1;

    // 방주인 프로필
    private ProfileDetails ownerUser;
    // 입장한 유저의 프로필
    private ProfileDetails enteredUser;
    private final GridBagLayout layout = new GridBagLayout();
    private final GridBagConstraints constraints = new GridBagConstraints();

    private class ProfileDetails extends JPanel {
        Optional<BufferedImage> userImage;
        Optional<String> username;
        public ProfileDetails(BufferedImage userImage, String username) {
            this.userImage = Optional.ofNullable(userImage);
            this.username = Optional.ofNullable(username);

            JPanel panel = new JPanel(new BorderLayout());

            panel.setBorder(new TitledBorder(""));
            JLabel image = new JLabel();
            image.setIcon(new ImageIcon(this.userImage.orElse(new BufferedImage(70,100, BufferedImage.TYPE_INT_BGR))));
            panel.add(image, BorderLayout.NORTH);
            panel.add(new JLabel(this.username.orElse("빈 자리"), SwingConstants.CENTER), BorderLayout.SOUTH);
            add(panel);
        }
    }

    public Profile() {
        setLayout(layout);
        var tBorder = new TitledBorder("입장 정보");
        tBorder.setTitlePosition(TitledBorder.ABOVE_TOP);
        setBorder(tBorder);

        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;

        //TODO: test profile details
        ownerUser = new ProfileDetails(null, "taeyang");
        enteredUser = new ProfileDetails(null, null);

        constraints.gridx = 0;
        constraints.gridy = 0;
        add(ownerUser, constraints);
        constraints.gridx = 1;
        constraints.gridy = 0;
        add(enteredUser, constraints);
    }
}
