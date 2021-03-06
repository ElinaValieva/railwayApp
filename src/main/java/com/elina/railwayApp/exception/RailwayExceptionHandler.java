package com.elina.railwayApp.exception;

import com.elina.railwayApp.DTO.ErrorDTO;
import com.sun.mail.smtp.SMTPSendFailedException;
import lombok.extern.log4j.Log4j;
import org.dom4j.DocumentException;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSendException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.concurrent.TimeoutException;

@ControllerAdvice
@Log4j
public class RailwayExceptionHandler {


    @ExceptionHandler(BusinessLogicException.class)
    public ResponseEntity<?> handleBusinessLogicException(BusinessLogicException ex) {
        log.error(ex.getMessage(), ex);
        return ResponseEntity.badRequest().body(new ErrorDTO(ex.getError()));
    }

    @ExceptionHandler({ParseException.class, IOException.class})
    public ResponseEntity<?> handleParseException(Exception ex) {
        log.error(ex.getMessage(), ex);
        if (ex instanceof ParseException)
            return ResponseEntity.badRequest().body(new ErrorDTO(ErrorCode.PARSE_EXCEPTION.getMessage()));
        else return ResponseEntity.badRequest().body(ErrorCode.IO_EXCEPTION.getMessage());
    }

    @ExceptionHandler({MessagingException.class, SMTPSendFailedException.class, MailSendException.class, MailException.class})
    public ResponseEntity<?> handleMailException(Exception ex) {
        log.error(ex.getMessage(), ex);
        return ResponseEntity.badRequest().body(new ErrorDTO(ErrorCode.MAIL_EXCEPTION.getMessage()));
    }

    @ExceptionHandler({FileNotFoundException.class, DocumentException.class})
    public ResponseEntity<?> handleFilesException(Exception ex) {
        log.error(ex.getMessage(), ex);
        if (ex instanceof FileNotFoundException)
            return ResponseEntity.badRequest().body(new ErrorDTO(ErrorCode.FILE_EXCEPTION.getMessage()));
        else return ResponseEntity.badRequest().body(new ErrorDTO(ErrorCode.DOCUMENT_EXCEPTION.getMessage()));
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<?> handleUsernameNotFoundException(UsernameNotFoundException ex) {
        log.error(ex.getMessage(), ex);
        return ResponseEntity.badRequest().body(new ErrorDTO(ErrorCode.USER_NOT_FOUND.getMessage()));
    }

    @ExceptionHandler(TimeoutException.class)
    public ResponseEntity<?> handleTimeOutException(TimeoutException ex) {
        log.error(ex.getMessage(), ex);
        return ResponseEntity.badRequest().body(new ErrorDTO(ErrorCode.TIME_OUT.getMessage()));
    }
}
