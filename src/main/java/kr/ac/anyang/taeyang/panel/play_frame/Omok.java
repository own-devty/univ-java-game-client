package kr.ac.anyang.taeyang.panel.play_frame;

import kr.ac.anyang.taeyang.utils.PanelInfo;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Omok extends JPanel {
    public static final int CELL = 30, SIZE = 19, STONE_SIZE = 28;
    public Map Map = new Map();

    public class Map {
        private short[][] map;
        public static final short BLACK = 1, WHITE = -1, EMPTY = 0;
        private boolean turn = true; //true-> 흑   false-> 백

        public Map() {
            map = new short[SIZE][];
            for (int i = 0; i < map.length; i++) {
                map[i] = new short[SIZE];
            }
        }

        public void clear() {
            for(short row[] : map){
                Arrays.fill(row, EMPTY);
            }
            repaint();
        }

        //착수된 돌을 기준으로 상 하 좌 우 좌상 좌하 우상 우하의 방향으로 돌 5개 놓여있는지 검사
        public short winnerAlgorithm(int y, int x) {
            short nowStoneColor = turn ? BLACK : WHITE;
            short winner = EMPTY;
            //움직일 수 있는 범위 : 상 하 좌 우 좌상 좌하 우상 우하
            int moves[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {1, -1}, {-1, 1}, {1, 1}};
            out:for (int[] move : moves) {
                //2번째 수부터 5번째 수까지 검사
                int cnt = 1;
                int tempy = y;
                int tempx = x;
                for (int i = 1; i < 5; ++i) {
                    tempy += move[0];
                    tempx += move[1];
                    // 바둑판을 벗어나는지 검사
                    if (tempx < 0 || tempx > Omok.SIZE - 1 || tempy < 0 || tempy > Omok.SIZE - 1) break;
                    // 착수한 돌과 색이 다른지 검사
                    if (map[tempy][tempx] != nowStoneColor) break;
                    if (++cnt == 5) {
                        winner = nowStoneColor;
                        break out;
                    }
                }
            }
            return winner;
        }

        public boolean isEmpty(int y, int x) {
            if (map[y][x] == 0) {
                return true;
            }
            return false;
        }

        public void setStone(int y, int x) {
            if (turn) {
                map[y][x] = BLACK;
            } else {
                map[y][x] = WHITE;
            }
        }

        public short getStone(int y, int x) {
            if (map[y][x] == BLACK) {
                return BLACK;
            } else if (map[y][x] == WHITE) {
                return WHITE;
            }
            return EMPTY;
        }

        public void changeTurn() {
            turn = !turn;
        }
    }

    public Omok() {
//        setPreferredSize(new Dimension(PanelInfo.PLAY_WIDTH, PanelInfo.PLAY_HEIGHT));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(new Color(206, 167, 61));

        // 오목판을 그림
        for (int i = 1; i <= SIZE; ++i) {
            g.drawLine(CELL, i * CELL, CELL * SIZE, i * CELL);
            g.drawLine(i * CELL, CELL, i * CELL, CELL * SIZE);
        }

        for (int y = 0; y < SIZE; ++y) {
            for (int x = 0; x < SIZE; ++x) {
                if (Map.getStone(y, x) == Map.BLACK) {
                    g.setColor(Color.BLACK);
                    g.fillOval(x * CELL + 15, y * CELL + 15, STONE_SIZE, STONE_SIZE);
                } else if (Map.getStone(y, x) == Map.WHITE) {
                    g.setColor(Color.WHITE);
                    g.fillOval(x * CELL + 15, y * CELL + 15, STONE_SIZE, STONE_SIZE);
                }
            }
        }
    }

}
