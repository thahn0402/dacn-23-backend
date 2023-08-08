package nlu.dacn23backend.service;

import nlu.dacn23backend.configuration.JwtRequestFilter;
import nlu.dacn23backend.dao.CartDao;
import nlu.dacn23backend.dao.OrderDetailDao;
import nlu.dacn23backend.dao.ProductDao;
import nlu.dacn23backend.dao.UserDao;
import nlu.dacn23backend.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class OrderDetailService { 


    private static final String ORDER_PLACE = "Đã đặt hàng";


    @Autowired
    private CartDao cartDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private OrderDetailDao orderDetailDao;
    @Autowired 
    private UserDao userDao;





    public List<OrderDetail> getOrderDetails() {
        String currentUser = JwtRequestFilter.CURRENT_USER;
        User user = userDao.findById(currentUser).get();

        return orderDetailDao.findByUser(user);
    }

    public List<OrderDetail> getAllOrderDetails(String status) {
        List<OrderDetail> orderDetails = new ArrayList<>();

        if (status.equals("Tất cả")) {
            orderDetailDao.findAll().forEach(
                    x -> orderDetails.add(x)
            );
        } else {
            orderDetailDao.findByOrderStatus(status).forEach(
                    x -> orderDetails.add(x)
            );
        }
        return orderDetails;
    }
    /*public void placeOrderProduct(OrderInput input, boolean isSingleProductCheckout) {
        List<OrderProductQuantity> productQuantityList = orderInput.getOrderProductQuantityList();

        for (OrderProductQuantity o : productQuantityList) {
            Product product = productDao.findById(o.getProductId()).get();

            String currentUser = JwtRequestFilter.CURRENT_USER;
            User user = userDao.findById(currentUser).get();

            OrderDetail orderDetail = new Detail(
                    input.getFullName(),
                    input.getFullAddress(),
                    input.getContactNumber(),
                    input.getAlternateContactNumber(),
                    ORDER,
                    product.getProductDiscountedPrice() * o.getQuantity(),
                    product,
                    user

            );

            // lam rong gio hang
            if (!isSingleProductCheckout) {
                List<Cart> carts = cartDao.findByUser(user);
                carts.stream().forEach(x -> cartDao.deleteById(x.getCartId()));
            }

            orderDetailDao.save(Detail);
        }
    }*/
    public void markOrderAsDelivered(Integer orderId) {
        OrderDetail orderDetail = orderDetailDao.findById(orderId).get();

        if (orderDetail != null) {
            orderDetail.setOrderStatus("Đã giao hàng");
            orderDetailDao.save(orderDetail);
        }
    }
    public void placeOrder(OrderInput orderInput, boolean isSingleProductCheckout) {
        List<OrderProductQuantity> productQuantityList = orderInput.getOrderProductQuantityList();

        for (OrderProductQuantity o : productQuantityList) {
            Product product = productDao.findById(o.getProductId()).get();

            String currentUser = JwtRequestFilter.CURRENT_USER;
            User user = userDao.findById(currentUser).get();

            OrderDetail orderDetail = new OrderDetail(
                    orderInput.getFullName(),
                    orderInput.getFullAddress(),
                    orderInput.getContactNumber(),
                    orderInput.getAlternateContactNumber(),
                    ORDER_PLACE,
                    product.getProductDiscountedPrice() * o.getQuantity(),
                    product,
                    user

            );

            // lam rong gio hang
            if (!isSingleProductCheckout) {
                List<Cart> carts = cartDao.findByUser(user);
                carts.stream().forEach(x -> cartDao.deleteById(x.getCartId()));
            }

            orderDetailDao.save(orderDetail);
        }
    }

}
