import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> integers2 = new ArrayList<>();
        integers2.add(1);
        integers2.add(2);
        integers2.add(3);

        ArrayList<List<Integer>> res = new ArrayList<>();

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        res.add(new ArrayList<>(integers));

        System.out.println(res.contains(integers2));

    }
}