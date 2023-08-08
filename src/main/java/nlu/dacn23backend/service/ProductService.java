package nlu.dacn23backend.service;

import nlu.dacn23backend.configuration.JwtRequestFilter;
import nlu.dacn23backend.dao.CartDao;
import nlu.dacn23backend.dao.ProductDao;
import nlu.dacn23backend.dao.UserDao;
import nlu.dacn23backend.entity.Cart;
import nlu.dacn23backend.entity.Product;
import nlu.dacn23backend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private CartDao cartDao;

    @Autowired
    private UserDao userDao;

    // public Product getProductDetailsById(Integer productId) {
    //        return productDao.findById(productId).get();
    //    }

    public Product getProductDetailsById(Integer productId) {
        return productDao.findById(productId).get();
    }


    public List<Product> sortProducts(String sortType) {
        if (sortType.equals("name_asc")) {
            return productDao.findAll((Pageable) Sort.by(Sort.Direction.ASC, "name"));
        } else if (sortType.equals("name_desc")) {
            return productDao.findAll((Pageable) Sort.by(Sort.Direction.DESC, "name"));
        } else if (sortType.equals("price_asc")) {
            return productDao.findAll((Pageable) Sort.by(Sort.Direction.ASC, "price"));
        } else if (sortType.equals("price_desc")) {
            return productDao.findAll((Pageable) Sort.by(Sort.Direction.DESC, "price"));
        } else {
            return (List<Product>) productDao.findAll();
        }
    }
    public void deleteProductDetails(Integer productId) {
        productDao.deleteById(productId);
    }



    public List<Product> getProductDetails(boolean isSingleProductCheckout, Integer productId) {
        if (isSingleProductCheckout && productId != 0) {
            //mua mot san pham
            List<Product> list = new ArrayList<>();
            Product product = productDao.findById(productId).get();
            list.add(product);
            return list;
        } else {
            //checkout gio hang
            String currentUser = JwtRequestFilter.CURRENT_USER;
            User user = userDao.findById(currentUser).get();
            List<Cart> carts = cartDao.findByUser(user);

            return carts.stream().map(x -> x.getProduct()).collect(Collectors.toList());
        }
    }
    public Product addNewProduct(Product product) {
        return productDao.save(product);
    }

    public List<Product> getAllProducts(int pageNumber, String searchKey) {
        Pageable pageable = PageRequest.of(pageNumber, 12);

        if (searchKey.equals("")) {
            return (List<Product>) productDao.findAll(pageable);

        } else {
            return (List<Product>) productDao.findByProductNameContainingIgnoreCaseOrProductDescriptionContainingIgnoreCase(
                    searchKey, searchKey, pageable
            );
        }

    }

}
