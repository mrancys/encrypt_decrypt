// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/martynasr/project/encrypt_decrypt/conf/routes
// @DATE:Wed Feb 24 23:57:12 EET 2021


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
