import scala.io.Source
import scala.collection.mutable.ArrayBuffer
import java.io.{ FileNotFoundException, IOException}
import java.lang.{ ArrayIndexOutOfBoundsException }
import java.io.PrintWriter
import scala.io.StdIn.{readLine, readInt}
object project4 {
  val arrayBuffer1 = ArrayBuffer[String]()
  val arrayBuffer = ArrayBuffer[Word]()
  //Word object were has the word and times it occurs
  class Word(var word : String,var times : Int){
    this.setWord(word)
    this.setTimes(times)
   
    
    def getWord() : String = word
    def setWord(word : String) = this.word=word
    def getTimes() : Int = times
    def setTimes(times : Int) = this.times=times
    
    override def toString() : String={
      return "Word: %s occurs %d times".format(this.word,this.times) 
    }
    
  }
  
   def main(args : Array[String] ){
       //Creates input.txt file with 
       //content of the assignment description    
       var fileName = "input.txt"
       var fileContent ="For this assignment you are to use read in this text for your input (input.txt) for input to your scala and java program. In this project you are to read each word in from the assignment file and output the list of unique words and the number of times each word comes up within the assignment file. For both programs you are to create two types of classes: one class that manages all the word objects, and another class whose instance takes in a unique word through its constructor function. This word encapsulating class must contain a member function update that increments its word count every time this word is found within the text. Points will be given based on producing the correct output, creating the manager and container class and lastly for style. This assignment is worth 20 pts."
       //Passes to the fileIO function were
       //it reads the input.txt file and puts
       //every word into an array
       fileIO(fileName,fileContent)
       //ArrayBuffer for unique words
       val uniqueBuffer = ArrayBuffer[Word]() 
       var count = 0
       //double for loop that sees how many times
       // the word occurs in the array
       for(element <- arrayBuffer1){
           count=0
           for(e <- arrayBuffer1){
              //if the word occurs then the count 
              // is incremented
              if(element==e){
                count=count+1
              }
         }
           //If occured more than once than added to
           // word list
           if(count>1){
             var word = new Word(element,count)
             arrayBuffer += word
           }
           //If occured once than added to
           // unique list
           else{
             var word = new Word(element,count)
             uniqueBuffer += word
           }
           
       }
       //Prints how many times a word occurs
       println("List of Words:")
        for(element <- arrayBuffer){
          println(element)
        }
        //Prints unique words
        println("List of Unique Words:")
        for(element <- uniqueBuffer){
          println(element)
        }
      }
     def fileIO(fileName : String, fileContent : String){
       val writer = new PrintWriter(fileName)
       writer.write(fileContent)
       writer.close()
       val file =  Source.fromFile(fileName)
       val lineIterator = file.getLines
       //Adds each word into an array buffer
       for(line <- lineIterator)
         for(element <- line.split(" ") ){
             arrayBuffer1 += element
     }
       file.close()
     }
}