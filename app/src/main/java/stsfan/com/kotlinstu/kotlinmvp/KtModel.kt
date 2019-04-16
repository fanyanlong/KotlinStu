package stsfan.com.kotlinstu.kotlinmvp

import android.support.annotation.MainThread
import com.bw.myfirstkotlin.RetrofitUtils
import io.reactivex.ObservableSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import java.util.*

/**
 * @copyright:  zhidu
 * @author   fanyanlong
 * @email  326445811@qq.com
 * @versions：  V1.0.1
 * @data： 2019/4/16
 * @description：
 *
 */
//open可被继承
class KtModel : Contract.Imodel {
    //override重写  fun方法
    override fun GetModelDate(page: Int, count: Int, model: Contract.Imodel.ModelCallBack) {
        //获取网络
        RetrofitUtils.instance.create.getNetDate(page, count)
                //切换io流
                .subscribeOn(Schedulers.io())
                //切换主线程
                .observeOn(AndroidSchedulers.mainThread())
                //订阅 object对象变量
                .subscribe(object : DisposableObserver<KtBean>() {
                    //完成操作
                    override fun onComplete() {

                    }

                    //下一步操作
                    override fun onNext(t: KtBean) {
                        model.onSuccess(t)
                    }

                    //错误操作
                    override fun onError(e: Throwable) {
                    }

                })
    }
}



