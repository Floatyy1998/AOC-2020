package Day15;

import java.util.*;
import static java.lang.System.*;

/**
 * Day15
 */
public class Day15 {

    public static void main(String[] args) {
        int[] inp = {
            20,9,11,0,1,2
        };
        List < Integer > nums = new ArrayList < > ();
        for (int i = 0; i < inp.length; i++) {
            nums.add(inp[i]);
        }

        memory(nums, 2020);
        memory(nums, 30000000);
    }

    private static void memory(List < Integer > nums, int turns) {
        int last = nums.get(nums.size() - 1);
        Map < Integer, Integer > num_dict = new HashMap < > ();
        int neu;
        for (int i = 0; i < nums.size() - 1; i++) {
            num_dict.put(nums.get(i), i + 1);

        }

        for (int i = nums.size(); i < turns; i++) {
           
            if (num_dict.containsKey(last)) {
                 neu = i - num_dict.get(last);
            }
            else{
                 neu = 0;
            }

            num_dict.put(last, i);
            last = neu;
        }
        out.println(num_dict.size());
    }
}