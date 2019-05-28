/*
 *
 */
package model;

import java.util.Observable;

import contract.IMap;
import entity.Entity;
import entity.IEntity;
import mobile.MobileEntityFactory;
import motionless.MotionlessEntityFactory;

public class Map implements IMap {

    private int height;
    private int viewWidth = 15, viewHeight = 15;
    private IEntity[][] map, viewMap = new Entity[this.getViewHeight()][this.getViewWidth()];
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
        for (int y = 0; y < this.getViewMap().length; y++) {
            for (int x = 0; x < this.getViewMap()[y].length; x++) {
                this.getViewMap()[y][x] = MotionlessEntityFactory.createDestructibleBlock();
            }
        }
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    private IEntity[][] getMap() {
        return this.map;
    }

    @Override
    public Observable getObservable() {

        return null;
    }

    /**
     * @param x
     * @param y
     */
    @Override
    public IEntity getOnTheMapXY(int x, int y) {

        return null;
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
    public void moveDown() {

    }

    @Override
    public void moveLeft() {

    }

    @Override
    public void moveRight() {

    }

    @Override
    public void moveUp() {

    }

    /**
     * @param height
     */
    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    private void setMap(IEntity[][] map) {
        this.map = map;
    }

    @Override
    public void setMobileHasChanged() {

    }

    @Override
    public void setOnTheMapXY(char c, int x, int y) {
        if (MotionlessEntityFactory.createEntity(c) != null) {
            this.getMap()[y][x] = MotionlessEntityFactory.createEntity(c);
        } else if (MobileEntityFactory.createEntity(c) != null) {
            this.getMap()[y][x] = MobileEntityFactory.createEntity(c);
        } else {
            NullPointerException e = new NullPointerException();
            e.printStackTrace();
        }
    }

    /**
     * @param entity
     * @param x
     * @param y
     */
    @Override
    public void setOnTheMapXY(IEntity entity, int x, int y) {

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

}