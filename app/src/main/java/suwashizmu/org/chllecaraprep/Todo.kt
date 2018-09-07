package suwashizmu.org.chllecaraprep

import com.google.firebase.database.ServerValue

/**
 * Created by Your name on 2018/09/08.
 *
 * @param text テキストデーター
 * @param createdAt 作成した日時
 */
data class Todo(val text: String = "", val createdAt: Map<String, Any> = mapOf("timestamp" to ServerValue.TIMESTAMP)) {
    fun timeStamp() = createdAt["timestamp"] as Long
}