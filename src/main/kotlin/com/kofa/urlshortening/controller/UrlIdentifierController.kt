package com.kofa.urlshortening.controller

import com.kofa.urlshortening.service.UrlIdentifierService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author mhmnazem
 * @created 11/20/23
 * @email Mohammad.nazem@gmail.com
 */
@RestController
@RequestMapping("/api/v1.0")
class UrlIdentifierController(private val urlIdentifierService: UrlIdentifierService) : IUrlIdentifierController {

    @PostMapping("generateIdentifier")
    override fun generateIdentifier(url: String, checkValidation: Boolean): ResponseEntity<Int> {
        return if (checkValidation) {
            ResponseEntity.badRequest().body(400)
        } else {
            val shortenedUrl = urlIdentifierService.generateIdentifier(url)
            return ResponseEntity.ok(shortenedUrl)
        }
    }
}