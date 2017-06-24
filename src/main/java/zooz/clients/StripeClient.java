package zooz.clients;

import com.stripe.Stripe;
import com.stripe.exception.*;
import com.stripe.model.Charge;
import com.stripe.model.ChargeCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zooz.config.ApplicationConfig;
import zooz.dto.ChargeDto;
import zooz.exceptions.ForbiddenException;
import zooz.exceptions.ValidationException;
import zooz.model.Filter;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.google.common.collect.ImmutableMap;

@Component
public class StripeClient {
    private static final Logger log = LoggerFactory.getLogger(StripeClient.class);
    private static final String API_KEY  = "sk_test_oRkEA033Mgk41TkpecBDTxPu";
    private static final Map<String, String> ALLOWED_FILTERS = getAllowedFilterMap();

    @Autowired
    private ApplicationConfig applicationConfig;

    private static Map<String, String> getAllowedFilterMap() {
        return ImmutableMap.of("createdDate", "created",
                                "limitTransactions" , "limit",
                                "customerId", "customer");
    }

    public List<ChargeDto> getTransactions(List<Filter> filters) {
        Map<String, Object> chargeParams = getParamsFromFilters(filters);
        try {
            log.debug("Try to get charges using params: ", chargeParams);
            ChargeCollection chargesCollection = Charge.list(chargeParams);
            log.debug("Succeeded to get charges using params: ", chargeParams);
            List<ChargeDto> chargeDtos = getChargeDtosFromList(chargesCollection.getData());

            return chargeDtos;
        } catch (AuthenticationException | APIConnectionException | CardException  e) {
            log.error("Failed to get charges using params: " + chargeParams, e);
            throw new ForbiddenException("api.stripe.error.stripe_request_failed", "exception from stripe service");
        } catch (InvalidRequestException | APIException e) {
            log.error("Failed to get charges using params: " + chargeParams, e);
            throw new ValidationException("api.stripe.error.stripe_request_failed", "invalid request for stripe client");
        }
    }

    private Map<String, Object> getParamsFromFilters(List<Filter> filters) {
        Map<String, Object> chargeParams = new HashMap<>();
        filters.forEach(filter -> {
            if(ALLOWED_FILTERS.containsKey(filter.getName())) {
                chargeParams.put(ALLOWED_FILTERS.get(filter.getName()), filter.getValue());
            } else {
                throw new ValidationException("api.stripe_client.error.filter_is_not_supported", filter.getName() + " filter name is not supported");
            }

        });

        return chargeParams;
    }

    private List<ChargeDto> getChargeDtosFromList(List<Charge> data) {
       return data.stream().map(charge -> new ChargeDto().setAmount(charge.getAmount())
                             .setCreated(charge.getCreated())
                             .setCurrency(charge.getCurrency())
                             .setCustomer(charge.getCustomer())
                             .setDescription(charge.getDescription())).collect(Collectors.toList());
    }

    @PostConstruct
    public void init() {
        Stripe.apiKey = applicationConfig.getApiKey();
    }
}
