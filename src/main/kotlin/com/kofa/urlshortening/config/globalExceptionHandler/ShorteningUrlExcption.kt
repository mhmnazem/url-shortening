package com.kofa.urlshortening.config.globalExceptionHandler

/**
 * @author mhmnazem
 * @created 11/20/23
 * @email Mohammad.nazem@gmail.com
 */
class InvalidUrlException(message: String) : IllegalArgumentException(message)

class NotFoundException(message: String) : NoSuchElementException(message)
