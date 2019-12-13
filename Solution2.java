import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.joining;

class solution53 {

    public static final String SPACE = " ";

    public static void main(String[] args) {
        solution53 tc = new solution53();
        tc.method();
    }

    public void method() {
        Scanner s1 = new Scanner(System.in);
        int numberOfTestCases = Integer.parseInt(s1.nextLine());
        for (int i = 0; i < numberOfTestCases; i++) {

            int numberOfChildren = Integer.parseInt(s1.nextLine());
            String[] agesArray = s1.nextLine().split(SPACE);

            Children[] child = new Children[numberOfChildren];

            for (int index = 0; index < numberOfChildren; index++) {
                child[index] = new Children(Integer.parseInt(agesArray[index]), index);
            }

            List<Children> orderByAgeChildren = new ArrayList<>(Arrays.asList(child));

            Collections.sort(orderByAgeChildren, Comparator.comparing(Children::getCurrentAge));
            List<Integer> ordertoProcess = new ArrayList<>();
            orderByAgeChildren.stream().forEach(s -> ordertoProcess.add(s.getOrder()));

            for (int index = 0; index < numberOfChildren; index++) {
                Integer leftAge = null;
                Integer rightAge = null;
                if (index - 1 >= 0) {
                    leftAge = child[index - 1].getCurrentAge();
                }
                if (index + 1 <= (numberOfChildren - 1)) {
                    rightAge = child[index + 1].getCurrentAge();
                }
                child[index] = new Children(child[index].getCurrentAge(), leftAge, rightAge);
            }

            for (int orderValue : ordertoProcess) {
                Children children = child[orderValue];
                leftSideProcess(child, orderValue, children);
                rightSideProcess(numberOfChildren, child, orderValue, children);
            }

            System.out.println(Arrays.stream(child).map(s -> String.valueOf(s.getClothes())).collect(joining(" ")));

        }

    }

    private void leftSideProcess(Children[] child, int orderValue, Children children) {
        int leftSideIndex = orderValue - 1;
        if (children.leftSideHighAge() && leftSideIndex >= 0) {
            Children leftSideChildren = child[leftSideIndex];
            if (leftSideChildren.clothes <= children.clothes) {
                leftSideChildren.clothes = children.clothes;
                leftSideChildren.increaseClothes();
            }
        }
    }

    private void rightSideProcess(int numberOfChildren, Children[] child, int orderValue, Children children) {
        int rightSideIndex = orderValue + 1;
        if (children.rightSideHighAge() && rightSideIndex < numberOfChildren) {
            Children rightSideChildren = child[rightSideIndex];
            if (rightSideChildren.clothes <= children.clothes) {
                rightSideChildren.clothes = children.clothes;
                rightSideChildren.increaseClothes();
            }
        }
    }

    class Children {
        int currentAge;
        Integer leftAge;
        Integer rightAge;
        int order;
        int clothes = 1;

        public Children(int currentAge, Integer leftAge, Integer rightAge) {
            this.currentAge = currentAge;
            this.leftAge = leftAge;
            this.rightAge = rightAge;
        }

        public Children(int currentAge, int order) {
            this.currentAge = currentAge;
            this.order = order;
            this.clothes = 1;
        }

        public int getOrder() {
            return order;
        }

        public int getCurrentAge() {
            return currentAge;
        }

        public int getClothes() {
            return clothes;
        }

        public Integer getLeftAge() {
            return leftAge;
        }

        public Integer getRightAge() {
            return rightAge;
        }

        public boolean leftSideHighAge() {
            return this.leftAge != null && this.leftAge > this.currentAge;
        }

        public boolean rightSideHighAge() {
            return this.rightAge != null && this.rightAge > this.currentAge;
        }

        public void increaseClothes() {
            this.clothes = this.clothes + 1;

        }
    }

}


