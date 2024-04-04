package ra.bussinessImp;

import ra.bussiness.IProduct;
import java.util.Scanner;

public class Product implements IProduct , Comparable<Product>{
    private int productid;
    private String productName;
    private String title;
    private String descriptions;
    private float importPrice;
    private float exportPrice;
    private float interest;
    private boolean productStatus;

    public Product() {}

    public Product(int productid, String productName, String title, String descriptions, float importPrice, float exportPrice, boolean productStatus) {
        this.productid = productid;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.productStatus = productStatus;
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã sản phẩm: ");
        this.productid = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Nhập tên sản phẩm: ");
        this.productName = scanner.nextLine();
        System.out.println("Nhập tiêu đề sản phẩm: ");
        this.title = scanner.nextLine();
        System.out.println("Nhập mô tả sản phẩm: ");
        this.descriptions = scanner.nextLine();
        System.out.println("Nhập giá nhập: ");
        this.importPrice = scanner.nextFloat();
        System.out.println("Nhập giá xuất: ");
        this.exportPrice = scanner.nextFloat();
        this.interest = this.exportPrice - this.importPrice;
        scanner.nextLine(); // Consume newline
        System.out.println("Nhập trạng thái sản phẩm (true/false): ");
        this.productStatus = scanner.nextBoolean();
    }

    public void displayData() {
        System.out.println("Mã sản phẩm: " + this.productid);
        System.out.println("Tên sản phẩm: " + this.productName);
        System.out.println("Tiêu đề sản phẩm: " + this.title);
        System.out.println("Mô tả sản phẩm: " + this.descriptions);
        System.out.println("Giá nhập: " + this.importPrice);
        System.out.println("Giá xuất: " + this.exportPrice);
        System.out.println("Lợi nhuận: " + this.interest);
        System.out.println("Trạng thái sản phẩm: " + (this.productStatus ? "Đang hoạt động" : "Ngừng hoạt động"));
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = (float) interest;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    @Override
    public int compareTo(Product otherProduct) {
        return Float.compare(this.interest, otherProduct.interest);
    }
}
