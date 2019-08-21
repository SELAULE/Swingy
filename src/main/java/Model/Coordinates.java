package Model;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Coordinates {

        private int _yPosition;
        private int _xPosition;

        public Coordinates(int yPosition, int xPosition) {
            if (yPosition < 0)
                this._yPosition = 0;
            else
                this._yPosition = yPosition;
            if (xPosition < 0)
                this._xPosition = 0;
            else
                this._xPosition = xPosition;
        }

    }

