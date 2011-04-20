package play.mvc

import glitter.Xml
import results.{Result, RenderHtml}

trait GlitterController {
  def Glitter(content: Xml): Result = new RenderHtml(content.render)
  
  implicit def xmlToGlitter(content: Xml): Result = Glitter(content)
}
