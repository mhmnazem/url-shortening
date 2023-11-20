package com.kofa.urlshortening.controller

import com.kofa.urlshortening.config.globalExceptionHandler.InvalidUrlException
import com.kofa.urlshortening.service.UrlIdentifierService
import com.kofa.urlshortening.utils.isUrlValid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * @author mhmnazem
 * @created 11/20/23
 * @email Mohammad.nazem@gmail.com
 */
@RestController
@RequestMapping("/api/v0")
class UrlIdentifierController(private val urlIdentifierService: UrlIdentifierService) : IUrlIdentifierController {

    @PostMapping("generateIdentifier")
    override fun generateIdentifier(url: String): ResponseEntity<String> {
        return if (!isUrlValid(url)) {
            throw InvalidUrlException("The url provided is invalid")
        } else {
            val generatedIdentifier = urlIdentifierService.generateIdentifier(url).toString()
            return ResponseEntity.ok(generatedIdentifier)
        }
    }

    @GetMapping("/getOriginalUrl/{identifier}")
    override fun getOriginalUrl(@PathVariable identifier: Int): ResponseEntity<String> {
        val originalUrl = urlIdentifierService.getOriginalUrlByIdentifier(identifier)
        return ResponseEntity.ok(originalUrl)
    }
}