package reviewSec_Again;

import java.util.List;
import java.util.ArrayList;

public class radix {
    public static void sort(int[] a) {

        for (int i = 0; i < 32; i++) {
            List<Integer> l0 = new ArrayList<>();
            List<Integer> l1 = new ArrayList<>();
            for (int j = 0; j < a.length; j++) {
                if (((a[j] >> i) & 1) == 1) {
                    l1.add(a[j]);
                } else
                    l0.add(a[j]);
            }
            int idx = 0;
            for (Integer integer : l0) {
                a[idx++] = integer;
            }
            for (Integer integer : l1) {
                a[idx++] = integer;
            }
        }
    }
}
