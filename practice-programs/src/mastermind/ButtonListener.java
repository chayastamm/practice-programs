package mastermind;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		if (arg0.getSource() instanceof ColorButton) {
			ColorButton button = (ColorButton) arg0.getSource();
			button.setPressed();
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

}
