package com.kofa.urlshortening.repository

import com.kofa.urlshortening.entity.UrlIdentifierEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * @author mhmnazem
 * @created 11/20/23
 * @email Mohammad.nazem@gmail.com
 */


/**
 * Interface for the repository handling URL identifiers.
 * This repository provides operations for querying and saving URL identifier entities.
 */
@Repository
interface UrlIdentifierRepository: JpaRepository<UrlIdentifierEntity,Long> {

    /**
     * Finds a URL identifier entity based on the original URL.
     *
     * @param originalUrl The original URL to search for.
     * @return The URL identifier entity if found, otherwise null.
     */
    fun findByOriginalUrl (originalUrl: String): UrlIdentifierEntity?

    /**
     * Finds a URL identifier entity based on its unique identifier.
     *
     * @param identifier The identifier of the URL.
     * @return The URL identifier entity if found, otherwise null.
     */
    fun findByIdentifier (identifier: Int): UrlIdentifierEntity?
}