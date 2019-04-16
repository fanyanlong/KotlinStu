package stsfan.com.kotlinstu.kotlinmvp
/**
 * @copyright:  zhidu
 * @author   fanyanlong
 * @email  326445811@qq.com
 * @versions：  V1.0.1
 * @data： 2019/4/16  
 * @description：
 *
 */
//data  数据类
data class KtBean(
    val message: String,
    val result: List<Result>,
    val status: String
)

data class Result(
    val followMovie: Int,
    val id: Int,
    val imageUrl: String,
    val name: String,
    val rank: Int,
    val summary: String
)