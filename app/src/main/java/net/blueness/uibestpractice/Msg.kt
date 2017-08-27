package net.blueness.uibestpractice

/**
 * Created by Blueness on 2017/8/26.
 */

class Msg(val content: String, val type: Int){
    companion object {
        val FINAL_TYPE_RECEIVED = 0
        val FINAL_TYPE_SENT = 1
    }
}