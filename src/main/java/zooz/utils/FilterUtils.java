package zooz.utils;

import org.springframework.util.StringUtils;
import zooz.model.Filter;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterUtils {
    public static List<Filter> getFiltersFromString(String filtersString) {
        if(StringUtils.isEmpty(filtersString)) {
            return Collections.emptyList();
        }
        return Stream.of(filtersString.split(";")).map(Filter::fromString).collect(Collectors.toList());
    }
}
