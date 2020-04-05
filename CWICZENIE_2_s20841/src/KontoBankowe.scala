

class KontoBankowe(var poczStanKonta: Double) {
  
  private var _stanKonta : Double = poczStanKonta;
  
  //Getter
  def stanKonta = _stanKonta 
  
  def this() {
    this(0);
  }
  
  def wplata(amount: Double)
  {
    _stanKonta += amount;
  }
  
  def wyplata(amount: Double)
  {
    _stanKonta -= amount;
  }
  
  }