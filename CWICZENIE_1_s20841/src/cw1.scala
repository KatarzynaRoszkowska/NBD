import scala.annotation.tailrec

object cw1 {
  def main(args: Array[String]): Unit ={
    var daysArray = List("Poniedziałek", "Wtorek", "Środa","Czwartek","Piątek","Sobota","Niedziela")
    val products: Map[String, Double] = Map(("Masło", 6), ("Mleko",3), ("Miód", 7), ("Woda", 2), ("Cukier", 5))
    val tuple = ("Jabłko" , 25, 5.7): Tuple3[String, Int, Double]
    val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")
    var intList = List(1,56,67,0,45,4,0,35,0,8,0)
    var empltyList = List()
    var fList = List(1,-56,67,11,-45,-4,0,35,0,-8,2)
    
    
    //1.a
    println("1.a Pętla for - Wszystkie dni tygodnia:")
    println(connectElements_For(daysArray))
    
    //1.b
    println("\n1.b Pętla for - Dni tygodnia zaczynające się na literkę P:")
    println(connectElementsStartsWithP_For(daysArray))
    
    //1.c
    println("\n1.c Pętla while - Wszystkie dni tygodnia:")
    println(connectElements_While(daysArray))
    
    //2.a
    println("\n2.a Funkcja rekurencyjna - łączenie przecinkiem:")
    println(concatencateDaysRec(daysArray, ""))
    
    //2.b
    println("\n2.b Funkcja rekurencyjna elementy od końca listy - łączenie przecinkiem:")
    println(reverse(daysArray, ""))
    
    //3
    println("\n3 Funkcja rekurencyjna ogonowa - łączenie przecinkiem:")
    println(tailRec(daysArray))
    
    //4.a
    println("\n4.a Metoda foldLeft - łączenie przecinkiem:")
    println(daysFoldLeft(daysArray))
    
    //4.b
    println("\n4.b Metoda foldRight - łączenie przecinkiem:")
    println(daysFoldRight(daysArray))
    
    //4.c
    println("\n4.c Metoda foldLeft - Dni tygodnia zaczynające się na literkę P")
    println(daysFoldLeftWithP(daysArray))
    
    //5
    println("\n5 Mapowanie produktów:")
    println("Bazowa Mapa     " + products)
    println("Mapa po obniżce " + listMapping(products))

    //6
    println("\n6 Krotka z trzema typami:")
    println(tuple._1) 
    println(tuple._2) 
    println(tuple._3) 
    
    //7
    println("\n7 Option:")
    println("show(capitals.get( \"Japan\")) : " + show(capitals.get( "Japan")) )
    println("show(capitals.get( \"India\")) : " + show(capitals.get( "India")) )
      
    //8
    println("\n8 Remove 0:")
    println("Bazowa Lista            " + intList)
    println("Lista po skasowaniu zer " + removeZero(intList,empltyList))

    //9
    println("\n9 List with map:")  
    println("Bazowa Lista       " + intList)
    println("Lista po dodaniu 1 " + addOneToList(intList))
    
    //10
    println("\n10 List with filter:")
    println("Bazowa Lista                   " + fList)
    println("Lista po z przedziałem <-5,12> " + filteredList(fList))

    
    
    
    // ---------------- FUNCTONS ---------------- //
    def connectElements_For(some_list: List[String]): String ={
      var acc = ""
      var size = some_list.length
      
      for ( x <- some_list ) {
         acc += x +","
      }
      acc.dropRight(1)
    }
    
    def connectElementsStartsWithP_For(some_list: List[String]): String ={
      var acc = ""
      
      for ( x <- some_list ) {
      if (x.charAt(0).==('P')){
        acc += x +","
      }
      }
      acc.dropRight(1)
    }

    def connectElements_While(some_list: List[String]): String ={
      var acc = ""
      var i = 0
      var size = daysArray.size
      
      while (i < size) {
        acc += daysArray(i) + ","
        i += 1
      }
      acc.dropRight(1)
    }
    
    def concatencateDaysRec(some_list: List[String] ,  some_string: String): String = {
      if(some_list.length > 1){
        return concatencateDaysRec(some_list.tail,some_string + some_list(0) + ",")
      }
      else{
        return some_string + some_list(0)
      }
    }
    
    def reverse(some_list: List[String] ,  some_string: String): String = {
      if(some_list.length > 1){
        return reverse(some_list.slice(0,some_list.length-1),some_string + some_list.last + ";")
      }
      else{
        return some_string + some_list.last
      }
    }
   
    def tailRec(some_list: List[String] ): String = {
      @tailrec
      def insideTailRec(some_list: List[String] ,  some_string: String): String = {
        if(some_list.length > 1){
          return insideTailRec(some_list.tail,some_string + some_list(0) + ";")
        }
        else{
          return some_string + some_list(0)
        }
      }
      insideTailRec(some_list,"")
    }
    
    def daysFoldLeft(some_list: List[String]): String ={
      var conStr = some_list.foldLeft("")((acc, s) => acc + s + ",")
      conStr.dropRight(1)
    }
      
    def daysFoldRight(some_list: List[String]): String ={
      var conStr = some_list.foldRight("")((acc, s) => acc + "," + s)
      conStr.dropRight(1)
    }
     
    def daysFoldLeftWithP(some_list: List[String]): String ={
      var conStr = some_list.foldLeft("")((acc, s) => 
        if(s.charAt(0).==('P')) acc + s + ","
        else acc)
      conStr.dropRight(1)
    }
    
    def listMapping(some_list: Map[String, Double]): Map[String, Double] = {
      some_list map {case (key, value) => (key, value * 0.9)}
    }
    
    def show(x: Option[String]) = x match {
      case Some(s) => s
      case None => "?"
    }
      
    def removeZero(some_list: List[Int], new_list: List[Int]): List[Int] = {
      if(some_list.length > 0)
      {
        if(some_list.head.equals(0)){
          removeZero(some_list.tail,new_list)
        }
        else{
          removeZero(some_list.tail,new_list :+ some_list.head)
        }
      }
      else
        new_list
    }
    
    def addOneToList(some_list: List[Int]): List[Int] = 
    {
      return some_list.map(x => x+1); 
    }
    
    def filteredList(some_list: List[Int]): List[Int] = {
      some_list.filter(x => (x>= -5 && x <= 12))
    }
     
  }
}