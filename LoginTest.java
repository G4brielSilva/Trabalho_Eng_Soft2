import org.junit.*;

public class LoginTest {
    public static Boolean userIsEmpty(String user) {
        return user.isEmpty();
    }

    public static Boolean userHasInvalidCharacters(String user) {
        return user.contains(String.valueOf('-'));
    }

    public static Boolean userIsValid(String user) {
        return !userIsEmpty(user) && !userHasInvalidCharacters(user);
    }

    @Test
    public void test() {
        // User is valid
        Assert.assertFalse(userIsValid(""));
        Assert.assertFalse(userIsValid("invalid-username"));

        Assert.assertTrue(userIsValid("validUserName"));
    }
}
