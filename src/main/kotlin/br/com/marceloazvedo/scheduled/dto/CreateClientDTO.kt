package br.com.marceloazvedo.scheduled.dto

import javax.validation.constraints.NotBlank
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement
class CreateClientDTO {
    @NotBlank
    var email: String? = null
    @NotBlank
    var name: String? = null
    @NotBlank
    var password: String? = null

    constructor() {}
    
    constructor(email: String?, password: String?, name: String?) {
        this.email = email
        this.password = password
        this.name = name
    }

}