package com.jj.bookservice.model

import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.*

@Entity
open class Book {

    @get:Id
    @get:SequenceGenerator(name = "cambio_seq", sequenceName = "cambio_seq", allocationSize = 1)
    @get:GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cambio_seq")
    open var id: Long? = null

    @get:Column(nullable = false, length = 200)
    open var author: String? = null

    @get:Column(nullable = false)
    open var launchDate: LocalDate? = null

    @get:Column(nullable = false)
    open var price: Double? = null

    @get:Column(nullable = false, length = 250)
    open var title: String? = null

    @Transient
    open var currency: String? = null

    @Transient
    open var environment: String? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Book

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }
}