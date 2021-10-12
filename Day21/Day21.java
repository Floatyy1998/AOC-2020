package Day21;

import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;




public class Day21 {
    private static Map < String, String > translations = new HashMap < > ();

    public static void main(String[] args) throws IOException {
        List < String > input = ReadTxtToArrayList.readLines("Day21/input.txt");
        part1(input);
        part2();

    }

    public static void part1(List < String > input) {
        Set < String > uniqueAllergens = new HashSet < > ();
        Set < String > uniqueIngredients = new HashSet < > ();
        for (String in: input) {
            String[] ingredients = in .substring(0, in .indexOf("(") - 1).split(" ");
            uniqueIngredients.addAll(Arrays.asList(ingredients));
            String[] allergens = in .substring( in .indexOf("contains") + 9, in .length() - 1).replace(",", "").split(" ");
            uniqueAllergens.addAll(Arrays.asList(allergens));
        }

        // possibleMatches map (unique allergen -> alle possible matches)
        // Beispiel [dairy = {mxmxvkd}, fish = {mxmxvkd, sqjhc},
        // soy = {sqjhc, fvjkl}]
        Map < String, ArrayList < String >> possibleMatches = new HashMap < > ();

        for (String ua: uniqueAllergens) {

            ArrayList < String > temp = new ArrayList < > (uniqueIngredients);
            
            for (int i = 0; i < input.size(); i++) {
                // input iterieren und schauen wo " "+ua vorhanden ist
                // " " wegen fish/shellfish, nuts/peanuts
                String line = input.get(i);
                if (line.contains(" " + ua)) {
                    String[] ingreds = line.substring(0, line.indexOf("(") - 1).split(" ");
                    ArrayList < String > other = new ArrayList < > (Arrays.asList(ingreds));
                    temp.retainAll(other); // retainAll: nur elemente die in temp und other drin sind bleiben in temp
                    // am ende beinhaltet temp alle ingredians mit dem jeweiligen allergen

                } 
            }
          

            possibleMatches.put(ua, temp);
        }
       

        // translations enthählt am Ende (einzelnes allergen -> ingredient) richtig zugeordnet
        translations = new HashMap < > ();
        while (!possibleMatches.isEmpty()) {
            // nachschauen welcher key genau eine zutat hat
            // wenn gefunden, (allergen -> ingredient) in translations map hinzufügen und entry
            // aus possibleMatches entfernen.
            // Iterator um durch die keys der hashmap zu iterieren und entrys zu entfernen
            Iterator < Entry < String, ArrayList < String >>> itr = possibleMatches.entrySet().iterator();
            while (itr.hasNext()) {
                Entry < String, ArrayList < String >> entry = itr.next();
                ArrayList < String > ingredients = entry.getValue();
                if (ingredients.size() == 1) {
                    String allergen = entry.getKey();
                    String ingredient = ingredients.get(0);
                    translations.put(allergen, ingredient);
                    itr.remove(); // entfernt aktuellen entry aus der map

                    // ingrediant aus allen values von possibleMatches entfernen
                    for (ArrayList < String > list: possibleMatches.values()) {
                        list.remove(ingredient);
                    }
                }

            }
            
        }
      

        // Durch originalen input iterieren und alle zutaten zählen die nicht in translations sind
        int count = 0;
        for (int i = 0; i < input.size(); i++) {
            String line = input.get(i);
            String[] ingredients = line.substring(0, line.indexOf("(") - 1).split(" ");
            for (String ingredient: ingredients) {
                if (!translations.values().contains(ingredient)) {
                    count++;
                }
            }
        }

        System.out.println("Anzahl der ungefährlichen Zutaten: " + count);

    }

    public static void part2() {
        String[] catalogue = new String[translations.size()];
        int i = 0;
        for (Entry < String, String > entry: translations.entrySet()) {
            catalogue[i] = entry.getKey() + "/" + entry.getValue();
            i++;
        }

        Arrays.sort(catalogue);
        
        String asz = "";
        for (String str: catalogue) {
            asz += str.substring(str.indexOf("/") + 1) + ",";
        }
       
        asz = asz.substring(0, asz.length() - 1); // letzten ',' entfernen

        System.out.println("Gefährliche Zutaten alphabetisch sortiert: " + asz);

    }
}