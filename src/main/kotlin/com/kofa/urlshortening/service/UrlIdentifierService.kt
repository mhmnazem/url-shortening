package com.kofa.urlshortening.service

import com.kofa.urlshortening.entity.UrlIdentifierEntity
import com.kofa.urlshortening.repository.UrlIdentifierRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

/**
 * @author mhmnazem
 * @created 11/20/23
 * @email Mohammad.nazem@gmail.com
 */

@Service
class UrlIdentifierService (private val urlIdentifierRepository: UrlIdentifierRepository){

    @Transactional
    fun generateIdentifier(originalUrl:String):Int{
        val findByOriginalUrl = urlIdentifierRepository.findByOriginalUrl(originalUrl)
        // Return the Hashed URL if it already exists
        if (findByOriginalUrl != null)
             return findByOriginalUrl.identifier

        val generateIdentifier = originalUrl.hashCode()
        val entity = UrlIdentifierEntity(originalUrl = originalUrl, identifier = generateIdentifier)
        urlIdentifierRepository.save(entity)
        return generateIdentifier
    }
}