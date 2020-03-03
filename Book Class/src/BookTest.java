import java.util.ArrayList;
import java.util.Scanner;

public class BookTest {
    static ArrayList<Book> ListBook = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ProgrammingBook programmingBook1 = new ProgrammingBook(111, "programming Book1", 150.0, "Mr.Tho", "Java", "java");
        ProgrammingBook programmingBook2 = new ProgrammingBook(222, "programming Book2", 170.0, "Mr.Tho", "Java", "java");
        ProgrammingBook programmingBook3 = new ProgrammingBook(333, "programming Book3", 120.0, "Mr.Tho", "Java", "java");
        ProgrammingBook programmingBook4 = new ProgrammingBook(444, "programming Book4", 90.0, "Mr.Tho", "Java", "java");
        ProgrammingBook programmingBook5 = new ProgrammingBook(555, "programming Book5", 190.0, "Mr.Tho", "Java", "java");

        FictionBook fictionBook1 = new FictionBook(555, "fiction Book 1", 200.0, "Mr.Doan", "PHP");
        FictionBook fictionBook2 = new FictionBook(666, "fiction Book 2", 110.0, "Mr.Doan", "PHP");
        FictionBook fictionBook3 = new FictionBook(777, "fiction Book 3", 23.0, "Mr.Doan", "PHP");
        FictionBook fictionBook4 = new FictionBook(888, "fiction Book 4", 50.0, "Mr.Doan", "PHP");
        FictionBook fictionBook5 = new FictionBook(999, "fiction Book 5", 240.0, "Mr.Doan", "PHP");

        ListBook.add(programmingBook1);
        ListBook.add(programmingBook2);
        ListBook.add(programmingBook3);
        ListBook.add(programmingBook4);
        ListBook.add(programmingBook5);
        ListBook.add(fictionBook1);
        ListBook.add(fictionBook2);
        ListBook.add(fictionBook3);
        ListBook.add(fictionBook4);
        ListBook.add(fictionBook5);

        System.out.println("Enter this Book that you want to search: ");
        String book_Search = scanner.nextLine();
        String searchPrice = searchPriceBook(book_Search);

        double total_Price = totalPrice(ListBook);
        int total_javaBook = coutJavaBook(ListBook);

        System.out.println(searchPrice);
        System.out.println("Total price of List Book: " + total_Price);

        System.out.println("Total java Book: " + total_javaBook);

        System.out.println("\nBubble sort: ");
        System.out.println("\n" + bubbleSort(ListBook));

        System.out.println("\nSelection sort: ");
        System.out.println("\n"+ selectionSort(ListBook));

        System.out.println("\ninsertion Sort: ");
        System.out.println("\n"+ insertionSort(ListBook));

        System.out.println(binarySearch(insertionSort(ListBook),"fiction Book 3"));
    }

    public static String searchPriceBook(String nameOfBook) {
        for (Book list : ListBook) {
            if (nameOfBook.equals(list.getName())) {
                return "price of " + nameOfBook + " is :" + list.getPrice();
            }
        }
        return "Not found";
    }

    public static double totalPrice(ArrayList<Book> listBook) {
        double price = 0;
        for (Book lists : listBook) {
            price += lists.getPrice();
        }
        return price;
    }

    public static int coutJavaBook(ArrayList<Book> listBook) {
        int totalJavaBook = 0;
        for (Book list_java_book : listBook) {
            boolean isProgrammingBook = list_java_book instanceof ProgrammingBook;
            if (isProgrammingBook) {
                boolean isJavaBook = ((ProgrammingBook) list_java_book).getLanguage().equals("Java");
                if (isJavaBook) {
                    totalJavaBook++;
                }
            }
        }
        return totalJavaBook;
    }

    public static ArrayList<Book> bubbleSort(ArrayList<Book> listBook) {
        for (int i = 1; i < listBook.size(); i++) {
            for (int j = 0; j < listBook.size() - i; j++) {
                if (listBook.get(j).getPrice() > listBook.get(j + 1).getPrice()) {
                    Book temp = listBook.get(j);
                    listBook.set(j, listBook.get(j + 1));
                    listBook.set(j + 1, temp);
                }
            }
        }
        return listBook;
    }

    public static ArrayList<Book> selectionSort(ArrayList<Book> listBook) {
        for (int i = 0; i < listBook.size(); i++) {
            Book minPriceOfBook = listBook.get(i);
            int currentIndex = listBook.indexOf(listBook.get(i));
            for (int j = i + 1; j < listBook.size(); j++) {
                if (minPriceOfBook.getPrice() > listBook.get(j).getPrice()) {

                    minPriceOfBook = listBook.get(j);
                    currentIndex = listBook.indexOf(listBook.get(j));
                }
            }
            if (currentIndex != i) {
                listBook.set(currentIndex, listBook.get(i));
                listBook.set(i, minPriceOfBook);
            }
        }
        return listBook;
    }

    public static ArrayList<Book> insertionSort(ArrayList<Book> listBook) {
        for (int i = 1; i < listBook.size(); i++) {
            Book currentBook = listBook.get(i);
            int j = i - 1;
            while ((j >= 0) && listBook.get(j).getPrice() > currentBook.getPrice()) {
                listBook.set(j+1,listBook.get(j));
                j--;
            }
            listBook.set(j + 1,currentBook);
        }
        return listBook;
    }

    public static double binarySearch(ArrayList<Book> listBook, String name){
         int low = 0;
         int hight = listBook.size() - 1;
         while (low <= hight){
             int mid = low + (hight - 1) / 2;
             int result = name.compareTo(listBook.get(mid).getName());
             if (result == 0){
                 return listBook.get(mid).getPrice();
             }
             if (result > 0){
                 low = mid + 1;
             }else
                 hight = mid - 1;
         }
        return -1;
    }
}


