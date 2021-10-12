package Day4;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day4Zwei {
    public static void main(String[] args) throws IOException {
       
        int antwort = 0;

        String pattern = "([a-z]+):(.*) ([a-z]+):(.*) ([a-z]+):(.*) ([a-z]+):(.*) ([a-z]+):(.*) ([a-z]+):(.*) ([a-z]+):(.*)";


        List < String > list = ReadTxtToArrayList.readLines("Day4/input.txt");
        Pattern r = Pattern.compile(pattern);


        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i).replaceAll("\\n", " ").trim());
            list.set(i, list.get(i).replaceAll("cid:[0-9]+", "").trim());
            list.set(i, list.get(i).replaceAll("  ", " ").trim());
        }




        for (String string: list) {
            Matcher m = r.matcher(string);
            if (m.find()) {
                boolean isValid = true;

                for (int i = 1; i < 15; i++) {

                    if (i % 2 != 0) {


                        switch (m.group(i)) {
                            case "byr":
                                if (!((Integer.parseInt(m.group(i + 1)) <= 2002) && (Integer.parseInt(m.group(i + 1)) >= 1920))) {
                                    isValid = false;
                                }

                                break;

                            case "iyr":
                                if (!((Integer.parseInt(m.group(i + 1)) <= 2020) && (Integer.parseInt(m.group(i + 1)) >= 2010))) {
                                    isValid = false;
                                }
                                break;

                            case "eyr":
                                if (!((Integer.parseInt(m.group(i + 1)) <= 2030) && (Integer.parseInt(m.group(i + 1)) >= 2020))) {
                                    isValid = false;
                                }
                                break;

                            case "hgt":
                                Pattern patterncm = Pattern.compile("([0-9]+)cm");
                                Pattern patternin = Pattern.compile("([0-9]+)in");
                                Matcher mcm = patterncm.matcher(m.group(i + 1));
                                Matcher min = patternin.matcher(m.group(i + 1));
                                if (mcm.matches()) {
                                    if (!((Integer.parseInt(mcm.group(1)) <= 193) && (Integer.parseInt(mcm.group(1)) >= 150))) {
                                        isValid = false;
                                    }

                                } else if (min.matches()) {
                                    if (!((Integer.parseInt(min.group(1)) <= 76) && (Integer.parseInt(min.group(1)) >= 59))) {
                                        isValid = false;
                                    }

                                } else {
                                    isValid = false;
                                }
                                break;

                            case "hcl":
                                Pattern patternhcl = Pattern.compile("#[a-f0-9]{6}");
                                Matcher mhcl = patternhcl.matcher(m.group(i + 1));

                                if (!mhcl.matches()) {
                                    isValid = false;
                                }

                                break;

                            case "ecl":
                                Set < String > values = new HashSet < > (Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth"));
                                if (!(values.contains(m.group(i + 1)))) {
                                    isValid = false;
                                }

                                break;

                            case "pid":
                                Pattern patternpid = Pattern.compile("[0-9]{9}");
                                Matcher mpid = patternpid.matcher(m.group(i + 1));
                                if (!mpid.matches()) {
                                    isValid = false;
                                }
                                break;

                            default:
                                break;
                        }
                    }
                    if (!isValid) {
                        break;
                    }
                }
                if (isValid) {
                    antwort++;
                }



            }
        }

        System.out.println(antwort);






    }
}