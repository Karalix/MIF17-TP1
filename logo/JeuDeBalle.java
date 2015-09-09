package logo;


import java.util.List;
import java.util.ArrayList;

/** class JeuDeBalle.
*/
public final class JeuDeBalle
{
   private List<TortueAmelioree> joueuses;
   private TortueBalle balle ;

   /** Constructor. */
   public JeuDeBalle()
   {
      joueuses = new ArrayList<TortueAmelioree>();
   }

   public void initJeu()
   {
      balle = new TortueBalle();
      joueuses.add(new TortueAmelioree("Messi"));
      joueuses.add(new TortueAmelioree("Zidane"));

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

   private void jouerUnTour()
   {
	for(TortueAmelioree t : joueuses)
	{
	   t.jouer();
	}
   }

   public void jouer(int nbTours)
   {
      for(int i=0; i< nbTours;i++)
      {
         jouerUnTour();
         /*
         try
         {
         	Thread.sleep(333);
         } catch(InterruptedException e)
         {
         }
         */
      }
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