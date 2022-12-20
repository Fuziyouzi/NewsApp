package com.example.newsapp.domain.models

abstract class DomainError : IllegalStateException()

class NoInternetConnection : DomainError()

class ServiceIsUnavailable : DomainError()

class StorageException : DomainError()