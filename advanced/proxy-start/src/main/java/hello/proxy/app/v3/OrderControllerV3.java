package hello.proxy.app.v3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OrderControllerV3 {

	private final OrderServiceV3 orderService;

	public OrderControllerV3(OrderServiceV3 orderService) {
		this.orderService = orderService;
	}

	@GetMapping("/v2/request")
	public String request(String itemId) { //LogTrace를 적용할 대상
		orderService.orderItem(itemId);
		return "ok";
	}

	@GetMapping("/v2/no-log")
	public String noLog() { //LogTrace를 적용하지 않을 대상
		return "ok";
	}
}
