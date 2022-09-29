package com.task5.exception

import org.springframework.http.HttpStatus

class CountryNotFoundException(taskId: Int): BaseException(
    HttpStatus.NOT_FOUND,
    ApiError(
        errorCode = "task.not.found",
        description = "Task not found with id=$taskId"
    )
) {
}