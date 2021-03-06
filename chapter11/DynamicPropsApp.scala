import scala.language.dynamics

object DynamicPropsApp extends App {

  class DynamicProps(val props: java.util.Properties) extends Dynamic {
    def selectDynamic(name: String): DynamicProp = {
      new DynamicProp(name)
    }
    def updateDynamic(name: String)(value: String): Unit = {
      props.setProperty(name, value)
    }
    class DynamicProp(val name: String) extends Dynamic {
      override def toString = props.getProperty(name)
      def selectDynamic(name: String): DynamicProp = {
        new DynamicProp(this.name + "." + name)
      }
      def updateDynamic(name: String)(value: String): Unit = {
        props.setProperty(this.name + "." + name, value)
      }
    }
  }

  val sysProps = new DynamicProps(System.getProperties)
  System.getProperties.keySet()
  println(sysProps.java.home)
  println(sysProps.java.runtime.name)
  sysProps.foo.bar.quux = "foo! bar! quux!"
  println(sysProps.foo.bar.quux)
}
