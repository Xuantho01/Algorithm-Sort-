public class SelectionSort {
    static double[] list = {1, 9, 4.5, 6.6, 5.7, -4.5};
    public static void slectionsort(double[] list){
        for (int i = 0; i < list.length - 1; i++){
            double currentValue = list[i];
            int currentIndex = i;
            for (int j = i + 1; j < list.length; j++){
                if (currentValue > list[j]){
                    currentValue = list[j];
                    currentIndex = j;
                }
            }
            if (currentIndex != i){
                list[currentIndex] = list[i];
                list[i] = currentValue;
            }
        }
    }

    public static void main(String[] args) {
        slectionsort(list);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }
}
