package com.task5.service.impl

import com.task5.dto.TaskDto
import com.task5.entity.TaskEntity
import com.task5.exception.CountryNotFoundException
import com.task5.repository.TaskRepository
import com.task5.service.TaskService
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class TaskServiceImpl (
    private val taskRepository: TaskRepository,
): TaskService{
    override fun getAll(pageIndex: Int): List<TaskDto> {
        return taskRepository.findByOrderByName(PageRequest.of(pageIndex, 2)).map{it.toDto()}
    }

    override fun getById(id: Int): TaskDto {
        return taskRepository.findByIdOrNull(id)
            ?.toDto()
            ?: throw CountryNotFoundException(id)
    }

    override fun search(prefix: String): List<TaskDto> =
        taskRepository.findByNameStartsWithIgnoreCaseOrderByName(prefix)
            .map{it.toDto()}


    override fun create(dto: TaskDto): Int {
        return taskRepository.save(dto.toEntity()).id
    }

    override fun update(id: Int, dto: TaskDto) {
        val existingTask = taskRepository.findByIdOrNull(id)
            ?: throw CountryNotFoundException(id)

        existingTask.name = dto.name
        existingTask.population = dto.population
        existingTask.age = dto.age
        existingTask.gender = dto.gender

        taskRepository.save(existingTask)
    }

    override fun delete(id: Int) {
        val existingCountry = taskRepository.findByIdOrNull(id)
            ?: throw CountryNotFoundException(id)

        taskRepository.deleteById(existingCountry.id)
    }

    private fun TaskEntity.toDto(): TaskDto =
        TaskDto(
            id = this.id,
            name = this.name,
            population = this.population,
            age = this.age,
            gender = this.gender
        )

    private fun TaskDto.toEntity(): TaskEntity =
        TaskEntity(
            id = 0,
            name = this.name,
            population = this.population,
            age = this.age,
            gender = this.gender
        )

}