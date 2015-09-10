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
public class JeuEquipe extends JeuDeBalle {
    
    private EquipeTortue equipe1;
    private EquipeTortue equipe2;
    
    
    public JeuEquipe()
    {
        joueuses = new ArrayList<TortueAmelioree>();
        
        balle = new TortueBalle();
        
        equipe1 = new EquipeTortue("France");
        equipe2 = new EquipeTortue("Espagne");
        
        TortueEquipe t1 = new TortueEquipe("1", equipe1, this);
        t1.setPosition(500/6+50, 400/2-100);
        TortueEquipe t2 = new TortueEquipe("2", equipe2, this);
        t2.setPosition(500/6, 400/2);
        
        joueuses.add(t2);
        joueuses.add(t1);
        
        for (TortueAmelioree joueuse : joueuses) {
            ajouterJoueusesEnAmies(joueuse);
        }
        
        joueuses.get(0).receiveBalle(balle);
    }

    public EquipeTortue getEquipe1() {
        return equipe1;
    }

    public EquipeTortue getEquipe2() {
        return equipe2;
    }
    
}
