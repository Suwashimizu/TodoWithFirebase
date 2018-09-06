package suwashizmu.org.chllecaraprep


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import suwashizmu.org.chllecaraprep.databinding.SignUpFragBinding

/**
 * Created by Your name on 2018/09/06.
 */
class SignUpFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance(): SignUpFragment = SignUpFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding: SignUpFragBinding = DataBindingUtil.inflate(inflater, R.layout.sign_up_frag, container, false)
        binding.signUpButton.setOnClickListener {
            (activity as? MainActivity)?.gotoSignUp()
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }
}