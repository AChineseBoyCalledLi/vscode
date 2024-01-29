package reviewSec_Again;

import java.util.ArrayList;

public class Permutation {
    public static int permutation(StringBuffer orig, StringBuffer dest, int pos) {
        if (dest.length() == pos) {
            System.out.println(dest);
            return 1;
        }
        int ret = 0;
        for (int i = 0; i < orig.length(); i++) {
            dest.setCharAt(pos, orig.charAt(i));
            orig.deleteCharAt(i);
            ret += permutation(orig, dest, pos + 1);
            orig.insert(i, dest.charAt(pos));
        }
        return ret;
    }

    public static int combination(StringBuffer orig, StringBuffer dest, int pos) {
        if (dest.length() == pos) {
            System.out.println(dest);
            return 1;
        }
        int ret = 0;
        while (!orig.isEmpty()) {
            dest.setCharAt(pos, orig.charAt(0));
            orig.deleteCharAt(0);
            ret += combination(new StringBuffer(orig), dest, pos + 1);
        }
        return ret;
    }

    public static int coins(int[] options, ArrayList<Integer> sol, int total) {
        if (total < 0)
            return 0;
        if (total == 0) {
            System.out.println(sol);
            return 1;
        }
        int ret = 0;
        for (int i = 0; i < options.length; i++) {
            if (!sol.isEmpty() && sol.get(sol.size() - 1) > options[i])
                continue;
            sol.add(options[i]);
            ret += coins(options, new ArrayList<>(sol), total - options[i]);
            sol.remove(sol.size() - 1);
        }
        return ret;
    }
}
