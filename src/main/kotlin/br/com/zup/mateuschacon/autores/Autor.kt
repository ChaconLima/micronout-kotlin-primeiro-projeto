package br.com.zup.mateuschacon.autores

import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Autor(
    val nome:String,
    val email:String,
    var descricao:String
) {

    @Id
    val id: String = UUID.randomUUID().toString()
    val criadoEm: LocalDateTime = LocalDateTime.now()
}
