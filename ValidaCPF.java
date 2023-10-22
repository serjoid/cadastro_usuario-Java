public class ValidaCPF {

    // Método para validar um número de CPF
    public static boolean validarCPF(String cpf) {
        // Verifica se o CPF é nulo ou se possui um tamanho inválido
        if (cpf == null) {
            throw new IllegalArgumentException("CPF não pode ser nulo.");
        } else if (cpf.length() != 11) {
            throw new IllegalArgumentException("CPF deve ter 11 dígitos.");
        }

        // Verifica se os dígitos verificadores são válidos
        return validarDigitosVerificadores(cpf);
    }

    // Método para validar os dígitos verificadores do CPF
    private static boolean validarDigitosVerificadores(String cpf) {
        int total1 = 0, total2 = 0;
        int multiplicador = 10;

        // Calcula o primeiro dígito verificador
        for (int i = 0; i < 9; i++) {
            int c = cpf.charAt(i) - '0';
            total1 += multiplicador * c;
            total2 += (multiplicador + 1) * c;
            multiplicador--;
        }

        // Verifica se o primeiro dígito verificador é válido
        int dv1 = calcularDigitoVerificador(total1);
        if (dv1 != cpf.charAt(9) - '0') {
            return false;
        }

        // Verifica se o segundo dígito verificador é válido
        total2 += dv1 * 2;
        int dv2 = calcularDigitoVerificador(total2);
        return dv2 == cpf.charAt(10) - '0';
    }

    // Calcula um dígito verificador com base no total
    private static int calcularDigitoVerificador(int total) {
        int resto = total % 11;
        return resto < 2 ? 0 : 11 - resto;
    }
}
