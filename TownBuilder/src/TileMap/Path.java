/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TileMap;

import java.util.ArrayList;

/**
 *
 * @author Jamie
 */
public class Path {
    
    private ArrayList<Integer> pathArr = new ArrayList<Integer>();
    private boolean hitEnemy;

    public boolean isHitEnemy() {
        return hitEnemy;
    }

    public void setHitEnemy(boolean hitEnemy) {
        this.hitEnemy = hitEnemy;
    }

    public ArrayList<Integer> getPathArr() {
        return pathArr;
    }

    public void setPathArr(ArrayList<Integer> pathArr) {
        this.pathArr = pathArr;
    }
    
    public Path addInt(int i){
         pathArr.add(i);
         return this;
    }
    
}
