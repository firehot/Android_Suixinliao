package com.tencent.qcloud.timchat.model;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import com.tencent.TIMMessage;
import com.tencent.TIMTextElem;
import com.tencent.qcloud.timchat.MyApplication;
import com.tencent.qcloud.timchat.R;
import com.tencent.qcloud.timchat.adapters.ChatAdapter;

/**
 * 文本消息数据
 */
public class TextMessage extends Message {

    public TextMessage(TIMMessage message){
        this.message = message;
    }

    public TextMessage(String s){
        message = new TIMMessage();
        TIMTextElem elem = new TIMTextElem();
        elem.setText(s);
        message.addElement(elem);
    }

    /**
     * 在聊天界面显示消息
     *
     * @param viewHolder 界面样式
     * @param context 显示消息的上下文
     */
    @Override
    public void showMessage(ChatAdapter.ViewHolder viewHolder, Context context) {
        TextView tv = new TextView(MyApplication.getContext());
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        tv.setTextColor(MyApplication.getContext().getResources().getColor(isSelf() ? R.color.white : R.color.black));
        tv.setText(((TIMTextElem) message.getElement(0)).getText());
        getBubbleView(viewHolder).removeAllViews();
        getBubbleView(viewHolder).addView(tv);
        showStatus(viewHolder);
    }

    /**
     * 获取消息摘要
     */
    @Override
    public String getSummary() {
        return ((TIMTextElem) message.getElement(0)).getText();
    }


}
