object Start extends App {

  def jumpSearch(arr: Array[Int], ele: Int): Unit = {

    val root: Int = Math.sqrt(arr.length).toInt

    var jump: Int = root

    while (jump < arr.length && arr(jump) <= ele) {
      jump = jump + root

      if (jump >= arr.length)
        jump = arr.length

    }

    val ranges = (jump - root) until jump
    for (i <- ranges) {
      if (arr(i) == ele) {
        println("element found at", i)
        return
      }

    }

    println("element not found")

  }

  jumpSearch(Array(1, 5, 4, 9), 9)

}
