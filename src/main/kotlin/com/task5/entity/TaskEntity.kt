package com.task5.entity

import javax.persistence.*

@Entity
@Table(name = "mytask2")
class TaskEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    var name: String = "",
    var population: Int = 0,
    var age: Int = 0,
    var gender: String = ""
)