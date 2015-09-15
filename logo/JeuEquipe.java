/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logo;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alix
 */
public class JeuEquipe extends JeuDeBalle {
    
    private EquipeTortue equipe1;
    private EquipeTortue equipe2;
    public boolean  gameFinished = false;
    
    
    public JeuEquipe(FeuilleDessin feuille)
    {
        super(feuille);
        joueuses = new ArrayList<TortueAmelioree>();
        
        balle = new TortueBalle();
        
        equipe1 = new EquipeTortue("France", 1);
        equipe2 = new EquipeTortue("Espagne", 4);
        
        TortueEquipe t1 = new TortueEquipe("1", equipe1, this);
        t1.setPosition(500/6, 400/2-100);
        TortueEquipe t3 = new TortueEquipe("3", equipe1, this);
        t3.setPosition(500/6, 400/2-80);
        TortueEquipe t4 = new TortueEquipe("4", equipe1, this);
        t4.setPosition(500/6, 400/2-60);
        TortueEquipe t5 = new TortueEquipe("5", equipe2, this);
        t5.setPosition(600/6, 400/2-100);
        TortueEquipe t6 = new TortueEquipe("6", equipe2, this);
        t6.setPosition(600/6, 400/2-80);
        TortueEquipe t2 = new TortueEquipe("2", equipe2, this);
        t2.setPosition(600/6, 400/2-60);
        
        joueuses.add(t6);
        joueuses.add(t5);
        joueuses.add(t4);
        joueuses.add(t3);
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

    @Override
    protected void jouerUnTour() {
         for(TortueAmelioree te : joueuses)
         {
             te.jouer();
             if(equipe1.getScore() >= 10)
             {
                 System.out.println("Fin de la partie, "+equipe1.getNom()+" gagne.");
                 System.out.println(equipe1.getScore()+" points.");
                 gameFinished = true ;
                 break ;
             } else if(equipe2.getScore() >= 10)
             {
                 System.out.println("Fin de la partie, "+equipe2.getNom()+" gagne.");
                 System.out.println(equipe2.getScore()+" points.");
                 gameFinished = true ;
                 break ;
             }
         }
    }

    public void jouer() {
        Thread th = new Thread(){
            public void run(){
               while(!gameFinished)
               {
                   jouerUnTour();
                   feuille.repaint();
                   try {
                       Thread.sleep(200);
                   } catch (InterruptedException ex) {
                       Logger.getLogger(JeuDeBalle.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            }
        };
        th.start();
    }
    
    
    
    
}
