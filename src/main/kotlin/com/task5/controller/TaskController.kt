package com.task5.controller

import com.task5.dto.TaskDto
import com.task5.service.TaskService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/api/tasks")
class TaskController (
    private val taskService: TaskService
        ) {

    @GetMapping
    fun getAll(@RequestParam("page") pageIndex: Int): List<TaskDto> =
        taskService.getAll(pageIndex)

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: Int): TaskDto =
        taskService.getById(id)

    @GetMapping("/search")
    fun searchCountries(@RequestParam("prefix") prefix: String): List<TaskDto> =
        taskService.search(prefix)

    @PostMapping
    fun create(@RequestBody dto: TaskDto): Int{
       return taskService.create(dto)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody dto: TaskDto){
        taskService.update(id, dto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int){
        taskService.delete(id)
    }
}
