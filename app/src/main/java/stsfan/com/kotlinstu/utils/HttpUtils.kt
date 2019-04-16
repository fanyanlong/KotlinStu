package stsfan.com.kotlinstu.utils

/**
 * @copyright:  zhidu
 * @author   fanyanlong
 * @email  326445811@qq.com
 * @versions：  V1.0.1
 * @data： 2019/4/16
 * @description：
 *
 */
class HttpUtils {
    //单例初始化
    companion object {
        var https: HttpUtils? = null
            get() {
                if (field == null) {
                    field = HttpUtils()
                }
                return field
            }

        @Synchronized
        fun get(): HttpUtils {
            return https!!
        }
    }
    // //初始化retrofit


}