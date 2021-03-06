package com.sinovoice.lib.kotlin

/**
 *Created by liqiang on 2020/9/23.
 **/
class LetApplyTest {
    /**
     * •5、let函数适用的场景

    场景一: 最常用的场景就是使用let函数处理需要针对一个可null的对象统一做判空处理。

    场景二: 然后就是需要去明确一个变量所处特定的作用域范围内可以使用

     */
    fun letTest(str:String){

       val afterlet= str.let {
            print("${it.length}\t")
            println(it)
            1000
        }
        print("after let $afterlet")
    }

    /**
     * 适用于调用同一个类的多个方法时，可以省去类名重复，直接调用类的方法即可，经常用于Android中RecyclerView中onBinderViewHolder中，数据model的属性映射到UI上
     */
    fun withTest(){
        val people=People("Tom",26)
        val result=with(people){
            study()
             age
        }
        println("result=$result")
    }

    /**
     * 适用于let,with函数任何场景。因为run函数是let,with两个函数结合体，准确来说它弥补了let函数在函数体内必须使用it参数替代对象，
     * 在run函数中可以像with函数一样可以省略，直接访问实例的公有属性和方法，另一方面它弥补了with函数传入对象判空问题，在run函数中可以像let函数一样做判空处理
     */
    fun runTest(){
        val people=People("Tom",26)
        val result = people.run {
            println("my name is $name, I am $age years old")
            1000
        }
        println("result: $result")

    }

    /**
     *
    •5、apply函数的适用场景

    整体作用功能和run函数很像，唯一不同点就是它返回的值是对象本身，而run函数是一个闭包形式返回，
    返回的是最后一行的值。正是基于这一点差异它的适用场景稍微与run函数有点不一样。apply一般用于一个对象实例初始化的时候，
    需要对对象中的属性进行赋值。或者动态inflate出一个XML的View的时候需要给View绑定数据也会用到，
    这种情景非常常见。特别是在我们开发中会有一些数据model向View model转化实例化的过程中需要用到。

     */
    fun applytest(){
        val people=People("Tom",26)
        val result=people.apply {
            age=30
            name="Andy"
            print("my name $name")
            1000
        }
        println("result: $result")
    }

    /**
     * 6.also函数的结构实际上和let很像唯一的区别就是返回值的不一样，let是以闭包的形式返回，返回函数体内最后一行的值，
     * 如果最后一行为空就返回一个Unit类型的默认值。而also函数返回的则是传入对象的本身
     */
    fun alsotest(){
        val people=People("Tom",26)
        people.also {
            it.age
            it.name
            print("my age=${it.age}")
        }
    }
}