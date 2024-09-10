package kr.ac.anyang.taeyang.frame;

import kr.ac.anyang.taeyang.utils.FrameHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rooms extends JFrame {
    JButton createRoomBtn = new JButton("방만들기");
    JButton logoutBtn = new JButton("로그아웃");

    private class Room {
        private final int roomID;
        private final String roomName;
        private final String ownerNickname;
        private final int enteredUser;

        public Room(int roomID, String roomName, String ownerNickname, int enteredUser) {
            this.roomID = roomID;
            this.roomName = roomName;
            this.ownerNickname = ownerNickname;
            this.enteredUser = enteredUser;
        }
    }

    public Rooms() {
        JScrollPane roomList = new JScrollPane();
        //TODO 서버에서 서버 목록을 받아온후 loop

        JPanel groupBtnPanel = new JPanel();
        groupBtnPanel.add(createRoomBtn);
        groupBtnPanel.add(logoutBtn);

        registerListener();

        setLayout(new BorderLayout());
        FrameHelper.RoomsSetup(this, () -> {
            add(roomList, BorderLayout.CENTER);
            add(groupBtnPanel, BorderLayout.SOUTH);
        });
    }

    private void registerListener() {
        createRoomBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String roomName = JOptionPane.showInputDialog(Rooms.this, "방 제목을 입력해주세요.", "방 생성", JOptionPane.PLAIN_MESSAGE);
                //TODO 서버에 유저정보 및 방 이름 전달하여 방생성
            }
        });

        logoutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO 서버에 로그아웃 요청

                dispose();
                new SignIn();
            }
        });
    }
}
