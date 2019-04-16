package stsfan.com.kotlinstu.kotlinmvp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.jcodecraeer.xrecyclerview.ProgressStyle
import com.jcodecraeer.xrecyclerview.XRecyclerView
import kotlinx.android.synthetic.main.activity_kt.*
import kotlinx.android.synthetic.main.activity_kt.view.*
import stsfan.com.kotlinstu.R
import java.lang.reflect.Array
import java.util.*
import kotlin.collections.ArrayList

/**
 * @copyright:  zhidu
 * @author   fanyanlong
 * @email  326445811@qq.com
 * @versions：  V1.0.1
 * @data： 2019/4/16
 * @description：
 *
 */
open class KtActivity : AppCompatActivity(), Contract.Iview {
    var ktpresenter: KtPresenter? = null
    var adapter: KtAdapter? = null
    var page: Int = 1
    var count: Int = 3
    var mHandler: Handler? = Handler()
    var array: ArrayList<Any>? = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kt)
        tv.text = "职业渡人"
        ktpresenter = KtPresenter(this)
        ktpresenter!!.Attch(this@KtActivity)
        //添加布局管理器
        kt_xrecyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        var block: (KtPresenter?) -> Unit = {
            it!!.Attch(this)
            it.GetPersnetViewDate(page, count)
        }
        ktpresenter.let(block)

        kt_xrecyclerview.setLoadingMoreEnabled(true)
        kt_xrecyclerview.setPullRefreshEnabled(true)
        kt_xrecyclerview.setLoadingMoreProgressStyle(ProgressStyle.BallZigZag)
        kt_xrecyclerview.setLoadingListener(object : XRecyclerView.LoadingListener {
            override fun onLoadMore() {

                //kt_xrecyclerview.postDelayed(Runnable { kotlin.run {  } },3000)
                mHandler!!.postDelayed(object : Runnable {
                    override fun run() {
                        page++
                        Log.i("onLoadMore===", page.toString())
                        // ktpresenter!!.Attch(this@KtActivity)
                        ktpresenter!!.GetPersnetViewDate(page, count)
                        adapter!!.notifyDataSetChanged()
                        kt_xrecyclerview.loadMoreComplete()

                    }
                }, 1000)


            }

            override fun onRefresh() {
                page = 1
                // ktpresenter!!.Attch(this@KtActivity)
                Log.i("onRefresh===", page.toString())
                ktpresenter!!.GetPersnetViewDate(page, count)
                adapter!!.notifyDataSetChanged()
                kt_xrecyclerview.refreshComplete()

            }
        })
    }

    override fun GetViewDate(mktbean: KtBean) {
        adapter = KtAdapter(this@KtActivity, mktbean)
        kt_xrecyclerview.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        ktpresenter!!.Decth()

    }

}
