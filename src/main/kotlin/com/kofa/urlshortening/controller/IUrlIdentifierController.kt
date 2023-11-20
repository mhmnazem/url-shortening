package com.kofa.urlshortening.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestParam

/**
 * @author mhmnazem
 * @created 11/20/23
 * @email Mohammad.nazem@gmail.com
 */
interface IUrlIdentifierController {

    fun generateIdentifier(
        @RequestParam(value = "url") url: String,
        @RequestParam("checkValidation") checkValidation: Boolean
    ): ResponseEntity<Int>
}