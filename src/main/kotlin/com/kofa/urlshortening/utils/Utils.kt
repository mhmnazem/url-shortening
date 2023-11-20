package com.kofa.urlshortening.utils


/**
 * @author mhmnazem
 * @created 11/20/23
 * @email Mohammad.nazem@gmail.com
 */
fun isUrlValid(url: String): Boolean {
    val urlRegex = "^(http://www\\.|https://www\\.|http://|https://)?[a-z0-9]+([\\-.]{1}[a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(/.*)?$"
        .toRegex(RegexOption.IGNORE_CASE)
    return urlRegex.matches(url)

}