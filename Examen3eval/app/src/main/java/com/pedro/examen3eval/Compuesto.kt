package com.pedro.examen3eval

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pedro.examen3eval.databinding.ElementoexBinding
import com.pedro.examen3eval.databinding.FragmentCompuestoBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class Compuesto : Fragment() {
    val canciones: MutableList<Canciones> = ArrayList()
    private val adaptador= Simple.Custom3Adapter(canciones)

    val check1:CheckBox?=null
    val check2:CheckBox?=null
    val check3:CheckBox?=null
    private var _binding: FragmentCompuestoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCompuestoBinding.inflate(inflater, container, false)
        with(binding.recyclerex2) {
            adapter = adaptador
            layoutManager = LinearLayoutManager(requireContext())
        }
        return binding.root

    }
    class Custom3Adapter(private val listadoDatos: MutableList<Canciones>) :
        RecyclerView.Adapter<Custom3Adapter.ViewHolder>() {

        /** Clase que describe la vista de cada elemento de la lista y su posición en esta. */
        class ViewHolder(binding: ElementoexBinding) : RecyclerView.ViewHolder(binding.root) {
            val mView = binding.root
            val img=binding.imageView2
            val textViewnombre = binding.textView2
            val textViewautor = binding.textView3
            val borrar = binding.btnDelete


            init {
                binding.btnDelete.setOnClickListener {
                }
            }




        }

        /** Método al que se llama cada vez que se crea uno de los elementos de la lista. */
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
            ElementoexBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )


        /** Método que vincula en cada elemento, según su posición, los datos correspondientes a
         * cada elemento */
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.textViewnombre.text = listadoDatos[position].titulo
            holder.textViewautor.text=listadoDatos[position].autor
            holder.img.setImageResource(listadoDatos[position].idImagen)
            with(holder) {
                if (position % 2 == 0) { // Si la posición de la fila es par
                    mView.setBackgroundColor(Color.CYAN)
                    textViewnombre.setTextColor(Color.BLACK)
                    textViewautor.setTextColor(Color.BLACK)
                } else { // Si la posición es impar
                    mView.setBackgroundColor(Color.BLUE)
                    textViewnombre.setTextColor(Color.WHITE)
                    textViewautor.setTextColor(Color.WHITE)
                }
            }
        }

        override fun getItemCount() = listadoDatos.size

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.checkBox.setOnClickListener{
            borarlista()
            var blus= comprobarblus()
            var rock= comprobarrock()
            var jaz=  comprobajazz()
            if(blus){
                añadirblus()
            }
            if (jaz){
                añadirjazz()
            }
            if(rock){
                añadirrock()
            }
            adaptador.notifyDataSetChanged()
        }
        binding.checkBox2.setOnClickListener{
            borarlista()
            var blus= comprobarblus()
            var rock= comprobarrock()
            var jaz=  comprobajazz()
            if(blus){
                añadirblus()
            }
            if (jaz){
                añadirjazz()
            }
            if(rock){
                añadirrock()
            }
            adaptador.notifyDataSetChanged()
        }
        binding.checkBox3.setOnClickListener{
            borarlista()
            var blus= comprobarblus()
            var rock= comprobarrock()
            var jaz=  comprobajazz()
            if(blus){
                añadirblus()
            }
            if (jaz){
                añadirjazz()
            }
            if(rock){
                añadirrock()
            }
            adaptador.notifyDataSetChanged()
        }



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    fun comprobarblus(): Boolean {
    if (binding.checkBox2.isChecked ){
     return true
    }
        return false
    }
    fun comprobarrock(): Boolean {
        if (binding.checkBox.isChecked ){
            return true
        }
        return false
    }
    fun comprobajazz(): Boolean {
        if (binding.checkBox3.isChecked ){
        return true
        }
    return false
    }
    fun añadirblus(){
        canciones.add(Canciones("Lady Soul", "Aretha Franklin",R.mipmap.ic_ladysoul_foreground))
        canciones.add(Canciones("I Never Loved a Man the Way I Love You", "Aretha Franklin",R.mipmap.ic_neverloved_foreground))
        canciones.add(Canciones("What's Going On", "Marvin Gaye",R.mipmap.ic_velvetunderground_foreground))
        canciones.add(Canciones("Are You Experienced", "Jimi Hendrix",R.mipmap.ic_whatsgoingon_foreground))
    }
    fun añadirrock(){
        canciones.add(Canciones("Abbey Road", "The Beatles",R.mipmap.ic_abbeyroad))
        canciones.add(Canciones("Exile on Main Street", "The Rolling Stones",R.mipmap.ic_exileonmainst_foreground))
        canciones.add(Canciones("The Velvet Underground", "he Velvet Underground and Nico",R.mipmap.ic_velvetunderground_foreground))
        canciones.add(Canciones("Are You Experienced", "Jimi Hendrix",R.mipmap.ic_areyouexperienced_foreground))
        canciones.add(Canciones("Back in Black", "AC/DC",R.mipmap.ic_backinblack_foreground))
        canciones.add(Canciones("Appetite for Destruction", "Guns N’ Roses",R.mipmap.ic_appetitefordestruction_foreground))
        canciones.add(Canciones("Led Zeppelin IV", "Led Zeppelin",R.mipmap.ic_ledzeppeliniv_foreground))
    }
    fun añadirjazz(){
        canciones.add(Canciones("Kind of Blue", "Miles Davis",R.mipmap.ic_kindofblue_foreground))
        canciones.add(Canciones("Bitches Brew", "Miles Davis",R.mipmap.ic_bitchesbrew_foreground))
        canciones.add(Canciones("A Love Supreme", "John Coltrane",R.mipmap.ic_alovesupreme_foreground))
        canciones.add(Canciones("Are You Experienced", "Jimi Hendrix",R.mipmap.ic_whatsgoingon_foreground))
    }
    fun borarlista(){
        canciones.removeAll(canciones);
    }
}