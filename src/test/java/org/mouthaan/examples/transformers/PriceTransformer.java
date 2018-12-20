//package org.mouthaan.examples.transformers;
//
//import cucumber.api.TypeRegistry;
//import cucumber.api.TypeRegistryConfigurer;
//import io.cucumber.datatable.DataTableType;
//import org.mouthaan.examples.models.Price;
//
//import java.util.Locale;
//import java.util.Map;
//
//public class PriceTransformer implements TypeRegistryConfigurer {
//    public Locale locale() {
//        return Locale.ENGLISH;
//    }
//
//    public void configureTypeRegistry(TypeRegistry typeRegistry) {
//        typeRegistry.defineDataTableType(new DataTableType(Price.class,
//                (Map<String, String> row) -> {
//                    String product = row.get("product");
//                    String currency = row.get("currency");
//                    Integer price = Integer.valueOf(row.get("price"));
//
//                    return new Price(product, price, currency);
//                }));
//    }
//}
