package zooz.resources;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zooz.dto.ChargeDto;
import zooz.managers.PaymentManager;

import java.util.List;

@RestController
public class PaymentController {
    private static final Logger log = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    private PaymentManager paymentManager;

    @RequestMapping(method = RequestMethod.GET, path = "/charges")
    public List<ChargeDto> greeting(@RequestParam(value="filters", defaultValue="") String filters) {
        return paymentManager.getTransactions(filters);
    }
}
