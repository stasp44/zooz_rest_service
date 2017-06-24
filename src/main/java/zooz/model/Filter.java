package zooz.model;

import org.springframework.http.HttpStatus;
import zooz.exceptions.BaseZoozServiceException;
import zooz.exceptions.ValidationException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Filter {
    private static final String FILTER_PATTERN_STRING = "(\\w+(?:,.+)*)\\)";
    private static final Pattern pattern = Pattern.compile(FILTER_PATTERN_STRING);

    private String name;
    private Object value;

    public Filter(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public static Filter fromString(String filterString) {
        Matcher matcher = pattern.matcher(filterString);
        if(matcher.find()) {
            String[] filterParams = matcher.group(1).split(",");
            validateFilterParams(filterParams);
            return new Filter(filterParams[0], filterParams[1]);
        } else {
            throw new ValidationException("api.filter.error.invalid_filter_format", "filter format is not supported");
        }
    }

    private static void validateFilterParams(String[] filterParams) {
        if(filterParams.length != 2) {
            throw new ValidationException("api.filter.error.invalid_filter_format", "wrong number of elements in the filter");
        }
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
