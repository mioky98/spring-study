package hello.proxy.app.v2;

public class OrderServiceV2 {

	private final OrderRepositoryV2 orderRepository;

	public OrderServiceV2(OrderRepositoryV2 orderRepositoryV2) {
		this.orderRepository = orderRepositoryV2;
	}

	public void orderItem(String itemId) {
		orderRepository.save(itemId);
	}
}
