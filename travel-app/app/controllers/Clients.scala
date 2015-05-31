package controllers

import play.api.mvc._

class Clients extends Controller {

  def show(id: String) = Action {
    Ok("Let's show this action: " + id)
  }
  
  def dynamic(value1: String) = Action {
    Ok("This can bring a paramter or not..." + value1 )
  }
}