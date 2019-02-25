import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
public class MainFrame extends JFrame {
    private ChessBoard chess;

    public MainFrame() {
        super();
        chess = new ChessBoard();

        createGUI();
    }

    private void createGUI() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(new Dimension(500, 500));

        add(chess, BorderLayout.CENTER);

        setLocationRelativeTo(null);
    }

    public static void main(String args[]) {
        new MainFrame().setVisible(true);
    }
}
