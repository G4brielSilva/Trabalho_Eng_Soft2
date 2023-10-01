import org.junit.*;

public class LoginTest {
    public static Boolean userIsEmpty(String user) {
        return user.isEmpty();
    }

    public static Boolean userHasValidCharacters(String user) {
        return user.contains(String.valueOf('-'));
    }

    public static Boolean userIsValid(String user) {
        return !userIsEmpty(user) && userHasValidCharacters(user);
    }

    @Test
    public void test() {
        // User is valid
        userIsValid("");
        userIsValid("invalid-username");
        userIsValid("validUserName");
    }
}
