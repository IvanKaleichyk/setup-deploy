package com.kaleichyk.database.utils

fun getOffset(page: Int, perPage: Int) = ((page - 1) * perPage).toLong()
