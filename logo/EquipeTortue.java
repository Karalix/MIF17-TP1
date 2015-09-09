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

    public EquipeTortue(String nomEquipe) {
        this.nomEquipe = nomEquipe;
        this.joueuses = new ArrayList<>();
    }
    
    public List<TortueEquipe> getJoueuses()
    {
        return joueuses ;
    }
    
    public void addJoueuse(TortueEquipe joueuse)
    {
        joueuses.add(joueuse);
    }
    
}
