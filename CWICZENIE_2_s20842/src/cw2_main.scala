

object cw2_punk1 {
  def main(args: Array[String]): Unit ={
    
    //1
    println("\n1. zadanie")
    println("Dla Poniedziałek funkcja zwraca " + matchDay("Poniedziałek"))
    println("Dla Wtorek funkcja zwraca " + matchDay("Wtorek"))
    println("Dla Środa funkcja zwraca " + matchDay("Środa"))
    println("Dla Czwartek funkcja zwraca " + matchDay("Czwartek"))
    println("Dla Piątek funkcja zwraca " + matchDay("Piątek"))
    println("Dla Sobota funkcja zwraca " + matchDay("Sobota"))
    println("Dla Niedziela funkcja zwraca " + matchDay("Niedziela"))
    println("Dla Kot funkcja zwraca " + matchDay("Kot"))
   
    //2
    println("\n2. zadanie")
    var kontoBankowe1 = new KontoBankowe(150000);
    var kontoBankowe2 = new KontoBankowe;
    println("Konstruktor ustawiający początkowy stan konta na wsjazaną kwotę");
    println(kontoBankowe1.poczStanKonta);
    println("Konstruktor ustawiający początkowy stan konta na zero");
    println(kontoBankowe2.poczStanKonta);
    
    //3
    println("\n3. zadanie")
    val osoba1 = new Osoba("Katarzyna","Roszkowska");    
    val osoba2 = new Osoba("Adam","Kowalski");  
    val osoba3 = new Osoba("Wiktoria", "Nowak");  
    val osoba4 = new Osoba("Natalia", "Troć");
    
    println(matchGreetings(osoba1))
    println(matchGreetings(osoba4))
    println(matchGreetings(osoba2))
    
    //4
    println("\n4. zadanie")
    println("Zwrócona wartość funkcji: " + mojaFunckja(7)(addition))
   
    //5
    println("\n5. zadanie")
    var student = new Student {}
    
    var pracownik = new Pracownik {}
    pracownik.pensja = 4000
    
    var nauczyciel = new Nauczyciel {}
    nauczyciel.pensja = 4000
    
    println("Pensja pracownika: " + pracownik.pensja)
    println("Pensja nauczyciela: " + nauczyciel.pensja)
    
    println("Podatek studenta: " + student.podatek)
    println("Podatek pracownika: " + pracownik.podatek)
    println("Podatek nauczyciela: " + nauczyciel.podatek)
}
  
  def mojaFunckja(x : Int)(myFunction: (Int,Int) => Int): Int = {
    myFunction(x,3) // trzy razy wywoła funkcję myFunction
  }
  
  def addition(x : Int, repetitions : Int): Int = {
    if (repetitions>0) {
      val z:Int=repetitions-1
      addition(x+x,z)
    }
    else x
}
  
  def matchDay(x: String): String = x match {
    case "Poniedziałek" => "Praca"
    case "Wtorek"       => "Praca"
    case "Środa"        => "Praca"
    case "Czwartek"     => "Praca"
    case "Piątek"       => "Praca"
    case "Sobota"       => "Weekend"
    case "Niedziela"    => "Weekend" 
    case _              => "Nie ma takiego dnia"
  }

  def matchGreetings(osoba: Osoba): String ={ 
    osoba.Imie match{
      case "Katarzyna" => s"Cześć, witam Cię serdecznie. Z tej strony ${osoba.Imie}"
      case "Adam"      => s"Witaj, tutaj ${osoba.Imie}. Miło Cię widzieć!"
      case _           => "Cześć"
    }
  }
}

