package com.test

import java.util.Formatter.FormatSpecifier;

import grails.rest.*

@Resource
class Book {
	
	String title

	static constraints = {
		title blank:false
	}
}