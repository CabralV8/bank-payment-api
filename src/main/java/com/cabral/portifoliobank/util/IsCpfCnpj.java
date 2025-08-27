package com.cabral.portifoliobank.util;

public class IsCpfCnpj {

    public static boolean isCpf(String cpfCnpj) {
        cpfCnpj = cpfCnpj.replaceAll("[^0-9]", "");
        if (cpfCnpj.length() != 11) {
            return false;
        }
        String firstDigit = cpfCnpj.substring(0, 1);
        boolean allEqual = true;
        for (int i = 1; i < cpfCnpj.length(); i++) {
            if (!cpfCnpj.substring(i, i + 1).equals(firstDigit)) {
                allEqual = false;
                break;
            }
        }
        if (allEqual) {
            return false;
        }

        int[] digits = new int[11];
        for (int i = 0; i < 11; i++) {
            digits[i] = Integer.parseInt(cpfCnpj.substring(i, i + 1));
        }
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += digits[i] * (10 - i);
        }

        int remainder = sum % 11;
        int digit1 = remainder < 2 ? 0 : 11 - remainder;
        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum +=digits[i] * (11 - i);
        }
        remainder = sum % 11;
        int digit2 = remainder < 2 ? 0 : 11 - remainder;
        return digits[9] == digit1 && digits[10] == digit2;
    }

    public static boolean isCnpj(String cpfCnpj) {
        cpfCnpj = cpfCnpj.replaceAll("[^0-9]", "");
        if (cpfCnpj.length() != 14) {
            return false;
        }
        int[] digits = new int[14];
        for (int i = 0; i < 14; i++) {
            digits[i] = Integer.parseInt(cpfCnpj.substring(i, i + 1));
        }
        int sum = 0;
        int factor = 5;
        for (int i = 0; i < 12; i++) {
            sum += digits[i] * factor;
            factor = (factor == 2) ? 9 : factor - 1;
        }
        int remainder = sum % 11;
        int digit1 = (remainder < 2) ? 0 : 11 - remainder;
        sum = 0;
        factor = 6;
        for (int i = 0; i < 13; i++) {
            sum += digits[i] * factor;
            factor = (factor == 2) ? 9 : factor - 1;
        }
        remainder = sum % 11;
        int digit2 = (remainder < 2) ? 0 : 11 - remainder;
        return digits[12] == digit1 && digits[13] == digit2;
    }
}
