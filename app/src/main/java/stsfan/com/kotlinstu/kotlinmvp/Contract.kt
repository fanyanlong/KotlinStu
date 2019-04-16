package stsfan.com.kotlinstu.kotlinmvp

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
interface Contract {
    //Iview
    interface Iview {
        fun GetViewDate(mktbean: KtBean)
    }

    // Ipresenter
    interface Ipresenter {
        fun GetPersnetViewDate(page: Int, count: Int)
        fun Attch(miview: Iview)
        fun Decth()
    }

    // Imodel
    interface Imodel {
        fun GetModelDate(page: Int, count: Int, model: ModelCallBack)
        interface ModelCallBack {
            fun onSuccess(mttbena: KtBean)
            fun onFails()
        }
    }
}


