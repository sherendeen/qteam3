package com.android.example.quizapp

/**
 * Access the common, shared question data
 */
var myCommonData : Common = Common()

class Common {

    private var arr : ArrayList<Question> = ArrayList<Question>()

    fun getArray() : ArrayList<Question> {
        return this.arr
    }

    fun setArray(arr: ArrayList<Question>) {
        this.arr = arr
    }

    fun addElement(element : Question) {
        this.arr.add(element)
    }

    fun removeElement(element : Question) {
        this.arr.remove(element)
    }

}