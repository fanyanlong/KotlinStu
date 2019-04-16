package stsfan.com.kotlinstu.kotlinmvp

import java.lang.ref.SoftReference

/**
 * @copyright:  zhidu
 * @author   fanyanlong
 * @email  326445811@qq.com
 * @versions：  V1.0.1
 * @data： 2019/4/16
 * @description：
 *
 */
open class KtPresenter(val mview: KtActivity) : Contract.Ipresenter {
    var mmodel: KtModel? = KtModel()
    //?可为空
    override fun Attch(miview: Contract.Iview) {

        //软引用
       // soft = SoftReference<Contract.Imodel>(mmodel)
    }

    override fun Decth() {
        if (mview != null) {
            mview == null
        }
    }

    override fun GetPersnetViewDate(page: Int, count: Int) {
        //!!表示对象不为空的情况下去执行
        mmodel!!.GetModelDate(page, count, object : Contract.Imodel.ModelCallBack {
            override fun onSuccess(mttbena: KtBean) {
                mview.GetViewDate(mttbena)
            }

            override fun onFails() {
            }
        })


    }
}