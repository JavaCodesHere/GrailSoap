package com.test

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

class SoapController {

	def index() {
		println "Soap index"
		withSoap(serviceURL:'http://www.holidaywebservice.com/Holidays/US/Dates/USHolidayDates.asmx') {
			def response = send {
				body {
					GetMothersDay(xmlns: 'http://www.27seconds.com/Holidays/US/Dates/') { year(2011) }
				}
			}
			println response.GetMothersDayResponse.GetMothersDayResult.text()
		}
	}


	def GeoIp() {
		String ip=params.ip
		String returnDetail;
		String country
		String code
		println "GeoIp Service"
		withSoap(serviceURL: 'http://www.webservicex.net/geoipservice.asmx') {
			def response = send {
				body {
					GetGeoIP(xmlns: 'http://www.webservicex.net/') { 
						IPAddress(ip) 
						}
				}
			}
			country=response.GetGeoIPResponse.GetGeoIPResult.CountryName.text()
			code= response.GetGeoIPResponse.GetGeoIPResult.CountryCode.text()
			returnDetail=response.GetGeoIPResponse.GetGeoIPResult.ReturnCodeDetails.text()
			
			//result= " Return "+returnDetail+" <br> Country Name : "+country+"<br>Country Code "+ code
			//println result;
		}
	[returnDetail:returnDetail,	country:country,code:code]
}
}
