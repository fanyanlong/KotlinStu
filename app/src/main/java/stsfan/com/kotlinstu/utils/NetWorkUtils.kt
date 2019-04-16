package stsfan.com.kotlinstu.utils

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query
import stsfan.com.kotlinstu.kotlinmvp.KtBean

/**
 * @copyright:  zhidu
 * @author   fanyanlong
 * @email  326445811@qq.com
 * @versions：  V1.0.1
 * @data： 2019/4/16
 * @description： retrofit 请求类
 *
 */
interface NetWorkUtils {

    @GET("findReleaseMovieList")
    fun getNetDate(@Query("page") page: Int, @Query("count") count: Int): Observable<KtBean>

}