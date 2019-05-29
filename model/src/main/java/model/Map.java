/*
 *
 */
package model;

import java.util.Observable;
import java.util.Observer;

import contract.IMap;
import entity.Entity;
import entity.IEntity;
import mobile.MobileEntityFactory;
import motionless.MotionlessEntityFactory;

public class Map extends Observable implements IMap, Observer {

    private int height;
    private int viewWidth = 16, viewHeight = 16;
    private volatile IEntity[][] map;
    private volatile IEntity[][] viewMap = new Entity[this.getViewHeight()][this.getViewWidth()];
    private int width;

    /**
     * @param map
     */
    public Map(char[][] map) {
        this.setMap(new Entity[map.length][map[0].length]);
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                this.setOnTheMapXY(map[y][x], x, y);
            }
        }
        this.fillView();
    }

    @Override
    public void fillView() {
        IEntity character = this.findCharacter();
        for (int y = character.getY() - (this.viewHeight / 2); y < (character.getY() + (this.viewHeight / 2)); y++) {
            for (int x = character.getX() - (this.viewWidth / 2); x < (character.getX() + (this.viewWidth / 2)); x++) {
                try {
                    if ((y < this.getMap().length) && (x < this.getMap()[0].length) && (y >= 0) && (x >= 0)
                            && (this.getOnTheMapXY(x, y) != null)) {
                        this.setOnTheViewMapXY(this.getOnTheMapXY(x, y),
                                x - (character.getX() - (this.getViewWidth() / 2)),
                                y - (character.getY() - (this.getViewHeight() / 2)));
                    } else if ((y < this.getMap().length) && (x < this.getMap()[0].length) && (y >= 0) && (x >= 0)
                            && (this.getOnTheMapXY(x, y) != null)) {
                        this.setOnTheViewMapXY(this.getOnTheMapXY(x, y),
                                x - (character.getX() - (this.getViewWidth() / 2)),
                                y - (character.getY() - (this.getViewHeight() / 2)));
                    } else {
                        this.setOnTheViewMapXY(MotionlessEntityFactory.createDestructibleBlock(),
                                x - (character.getX() - (this.getViewWidth() / 2)),
                                y - (character.getY() - (this.getViewHeight() / 2)));
                    }
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }
        }
        this.setChanged();
        this.notifyObservers();
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public IEntity[][] getMap() {
        return this.map;
    }

    @Override
    public Observable getObservable() {

        return this;
    }

    @Override
    public IEntity findCharacter() {
        int x = 0, y = 0;
        for (y = 0; y < this.getMap().length; y++) {
            for (x = 0; x < this.getMap()[y].length; x++) {
                if (this.getOnTheMapXY(x, y).getClass() == MobileEntityFactory.createCharacter().getClass()) {
                    return this.getOnTheMapXY(x, y);
                }
            }
        }
        return null;
    }

    /**
     * @param x
     * @param y
     */
    @Override
    public IEntity getOnTheMapXY(int x, int y) {

        return this.getMap()[y][x];
    }

    @Override
    public IEntity getOnTheViewMapXY(int x, int y) {

        return this.getViewMap()[y][x];
    }

    public int getViewHeight() {
        return this.viewHeight;
    }

    @Override
    public IEntity[][] getViewMap() {
        return this.viewMap;
    }

    public int getViewWidth() {
        return this.viewWidth;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    private void setMap(IEntity[][] map) {
        this.map = map;
    }

    @Override
    public void setOnTheMapXY(IEntity entity, int x, int y) {
        this.getMap()[y][x] = entity;
    }

    @Override
    public void setOnTheViewMapXY(IEntity entity, int x, int y) {
        this.getViewMap()[y][x] = entity;
    }

    @Override
    public void setOnTheMapXY(char c, int x, int y) {
        if (MotionlessEntityFactory.createEntity(c) != null) {
            this.setOnTheMapXY(MotionlessEntityFactory.createEntity(c), x, y);
            this.getOnTheMapXY(x, y).setY(y);
            this.getOnTheMapXY(x, y).setX(x);
            this.getOnTheMapXY(x, y).setObserver(this);
        } else if (MobileEntityFactory.createEntity(c) != null) {
            this.setOnTheMapXY(MobileEntityFactory.createEntity(c), x, y);
            this.getOnTheMapXY(x, y).setY(y);
            this.getOnTheMapXY(x, y).setX(x);
            this.getOnTheMapXY(x, y).setObserver(this);
        } else {
            NullPointerException e = new NullPointerException();
            e.printStackTrace();
        }
    }

    public void setViewHeight(int viewHeight) {
        this.viewHeight = viewHeight;
    }

    @Override
    public void setViewMap(IEntity[][] viewMap) {
        this.viewMap = viewMap;
    }

    public void setViewWidth(int viewWidth) {
        this.viewWidth = viewWidth;
    }

    /**
     * @param width
     */
    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void update(Observable o, Object arg) {
        // TODO Auto-generated method stub
        this.setChanged();
        this.notifyObservers();
    }

}