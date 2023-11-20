package com.kofa.urlshortening.service

import com.kofa.urlshortening.entity.UrlIdentifierEntity
import com.kofa.urlshortening.repository.UrlIdentifierRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers.any
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.boot.test.context.SpringBootTest

/**
 * @author mhmnazem
 * @created 11/20/23
 * @email Mohammad.nazem@gmail.com
 */

@ExtendWith(MockitoExtension::class)
@SpringBootTest
class UrlIdentifierServiceTest {
    @Mock
    private lateinit var urlRepository: UrlIdentifierRepository

    private lateinit var urlIdentifierService: UrlIdentifierService

    @BeforeEach
    fun setUp() {
        urlIdentifierService = UrlIdentifierService(urlRepository)
    }


    @Test
    fun `should return existing URL if already exists`() {
        val originalUrl = "https://www.example.com"
        val existingIdentifier = 123456
        val existingEntity = UrlIdentifierEntity(originalUrl = originalUrl, identifier = existingIdentifier)

        `when`(urlRepository.findByOriginalUrl(originalUrl)).thenReturn(existingEntity)

        val result = urlIdentifierService.generateIdentifier(originalUrl)

        assertEquals(existingIdentifier, result)
    }

    @Test
    fun `should generate new identifier if URL does not exist`() {
        val originalUrl = "https://www.example.com"
        val newIdentifier = originalUrl.hashCode()
        val newEntity = UrlIdentifierEntity(originalUrl = originalUrl, identifier = newIdentifier)

        `when`(urlRepository.findByOriginalUrl(originalUrl)).thenReturn(null)
        `when`(urlRepository.save(any())).thenReturn(newEntity)

        val result = urlIdentifierService.generateIdentifier(originalUrl)

        assertEquals(newIdentifier, result)
        verify(urlRepository, times(1)).save(any())
    }

    @Test
    fun `should return original URL for given identifier`() {
        val identifier = 12345
        val originalUrl = "https://www.example.com"
        val entity = UrlIdentifierEntity(originalUrl = originalUrl, identifier = identifier)

        `when`(urlRepository.findByIdentifier(identifier)).thenReturn(entity)

        val result = urlIdentifierService.getOriginalUrlByIdentifier(identifier)

        assertEquals(originalUrl, result)
    }

    @Test
    fun `should return null if identifier does not exist`() {
        val identifier = 67890

        `when`(urlRepository.findByIdentifier(identifier)).thenReturn(null)

        val result = urlIdentifierService.getOriginalUrlByIdentifier(identifier)

        assertNull(result)
    }

}