package com.task5.service

import com.task5.dto.TaskDto

interface TaskService {
    fun getAll(pageIndex: Int): List<TaskDto>

    fun getById(id: Int): TaskDto

    fun search(prefix: String): List<TaskDto>

    fun create(dto: TaskDto): Int

    fun update(id: Int, dto: TaskDto)

    fun delete(id: Int)
}