package play.modules

package object glitter {
  
  import play.mvc.{Scope, Http, Router}
  import play.i18n.{Lang, Messages}
  import play.data.validation.Validation
  
  val errors = Validation.errors
  
  val flash = Scope.Flash.current
  
  val lang = Lang.current
  
  val messages = new Messages
  
  val params = Scope.Params.current
  
  val request = Http.Request.current
  
  val session = Scope.Session.current
  
  def & (key: String, args: AnyRef*) = Messages.get(key, args:_*)
  
  def @@(action: String, params: (Symbol, Any)*) = {
    import scala.collection.JavaConversions._
    import collection.mutable
    
    val args = mutable.Map.empty ++ params.map(p => (p._1.name, p._2.asInstanceOf[AnyRef])).toMap
    Router.reverse(action, args).url
  }
}
