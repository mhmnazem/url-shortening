package com.kofa.urlshortening.service

import com.kofa.urlshortening.config.globalExceptionHandler.InvalidUrlException
import com.kofa.urlshortening.config.globalExceptionHandler.NotFoundException
import com.kofa.urlshortening.entity.UrlIdentifierEntity
import com.kofa.urlshortening.repository.UrlIdentifierRepository
import com.kofa.urlshortening.utils.isUrlValid
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

/**
 * @author mhmnazem
 * @created 11/20/23
 * @email Mohammad.nazem@gmail.com
 */

@Service
class UrlIdentifierService (private val urlIdentifierRepository: UrlIdentifierRepository){

    /**
     * Generates a unique identifier for a given URL.
     *
     * This function checks if the provided URL already has an associated identifier in the repository.
     * If it exists, the existing identifier is returned. Otherwise, it generates a new identifier
     * based on the hash code of the URL, stores this information in the repository, and returns the identifier.
     *
     * @param originalUrl The URL for which the identifier is to be generated.
     * @return An integer representing the unique identifier for the given URL.
     *
     * @Transactional Ensures that the entire process of checking, possibly generating a new identifier,
     * and storing the information is completed atomically.
     */
    @Transactional
    fun generateIdentifier(originalUrl:String):String {
         if (!isUrlValid(originalUrl)) {
            throw InvalidUrlException("The url provided is invalid")
        }
            val findByOriginalUrl = urlIdentifierRepository.findByOriginalUrl(originalUrl)
            // Return the Hashed URL if it already exists

            if (findByOriginalUrl != null)
                return findByOriginalUrl.identifier.toString()

            val generateIdentifier = originalUrl.hashCode()
            val entity = UrlIdentifierEntity(originalUrl = originalUrl, identifier = generateIdentifier)
            urlIdentifierRepository.save(entity)
            return generateIdentifier.toString()

    }

    /**
     * Retrieves the original URL associated with a given identifier.
     *
     * This function looks up the URL identifier entity in the repository using the provided identifier.
     * If an entity with the given identifier is found, it returns the original URL associated with it.
     * If no such entity is found, the function returns null, indicating that no URL is associated with the given identifier.
     *
     * @param identifier The unique identifier associated with a URL.
     * @return The original URL corresponding to the given identifier, or null if no URL is associated with this identifier.
     * @throws NotFoundException if the identifier does not exist in the repository.
     */
    fun getOriginalUrlByIdentifier(identifier: Int): String? {
        val urlEntity = urlIdentifierRepository.findByIdentifier(identifier)
            ?: throw NotFoundException("There is no URL with this identifier $identifier")

        return urlEntity.originalUrl
    }
}