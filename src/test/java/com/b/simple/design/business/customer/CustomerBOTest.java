package com.b.simple.design.business.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.b.simple.design.business.exception.DifferentCurrenciesException;
import com.b.simple.design.model.customer.Amount;
import com.b.simple.design.model.customer.AmountImpl;
import com.b.simple.design.model.customer.Currency;
import com.b.simple.design.model.customer.Product;
import com.b.simple.design.model.customer.ProductImpl;
import com.b.simple.design.model.customer.ProductType;

public class CustomerBOTest {

    private CustomerBO customerBO = new CustomerBOImpl();

    @Test
    public void customerProductSumTwoProductsSameCurrencies() throws DifferentCurrenciesException {
        List<AmountImpl> amounts = new ArrayList<AmountImpl>() {{
            add(new AmountImpl(new BigDecimal("5.0"), Currency.EURO));
            add(new AmountImpl(new BigDecimal("6.0"), Currency.EURO));
        }};
        List<Product> products = getProductsWithAmounts(amounts);

        Amount actual = customerBO.getCustomerProductsSum(products);
        Amount expected = new AmountImpl(new BigDecimal("11.0"), Currency.EURO);

        assertCurrency(expected, actual);
    }

    @Test
    public void customerProductSumOfTwoDifferentCurrencies(){
        List<AmountImpl> amounts = new ArrayList<AmountImpl>() {{
            add(new AmountImpl(new BigDecimal("5.0"), Currency.INDIAN_RUPEE));
            add(new AmountImpl(new BigDecimal("6.0"), Currency.EURO));
        }};

        List<Product> products = getProductsWithAmounts(amounts);

        Assertions.assertThrows(DifferentCurrenciesException.class, () ->
                customerBO.getCustomerProductsSum(products));
    }

    @Test
    public void customerProductSumEmptyProduct() throws DifferentCurrenciesException {
        Amount expected = new AmountImpl(BigDecimal.ZERO, Currency.EURO);
        Amount actual = customerBO.getCustomerProductsSum( new ArrayList<>());

        assertCurrency(expected, actual);
    }

    private static void assertCurrency(Amount expected, Amount actual) {
        assertEquals(expected.getCurrency(), actual.getCurrency());
        assertEquals(expected.getValue(), actual.getValue());
    }

    List<Product> getProductsWithAmounts(List<AmountImpl> amounts) {
        return amounts.stream().
                map(amount ->
                        new ProductImpl(100, "Product 15", ProductType.BANK_GUARANTEE, amount))
                .collect(Collectors.toList());
    }

}