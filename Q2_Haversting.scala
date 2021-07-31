import scala.io.StdIn._
object Haverest{
  var Year = Array(
    Array(1,2,3,1,6,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),//Jan
    Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),//Feb
    Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),//Mar
    Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),//April
    Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),//May
    Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),//June
    Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),//July
    Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),//Aug
    Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),//Sep
    Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),//Oct
    Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),//Nov
    Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)) //Dec

  def analyze(r1:Int,col1:Int,r2:Int,col2:Int):Unit={
    var total=0
    var count=0
    var max=Year(r1-1)(col1-1)
    var min=Year(r1-1)(col1-1)

    for(i <- r1-1 to r2-1){
      for(j <- col1-1 to col2-1){
        total += Year(i)(j);
        if(max< Year(i)(j)){max=Year(i)(j)}
        if(min> Year(i)(j)){min=Year(i)(j)}

        count +=1
      }
    }

    val avg=total/count
    val range=max-min

    print("\n@ Average = " +avg)
    print("\n@ Range = " +range)
    print("\n@ Max = " +max)
    print("\n@ Min = " +min)
  }

  def printreport(plan:Array[Array[Int]]):Unit={
    var i = 0
    var j = 0

    println()
    for(i <- 0 to 11){
      var mon = returnMonth(i+1)
      print(mon+ "\t" )
      for(j <- 0 to 29){
        print(plan(i)(j)+ " ")
      }
      println()
    }
    println()
  }

  def returnMonth(index:Int):String={
    index match {
      case 1 =>
        return "Jan"
      case 2 =>
        return "Feb"
      case 3 =>
        return "Mar"
      case 4 =>
        return "Apr"
      case 5 =>
        return "May"
      case 6 =>
        return "Jun"
      case 7 =>
        return "Jul"
      case 8 =>
        return "Aug"
      case 9 =>
        return "Sep"
      case 10 =>
        return "Oct"
      case 11 =>
        return "Nov"
      case 12 =>
        return "Dec"
    }
  }

  def main(args: Array[String]): Unit = {
    print("\n\n\t\t\t ### ANALYZE HAVERESTING OF THE YEAR !!! ###\n\n\n")
    print("SELECT an option and Enter the Option Number to proceed.")
      print("\n\t1. VIEW Haverest report.")
      print("\n\t2. UPDATE Haverest report for a day.")
      print("\n\t3. Analyze Haverest report for a period.")
      print("\n\t4. EXIT Process.")
    print("\n@ Enter the Option Number to proceed: ")
    var in = readInt()
    while(in != 4){
      if(in == 1){
        printreport(Year)
        analyze(1,1,12,30)
      }else if(in ==2){
        print("\n\t@ Enter the Month & Date:")
        print("\n\t  Month: ")
        var r = readInt()
        print("\n\t  Date: ")
        var col = readInt()
        print("\n\t  Daily_Haverest: ")
        Year(r-1)(col-1) = readInt()
      }else if(in == 3){
        print("\n@ Enter the Period")
        print("\n\t# START ->")
        print("\n\t  Month: ")
        var r1 = readInt()
        print("\n\t  Date: ")
        var col1 = readInt()
        print("\n\t# END ->")
        print("\n\t  Month: ")
        var r2 = readInt()
        print("\n\t  Date: ")
        var col2 = readInt()
        analyze(r1,col1,r2,col2)
      }
      print("\n\nSELECT an option and Enter the Option Number to proceed.")
        print("\n\t1. VIEW Haverest report.")
        print("\n\t2. UPDATE Haverest report for a day.")
        print("\n\t3. Analyze Haverest report for a period.")
        print("\n\t4. EXIT Process.")
      print("\n@ Enter the Option Number to proceed: ")
      in = readInt()
    }
  }
}
