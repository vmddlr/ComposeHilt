package com.example.corrutinasflow.data.domain

import javax.inject.Inject

class CalculateFibonacciUserCase @Inject constructor() {

    fun getCalculateFibonacci(n: Long): Long {
        val value = if (n <= 1) {
            n
        } else {
            getCalculateFibonacci(n - 1) + getCalculateFibonacci(n - 2)
        }
        return value
    }
}