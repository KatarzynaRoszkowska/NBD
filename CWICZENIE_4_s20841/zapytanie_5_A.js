  db.people.aggregate([
    {
        $match: { sex: "Female", nationality: "Poland" }
    },
    {
        $unwind: "$credit"
    },
    {
        $group: {
            _id: "$credit.currency",
            sum: { $sum:  { $toDouble: "$credit.balance" }  },
            avg: { $avg: { $toDouble: "$credit.balance" }  }
        }
    },
    {
        $out: "result5A"
    }
])
db.result5A.find({})
