import java.util.Arrays;
import java.util.Scanner;

    public class Array {
        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            int[] initialArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            String command = scanner.nextLine();

            while(!command.equals("end")){
                String[] commandParts = command.split(" ");
                String firstToken = commandParts[0];
                int count;
                String type;
                switch (firstToken){
                    case "exchange":
                        int index = Integer.parseInt(commandParts[1]);
                        exchangeArray(initialArray,index);
                        break;
                    case "max":
                        type = commandParts[1];
                        if(type.equals("even")){
                            getMaxEvenElement(initialArray);
                        }else{
                            getMaxOddElement(initialArray);
                        }
                        break;
                    case "min":
                        type = commandParts[1];
                        if(type.equals("even")){
                            getMinEvenElement(initialArray);
                        }else{
                            getMinOddElement(initialArray);
                        }
                        break;
                    case "first":
                        count = Integer.parseInt(commandParts[1]);
                        type = commandParts[2];
                        if(type.equals("even")){
                            printFirstEvenElements(initialArray,count);
                        }else{
                            printFirstOddElements(initialArray,count);
                        }
                        break;
                    case "last":
                        count = Integer.parseInt(commandParts[1]);
                        type = commandParts[2];
                        if(type.equals("even")){
                            printLastEvenElements(initialArray,count);
                        }else{
                            printLastOddElements(initialArray,count);
                        }
                }

                command = scanner.nextLine();
            }

            System.out.print("[");
            for (int i = 0; i < initialArray.length; i++) {
                System.out.print(initialArray[i]);
                if (i < initialArray.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");

        }

        public static void exchangeArray(int[] array,int index){

            if(index <0 || index > array.length-1){
                System.out.println("Invalid index");
                return;
            }

            int[] firstSubArray = new int[index+1];
            int[] secondSubArray = new int[array.length - index -1];

            for(int i=0;i<=index;i++){
                firstSubArray[i] = array[i];
            }

            for (int i = index + 1; i < array.length; i++) {
                secondSubArray[i-index-1] = array[i];
            }

            int[] combined = new int[array.length];
            int pos = 0;

            for (int num : secondSubArray) {
                combined[pos++] = num;
            }
            for (int num : firstSubArray) {
                combined[pos++] = num;
            }
            System.arraycopy(combined, 0, array, 0, array.length);
        }

        public static void getMaxEvenElement(int[] array){
            int indexOfMaxElement = 0;
            boolean hasMatches = false;
            int maxElement = Integer.MIN_VALUE;
            for(int i=0;i< array.length;i++){
                int currentElement = array[i];
                if(currentElement % 2 ==0 && currentElement>=maxElement){
                    hasMatches = true;
                    maxElement = currentElement;
                    indexOfMaxElement = i;
                }
            }
            if(!hasMatches){
                System.out.println("No matches");
            }else{
                System.out.println(indexOfMaxElement);
            }
        }

        public static void getMaxOddElement(int[] array){
            int indexOfMaxElement = 0;
            boolean hasMatches = false;
            int maxElement = Integer.MIN_VALUE;
            for(int i=0;i< array.length;i++){
                int currentElement = array[i];
                if(currentElement % 2 !=0 && currentElement>=maxElement){
                    hasMatches = true;
                    maxElement = currentElement;
                    indexOfMaxElement = i;
                }
            }

            if(!hasMatches){
                System.out.println("No matches");
            }else{
                System.out.println(indexOfMaxElement);
            }
        }

        public static void getMinEvenElement(int[] array){
            int indexOfMinElement = 0;
            boolean hasMatches = false;
            int minElement = Integer.MAX_VALUE;
            for(int i=0;i< array.length;i++){
                int currentElement = array[i];
                if(currentElement % 2 ==0 && currentElement<=minElement){
                    hasMatches = true;
                    minElement = currentElement;
                    indexOfMinElement = i;
                }
            }

            if(!hasMatches){
                System.out.println("No matches");
            }else{
                System.out.println(indexOfMinElement);
            }

        }

        public static void getMinOddElement(int[] array){
            int indexOfMinElement = 0;
            boolean hasMatches = false;
            int minElement = Integer.MAX_VALUE;
            for(int i=0;i< array.length;i++){
                int currentElement = array[i];
                if(currentElement % 2 !=0 && currentElement<minElement){
                    hasMatches = true;
                    minElement = currentElement;
                    indexOfMinElement = i;
                }
            }

            if(!hasMatches){
                System.out.println("No matches");
            }else{
                System.out.println(indexOfMinElement);
            }
        }

        public static void printFirstEvenElements(int[] array, int count){

            int[] evenElements = new int[count];
            int found = 0;

            if(count > array.length){
                System.out.println("Invalid count");
                return;
            }else {
                for (int i = 0; i < array.length && found < count; i++) {
                    if (array[i] % 2 == 0) {
                        evenElements[found++] = array[i];
                    }
                }
            }

            if (found == 0) {
                System.out.println("[]");
                return;
            }
            System.out.print("[");
            for (int i = 0; i < found; i++) {
                System.out.print(evenElements[i]);
                if (i < found - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }

        public static void printFirstOddElements(int[] array, int count){
            int[] oddElements = new int[count];
            int found = 0;

            if(count > array.length){
                System.out.println("Invalid count");
                return;
            }else {
                for (int i = 0; i < array.length && found < count; i++) {
                    if (array[i] % 2 != 0) {
                        oddElements[found++] = array[i];
                    }
                }
            }
            if (found == 0) {
                System.out.println("[]");
                return;
            }
            System.out.print("[");
            for (int i = 0; i < found; i++) {
                System.out.print(oddElements[i]);
                if (i < found - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }

        public static void printLastEvenElements(int[] array, int count){
            int[] evenElements = new int[count];
            int found = 0;

            if(count > array.length){
                System.out.println("Invalid count");
                return;
            }else {
                for (int i = array.length - 1; i >= 0 && found < count; i--) {
                    if (array[i] % 2 == 0) {
                        evenElements[found++] = array[i];
                    }
                }
            }

            if (found == 0) {
                System.out.println("[]");
                return;
            }
            System.out.print("[");
            for (int i = found -1; i >= 0; i--) {
                System.out.print(evenElements[i]);
                if (i > 0) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }

        public static void printLastOddElements(int[] array, int count){
            int[] oddElements = new int[count];
            int found = 0;

            if(count > array.length){
                System.out.println("Invalid count");
                return;
            }else {
                for (int i = array.length - 1; i >= 0 && found < count; i--) {
                    if (array[i] % 2 != 0) {
                        oddElements[found++] = array[i];
                    }
                }
            }

            if (found == 0) {
                System.out.println("[]");
                return;
            }
            System.out.print("[");
            for (int i = found -1; i >= 0; i--) {
                System.out.print(oddElements[i]);
                if (i > 0) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
