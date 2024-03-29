package ir

/**
 * Does Scala support virtual classes? Not yet as of 2.9.1.
 *
 * @author Nikolay
 *
 */
object VirtualClass extends App {

  class VirtualContainer {

    class NestedVirtualClass {
      def conflicting = "base class"
    }

    class NestedSubclass extends NestedVirtualClass {
      def test = conflicting
    }

  }

  class OverridingContainer extends VirtualContainer {

    class NestedVirtualClass {
      def conflicting = "sub class"
    }

  }

  val container = new VirtualContainer
  val nested = new container.NestedSubclass
  println(nested.test)

  val overridingContainer = new OverridingContainer
  val nestedOverriding = new overridingContainer.NestedSubclass

  // This will print "sub class" on Newspeak
  println(nestedOverriding.test) // prints "base class"

}