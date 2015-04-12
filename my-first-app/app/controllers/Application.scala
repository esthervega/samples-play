package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }
  
  def nameWelcome(name: String) = Action {
    Ok("Hello and welcome! " + name)
  }

}