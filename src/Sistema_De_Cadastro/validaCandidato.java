public class ValidaCandidato {

        public boolean validarIdade(String idade) {
            try {
                int valor = Integer.parseInt(idade);
                return valor > 0 && valor < 120;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        public boolean validarEmail(String email) {
            return email.contains("@") && email.contains(".");
        }
    }


