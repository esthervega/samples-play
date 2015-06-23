package controllers

import java.io.File

import play.api.libs.json.JsValue
import play.api.mvc._
import play.api.mvc.BodyParsers.parse._

class MainController extends Controller {

  def textParser = Action { request =>
    val body: AnyContent = request.body
    val textBody: Option[String] = body.asText
  
    // Expecting text body
    //Call example:
    //curl -v -X POST -H "Content-Type:text/plain" --data "hola" http://localhost:9000/textParser

    textBody.map { text =>
      Ok("Got: " + text)
    }.getOrElse {
      BadRequest("Expecting text/plain request body... ")
    }    
  }
  
  def jsonParser = Action { request =>
    val body: AnyContent = request.body
    val jsonBody: Option[JsValue] =body.asJson
    
    // Expecting application/json body
    // Call example:
    // curl  -X POST -H "Content-Type:application/json" --data '{"param":"value"}' http://localhost:9000/jsonParser
    jsonBody.map(json => Ok("This is the json: " + json))
             .getOrElse(BadRequest("This was not a json..."))
  }
  
  // curl  -X POST -H "Content-Type:application/json" --data '{"param":"value"}' http://localhost:9000/save
  // would create a file with the content.... {"param":"value"}
  def save = Action(parse.file(to = new File("/home/esther/Downloads/parserFiles"))) { request =>
    Ok("Saved the request content to " + request.body)
  }
  
  def storeInUserFile(username: Option[String]) = parse.using { request =>
    username match {
      case Some(user) => file(to = new File("/home/esther/Downloads/" + user + ".uploadParser"))
      case _ => sys.error("You don't have the right to upload here")
    }
  }
  
  // Call that works.
  //curl  -X POST -H "Content-Type:application/json" -H "username:lalala" --data '{"param":"value2"}' http://localhost:9000/saveByUser?username=eee
  //Saved the request content to /home/esther/Downloads/eee.uploadParser
  def saveByUser(username: Option[String]) = Action(storeInUserFile(username)) { request =>
    Ok("Saved the request content to " + request.body)
  }
  // example was with username in session. but redirect wouldnt work for POST
  // Redirect("/save").addingToSession("username" -> "value")
  
  
}