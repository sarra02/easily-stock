package tn.sarra.easily_stock.data;

import java.util.ArrayList;
import java.util.List;


public class AppConstants {
	
    public static final String[] PAYS = {"tunisie", "algerie"};
	public static final String[] VILLES = {"tunis", "sfax", "sousse", "alger"};
	
	public static final List<Pays> PAYS_VILLES = new ArrayList<Pays>();
	
	public static final String[] TUN_VILLES = {"tunis","sfax","sousse"};
	public static final String [] ALG_VILLES = {"alger"};
	
	static final Pays TUN = new Pays("tunisie",TUN_VILLES);
	static final Pays ALG = new Pays("algerie",ALG_VILLES);
	   static {
		   PAYS_VILLES.add(TUN);
		   PAYS_VILLES.add(ALG);
	   }
	 
	
}
