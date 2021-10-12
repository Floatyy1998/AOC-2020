package Day1;

import java.io.IOException;

import java.util.List;


public class Day1Zwei {
    public static void main(String[] args) throws IOException {
        List < Integer > test = ReadTxtToArray.readLines("Day1/test.txt");
        for (int i = 0; i < test.size(); i++) {
            for (int j = i + 1; j < test.size(); j++) {
                for (int k = j + 1; k < test.size(); k++) {
                    // compare list.get(i) and list.get(j)
                    int vergleich = test.get(i) + test.get(j) + test.get(k);
                    if (vergleich == 2020) {
                        System.out.println(test.get(i));
                        System.out.println(test.get(j));
                        System.out.println(test.get(k));
                        System.out.println(test.get(i) * test.get(j) * test.get(k));
                    }

                }
            }
        }


    }





}