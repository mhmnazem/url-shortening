package com.kofa.urlshortening.utils


/**
 * @author mhmnazem
 * @created 11/20/23
 * @email Mohammad.nazem@gmail.com
 */

/**
 * Validates the given URL string against a predefined regular expression pattern.
 *
 * This function checks if the provided URL string is in a valid format. It supports both HTTP and HTTPS protocols
 * and allows for a wide range of valid URLs, including those with ports and paths. The validation is not case-sensitive.
 *
 * @param url The URL string.
 * @return A Boolean to valid or invalid value.
 */
fun isUrlValid(url: String): Boolean {
    val urlRegex =
        "^(http://www\\.|https://www\\.|http://|https://)?[a-z0-9]+([\\-.]{1}[a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(/.*)?$"
            .toRegex(RegexOption.IGNORE_CASE)
    return urlRegex.matches(url)
}