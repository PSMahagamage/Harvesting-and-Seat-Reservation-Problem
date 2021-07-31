import scala.io.StdIn._
object Reservation {
  var seatsColomboMattala = Array(
    Array(0,0,0,0),
    Array(0,0,0,0),
    Array(0,0,0,0),
    Array(0,0,0,0))

  var seatsMattalaRathmalana = Array(
    Array(0,0,0,0),
    Array(0,0,0,0),
    Array(0,0,0,0),
    Array(0,0,0,0))

  var seatsRathmalanaDelhi = Array(
    Array(0,0,0,0),
    Array(0,0,0,0),
    Array(0,0,0,0),
    Array(0,0,0,0))

  var seatsDelhiMombai = Array(
    Array(0,0,0,0),
    Array(0,0,0,0),
    Array(0,0,0,0),
    Array(0,0,0,0))

  def returnCitySeat(index:Int):Array[Array[Int]]={
    index match {
      case 1 =>
        return seatsColomboMattala
      case 2 =>
        return seatsMattalaRathmalana
      case 3 =>
        return seatsRathmalanaDelhi
      case 4 =>
        return seatsDelhiMombai
    }
  }

  def reserveSeat(start:Int, end:Int, row:Int, seatNo:Int):Unit={
    var num1 = start
    var num2 = end
    var i = 0
    var test = 0

    for(i <- num1 to num2-1){
      if(returnCitySeat(i)(row-1)(seatNo-1) == 1){
        test = 1
      }
    }

    if(test == 0)
    {
      for(i <- num1 to num2-1){
        returnCitySeat(i)(row-1)(seatNo-1) = 1
      }
      println("# Request is SUCCESSFUL, Reserved seat IS " +row+ " . "+seatNo )
    }
    else{
      println("Your request is UNSUCCESSFUL, please try ANOTHER ONE")
    }
  }

  def view(plan:Array[Array[Int]]):Unit={
    var i = 0
    var j = 0
    print("seat No : ")
    for(i <- 0 until 4){
      print(" " + (i+1))
    }
    println()
    for(i <- 0 to 3){
      print(i+1+" Row   : ")
      for(j <- 0 until 4){
        print(" "+plan(i)(j))
      }
      println()
    }
    println()
  }

  def main(args: Array[String]): Unit = {
    print("\n\n\t\t\t ### LETS RESERVE SEATS !!! ###\n\n\n")
    print("@ Please use following number format for the relavent bookings !!!\n")
    println("\t# Colombo     ->1")
    println("\t# Mattala     ->2")
    println("\t# Rathmalana  ->3")
    println("\t# Delhi       ->4")
    println("\t# Mombai      ->5")
    print("# SELECT an option and Enter the Option Number to proceed.")
      print("\n\t1. Reserve a seats.")
      print("\n\t2. View Reserved seats.")
      print("\n\t3. EXIT Process.")
      print("\n@ Enter the Option Number to proceed: ")
      var in = readInt()
    while(in != 3){
      if(in == 1){
        print("\n@ Enter the Both Points ->")
        print("\n\t# START Location:")
        var L1 = readInt()
        print("\n\t# END Location:")
        var L2 = readInt()
        print("\n@ Enter the Seat No ->")
        print("\n\t# Seat Row: ")
        var row = readInt()
        print("\n\t# Seat No: ")
        var seatNo = readInt()
        reserveSeat(L1, L2, row,seatNo)
      }else if(in == 2){
        view(seatsColomboMattala)
        view(seatsMattalaRathmalana)
        view(seatsRathmalanaDelhi)
        view(seatsDelhiMombai)
      }
      print("# SELECT an option and Enter the Option Number to proceed.")
        print("\n\t1. Reserve a seats.")
        print("\n\t2. View Reserved seats.")
        print("\n\t3. EXIT Process.")
        print("\n@ Enter the Option Number to proceed: ")
      in = readInt()
    }
  }
}
