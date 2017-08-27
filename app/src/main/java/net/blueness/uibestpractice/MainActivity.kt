package net.blueness.uibestpractice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.EditText
import org.jetbrains.anko.find


class MainActivity : AppCompatActivity() {

    private var msgList = ArrayList<Msg>()
    private var inputText: EditText? = null
    private var send: Button? = null
    private var msgRecyclerView: RecyclerView? = null
    private var msgAdapter: MsgAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initMsgs(); // 初始化消息数据
        inputText = find(R.id.input_text)
        send = find(R.id.send)
        msgRecyclerView = find(R.id.msg_recycler_view)
        val layoutManager = LinearLayoutManager(this)
        msgRecyclerView?.layoutManager = layoutManager
        msgAdapter = MsgAdapter(msgList)
        msgRecyclerView?.adapter = msgAdapter
        send?.setOnClickListener{
            val content = inputText!!.getText().toString()
            if (content != "") {
                val msg = Msg(content, Msg.FINAL_TYPE_SENT)
                msgList.add(msg)
                msgAdapter?.notifyItemInserted(msgList.size - 1) // 当有新消息时，刷新ListView中的显示
                msgRecyclerView?.scrollToPosition(msgList.size - 1) // 将ListView定位到最后一行
                inputText?.setText("") // 清空输入框中的内容
            }
        }
    }

    private fun initMsgs() {
        val msg1 = Msg("Hello guy.", Msg.FINAL_TYPE_RECEIVED)
        msgList.add(msg1)
        val msg2 = Msg("Hello. Who is that?", Msg.FINAL_TYPE_SENT)
        msgList.add(msg2)
        val msg3 = Msg("This is Tom. Nice talking to you. ", Msg.FINAL_TYPE_RECEIVED)
        msgList.add(msg3)
    }

}
