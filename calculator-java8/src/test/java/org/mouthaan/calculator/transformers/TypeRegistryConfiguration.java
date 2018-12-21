package org.mouthaan.calculator.transformers;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import org.mouthaan.calculator.models.Entry;
import org.mouthaan.calculator.models.Grocery;
import org.mouthaan.calculator.models.Price;

import java.util.Locale;
import java.util.Map;

public class TypeRegistryConfiguration implements TypeRegistryConfigurer {
    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(new DataTableType(
                Entry.class,
                (Map<String, String> row) -> new Entry(
                        Integer.valueOf(row.get("first")),
                        Integer.valueOf(row.get("second")),
                        row.get("operation")
                )
        ));

        typeRegistry.defineDataTableType(new DataTableType(
                Grocery.class,
                (Map<String, String> row) -> new Grocery(
                        row.get("name"),
                        new Price(Integer.valueOf(row.get("price")))
                )
        ));
    }
}
