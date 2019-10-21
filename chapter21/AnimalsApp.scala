/*
Type classes consist of three components:

1. The type class, which is defined as a trait that takes at least one generic parameter (a generic “type”)
2. Instances of the type class for types you want to extend
3. Interface methods you expose to users of your new API
*/


object AnimalsApp extends App {

  trait BehavesLikeHuman[A] {
    def speak(a: A): Unit
  }

  sealed trait Animal
  final case class Dog(name: String) extends Animal
  final case class Cat(name: String) extends Animal
  final case class Bird(name: String) extends Animal

  object BehavesLikeHumanInstances{
    // only for Dog
    implicit val dogBehavesLikeHuman = new BehavesLikeHuman[Dog] {
      def speak(dog: Dog): Unit = {
        println(s"I'm a dog, but I can speak like human. My name is ${dog.name}")
      }
    }
  }

  //Approach #1 to use type class. (Interface Object) pattern
  object BehavesLikeHuman {
    def speak[A](a: A)(implicit behavesLikeHumanInstance: BehavesLikeHuman[A]): Unit = {
      behavesLikeHumanInstance.speak(a)
    }
  }

  //start main()
  import BehavesLikeHumanInstances.dogBehavesLikeHuman

  val rover = Dog("Rover")
  BehavesLikeHuman.speak(rover)

  //Approach #2 to use type class. (Interface Syntax) pattern
  

  object BehavesLikeHumanSyntax {
    implicit class BehavesLikeHumanOps[A](value: A) {
      def speak(implicit behavesLikeHumanInstance: BehavesLikeHuman[A]): Unit = {
        behavesLikeHumanInstance.speak(value)
      }
    }
  }

  import BehavesLikeHumanSyntax.BehavesLikeHumanOps
  val fido = Dog("Fido")
  fido.speak

}
