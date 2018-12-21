package org.mouthaan.calculator2.transformers;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterByTypeTransformer;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableCellByTypeTransformer;
import io.cucumber.datatable.TableEntryByTypeTransformer;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import org.mouthaan.calculator2.models.Price;

import java.lang.reflect.Type;
import java.util.Locale;
import java.util.Map;

public class ParameterTypes implements TypeRegistryConfigurer {
    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(new DataTableType(Price.class,
                (Map<String, String> row) -> {
                    String product = row.get("product");
                    String currency = row.get("currency");
                    Integer price = Integer.valueOf(row.get("price"));

                    return new Price(product, price, currency);
                }));
    }
}
