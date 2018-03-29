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
    
//correct data with "-" and without "+38"
    @Test
    public static void test1_isPhone() {
        String testData = "097 515-69-00";
        boolean result = isPhone(testData);
        Assert.assertTrue(result, "Test1");
    }

//correct data without "-" and with "+38"
    @Test
    public static void test2_isPhone() {
        String testData = "+380975156900";
        boolean result = isPhone(testData);
        Assert.assertTrue(result, "Test2");
    }

//empty value
    @Test
    public static void test8_isPhone() {
        String testData = "";
        boolean result = isPhone(testData);
        Assert.assertFalse(result, "Test8");
    }

// incorrect data
    @Test
    public static void test3_isPhone() {
        String testData = "asdaddasds";
        boolean result = isPhone(testData);
        Assert.assertFalse(result, "Test3");
    }

//too long numb
    @Test
    public static void test4_isPhone() {
        String testData = "+3809751569009";
        boolean result = isPhone(testData);
        Assert.assertFalse(result, "Test4");
    }

//too short numb
    @Test
    public static void test9_isPhone() {
        String testData = "+3809751569009";
        boolean result = isPhone(testData);
        Assert.assertFalse(result, "Test9");
    }

// tab instead of space
    @Test
    public static void test5_isPhone() {
        String testData = "+38097   5156900";
        boolean result = isPhone(testData);
        Assert.assertFalse(result, "Test5");
    }

// "-" on unexpected place
    @Test
    public static void test7_isPhone() {
        String testData = "+38097515--6900";
        boolean result = isPhone(testData);
        Assert.assertFalse(result, "Test7");
    }

//space on unexpected place
    @Test
    public static void test10_isPhone() {
        String testData = "+38097515--6900";
        boolean result = isPhone(testData);
        Assert.assertFalse(result, "Test10");
    }

}
