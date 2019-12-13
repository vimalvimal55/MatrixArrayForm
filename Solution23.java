import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution23 {


    public static final String SPACE = " ";
    public static void main(String[] args) {
        Solution23 tc = new Solution23();
        tc.method();
    }
    public void method() {
        Scanner s1 = new Scanner(System.in);
        int numberOfTestCases = Integer.parseInt(s1.nextLine());

        for (int i = 0; i < numberOfTestCases; i++) {
            int sum = 0;
            int finalLitre = 0;

            int numberOfContainers = Integer.parseInt(s1.nextLine());
            String[] capacityArray = s1.nextLine().split(SPACE);
            String[] currentVolumeArray = s1.nextLine().split(SPACE);
            Container[] containerArray = new Container[numberOfContainers];
            for (int index1 = 0; index1 < numberOfContainers; index1++) {
                containerArray[index1] = new Container(Integer.parseInt(capacityArray[index1]), Integer.parseInt(currentVolumeArray[index1]));

            }
            for (int index = 1; index < numberOfContainers; index++) {

            }
            System.out.println(finalLitre + SPACE + sum);
        }
    }

    public class Container {
        private int capacity;
        private int currentVolume;

        public Container(int capacity, int currentVolume) {
            this.capacity = capacity;
            this.currentVolume = currentVolume;
        }

        public int getCurrentVolume() {
            return currentVolume;
        }

        @Override
        public String toString() {
            return "Container{" +
                    "volume=" + capacity +
                    ", currentVolume=" + currentVolume +
                    '}';
        }

        int fillAndSpillRemaining(int incomingValue) {
            int couldTakeIn = this.capacity - this.currentVolume;
            if (incomingValue > couldTakeIn) {
                this.currentVolume = this.capacity;
                //reaming sent as spill
                return incomingValue - couldTakeIn;
            }
            this.currentVolume = this.currentVolume + incomingValue;
            return 0;
        }
    }
}
