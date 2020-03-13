package br.com.marceloazvedo.scheduled.model

import br.com.marceloazvedo.scheduled.enum.HttpMethod

class ResourceMethod(
        var id: Long? = null,
        var method: HttpMethod,
        var path: String,
        var allocatedMathods: List<HttpMethod>
)