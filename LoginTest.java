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

public class VerificarSenha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        if (verificarSenha(senha)) {
            System.out.println("Senha válida!");
        } else {
            System.out.println("Senha inválida!");
        }
    }

    public static boolean verificarSenha(String senha) {
        // Verificar o comprimento mínimo
        if (senha.length() < 8) {
            return false;
        }

        // Verificar se há pelo menos 1 caractere maiúsculo
        boolean temMaiusculo = false;
        for (int i = 0; i < senha.length(); i++) {
            char c = senha.charAt(i);
            if (Character.isUpperCase(c)) {
                temMaiusculo = true;
                break;
            }
        }

        return temMaiusculo;
    }
}
