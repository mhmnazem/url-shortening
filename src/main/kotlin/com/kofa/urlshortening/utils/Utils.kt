package com.kofa.urlshortening.utils

import java.net.URL

/**
 * @author mhmnazem
 * @created 11/20/23
 * @email Mohammad.nazem@gmail.com
 */
fun isUrlValid(url: String): Boolean {
    return try {
        URL(url).toURI()
        true
    } catch (e: Exception) {
        false
    }
}