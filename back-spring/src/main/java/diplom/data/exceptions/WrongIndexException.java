package diplom.data.exceptions;

/**
 * Исключение вызывается при неверном индексе из списков для отобрадения
 */
public class WrongIndexException extends BaseException{

    public WrongIndexException(String message) {
        super(message);
    }
}
