/*
 *
 */
package motionless;

import entity.Permeability;

public class Border extends MotionlessEntity {

    private static String IMAGE = "sprites\\Motionless\\border.png";
    private static char SPRITE = '#';
    private static Permeability PERMEABILITY = Permeability.BLOCKING;

    public Border() {
        super(SPRITE, IMAGE, PERMEABILITY);
    }

    @Override
    public String getFolder() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setFolder(String folder) {
        // TODO Auto-generated method stub

    }

    @Override
    public int getY() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setY(int y) {
        // TODO Auto-generated method stub

    }

    @Override
    public int getX() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setX(int x) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setHasMoved() {
        // TODO Auto-generated method stub

    }
}