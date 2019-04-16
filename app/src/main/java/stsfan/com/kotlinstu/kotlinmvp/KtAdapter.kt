package stsfan.com.kotlinstu.kotlinmvp

import android.content.Context
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.facebook.drawee.view.SimpleDraweeView
import kotlinx.android.synthetic.main.kt_listitem_layout.view.*
import stsfan.com.kotlinstu.R

/**
 * @copyright:  zhidu
 * @author   fanyanlong
 * @email  326445811@qq.com
 * @versions：  V1.0.1
 * @data： 2019/4/16
 * @description：
 *
 */
class KtAdapter(var context: Context, var ktBean: KtBean) : RecyclerView.Adapter<KtAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.kt_listitem_layout, p0, false))
    }

    override fun getItemCount(): Int {
        return ktBean.result.size
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        // p0.kttv.setText(ktBean.result.get(p1).name)
        p0.kttv.text = ktBean.result.get(p1).name
        p0.ktimg.setImageURI(Uri.parse(ktBean.result.get(p1).imageUrl))
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ktimg: SimpleDraweeView = itemView.kt_item_iv
        var kttv: TextView = itemView.kt_item_tv
    }
}
