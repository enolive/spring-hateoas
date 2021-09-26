package com.example.springhateoas

import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.Link
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller {
  @GetMapping("/hellos")
  suspend fun hello() =
    Greetings("Hello, World!").withLinkToItself().wrappedInResponseEntity()

  private fun Greetings.withLinkToItself() = EntityModel.of(
    this,
    Link.of("/hellos").withSelfRel()
    )

  private fun <T> T.wrappedInResponseEntity() = ResponseEntity.ok(this)
}

