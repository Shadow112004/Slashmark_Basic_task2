import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the desired password length:");
        int passwordLength = scanner.nextInt();
        String password = generatePassword(passwordLength);
        System.out.println("Generated password: " + password);
        System.out.println("Password strength: " + checkPasswordStrength(password));
    }

    public static String generatePassword(int length) {
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialCharacters = "!@#$%^&*()-+";
        String allCharacters = uppercaseLetters + lowercaseLetters + numbers + specialCharacters;
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allCharacters.length());
            password.append(allCharacters.charAt(randomIndex));
        }
        return password.toString();
    }

    public static String checkPasswordStrength(String password) {
        int strength = 0;
        if (password.length() >= 12) {
            strength += 1;
        }
        if (password.matches(".*[A-Z].*")) {
            strength += 1;
        }
        if (password.matches(".*[a-z].*")) {
            strength += 1;
        }
        if (password.matches(".*[0-9].*")) {
            strength += 1;
        }
        if (password.matches(".*[!@#$%^&*()-+].*")) {
            strength += 1;
        }
        switch (strength) {
            case 1:
                return "Very weak";
            case 2:
                return "Weak";
            case 3:
                return "Moderate";
            case 4:
                return "Strong";
            case 5:
                return "Very strong";
            default:
                return "Invalid password";
        }
    }
}