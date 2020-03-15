package br.com.marceloazvedo.scheduled.dto

import javax.validation.constraints.NotBlank
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement
class CreateUserDTO {
    @NotBlank
    var email: String? = null

    @NotBlank
    var password: String? = null

    constructor() {}
    
    constructor(email: String?, password: String?) {
        this.email = email
        this.password = password
    }

}