import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
public class ValidaEmail {

    public static boolean isEmailValido(String email) {
        boolean resultado = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex){
            resultado = false;
        }
        return resultado;
    }

}
