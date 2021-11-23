package hello.proxy.app.v1;

public class OrderControllerV1Impl implements OrderControllerV1{

	private final OrderServiceV1 orderService;

	public OrderControllerV1Impl(OrderServiceV1 orderServiceV1) {
		this.orderService = orderServiceV1;
	}

	@Override
	public String request(String itemId) { //LogTrace를 적용할 대상
		orderService.orderItem(itemId);
		return "ok";
	}

	@Override
	public String noLog() { //LogTrace를 적용하지 않을 대상
		return "ok";
	}
}
