package view;

import model.entity.Avatar;
import javax.swing.JComponent;

public class EntityView extends JComponent{
	private Avatar avatar;

	public EntityView(Avatar avatar) {
		this.avatar = avatar;
		this.setVisible(true);
		
	}

}
