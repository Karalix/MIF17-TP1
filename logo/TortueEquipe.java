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
    private EquipeTortue equipe;
    private JeuEquipe jeu ;

    public TortueEquipe(String nom, EquipeTortue equipe, JeuEquipe jeu) {
        super(nom);
        this.equipe = equipe ;
        this.jeu = jeu ;
    }

    public String getNomEquipe() {
        return this.equipe.getNom();
    }
    
    

    @Override
    protected void saluerAmie(TortueAmelioree t) {
        if(((TortueEquipe)t).getNomEquipe() == this.getNomEquipe())
        {
            super.saluerAmie(t);
        } else {
            if(t.maBalle != null && rand.nextInt(10)<3)//Si l'adversaire possède la balle, il y a 50% de chance de récupérer la balle
            {
                t.passerBalle(this);
                System.out.println(this.getNom()+ " a contré "+t.getNom()+" et a récupéré la balle");
            }
        }
    }

    @Override
    public void jouer() {
        int angle = 0 ;
        int dist = rand.nextInt(30) ;
        //si j'ai la balle, je m'éloigne du plus proche adversaire
        if(maBalle != null)
        {
            TortueEquipe nearestOpponent = getNearestOpponent();
            if(nearestOpponent == null)
            {
                System.out.println("Je ne joue contre aucun adversaire, à quoi rime cette mise en scène ? Jouer n'a aucune saveur sans adversaire, sans obstacle à surpasser.");
                return ;
            }
            int angleOppose = (int)calculateAngleToFaceTurtleByTurningToRight(nearestOpponent);
            angle = angleOppose < 0 ? angleOppose + 180 : angleOppose -180 ;
        } else {//si j'ai pas la balle, je me rapproche de la balle
            if(jeu.balle == null)
            {
                System.out.println("Je joue sans aucune balle ? Ô quelle cruauté de mon créateur de m'avoir conçu dans un unique but sans toutefois me donner les moyens pour l'accomplir !");
                return ;
            }
            angle = (int)calculateAngleToFaceTurtleByTurningToRight(jeu.balle);
        }
        
        this.droite(angle);
        this.avancer(dist);
    }

    private TortueEquipe getNearestOpponent() {
        TortueEquipe nearestOpponent = null ;
        double nearestOpponentDistance = 0;
        boolean first = true ;
        
        for(Tortue t : jeu.getJoueuses())
        {   
            TortueEquipe te = (TortueEquipe)t ;
            if(te.getNomEquipe() == this.getNomEquipe())
            {
                continue;
            }
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
    
    private double calculateAngleToFaceTurtleByTurningToRight(Tortue t)
    {
        double deltay = t.y - this.y ;
        double deltaX = t.x - this.x ;
        
        double phi = Math.atan2(deltay, deltaX);
        
        
        return (phi*(180/Math.PI))-dir ;
    }

    @Override
    public void passerBalle(TortueAmelioree destinataire) {
        super.passerBalle(destinataire); //To change body of generated methods, choose Tools | Templates.
        if(((TortueEquipe)destinataire).getNomEquipe() != this.getNomEquipe())
        {
            equipe.resetScore();
        }
    }

    @Override
    public void receiveBalle(TortueBalle balle) {
        super.receiveBalle(balle); //To change body of generated methods, choose Tools | Templates.
        equipe.incScore();
        droite(1);
        //avancer(3);
    }
    
    
    
    
}
