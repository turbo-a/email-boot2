package com.yaorange.proxy;

import org.springframework.cglib.proxy.Proxy;

public class HouseApp2 {
	public static void main(String[] args) {
        BuyHouse buyHouse = new BuyHouseImpl();
        BuyHouse proxyBuyHouse = (BuyHouse) Proxy.newProxyInstance(
        BuyHouse.class.getClassLoader(),
        new Class[]{BuyHouse.class},
        new DynamicProxyHandler(buyHouse));
        proxyBuyHouse.buyHouse();
    }
}
