package br.com.marceloazvedo.scheduled.model

class ResourceModule(
        var id: Long? = null,
        var name: String,
        var path: String,
        var allocatedVerbs: List<ResourceMethod>
)