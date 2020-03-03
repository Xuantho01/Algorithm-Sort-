public class InsertionSort {
    static double[] list = {1, 9, 4.5, 6.6, 5.7, -4.5};
    public static void insertionSort(double[] list) {
        for (int i = 1; i < list.length ; i++){
            double currentValue = list[i];
            int j = i - 1;
            while((j >= 0) && list[j] > currentValue) {
                list[j+1] = list[j];
                j--;
            }
            list[j + 1] = currentValue;
        }
    }

    public static void main(String[] args) {
        insertionSort(list);
        for (Double lists: list){
            System.out.print(lists+" ");
        }
    }
}
