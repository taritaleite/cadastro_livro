package projetos.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class LivroExceptionHandler {

    @ExceptionHandler(LivroException.class)
    public ResponseEntity<Error> handleLivroExistenteException(LivroException ex) {

        Error error = new Error(HttpStatus.CONFLICT.value(),ex.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Error> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Error error = new Error(HttpStatus.BAD_REQUEST.value(),ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
