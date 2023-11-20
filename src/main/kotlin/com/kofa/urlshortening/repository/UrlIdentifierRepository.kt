package com.kofa.urlshortening.repository

import com.kofa.urlshortening.entity.UrlIdentifierEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * @author mhmnazem
 * @created 11/20/23
 * @email Mohammad.nazem@gmail.com
 */
@Repository
interface UrlIdentifierRepository: JpaRepository<UrlIdentifierEntity,Long> {

    fun findByOriginalUrl (originalUrl: String): UrlIdentifierEntity?
}