package bank.exceptions;

import net.minidev.json.JSONObject;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<CustomExceptionHandlerResponse> customErrors = ex.getFieldErrors().stream()
                .map(f -> new CustomExceptionHandlerResponse(f.getField(), f.getDefaultMessage()))
                .collect(Collectors.toList());

        return new ResponseEntity<>(customErrors, status);
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DataIntegrityViolationException.class)
    protected ResponseEntity<Object> handleDuplicatedValues(DataIntegrityViolationException ex) {
        JSONObject bodyResponse = new JSONObject();
        String error = ex.toString();

        if(error.contains("CPF")){
            bodyResponse.put("cpf","Este CPF já está cadastrado");
        }

        if (error.contains("EMAIL")){
            bodyResponse.put("email","Este email já está cadastrado");
        }

        return new ResponseEntity<>(bodyResponse.toString(), HttpStatus.CONFLICT);
    }
}