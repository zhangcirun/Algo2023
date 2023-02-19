import Go2023.IntegerToEnglish;
import org.junit.Assert;
import org.junit.Test;

public class IntegerToEnglishTest {
    IntegerToEnglish integerToEnglish = new IntegerToEnglish();
    @Test
    public void test1() {
        Assert.assertEquals("Twenty", integerToEnglish.numberToWords(20));
    }

    @Test
    public void test2() {
        Assert.assertEquals("One Hundred Twenty", integerToEnglish.numberToWords(120));
    }


    @Test
    public void test3() {
        Assert.assertEquals("Four Thousand One", integerToEnglish.numberToWords(4001));
    }
    @Test
    public void test4() {
        Assert.assertEquals("One Hundred Thousand", integerToEnglish.numberToWords(100000));
    }

    @Test
    public void test5() {
        Assert.assertEquals("One Million Three Hundred", integerToEnglish.numberToWords(1000300));
    }

    @Test
    public void test6() {
        Assert.assertEquals("Zero", integerToEnglish.numberToWords(0));
    }

    @Test
    public void test7() {
        Assert.assertEquals("One", integerToEnglish.numberToWords(1));
    }

    @Test
    public void test8() {
        Assert.assertEquals("Two", integerToEnglish.numberToWords(2));
    }

    @Test
    public void test9() {
        Assert.assertEquals("Three", integerToEnglish.numberToWords(3));
    }

    @Test
    public void test10() {
        Assert.assertEquals("Four", integerToEnglish.numberToWords(4));
    }

    @Test
    public void test11() {
        Assert.assertEquals("Five", integerToEnglish.numberToWords(5));
    }

    @Test
    public void test12() {
        Assert.assertEquals("Six", integerToEnglish.numberToWords(6));
    }

    @Test
    public void test13() {
        Assert.assertEquals("Seven", integerToEnglish.numberToWords(7));
    }

    @Test
    public void test14() {
        Assert.assertEquals("Eight", integerToEnglish.numberToWords(8));
    }

    @Test
    public void test15() {
        Assert.assertEquals("Eleven", integerToEnglish.numberToWords(11));
    }

    @Test
    public void test16() {
        Assert.assertEquals("Twelve", integerToEnglish.numberToWords(12));
    }


    @Test
    public void test17() {
        Assert.assertEquals("Thirteen", integerToEnglish.numberToWords(13));
    }

    @Test
    public void test18() {
        Assert.assertEquals("Fourteen", integerToEnglish.numberToWords(14));
    }

    @Test
    public void test19() {
        Assert.assertEquals("Fifteen", integerToEnglish.numberToWords(15));
    }

    @Test
    public void test20() {
        Assert.assertEquals("Sixteen", integerToEnglish.numberToWords(16));
    }

    @Test
    public void test21() {
        Assert.assertEquals("Seventeen", integerToEnglish.numberToWords(17));
    }

    @Test
    public void test22() {
        Assert.assertEquals("Eighteen", integerToEnglish.numberToWords(18));
    }

    @Test
    public void test23() {
        Assert.assertEquals("Nineteen", integerToEnglish.numberToWords(19));
    }

    @Test
    public void test24() {
        Assert.assertEquals("One Billion Seven Hundred Eighty Three Million Four Hundred Eighty Three Thousand Six Hundred Twelve", integerToEnglish.numberToWords(1783483612));
    }

    @Test
    public void test25() {
        Assert.assertEquals("Thirty", integerToEnglish.numberToWords(30));
    }

    @Test
    public void test26() {
        Assert.assertEquals("Forty", integerToEnglish.numberToWords(40));
    }

    @Test
    public void test27() {
        Assert.assertEquals("Fifty", integerToEnglish.numberToWords(50));
    }

    @Test
    public void test28() {
        Assert.assertEquals("Sixty", integerToEnglish.numberToWords(60));
    }

    @Test
    public void test29() {
        Assert.assertEquals("Seventy", integerToEnglish.numberToWords(70));
    }

    @Test
    public void test30() {
        Assert.assertEquals("Eighty", integerToEnglish.numberToWords(80));
    }

    @Test
    public void test31() {
        Assert.assertEquals("Ninety", integerToEnglish.numberToWords(90));
    }
}
