package Model.Heros;

public class Coordinates {
        private int _yPosition;
        private int _xPosition;

        public Coordinates(int yPosition, int xPosition, Hero hero) {
            if (yPosition < 0)
                this._yPosition = 0;
            else
                this._yPosition = yPosition;
            if (xPosition < 0)
                this._xPosition = 0;
            else
                this._xPosition = xPosition;
        }

        public int get_xPosition() {
            return this._xPosition;
        }

        public int get_yPosition() {
            return _yPosition;
        }
    }

