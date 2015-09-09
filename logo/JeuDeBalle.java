package logo;


import java.util.List;
import java.util.ArrayList;

/** class JeuDeBalle.
*/
public class JeuDeBalle
{
   protected List<TortueAmelioree> joueuses;
   protected TortueBalle balle ;

    public JeuDeBalle() {
      joueuses = new ArrayList<TortueAmelioree>();
       
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