package ra.run;

import ra.bussiness.IProduct;
import ra.bussinessImp.Product;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ProductManagement {
    private static ArrayList<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product(1,"ca chua","thucpham","hoaquatuoi",1000,2000,true));
        productList.add(new Product(2,"du du","thucpham","hoaquatuoi",2000,3000,true));
        productList.add(new Product(3,"cam","thucpham","hoaquatuoi",4000,5000,true));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************");
            System.out.println("1. Nhập số sản phẩm và nhập thông tin sản phẩm");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Sắp xếp sản phẩm theo lợi nhuận tăng dần");
            System.out.println("4. Xóa sản phẩm theo mã sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên sản phẩm");
            System.out.println("6. Thay đổi trạng thái của sản phẩm theo mã sản phẩm");
            System.out.println("7. Thoát");
            System.out.print("Chọn: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    inputData();
                    break;
                case 2:
                    displayData();
                    break;
                case 3:
                    sortProductByInterest();
                    break;
                case 4:
                    deleteProductById();
                    break;
                case 5:
                    searchProductByName();
                    break;
                case 6:
                    changeProductStatusById();
                    break;
                case 7:
                    System.out.println("Thoát khỏi chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (choice != 7);
        scanner.close();
    }

    private static void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số sản phẩm cần nhập thông tin: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sản phẩm thứ " + (i + 1) + ": ");
            IProduct product = new Product();
            product.inputData();
            productList.add((Product) product);
        }
    }

    private static void displayData() {
        System.out.println("Thông tin các sản phẩm:");
        for (IProduct product : productList) {
            product.displayData();
            System.out.println();
        }
    }

    private static void sortProductByInterest() {
        Collections.sort(productList);
        System.out.println("Sắp xếp thành công.");
        displayData();
    }

    private static void deleteProductById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã sản phẩm cần xóa: ");
        int id = scanner.nextInt();
        boolean isDeleted = false;
        for (int i = 0; i < productList.size(); i++) {
            Product product = (Product) productList.get(i);
            if (product.getProductid() == id) {
                productList.remove(i);
                isDeleted = true;
                break;
            }
        }
        if (isDeleted) {
            System.out.println("Xóa sản phẩm thành công.");
        } else {
            System.out.println("Không tìm thấy sản phẩm cần xóa.");
        }
    }

    private static void searchProductByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên sản phẩm cần tìm kiếm: ");
        String name = scanner.nextLine();
        boolean isFound = false;
        for (IProduct product : productList) {
            if (((Product) product).getProductName().equalsIgnoreCase(name)) {
                product.displayData();
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println("Không tìm thấy sản phẩm nào có tên \"" + name + "\".");
        }
    }

    private static void changeProductStatusById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã sản phẩm cần thay đổi trạng thái: ");
        int id = scanner.nextInt();
        boolean isChanged = false;
        for (IProduct product : productList) {
            if (((Product) product).getProductid() == id) {
                ((Product) product).setProductStatus(!((Product) product).isProductStatus());
                System.out.println("Thay đổi trạng thái của sản phẩm thành công.");
                isChanged = true;
                break;
            }
        }
        if (!isChanged) {
            System.out.println("Không tìm thấy sản phẩm có mã \"" + id + "\".");
        }
    }
}
