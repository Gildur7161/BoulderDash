/*
 *
 */
package mobile;

import java.util.Random;

public class Enemy extends MobileEntity {

    private static char SPRITE = 'X';
    private static String[] folderArray = { "sprites\\Mobile\\Butterfly", "sprites\\Mobile\\Blob" };
    private static Random ran = new Random();
    private static String s_ran = folderArray[ran.nextInt(folderArray.length)];

    public Enemy() {
        super(SPRITE, s_ran);
    }

    @Override
    public String getImage() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setImage(String image) {
        // TODO Auto-generated method stub

    }

}