package controllers

import play.api._
import play.api.mvc._

class Application extends Controller {

  def default = Action {
    Ok("It works!")
  }
  
  def index = Action { 
    implicit request =>
      Ok(views.html.index("Your new application is ready."))
  }
  
  val echo = Action { implicit request =>
    Ok("Got request[ " + request + "]")
    }
  
  def parameter(name: String) = Action {
    Ok("Hello " + name)
  }

  def siempreYo = Action {
    Redirect("/parameter/siempreyo")
  }
  
  def optional(name: Option[String]) = Action {
    Ok("hola!!!! you are: " + name.getOrElse("no value"))
  }
  
  def todo = TODO
}
