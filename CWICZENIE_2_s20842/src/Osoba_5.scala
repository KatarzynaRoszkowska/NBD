

class Osoba_5 {
  private val _imie : String = "Anna"
  private val _nazwisko : String = "Nowak"
  private var _podatek : Double = 1
  
  def imie = _imie
  def nazwisko = _nazwisko
  def podatek = _podatek

}

trait Student extends Osoba_5 {
  override def podatek: Double = 0
}

trait Pracownik extends Osoba_5 {
  private var _pensja : Double = 0
  
  // Getter
  def pensja = _pensja
  
   // Setter
  def pensja_= (value : Double) = _pensja = (value * podatek)
  
  override def podatek: Double = 0.70
}

trait Nauczyciel extends Pracownik {
  override def podatek: Double = 0.75
}