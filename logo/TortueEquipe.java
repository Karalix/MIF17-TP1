/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logo;

import java.util.List;

/**
 *
 * @author Alix
 */
public class TortueEquipe extends TortueAmelioree {
    private String nomEquipe;
    private EquipeTortue equipe;
    private JeuEquipe jeu ;

    public TortueEquipe(String nomEquipe, String nom, EquipeTortue equipe, JeuEquipe jeu) {
        super(nom);
        this.nomEquipe = nomEquipe;
        this.equipe = equipe ;
        this.jeu = jeu ;
    }

    public String getNomEquipe() {
        return nomEquipe;
    }
    
    

    @Override
    protected void saluerAmie(TortueAmelioree t) {
        if(((TortueEquipe)t).getNomEquipe() == this.getNomEquipe())
        {
            super.saluerAmie(t);
        } else {
            if(t.maBalle != null && rand.nextBoolean())//Si l'adversaire possède la balle, il y a 50% de chance de récupérer la balle
            {
                t.passerBalle(this);
                System.out.println(this.getNom()+ " a contré "+t.getNom()+" et a récupéré la balle");
            }
        }
    }

    @Override
    public void jouer() {
        //si j'ai la balle, je m'éloigne du plus proche adversaire
        if(maBalle != null)
        {
            getNearestOpponent();
        }
        //si j'ai pas la balle, je me rapproche de la balle
    }

    private TortueEquipe getNearestOpponent() {
        TortueEquipe nearestOpponent = null ;
        double nearestOpponentDistance = 0;
        boolean first = true ;
        
        for(Tortue t : jeu.getJoueuses())
        {   
            TortueEquipe te = (TortueEquipe)t ;
            double distance = DistanceTortue(t);
            if(first && te.getNomEquipe() != this.getNomEquipe())
            {
                nearestOpponentDistance = distance ;
                nearestOpponent = te ;
                first = false ;
            } else {
                if(distance < nearestOpponentDistance && te.getNomEquipe() != this.getNomEquipe())
                {
                   nearestOpponentDistance = distance ;
                   nearestOpponent = te ;
                }
            }
        }
        
        return nearestOpponent ;
    }
    
    private boolean isFromMyTeam(TortueEquipe t)
    {
        return false ;
    }
}
