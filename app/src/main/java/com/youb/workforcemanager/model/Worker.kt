package com.youb.workforcemanager.model

data class Worker(
    val id: String,
    val name: String,
    val position: String,
    val site: String,
    val imageUrl: String?
)