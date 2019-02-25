import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class ChessBoard extends JComponent implements MouseListener {
    private Image images[][];
    private Piece board[][];

    private class Cell {
        public int x;
        public int y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private Cell selected;

    public ChessBoard() {
        try {
            images = new Image[2][6];

            images[0][0] = ImageIO.read(getClass().getResource("/Chess/images/wking.png"));
            images[0][1] = ImageIO.read(getClass().getResource("/Chess/images/wqueen.png"));
            images[0][2] = ImageIO.read(getClass().getResource("/Chess/images/wrook.png"));
            images[0][3] = ImageIO.read(getClass().getResource("/Chess/images/wbishop.png"));
            images[0][4] = ImageIO.read(getClass().getResource("/Chess/images/wkingth.png"));
            images[0][5] = ImageIO.read(getClass().getResource("/Chess/images/wpawn.png"));

            images[1][0] = ImageIO.read(getClass().getResource("/Chess/images/bking.png"));
            images[1][1] = ImageIO.read(getClass().getResource("/Chess/images/bqueen.png"));
            images[1][2] = ImageIO.read(getClass().getResource("/Chess/images/brook.png"));
            images[1][3] = ImageIO.read(getClass().getResource("/Chess/images/bbishop.png"));
            images[1][4] = ImageIO.read(getClass().getResource("/Chess/images/bkingth.png"));
            images[1][5] = ImageIO.read(getClass().getResource("/Chess/images/bpawn.png"));
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        board = new Piece[8][8];

        init();
        addMouseListener(this);
    }

    private void init() {
        for(int y = 0; y < 8; y++) {
            for(int x = 0; x < 8; x++) {
                switch(y) {
                    case 0:
                        switch(x) {
                            case 0:
                            case 7:
                                board[x][y] = new Piece(Piece.BLACK, Piece.PIECE_ROOK);
                                continue;

                            case 1:
                            case 6:
                                board[x][y] = new Piece(Piece.BLACK, Piece.PIECE_KNIGHT);
                                continue;

                            case 2:
                            case 5:
                                board[x][y] = new Piece(Piece.BLACK, Piece.PIECE_BISHOP);
                                continue;

                            case 3:
                                board[x][y] = new Piece(Piece.BLACK, Piece.PIECE_QUEEN);
                                continue;

                            case 4:
                                board[x][y] = new Piece(Piece.BLACK, Piece.PIECE_KING);
                                continue;
                        }
                        break;

                    case 1:
                        board[x][y] = new Piece(Piece.BLACK, Piece.PIECE_PAWN);
                        continue;

                    case 6:
                        board[x][y] = new Piece(Piece.WHITE, Piece.PIECE_PAWN);
                        continue;

                    case 7:
                        switch(x) {
                            case 0:
                            case 7:
                                board[x][y] = new Piece(Piece.WHITE, Piece.PIECE_ROOK);
                                continue;

                            case 1:
                            case 6:
                                board[x][y] = new Piece(Piece.WHITE, Piece.PIECE_KNIGHT);
                                continue;

                            case 2:
                            case 5:
                                board[x][y] = new Piece(Piece.WHITE, Piece.PIECE_BISHOP);
                                continue;

                            case 3:
                                board[x][y] = new Piece(Piece.WHITE, Piece.PIECE_QUEEN);
                                continue;

                            case 4:
                                board[x][y] = new Piece(Piece.WHITE, Piece.PIECE_KING);
                                continue;
                        }
                        break;
                }

                board[x][y] = null;
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        int width = getSize().width / 8;
        int height = getSize().height / 8;

        for(int y = 0; y < 8; y++) {
            for(int x = 0; x < 8; x++) {
                Rectangle rect = new Rectangle(x * width, y * height, width, height);

                if(y % 2 == 0) {
                    if(x % 2 == 0)
                        g2d.setColor(Color.WHITE);
                    else
                        g2d.setColor(Color.GRAY);
                }
                else {
                    if(x % 2 == 0)
                        g2d.setColor(Color.GRAY);
                    else
                        g2d.setColor(Color.WHITE);
                }

                g2d.fill(rect);

                if(board[x][y] != null) {
                    Piece piece = board[x][y];
                    g2d.drawImage(images[piece.getColor()][piece.getType()], rect.x, rect.y, rect.width, rect.height, null);
                }
            }
        }
    }

    public void mouseClicked(MouseEvent event) {
        int width = getSize().width / 8;
        int height = getSize().height / 8;

        int x = event.getX() / width;
        int y = event.getY() / height;

        if(selected == null) {
            if(board[x][y] != null) selected = new Cell(x, y);
        }
        else {
            Piece piece = board[selected.x][selected.y];

            if(board[x][y] != null && board[x][y].getColor() == piece.getColor()) {
                selected = null;
                return;
            }

            board[x][y] = piece;
            board[selected.x][selected.y] = null;
            selected = null;

            repaint();
        }
    }

    public void mousePressed(MouseEvent event) {

    }

    public void mouseReleased(MouseEvent event) {

    }

    public void mouseEntered(MouseEvent event) {

    }

    public void mouseExited(MouseEvent event) {

    }

}