package com.openshop.parser;

import static java.util.Collections.singletonList;
import static org.testng.Assert.assertEquals;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Currency;
import java.util.Locale;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.openshop.product.domain.Component;
import com.openshop.product.domain.Price;
import com.openshop.product.domain.Product;

/**
 * Unit test for {@link ObjectToJsonParser}.
 *
 * @author Laszlo_Sisa
 */
public class ObjectToJsonParserTest {

    private static final Price TEN_DOLLARS = new Price(BigDecimal.TEN, Currency.getInstance(Locale.US));
    private static final String EXPECTED_JSON = "{\"id\":\"-1\",\"name\":\"name\",\"description\":\"description\",\"price\":{\"nativeAmount\":10,\"nativeCurrency\":\"USD\"},\"images\":[\"http://url\"],\"components\":[{\"id\":\"-1\"}]}";

    private ObjectToJsonParser underTest;

    @BeforeClass
    public void setUp() {
        underTest = new ObjectToJsonParser();
    }

    @Test
    public void testCreateJsonWhenCalledShouldReturnJsonAsString() throws MalformedURLException {
        Product product = createProduct();

        String actual = underTest.serializeObject(product);

        assertEquals(actual, EXPECTED_JSON);
    }

    private Product createProduct() throws MalformedURLException {
        Component component = new Component.Builder().withId("-1").build();
        URL images = new URL("http://url");
        return new Product.Builder().withComponents(singletonList(component)).withDescription("description").withId("-1")
                .withImages(singletonList(images)).withName("name").withPrice(TEN_DOLLARS).build();
    }

}
