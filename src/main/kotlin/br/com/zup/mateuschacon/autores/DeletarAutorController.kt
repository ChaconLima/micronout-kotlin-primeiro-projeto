package br.com.zup.mateuschacon.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.PathVariable

@Controller(value = "/api/autores/{id}")
class DeletarAutorController( val autorRepository: AutorRepository) {

    @Delete
    fun deleta( @PathVariable id: String) : HttpResponse<Any>{
        val possivelAutor = this.autorRepository.findById(id)

        if(!possivelAutor.isPresent){
           return HttpResponse.notFound()
        }

        val autor = possivelAutor.get()
        this.autorRepository.delete(autor)

        return HttpResponse.ok()
    }
}