package diplom.data.exceptions;

/**
 * Исключение вызывается при ошибки во время выполнения скрипта
 */
public class ScriptFailureException extends BaseException{

    public ScriptFailureException(String message) {
        super(message);
    }

}
