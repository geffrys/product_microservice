package com.geffry.order_service.service;

import com.geffry.order_service.dto.OrderLineItemsDto;
import com.geffry.order_service.dto.OrderRequest;
import com.geffry.order_service.model.Order;
import com.geffry.order_service.model.OrderLineItems;
import com.geffry.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtos()
                .stream()
                .map(this::mapToDto)
                .toList();
        order.setOrderLineItemsList(orderLineItems);

        orderRepository.save(order);
    }

    private OrderLineItems mapToDto(OrderLineItemsDto item) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(item.getPrice());
        orderLineItems.setQuantity(item.getQuantity());
        orderLineItems.setSkuCode(item.getSkuCode());
        return orderLineItems;
    }
}
