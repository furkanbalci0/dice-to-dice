package com.furkanbalci.dice_to_dice

import java.lang.Math

class Math {


}

fun main() {
    println(encodeMsg("Test"))
}

fun encodeMsg(message: String, encode: (String) -> String = {input -> input.reversed()}): String {
    return encode(message)
}