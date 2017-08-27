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
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.msg_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val msg = mMsgList.get(position)
        if (msg.type == Msg.FINAL_TYPE_RECEIVED) {
//            如果是收到的消息，则显示左边的消息布局，将右边的消息布局隐藏
            holder.leftLayout.visibility = View.VISIBLE;
            holder.rightLayout.visibility = View.GONE;
            holder.leftMsg.text = msg.content;
        } else if(msg.type == Msg.FINAL_TYPE_SENT) {
//            如果是发出的消息，则显示右边的消息布局，将左边的消息布局隐藏
            holder.rightLayout.visibility = View.VISIBLE;
            holder.leftLayout.visibility = View.GONE;
            holder.rightMsg.text = msg.content;
        }
    }



    override fun getItemCount(): Int {
        return mMsgList.size
    }

}