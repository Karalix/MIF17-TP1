package logo;


import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/** class JeuDeBalle.
*/
public class JeuDeBalle
{
   protected List<TortueAmelioree> joueuses;
   protected TortueBalle balle ;
   protected FeuilleDessin feuille ;

    public JeuDeBalle(FeuilleDessin feuille) {
      joueuses = new ArrayList<TortueAmelioree>();
      this.feuille = feuille ;
       
      balle = new TortueBalle();
      joueuses.add(new TortueAmelioree("Messi"));
      joueuses.add(new TortueAmelioree("Zidane"));
      joueuses.add(new TortueAmelioree("Thuram"));
      joueuses.add(new TortueAmelioree("Henry"));
      joueuses.add(new TortueAmelioree("Platini"));

      for(TortueAmelioree t : joueuses)
      {
         ajouterJoueusesEnAmies(t);
      }

	joueuses.get(0).receiveBalle(balle);
    }

   public void ajouterJoueusesEnAmies(TortueAmelioree tortue)
   {
      tortue.AddFriends(joueuses);
      tortue.RemoveFriend(tortue);
   }

   protected void jouerUnTour()
   {
	for(TortueAmelioree t : joueuses)
	{
	   t.jouer();
	}
   }

   public void jouer(int nbTours)
   {
        Thread th = new Thread(){
            public void run(){
               for(int i=0; i< nbTours;i++)
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

   public List<TortueAmelioree> getJoueuses()
   {
      return this.joueuses;
   }

   public TortueBalle getBalle()
   {
      return this.balle;
   }
}