// src/test/java/ru/netology/service/CashbackHackServiceJUnit4.java
package ru.netology.services;

import org.junit.Assert;
import org.junit.Test; // Полное имя аннотации


public class CashbackHackServiceJUnit4 { // Класс должен быть public

    CashbackHackService service = new CashbackHackService();

    @Test
    public void shouldReturnRemainingWhenAmountIsLessThanBoundary() {
        int amount = 900;
        int expected = 100; // 1000 - 900 = 100 (корректно)
        int actual = service.remain(amount);
        Assert.assertEquals("При сумме 900 должно оставаться 100.", expected, actual);
    }

    @Test // Этот тест упадет, так как ожидаем 0, а получаем 1000 из-за бага
    public void shouldReturnZeroWhenAmountIsEqualToBoundary() {
        int amount = 1000;
        int expected = 0; // Ожидаемое: 0 (корректное поведение)
        int actual = service.remain(amount); // Фактически вернет 1000 из-за бага: 1000 - 1000 % 1000 = 1000 - 0 = 1000
        Assert.assertEquals("При сумме 1000 должно оставаться 0 (ожидаемое корректное поведение).", expected, actual);
    }


    @Test
    public void shouldReturnFullBoundaryWhenAmountIsZero() {
        int amount = 0;
        int expected = 1000; // 1000 - 0 = 1000 (корректно)
        int actual = service.remain(amount);
        Assert.assertEquals("При сумме 0 должно оставаться 1000.", expected, actual);
    }

    @Test
    public void shouldReturnOneWhenAmountIsBoundaryMinusOne() {
        int amount = 999;
        int expected = 1; // 1000 - 999 = 1 (корректно)
        int actual = service.remain(amount);
        Assert.assertEquals("При сумме 999 должно оставаться 1.", expected, actual);
    }
}
