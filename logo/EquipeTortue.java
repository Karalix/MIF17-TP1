/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alix
 */
public class EquipeTortue {
    private String nomEquipe;
    private List<TortueEquipe> joueuses ;
    private int currentScore ;

    public EquipeTortue(String nomEquipe) {
        this.nomEquipe = nomEquipe;
        this.joueuses = new ArrayList<>();
        this.currentScore = 0 ;
    }
    
    public List<TortueEquipe> getJoueuses()
    {
        return joueuses ;
    }
    
    public void addJoueuse(TortueEquipe joueuse)
    {
        joueuses.add(joueuse);
    }

    String getNom() {
        return nomEquipe ;
    }
    
    public void resetScore()
    {
        currentScore = 0 ;
    }
    
    public int getScore()
    {
        return currentScore ;
    }
    
    public void incScore()
    {
        currentScore ++ ;
    }
}
