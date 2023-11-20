package com.kofa.urlshortening.controller

import com.kofa.urlshortening.config.globalExceptionHandler.NotFoundException
import com.kofa.urlshortening.service.UrlIdentifierService
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.annotation.Rollback
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

/**
 * @author mhmnazem
 * @created 11/20/23
 * @email Mohammad.nazem@gmail.com
 */

@WebMvcTest(UrlIdentifierController::class)
class UrlIdentifierControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var urlIdentifierService: UrlIdentifierService

    @Test
    @Rollback
    fun `should generate identifier for URL`() {
        val url = "http://example.com"
        val identifier = "12345"
        `when`(urlIdentifierService.generateIdentifier(url)).thenReturn(identifier)

        mockMvc.perform(
            post("/api/v1/generateIdentifier")
                .param("url", url)
        )
            .andExpect(status().isOk)
            .andExpect(content().string(identifier))
    }


    @Test
    fun `should retrieve original URL for identifier`() {
        val identifier = 12345
        val originalUrl = "http://example.com"
        `when`(urlIdentifierService.getOriginalUrlByIdentifier(identifier)).thenReturn(originalUrl)

        mockMvc.perform(get("/api/v1/getOriginalUrl/$identifier"))
            .andExpect(status().isOk)
            .andExpect(content().string(originalUrl))
    }

    @Test
    fun `shouldn't retrieve original URL for identifier`() {
        val identifier = 12345
        `when`(urlIdentifierService.getOriginalUrlByIdentifier(identifier)).thenThrow(NotFoundException("not found"))
        mockMvc.perform(get("/api/v1/getOriginalUrl/$identifier"))
            .andExpect(status().isNotFound)
    }
}
