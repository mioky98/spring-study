package hello.proxy.app.v2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@RequestMapping
//@Controller는 안에 bean이 자동등록 되기때문에 안씀. 수동 bean등록하는 중임
@ResponseBody
public class OrderControllerV2 {

	private final OrderServiceV2 orderService;

	public OrderControllerV2(OrderServiceV2 orderServiceV2) {
		this.orderService = orderServiceV2;
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
