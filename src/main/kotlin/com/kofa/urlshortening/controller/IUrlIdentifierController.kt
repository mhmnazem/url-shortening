package com.kofa.urlshortening.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam

/**
 * @author mhmnazem
 * @created 11/20/23
 * @email Mohammad.nazem@gmail.com
 */
interface IUrlIdentifierController {

    @Operation(summary = "Generate Identifier", description = "Creates an identifier associated with the provided URL.")
    fun generateIdentifier(
        @RequestParam(value = "url")
        @Parameter(
            description = "The original url to initiate the identifier",
            example = "https://www.example.com"
        ) url: String,

        @RequestParam("checkValidation")
        @Parameter(description = "The property to enable validation url", example = "false")
        checkValidation: Boolean
    ): ResponseEntity<Int>

    @Operation(summary = "Retrieve the original URL")
    fun getOriginalUrl(@PathVariable identifier: Int): ResponseEntity<String>

}