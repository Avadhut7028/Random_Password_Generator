import java.util.*;

public class PasswordGenerator {
    public static void main(String[] args) {
        int length = getPasswordLength();
        boolean includeUppercase = shouldIncludeUppercase();
        boolean includeLowercase = shouldIncludeLowercase();
        boolean includeNumbers = shouldIncludeNumbers();
        boolean includeSpecialChars = shouldIncludeSpecialChars();

        String password = generatePassword(length, includeUppercase, includeLowercase, includeNumbers, includeSpecialChars);

        System.out.println("Generated password: " + password);
    }

    public static int getPasswordLength() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter password length: ");
        return scanner.nextInt();
    }

    public static boolean shouldIncludeUppercase() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Include uppercase letters? (Y/N): ");
        String input = scanner.nextLine();
        return input.equalsIgnoreCase("Y");
    }

    public static boolean shouldIncludeLowercase() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Include lowercase letters? (Y/N): ");
        String input = scanner.nextLine();
        return input.equalsIgnoreCase("Y");
    }

    public static boolean shouldIncludeNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Include numbers? (Y/N): ");
        String input = scanner.nextLine();
        return input.equalsIgnoreCase("Y");
    }

    public static boolean shouldIncludeSpecialChars() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Include special characters? (Y/N): ");
        String input = scanner.nextLine();
        return input.equalsIgnoreCase("Y");
    }

    public static String generatePassword(int length, boolean includeUppercase, boolean includeLowercase, boolean includeNumbers, boolean includeSpecialChars) {
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialChars = "!@#$%^&*()-_=+[]{}\\|;:'\",.<>/?";

        String validChars = "";
        if (includeUppercase) {
            validChars += uppercaseLetters;
        }
        if (includeLowercase) {
            validChars += lowercaseLetters;
        }
        if (includeNumbers) {
            validChars += numbers;
        }
        if (includeSpecialChars) {
            validChars += specialChars;
        }

        Random random = new Random();
        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(validChars.length());
            password.append(validChars.charAt(randomIndex));
        }

        return password.toString();
    }
}
