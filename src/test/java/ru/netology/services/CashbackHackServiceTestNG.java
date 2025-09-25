// src/test/java/ru/netology/service/CashbackHackServiceTestNG.java
package ru.netology.services;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.netology.services.CashbackHackService;

public class CashbackHackServiceTestNG {

    CashbackHackService service = new CashbackHackService();

    @Test
    public void shouldReturnRemainingWhenAmountIsLessThanBoundary() {
        int amount = 900;
        int expected = 100; // 1000 - 900 % 1000 = 1000 - 900 = 100
        int actual = service.remain(amount);
        Assert.assertEquals(actual, expected, "При сумме 900 должно оставаться 100.");
    }

    @Test
    public void shouldReturnBoundaryWhenAmountIsEqualToBoundary() {
        int amount = 1000;
        int expected = 1000; // 1000 - 1000 % 1000 = 1000 - 0 = 1000 (ошибка)
        int actual = service.remain(amount);
        Assert.assertEquals(actual, expected, "При сумме 1000 должно оставаться 1000 (по ошибке).");
    }

    @Test
    public void shouldReturnRemainingWhenAmountIsGreaterThanBoundary() {
        int amount = 1100;
        int expected = 900; // 1000 - 1100 % 1000 = 1000 - 100 = 900
        int actual = service.remain(amount);
        Assert.assertEquals(actual, expected, "При сумме 1100 должно оставаться 900 (по ошибке).");
    }

    @Test
    public void shouldReturnFullBoundaryWhenAmountIsZero() {
        int amount = 0;
        int expected = 1000; // 1000 - 0 % 1000 = 1000 - 0 = 1000
        int actual = service.remain(amount);
        Assert.assertEquals(actual, expected, "При сумме 0 должно оставаться 1000.");
    }

    @Test
    public void shouldReturnAlmostFullBoundaryWhenAmountIsOne() {
        int amount = 1000;
        int expected = 0;
        int actual = service.remain(amount);
        Assert.assertEquals(actual, expected, "При сумме 1000 должно оставаться 0.");
    }

    @Test
    public void shouldReturnOneWhenAmountIsBoundaryMinusOne() {
        int amount = 999;
        int expected = 1; // 1000 - 999 % 1000 = 1000 - 999 = 1
        int actual = service.remain(amount);
        Assert.assertEquals(actual, expected, "При сумме 999 должно оставаться 1.");
    }

    @Test
    public void shouldReturnRemainingWhenAmountIsMuchGreaterThanBoundary() {
        int amount = 2500;
        int expected = 500; // 1000 - 2500 % 1000 = 1000 - 500 = 500 (ошибка)
        int actual = service.remain(amount);
        Assert.assertEquals(actual, expected, "При сумме 2500 должно оставаться 500 (по ошибке).");
    }
}
