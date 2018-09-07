package suwashizmu.org.chllecaraprep

import android.content.Context
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

/**
 * Created by Your name on 2018/09/08.
 */
class TodoArrayAdapter(context: Context) : ArrayAdapter<Todo>(context, android.R.layout.simple_list_item_1, android.R.id.text1) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val textView = convertView as? TextView
                ?: LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false) as TextView

        textView.text = "${DateFormat.format("yy/MM/dd,HH:mm:ss", getItem(position).timeStamp())}:${getItem(position).text}"

        return textView
    }
}