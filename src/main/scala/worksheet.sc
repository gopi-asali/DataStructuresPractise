import scala.collection.immutable.{NumericRange, Range}
import scala.util.control.Breaks.break

println("Hi")


def linearSearch(arr:Array[Int], element:Int) = {

  for (i <- arr.indices) {

    if (arr(i) == element) {
      println("Element found at the position", i)
      break
    }

  }
   println("element not found");
}


def binarySearch(arr:Array[Int],mid:Int , min:Int, max:Int, ele:Int): Unit = {

  if(arr(mid) == ele) {
    println("Element found at", mid)
    return
  } else if(min<max) {
    val mid = max-min / 2

    if(arr(mid) <= ele){
      binarySearch(arr, mid, mid, max, ele)
      return
    }
    else {
      binarySearch(arr, mid, min, mid, ele)
      return
    }
  }

  println("Element not found")
}


def binSearch(arr:Array[Int], ele:Int): Unit ={

  binarySearch(arr, 0, 0, arr.length-1, ele)

}




def jumpSearch(arr:Array[Int], ele:Int): Unit ={

  val root:Int = Math.sqrt(arr.length).toInt


  var jump: Int = root

  while( arr(jump) <= ele){
    jump = jump+root
  }

  val ranges = (jump-root) until   jump
  for(i <- ranges){

   if(i < arr.length-1 && arr(i) == ele){
     println("element found at", i )
     return
   }

  }

  println("element not found")




}

//jumpSearch(Array(1,5,4,9),9)


sealed trait Answer
case object Yes extends Answer
case object No extends Answer

val x: Answer = No

x match {
  case No => println("No")
}

