package controllers

import play.api.mvc._

class Clients extends Controller {
  
  implicit val myCustomCharset = Codec.javaSupported("iso-8859-1")

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
  
  val helloHtml = Action {
    Ok(<h1>Hello World!</h1>).as(HTML)
                             .withHeaders(CACHE_CONTROL -> "max-age=3600", ETAG -> "xx")
                             .withCookies(Cookie("theme", "blue"))
                             .discardingCookies(DiscardingCookie("skin"))
  }
}