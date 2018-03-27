import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class TestMavenClass {
//    public static void main(String[] args) throws IOException {
//         String[] testData = { "0975156900", "(097)5156900", "(097)515-69-00", "(097)51-56-900", "+380975156900",
//                 "+38 097 515 69 00" };
//        test1_isPhone();
//        test2_isPhone();
//    }

    public static boolean isPhone(String text) {
        String regex = "(?:\\+38)? ?(?:0\\d{2}|\\(0\\d{2}\\)) ?\\d{2}(?:\\d{3}|\\d[- ]\\d{2}[- ]|[ -]\\d{2}[ -]\\d)\\d{2}";
        return text.matches(regex);
    }

    @Test
    public static void test1_isPhone() {
        String testData = "097515-69-00";
        boolean result = isPhone(testData);
        Assert.assertTrue(result, "Test1");
    }
//    @Test
//    public static void test6_isPhone() {
//        String testData = "097515-69-00";
//        boolean result = isPhone(testData);
//        Assert.assertTrue(result, "Test6");
//    }

    @Test
    public static void test2_isPhone() {
        String testData = "+380975156900";
        boolean result = isPhone(testData);
        Assert.assertTrue(result, "Test2");
    }

    @Test
    public static void test3_isPhone() {
        String testData = "asdaddasds";
        boolean result = isPhone(testData);
        Assert.assertFalse(result);
    }

    @Test
    public static void test4_isPhone() {
        String testData = "+380975156900 65454";
        boolean result = isPhone(testData);
        Assert.assertFalse(result, "Test4 with too long numb");
    }

    @Test
    public static void test5_isPhone() {
        String testData = "+38 0975 15 6900";
        boolean result = isPhone(testData);
        Assert.assertFalse(result, "Test5");
    }

    @Test
    public static void test7_isPhone() {
        String testData = "+38097515--6900";
        boolean result = isPhone(testData);
        Assert.assertFalse(result, "Test7");
    }

}
