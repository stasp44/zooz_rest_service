package zooz.managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zooz.clients.StripeClient;
import zooz.dto.ChargeDto;
import zooz.model.Filter;
import zooz.utils.FilterUtils;

import java.util.List;

@Service
public class PaymentManagerImpl implements PaymentManager {

    @Autowired
    private StripeClient stripeClient;

    @Override
    public List<ChargeDto> getTransactions(String filtersString) {
        List<Filter> filters = FilterUtils.getFiltersFromString(filtersString);
        return stripeClient.getTransactions(filters);
    }
}
