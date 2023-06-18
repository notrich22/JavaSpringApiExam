package org.top.exam.controller;

import org.springframework.web.bind.annotation.*;
import org.top.exam.repository.*;
import org.top.exam.entity.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RestController
public class MainController {

    private final ItemRepository itemRepository;
    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;


    public MainController(ItemRepository itemRepository, OrderItemRepository orderItemRepository, OrderRepository orderRepository) {
        this.itemRepository = itemRepository;
        this.orderItemRepository = orderItemRepository;
        this.orderRepository = orderRepository;
    }
    @GetMapping("/")
    public String status(){
        return "Server is running";
    }
    @GetMapping("/ping")
    public String ping(){
        return "ping!";
    }
    @GetMapping("/items/")
    public Iterable<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @GetMapping("/items/{id}")
    public Optional<Item> getItemById(@PathVariable Integer id) {
        return itemRepository.findById(id);
    }

    @GetMapping("/items/find-by-name/{name}")
    public Item getItemByName(@PathVariable String name) {
        return itemRepository.findByName(name);
    }

    @PostMapping("/items/add")
    public Item addItem(@RequestBody Item item) {
        return itemRepository.save(item);
    }

    @PostMapping("/items/edit/{id}")
    public Item updateItem(@PathVariable Integer id, @RequestBody Item updatedItem) throws Exception {
        Item existingItem = itemRepository.findById(id)
                .orElseThrow(() -> new Exception("Item not found"));
        existingItem.setName(updatedItem.getName());
        existingItem.setPrice(updatedItem.getPrice());
        return itemRepository.save(existingItem);
    }

    @GetMapping("items/delete/{id}")
    public void deleteItem(@PathVariable Integer id) {
        itemRepository.deleteById(id);
    }

    @PostMapping("/orders/create")
    public Order createOrder(@RequestBody List<OrderItem> orderItems, @RequestBody String customerName) {
        Order order = new Order();
        order.setCreatedAt(LocalDateTime.now());
        order.setCustomerName(customerName);
        order.setOrderItems(orderItems);
        return orderRepository.save(order);
    }

    @GetMapping("/orders/")
    public Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/orders/{id}")
    public Optional<Order> getOrderById(@PathVariable Integer id) {
        return orderRepository.findById(id);
    }

    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable Integer id) {
        orderRepository.deleteById(id);
    }
}
