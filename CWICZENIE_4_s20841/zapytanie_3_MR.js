  db.people.mapReduce(
  function () { emit( this.job, {workerQty:1}); },
  function (key, values) {
    var tmp = {workerQty: 0};

    values.forEach(function (value) {
      tmp.workerQty += value.workerQty;
    });

    return tmp;
  }, {
    out: "unikalneZawody"
  }
);
  
  db.unikalneZawody.find({})
