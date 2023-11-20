package com.kofa.urlshortening.config.globalExceptionHandler

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

/**
 * @author mhmnazem
 * @created 11/20/23
 * @email Mohammad.nazem@gmail.com
 */

@ControllerAdvice
class GlobalExceptionHandler {
    /**
     * Handles InvalidUrlException by returning a ResponseEntity with a BAD REQUEST status.
     * sets the HTTP status to BAD REQUEST (400).
     * @param ex The caught InvalidUrlException.
     * @return A ResponseEntity containing the exception message and a BAD REQUEST status.
     */
    @ExceptionHandler(InvalidUrlException::class)
    fun handleInvalidUrlException(ex: InvalidUrlException): ResponseEntity<String> {
        return ResponseEntity(ex.message, HttpStatus.BAD_REQUEST)
    }

    /**
     * Handles NotFoundException by returning a ResponseEntity with a NOT FOUND status.
     * sets the HTTP status to NOT FOUND (404).
     * @param ex The caught NotFoundException.
     * @return A ResponseEntity containing the exception message and a NOT FOUND status.
     */
    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(ex: NotFoundException): ResponseEntity<String> {
        return ResponseEntity(ex.message, HttpStatus.NOT_FOUND)
    }
}