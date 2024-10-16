package com.b.simple.design.business.customer;

import java.math.BigDecimal;
import java.util.List;

import com.b.simple.design.business.exception.DifferentCurrenciesException;
import com.b.simple.design.model.customer.Amount;
import com.b.simple.design.model.customer.AmountImpl;
import com.b.simple.design.model.customer.Currency;
import com.b.simple.design.model.customer.Product;

public class CustomerBOImpl implements CustomerBO {

    @Override
    public Amount getCustomerProductsSum(List<Product> products) throws DifferentCurrenciesException {
        if (products.isEmpty()) {
            return new AmountImpl(BigDecimal.ZERO, Currency.EURO);
        }
        Currency firstProductCurrency = products.get(0).getAmount().getCurrency();
        if (!doAllProductsHaveSameCurrency(products, firstProductCurrency)) {
            throw new DifferentCurrenciesException();
        }

        return new AmountImpl(calculateSumOfProducts(products), firstProductCurrency);
    }

    private static BigDecimal calculateSumOfProducts(List<Product> products) {
        return products.stream()
                .map(product -> product.getAmount().getValue())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private static boolean doAllProductsHaveSameCurrency(List<Product> products, Currency currency) {
        return products.stream()
                .map(product -> product.getAmount().getCurrency())
                .allMatch(productCurrency -> productCurrency.equals(currency));
    }
}