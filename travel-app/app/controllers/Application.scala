package controllers

import play.api._
import play.api.mvc._

class Application extends Controller {

  def default = Action {
    Ok("It works!")
  }
  
  def index = Action {
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
  
  def todo = TODO
}
