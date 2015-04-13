package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }
  
  def nameWelcome(name: String, age:Int) = Action {
    Ok("Hello and welcome! " + name + " And you are... " + age + " years old")
  }

  def nameWelcomeNeska() = Action {
    Redirect(routes.Application.nameWelcome("Neska", 32))
  }
  
  def nameWelcomeXml(name: String) = Action {
    Ok("<h1>Hello and welcome! " + name +"</h1>").as("text/plain")
  }
}