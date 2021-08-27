package com.jj.bookservice.response

data class Cambio(var id: Long, var from: String, var to: String,
                  var conversionFactor: Double, var convertedValue: Double,
                  var environment: String) {
}