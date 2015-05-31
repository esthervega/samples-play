package controllers

import play.api.mvc._

class Clients extends Controller {

  def show(id: String) = Action {
    Ok("Let's show this action: " + id)
  }
  
  def dynamic(value1: String) = Action {
    Ok("This can bring a paramter or not..." + value1 )
  }
  
/*  def show(page: String) = Action {
    loadContentFromDatabase(page).map { htmlContent =>
      Ok(htmlContent).as("text/html")
    }.getOrElse(NotFound)
  }*/
  
  def getLog(number: Long) = Action {
    Ok ("This is a long..." + number)
  }
}