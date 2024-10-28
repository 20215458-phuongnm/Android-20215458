package com.example.gmailclone

data class Email(
    val senderIcon: String,
    val senderName: String,
    val subject: String,
    val time: String,
    val isStarred: Boolean
)
