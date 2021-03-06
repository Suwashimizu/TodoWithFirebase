package suwashizmu.org.chllecaraprep


import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import com.google.firebase.auth.FirebaseAuth
import suwashizmu.org.chllecaraprep.databinding.TodoListFragBinding

/**
 * Created by Your name on 2018/09/08.
 */
class TodoListFragment : Fragment() {

    companion object {
        fun newInstance(): TodoListFragment = TodoListFragment()
    }

    private lateinit var binding: TodoListFragBinding

    private var todoRepository: TodoRepository? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.todo_list_frag, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val user = FirebaseAuth.getInstance().currentUser
        if (user == null) {
            requireActivity().finish()
            return
        }

        binding.listView.adapter = TodoArrayAdapter(requireActivity())

        //ListViewへアイテムを追加
        todoRepository = TodoRepository(user) {
            (binding.listView.adapter as TodoArrayAdapter).clear()
            (binding.listView.adapter as TodoArrayAdapter).addAll(it)
        }

        //送信ボタン
        binding.addButton.setOnClickListener {
            todoRepository?.add(Todo(binding.todoEdit.text.toString()))
            binding.todoEdit.text.clear()
        }
    }

    override fun onResume() {
        super.onResume()

        todoRepository?.fetch()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.todo, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.sign_out) {

            //ログアウトの実行
            FirebaseAuth.getInstance().signOut()

            startActivity(Intent(context, MainActivity::class.java))
            requireActivity().finish()
        }
        return super.onOptionsItemSelected(item)
    }
}