package com.test

import grails.transaction.*
import static org.springframework.http.HttpStatus.*
import static org.springframework.http.HttpMethod.*


@Transactional(readOnly = true)
class BookController {

    def index(Integer max) {
		println "Book Index"
    params.max = Math.min(max ?: 10, 100)
    respond Book.list(params), model:[bookCount: Book.count()]	
}	
}
