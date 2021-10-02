// Name: Luttrell, Bryan                CMIS 141/6382           Date: 10/02/2021 <-- creation date
// Week 7 - Arrays

// Libraries
import java.util.Scanner;
import java.io.PrintWriter;
import java.text.DecimalFormat;

/**
*	Chex mix recipe...changing recipe for portion sizes!
*	Full credit for recipe goes to: Barbara Curry
*	Recipe source: https://www.butterandbaggage.com/wprm_print/21039
*       @author Bryan Luttrell
*       @version %I%, %G%
*/

public class Disc7 {

	// create public scanners for use in all methods.
	public static final Scanner SCANBYTE = new Scanner(System.in);
	public static final String line = "-";

	/**
	* program menu
	*/
	private static byte progMenu() {
		// initialize needed vars		
		byte sel = -1;
                String getSel = "How many batches would you like to make? ";

		// print menu
		System.out.println(line.repeat(45));
		System.out.println("\tHomemade Chex Mix Recipe");
		System.out.println(line.repeat(45));
		System.out.println("A batch of homemade Chex mix coated in a bold \n"
				  +"and buttery seasoning is an ideal snack. Great\n"
				  +"for road trips or back to school. It's an old \n"
				  +"fashioned snack that never goes out of style!!\n");
		System.out.print("\n" + getSel);
		
		// get validated input
                while (sel < 1 || sel > 3){
                        while (!SCANBYTE.hasNextByte()) {
                                System.out.print(getSel);
                                SCANBYTE.next();
                        }
                        sel = SCANBYTE.nextByte();
                        if (sel < 1 || sel > 3){
                                System.out.print(getSel);
                        }
                }           
		
		// return selection to main
		return sel;
	}
	
	/**
	* calculate recipe amounts
	*/
	private static double[] calcBatches(double[] batches, byte selection) {

		for (int s = 0; s < batches.length; ++s) {
			batches[s] *= selection;
		}
		return batches;
	}

	/**
	* main method
	*/
	public static void main(String[] args) {

		// class info print statement	
                String classInfo = "\nName: Luttrell, Bryan\t\tCMIS 141/6382\t\tDate: 10/02/2021\n";
		System.out.println(classInfo);

		// formatting
		DecimalFormat fmt = new DecimalFormat("0");
		fmt.setMaximumFractionDigits(2);
		PrintWriter pw = new PrintWriter(System.out,true);

		// portion sizes
		double cerealAmt = 3;
		double pretzAmt = 2;
		double otherAmt = 1;
		double sauceAmt = 1d/3d;
		double saltAmt = (1d/2d)+1;
		double butSticks = 2;
		double[] batches = {cerealAmt,pretzAmt,otherAmt,sauceAmt,saltAmt,butSticks};
		
		// menu selection
		byte selection = 0;
		selection = progMenu();

		// get the batches calculated using input (1-3) from the user
		batches = calcBatches(batches,selection);

		// ingredients
		String recipe = "";
		String wheat = "\t\t\tWheat Chex Cereal";
		String rice = "\t\t\tRice Chex Cereal";
		String corn = "\t\t\tCorn Chex Cereal";
		String pretzels = "\t\t\tmini pretzels salted";
		String bagelChips = "\t\t\tRye bagel chips";
		String mixNuts = "\t\t\tmixed nuts (optional)";
		String butter = "\t\t\tbutter (" + fmt.format(batches[5]) + " sticks)";
		String worSauce = "\t\t\tWorcestershire sauce";
		String seasonSalt = "\t\tLawry's seasoned salt";
		String gPowder = "\t\tgarlic powder";
		String oPowder = "\t\tonion powder";
		String[] ingredients = {wheat,rice,corn,pretzels,bagelChips,mixNuts,butter,worSauce,seasonSalt,gPowder,oPowder};

		// measurements with/without plurals
		String cup = " cup";
		String tsp = " teaspoon";
		String tbsp = " tablespoon";
		String plrl = "s";
		String msmt = "";
		String prettyPrtn = "";

		// unicode for special characters, to make the format pretty
		char degrees = '\u00B0';
		char half = '\u00BD';
		char oneThird = '\u2153';
		char twoThirds = '\u2154';

		// format and print the recipe with a for loop
		for (int i = 0; i < ingredients.length; i++) {
			msmt = "";
			prettyPrtn = "";
			if (i < 3) {
				// Cereal
				msmt = cup + plrl;
				recipe += fmt.format(batches[0]) + msmt + ingredients[i] + "\n";
			} else if (i == 3) {
				// Pretzels
				msmt = cup + plrl;
				recipe += fmt.format(batches[1]) + msmt + ingredients[i] + "\n";
			} else if (i > 3 && i < 7) {
				// Rye bagel chips, Mixed nuts, Butter
				msmt = (batches[2] > 1) ? cup + plrl : cup;
				recipe += fmt.format(batches[2]) + msmt + ingredients[i] + "\n";
			} else if (i == 7) {
				// Worcestershire sauce
				msmt = cup;
				if (batches[3] < .4) {
					recipe += oneThird + msmt + ingredients[i] + "\n";
				} else if (batches[3] < .7) {
					recipe += twoThirds + msmt + ingredients[i] + "\n";
				} else {
					recipe += fmt.format(batches[3]) + msmt + ingredients[i] + "\n";
				}
			} else if (i == 8) {
				// Seasoned salt
				msmt = (batches[4] > 1) ? tbsp + plrl : tbsp;
				if (batches[4] == 1.5) {
					prettyPrtn = "1" + half;
					recipe += prettyPrtn + msmt + ingredients[i] + "\n";
				} else if (batches[4] == 3) {
					recipe += fmt.format(batches[4]) + msmt + ingredients[i] + "\n";
				} else {
					prettyPrtn = "4" + half;
					recipe += prettyPrtn + msmt + ingredients[i] + "\n";
				}
			} else if (i > 8 && i < 11) {
				// Garlic and Onion powder
				msmt = (batches[2] > 1) ? tsp + plrl : tsp;
				recipe += fmt.format(batches[2]) + msmt + ingredients[i] + "\n";
			}
		}

		// add baking steps to recipe string
		recipe += line.repeat(70);
		recipe += "\n1) Preheat oven to 250" + degrees + ".\n\n"
			 +"2) Combine cereal, pretzels, chips, and nuts in a large bowl.\n\n"
			 +"3) In a microwave safe bowl, melt butter and whisk in Worcestershire\n"
			 +"sauce and seasonings and gradually pour over cereal mixture mixing\n"
			 +"with your hands or a large spoon after each addition until the\n"
			 +"cereal is fully coated.\n\n"
		 	 +"4) Spread onto 2 large rimmed baking sheets and bake for 1 hour\n"
			 +"stirring every 15 minutes and rotating the tray from top to bottom\n"
			 +"to ensure even cooking. Remove from oven when golden brown and crisp.\n\n"
			 +"5) Yield is 28 " + half + " cup servings per batch.\n"
			 +"\n***** NOTE: Cooking instructions are for 1 batch at a time. *****";

		// print recipe
		System.out.println(line.repeat(50));
		pw.println(recipe);
		System.out.println(line.repeat(70));

		// close scanners
		SCANBYTE.close();
	}
}
