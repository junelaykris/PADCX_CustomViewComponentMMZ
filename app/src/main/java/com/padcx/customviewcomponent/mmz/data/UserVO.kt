package com.padcx.customviewcomponent.mmz.data

/**
 * Created by Myint Myint Zaw on 7/25/2020.
 */
data class UserVO(
    var status: String = "",
    var name: String = "",
    var title: String = "",
    var imageurl: Int = 0,
    var messagecount: Int = 0,
    var attachment: Int = 0,
    var jobtype: String = "",
    var closedtask_count: String = "",
    var opentask_count: String = ""
) {
}