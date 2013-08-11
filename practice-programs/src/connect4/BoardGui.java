package connect4;

import javax.swing.JFrame;

public class BoardGui extends JFrame {
	private static final long serialVersionUID = 1L;

	private BoardPanel panel = new BoardPanel();

	public BoardGui() {
		this.panel = new BoardPanel();
		this.add(this.panel);

		this.setSize(709, 635);
		this.setTitle("Connect Four");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}


}
