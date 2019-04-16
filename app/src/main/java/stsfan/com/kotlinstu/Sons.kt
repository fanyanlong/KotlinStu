package stsfan.com.kotlinstu

import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import stsfan.com.kotlinstu.R.id.tvs
import kotlin.properties.Delegates

class Sons: Person("职度") {
     fun  Person.all()="dddddd"
     fun  Sons.sums(a:String,b:String)=a+b

     fun fins(sons:Sons){
       println(sons.sums("dd","rrr"))
         println(sons.pens("职度"))





     }
    var nameer: String by Delegates.observable("初始值") {
        p, old, news ->
        println("旧值：$old -> 新值：$news-> p:$p")
    }


    class  Eend(var name:String,var pswd:String){

        fun login(){
            println("$name$pswd")

        }
    }



    private fun init() {
        //常量定义
        val name:String="第一个kotlin程序"



    }


}


fun mains() {
       var  som=Sons();
    som.fins(Sons())
    som.nameer = "第一次赋值"
    som.nameer= "第二次赋值"
   var thread:Thread= Thread()
    thread.start();

}