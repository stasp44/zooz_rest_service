package zooz.managers;

import zooz.dto.ChargeDto;

import java.util.List;

public interface PaymentManager {
    List<ChargeDto> getTransactions(String filters);
}
