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
        equipe1 = new EquipeTortue("France");
        equipe2 = new EquipeTortue("Espagne");
    }

    public EquipeTortue getEquipe1() {
        return equipe1;
    }

    public EquipeTortue getEquipe2() {
        return equipe2;
    }
    
}
