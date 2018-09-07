package suwashizmu.org.chllecaraprep

import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

/**
 * Created by Your name on 2018/09/08.
 */
class TodoRepository(private val user: FirebaseUser,
                     private val callback: (todoList: Collection<Todo>) -> Unit) {

    /**
     * @param todo
     *
     * Todoを追加
     */
    fun add(todo: Todo) {
        FirebaseDatabase.getInstance()
                .getReference(user.uid)
                .push()
                .setValue(todo)

    }

    fun fetch() {
        FirebaseDatabase.getInstance()
                .getReference(user.uid)
                .addValueEventListener(object : ValueEventListener {

                    override fun onDataChange(dataSnapshot: DataSnapshot) {

                        //KeyValueをTodoに変換
                        callback(dataSnapshot.children.mapNotNull {
                            it.getValue(Todo::class.java)
                        })

                    }

                    override fun onCancelled(p0: DatabaseError) {

                    }

                })
    }
}