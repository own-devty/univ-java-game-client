package kr.ac.anyang.taeyang.panel.play_frame.info_componet;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.Optional;

public class Profile extends JPanel {
    private static int border = 1;

    // 방주인 프로필
    private ProfileDetails ownerUser;
    // 입장한 유저의 프로필
    private ProfileDetails enteredUser;

    private class ProfileDetails extends JPanel {
        Optional<Image> userImage;
        Optional<String> username;
        public ProfileDetails(Image userImage, String username) {
            this.userImage = Optional.ofNullable(userImage);
            this.username = Optional.ofNullable(username);
        }
    }

    public Profile() {
        //TODO: test profile details
        ownerUser = new ProfileDetails(null, "taeyang");
        enteredUser = new ProfileDetails(null, null);
        var tBorder = new TitledBorder("입장 정보");
        tBorder.setTitlePosition(TitledBorder.ABOVE_TOP);
        this.setBorder(tBorder);

        add(ownerUser);
        add(enteredUser);
    }
}
