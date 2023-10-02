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

    public static Boolean PasswordHasLessThan8Characters(String password) {
        return password.length()<8;
    }
    
    public static Boolean PasswordHasUppercase(String password) {
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }
    
    public static Boolean PasswordHasNumber(String password) {
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
    
    public static Boolean PasswordHasSpecialChar(String password) {
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (!Character.isDigit(c) && !Character.isLetter(c)) {
                return true;
            }
        }
        return false;
    }
    
    public static Boolean PasswordIsValid(String password) {
        return !PasswordHasLessThan8Characters(password) && PasswordHasUppercase(password) && PasswordHasNumber(password) && PasswordHasSpecialChar(password);
    }
    
    @Test
    public void test() {
        // User is valid
        Assert.assertFalse(userIsValid(""));
        Assert.assertFalse(userIsValid("invalid-username"));

        Assert.assertTrue(userIsValid("validUserName"));
        
        Assert.assertFalse(PasswordIsValid("A4!")); //Menos de 8 caracteres
        Assert.assertFalse(PasswordIsValid("@2345678")); //Sem letra maiuscula
        Assert.assertFalse(PasswordIsValid("Abcdefg@")); //Sem numero
        Assert.assertFalse(PasswordIsValid("A2345678")); //Sem caracter especial
        
        Assert.assertTrue(PasswordIsValid("A@345678"));
    }
}



//public class VerificarSenha {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Digite a senha: ");
//        String senha = scanner.nextLine();
//
//        if (verificarSenha(senha)) {
//            System.out.println("Senha válida!");
//        } else {
//            System.out.println("Senha inválida!");
//        }
//    }
//
//    public static boolean verificarSenha(String senha) {
//        // Verificar o comprimento mínimo
//        if (senha.length() < 8) {
//            return false;
//        }
//
//       // Verificar se há pelo menos 1 caractere maiúsculo
//        boolean temMaiusculo = false;
//        for (int i = 0; i < senha.length(); i++) {
//            char c = senha.charAt(i);
//            if (Character.isUpperCase(c)) {
//                temMaiusculo = true;
//                break;
//            }
//        }
//
//        return temMaiusculo;
//    }
//}
