package Utils;

import Base.BaseTest;
import org.testng.annotations.DataProvider;

public class TestUtils {

    @DataProvider(name="fillform")
    public static Object[][] getData()
    {
        return new Object[][]{
                {"Awe","some","627359"},
                {"meow","kutty","67890"},
                {"wer","are","89076"}
        };
    }
}
