package model;

public class Player {
	// create player coordinate variable
		private int x;

		private int y;

		// set all movement to false
		private boolean[] direction = {false, false, false, false };;

		private boolean shift;

		public Player() {
			this.x = 0;
			this.y = 0;
			this.shift = false;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public boolean getDirection(int numb) {
			return direction[numb];
		}

		public void setDirection(int numb, boolean direction) {
			this.direction[numb] = direction;
		}

		public boolean isShift() {
			return shift;
		}

		public void setShift(boolean shift) {
			this.shift = shift;
		}
		
		public boolean isMoving() {
			for(int i = 0;i<4;i++)
				if(direction[i] == true)
					return true;
			return false;
		}
		
}
