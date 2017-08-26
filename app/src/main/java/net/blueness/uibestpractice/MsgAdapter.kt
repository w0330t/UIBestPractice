package net.blueness.uibestpractice

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import org.jetbrains.anko.find

/**
 * Created by Blueness on 2017/8/26.
 */
class MsgAdapter(private val mMsgList: MutableList<Msg>): RecyclerView.Adapter<MsgAdapter.ViewHolder>(){

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val leftLayout: LinearLayout = view.find(R.id.left_layout)
        val rightLayout: LinearLayout = view.find(R.id.right_layout)
        val leftMsg: TextView = view.find(R.id.left_msg)
        val rightMsg: TextView = view.find(R.id.right_msg)
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.msg_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val msg = mMsgList.get(position)
//        if(msg.type == Msg.)
    }



    override fun getItemCount(): Int {
        return mMsgList.size
    }

}