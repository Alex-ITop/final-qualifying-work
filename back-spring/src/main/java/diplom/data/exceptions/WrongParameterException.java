package diplom.data.exceptions;

/**
 * Исключение вызывается при неверном параметре для материала
 */
public class WrongParameterException extends BaseException{

    public WrongParameterException(String message) {
        super(message);
    }
}