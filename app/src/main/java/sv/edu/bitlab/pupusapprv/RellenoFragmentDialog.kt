package sv.edu.bitlab.pupusapprv

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [RellenoFragmentDialog.OnRellenoFragmentInteraction] interface
 * to handle interaction events.
 * Use the [RellenoFragmentDialog.newInstance] factory method to
 * create an instance of this fragment.
 */
class RellenoFragmentDialog : DialogFragment() {
  // TODO: Rename and change types of parameters
  private var listener: OnRellenoFragmentInteraction? = null
  private lateinit var aceptarBtn:Button
  private lateinit var cancelarBtn:Button
  private lateinit var rellenoTxt:EditText

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_dialog_relleno, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    rellenoTxt = view.findViewById(R.id.rellenoTxt)
    aceptarBtn = view.findViewById(R.id.aceptarBtn)
    cancelarBtn = view.findViewById(R.id.cancelarBtn)
    aceptarBtn.setOnClickListener {
      listener?.onButtonClicked(rellenoTxt.text.toString())
      this.dismiss()
    }
    cancelarBtn.setOnClickListener { this.dismiss() }
  }

  override fun onAttach(context: Context) {
    super.onAttach(context)
    if (context is OnRellenoFragmentInteraction) {
      listener = context
    } else {
      throw RuntimeException(context.toString() + " must implement OnRellenoFragmentInteraction")
    }
  }

  override fun onDetach() {
    super.onDetach()
    listener = null
  }

  /**
   * This interface must be implemented by activities that contain this
   * fragment to allow an interaction in this fragment to be communicated
   * to the activity and potentially other fragments contained in that
   * activity.
   *
   *
   * See the Android Training lesson [Communicating with Other Fragments]
   * (http://developer.android.com/training/basics/fragments/communicating.html)
   * for more information.
   */
  interface OnRellenoFragmentInteraction {
    // TODO: Update argument type and name
    fun onButtonClicked(relleno: String)
  }

  companion object {
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RellenoFragmentDialog.
     */
    // TODO: Rename and change types and number of parameters
    @JvmStatic
    fun newInstance() =
      RellenoFragmentDialog().apply {

      }
  }
}
