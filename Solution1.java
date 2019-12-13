import java.util.*;

public class Solution1 {

    public static final String SPACE = " ";

    public static void main(String[] args) {
        Solution1 tc = new Solution1();
        tc.method();
    }

    public void method() {
        Scanner s1 = new Scanner(System.in);
        int numberOfTestCases = Integer.parseInt(s1.nextLine());
        for (int i = 0; i < numberOfTestCases; i++) {

            int numberOfStars = Integer.parseInt(s1.nextLine());
            Map<Integer, Set<Integer>> map = new HashMap<>();
            for (int index = 1; index < numberOfStars; index++) {
                String[] capacityArray = s1.nextLine().split(SPACE);
                String startingPoint = capacityArray[0];
                String endPoint = capacityArray[1];
                if (map.containsKey(Integer.parseInt(startingPoint))) {
                    Set<Integer> set = map.get(Integer.parseInt(startingPoint));
                    set.add(Integer.parseInt(endPoint));
                    map.put(Integer.parseInt(startingPoint), set);
                } else {
                    Set<Integer> set = new HashSet<>();
                    set.add(Integer.parseInt(endPoint));
                    map.put(Integer.parseInt(startingPoint), set);
                }
            }
            String[] startingPoint = s1.nextLine().split(SPACE);

            List<Integer> inputList = new ArrayList();
            inputList.add(Integer.parseInt(startingPoint[0]));

            int result = findLowest(map, inputList);
            System.out.println(result);
        }

    }

    private Integer findLowest(Map<Integer, Set<Integer>> map, List<Integer> inputList) {
        List<Integer> childrens = new ArrayList<>();
        Set<Integer> singleSet;
        for (Integer s : inputList) {
            if (map.containsKey(s)) {
                singleSet = map.get(s);
                for (Integer m : singleSet) {
                    childrens.add(m);
                }
            }
        }

        Collections.sort(childrens);
        if (childrens.size() == 0) {
            return inputList.get(0);
        } else {
            return findLowest(map, childrens);
        }

    }

}


