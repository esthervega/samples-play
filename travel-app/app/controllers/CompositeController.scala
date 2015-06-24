package controllers

import play.api.mvc.Controller
import play.api.mvc.Request
import scala.concurrent.Future
import play.api.Logger
import play.api.mvc.{Result, ActionBuilder}
import play.api.mvc._

class CompositeController extends Controller {
  
  def indexLogged = LoggingAction { request => {
      Logger.debug("This message should go to file")
      Ok("hello world")
    }
  }
  
}

// logging decorator
// logged in the console (terminal that launched the activator)
object LoggingAction extends ActionBuilder[Request] {
  def invokeBlock[A](request: Request[A], block: (Request[A]) => Future[Result]) = {
    Logger.info("calling action")
    block(request)
  }
}