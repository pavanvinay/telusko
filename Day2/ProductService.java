import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    private List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    // To get all products and their details in list
    public List<Product> getAllProducts() {
        return products;
    }

    // To get the product based on input name
    public List<Product> getProduct(String name) {
        return products.stream()
                .filter(p -> p.getName().toLowerCase().equals(name.toLowerCase()))
                .collect(Collectors.toList());
        // .orElse(null); // returns null if product not in list
    }

    // To get the product details with input text in it
    public List<Product> getProductWithText(String text) {
        String str = text.toLowerCase();

        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains(str)
                        || p.getType().toLowerCase().contains(str)
                        || p.getPlace().toLowerCase().contains(str))
                .collect(Collectors.toList());
    }

    // To find products with expired warranty period
    public List<Product> getProductsOutOfWarranty(int warranty) {
        return products.stream()
                .filter(p -> p.getWarranty() < warranty)
                .collect(Collectors.toList());
    }

    // To get the products which are in particular place
    public List<Product> findProductsByPlace(String place) {

        return products.stream()
                .filter(prod -> prod.getPlace().toLowerCase().equals(place.toLowerCase()))
                .collect(Collectors.toList());
    }

}
