package logo;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package logo;
//import logo.Tortue;
/**
 *
 * @author p1410147
 */
public class TortueAmelioree extends Tortue{
    protected String nom;
    protected List<TortueAmelioree> amies;
    protected static String nomDefaut = "Anonyme";
    protected TortueBalle maBalle = null ;
    
    protected static Random rand = new Random();

    public TortueAmelioree(){
        this(nomDefaut);
    }
    public TortueAmelioree(String nom){
        super();
        this.nom=nom;
        this.amies = new ArrayList<TortueAmelioree>();

    }

    public void EcrireNom(){
        System.out.println(this.nom);
    }

    public void AddFriend(TortueAmelioree t){
        amies.add(t);
    }

    public void AddFriends(List<TortueAmelioree> amies)
    {
       this.amies.addAll(amies);
    }

    public void RemoveFriend(Tortue t){
        amies.remove(t);
    }

    public double DistanceTortue(Tortue t){
        double d, deltaX, deltaY;

        deltaX = this.x - t.x;
        deltaY = this.y - t.y;
        d=Math.sqrt((deltaX*deltaX)+(deltaY*deltaY));
        //System.out.println(d);
        return d;
    }

    @Override
    public void avancer(int pas){
        super.avancer(pas);
        for(TortueAmelioree t : amies){
            if(DistanceTortue(t) < 15)
            {
                saluerAmie(t);
                //t.avancer(2);
            }
        }

    }

    protected void saluerAmie(TortueAmelioree t) {
        
        this.passerBalle(t);
    }

    public String getNom(){
        return this.nom ;
    }

    public void receiveBalle(TortueBalle balle)
    {
       maBalle = balle ;
       maBalle.setPosition(this.x, this.y);
    }
    public void passerBalle(TortueAmelioree destinataire)
    {
       if(maBalle == null)
       {
          return ;
       }
       
       System.out.println(destinataire.getNom() + " recoit la balle de " + this.getNom());
       destinataire.receiveBalle(maBalle);
       maBalle = null ;
    }

    public void jouer()
    {
       
       int distance = rand.nextInt(30);
       int angle = rand.nextInt(360);

       this.droite(angle);
       this.avancer(distance);
       if(maBalle != null)
       {
       	maBalle.setPosition(this.x, this.y);
       }
    }
}
