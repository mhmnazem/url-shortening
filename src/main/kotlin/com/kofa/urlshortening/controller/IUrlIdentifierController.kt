package com.kofa.urlshortening.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.responses.ApiResponse
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
    @ApiResponse(responseCode = "200", description = "Successfully generated the identifier.")
    @ApiResponse(responseCode = "400", description = "URL is not valid.")
    fun generateIdentifier(
        @RequestParam(value = "url")
        @Parameter(
            description = "The original url to initiate the identifier",
            example = "https://www.example.com"
        ) url: String
    ): ResponseEntity<String>

    @Operation(summary = "Retrieve the original URL")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved the original URL.")
    @ApiResponse(responseCode = "404", description = "URL identifier not found.")
    fun getOriginalUrl(@PathVariable identifier: Int): ResponseEntity<String>

}