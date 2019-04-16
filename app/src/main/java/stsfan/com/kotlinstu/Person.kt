package stsfan.com.kotlinstu

import com.lljjcoder.citylist.sortlistview.SideBar
import kotlin.reflect.KProperty
import com.lljjcoder.citylist.sortlistview.SideBar.b


open class Person {
    lateinit var name: String

    //lateinit 只用于变量 var，而 lazy 只用于常量 val
    //次构造器
    constructor (name: String) {
        println("$name")

    }

    open fun pens(name: String) {
        println("${name}教育")

    }

    //内部嵌套类
    inner class son {
        val foodw: String? = "面包"
        var eate: String? = "吃"
        var namesd: String = "小明"
        fun love(names: String, food: String, eat: String) {
            println(names + eat + food)

        }
    }

    class soner {
        val foodw: String? = "面包"
        var eate: String? = "吃"
        var namesd: String = "小明"

        fun love(names: String, food: String, eat: String) {
            println(names + eat + food)

        }
    }


}

fun main(args: Array<String>): Boolean {
    println("dhhh")
    //次构造器
    var person = Person("小花爱笑")
    //内部嵌套
    var sons = Person("小花爱笑").son()
    //嵌套类
    Person.soner().love("小黑", "黑豆", "吃")

    sons.love("小王", "闷到马户", "喝")


    person.pens(sons.namesd)


    println(sons.namesd + sons.eate + sons.foodw)


    // .if表达式与三元运算符
    // c = if (a > b) 3 else 4//如果a>b，c=3，否则c=4
    //对应的Kotlin中的if表达式

    var a: Int = 3
    var b: Int = 2
    var mc = if (a > b) 3 else 4
    //java中  c = a > b ? 1 : 2;//如果a>b，c=1，否则c=2
    //对应的Kotlin中的if表达式
    var c = if (a > b) 1 else 2
    //代码块 实现
    var d = if (a > b) {
        1
    } else {
        2
    }
    //when与java中的switch
    //
    /* int a = 0;
     switch (a) {
         case 0:
         break;
         case 1:
         break;
         default:
         break;
     }*/

    // Kotlin中对应的when语句
    var ma = 0
    when (ma) {
        0 -> {
        }
        1 -> {
        }
        else -> {
        }
    }
    //id

    fun GetNumber(x: Any) = when (x) {//kotlin中所有类都有一个共同的父类： Any
        is String -> {//如果x是String类型，执行该代码块
        }
        is Int -> {
            //如果x是Int类型，执行该代码块
        }
        else -> false
    }

   //定位2在1-5范围中返回值
    if (2 in 1..10){
        return true
    }else{
        return false
    }

}






