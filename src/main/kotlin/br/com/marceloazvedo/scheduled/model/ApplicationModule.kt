package br.com.marceloazvedo.scheduled.model

class ApplicationModule(
        var id: Long? = null,
        var name: String,
        var inMaintenance: Boolean,
        var resources: List<ResourceModule>
)