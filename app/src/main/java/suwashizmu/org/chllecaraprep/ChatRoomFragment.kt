package suwashizmu.org.chllecaraprep


import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import com.google.firebase.auth.FirebaseAuth
import suwashizmu.org.chllecaraprep.databinding.ChatRoomFragBinding

/**
 * Created by Your name on 2018/09/06.
 */
class ChatRoomFragment : Fragment() {

    companion object {
        fun newInstance(): ChatRoomFragment {
            return ChatRoomFragment()
        }
    }

    private lateinit var binding: ChatRoomFragBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.chat_room_frag, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.chat_room, menu)
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