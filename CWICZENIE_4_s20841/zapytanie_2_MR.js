db.people.mapReduce(
  function () {
    if (!this.credit) return;
    this.credit.forEach(function (credit) {emit(parseFloat(credit.balance) || 0, credit.currency);});},
  function (key, wartosci) { return Array.sum(wartosci)}, 
  {
      out: "pozostaleSrodkiWaluta"
  }
);
  
db.pozostaleSrodkiWaluta.find({})
