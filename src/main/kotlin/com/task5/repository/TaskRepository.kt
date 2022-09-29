package com.task5.repository

import com.task5.entity.TaskEntity
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository

interface TaskRepository: CrudRepository<TaskEntity, Int> {

    fun findByOrderByName(pageable: Pageable): List<TaskEntity>

    fun findByNameStartsWithIgnoreCaseOrderByName(prefix: String): List<TaskEntity>
}