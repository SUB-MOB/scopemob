package com.github.mustafaozhan.scopemob.lambda

inline fun <reified T, R> ensure(
    vararg elements: T?,
    closureSafe: () -> R
) =
    if (elements.all { it != null }) {
        closureSafe()
    } else {
        null
    }

inline fun <reified T> T?.inCase(block: () -> Unit) {
    if (this == null) block()
}