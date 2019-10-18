package com.example.smarthomes



import android.R.id
import android.R.style
import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Animatable
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.CardView
import android.view.Gravity
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.MediaController
import android.widget.TextView
import android.widget.Toast
import com.jgabrielfreitas.core.BlurImageView
import kotlinx.android.synthetic.main.activity_main.*

//import pl.droidsonroids.gif.GifDrawable
//import pl.droidsonroids.gif.GifImageButton
//import sun.net.www.content.image.gif



@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    lateinit var myBlurImage:BlurImageView
    internal val context: Context = this
    private val btn: ImageView? = null
    private val fan: ImageView? = null
    internal var img: ImageView?=null
    internal var isClickedDummy: Boolean? = null // global after the declaration of your class

    internal lateinit var  cardView: CardView
    internal lateinit var cardv: CardView
    internal lateinit  var firecard: CardView
    internal lateinit var ac: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        isClickedDummy = true

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //   img = findViewById(R.id.MASTERBEDRROM)

    }
    fun imageClicked(v:View){

            myBlurImage=findViewById(R.id.blur_screen)

            myBlurImage.setBlur(8)

            myBlurImage.visibility=View.VISIBLE
            main_screen.visibility=View.INVISIBLE




            // custom dialog
            val dialog = Dialog(context,R.style.TranslucentDialog)
            dialog.setContentView(R.layout.transparent_dailogbox)
            val lp = dialog.window!!.attributes
            lp.dimAmount = 0.0f
            dialog.window!!.attributes = lp
            dialog.window!!.addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND)

            val image = dialog.findViewById(R.id.Id_Bulb) as ImageView
             var label=dialog.findViewById<TextView>(R.id.label)
            image.setImageResource(R.drawable.bulb)
            dialog.setCanceledOnTouchOutside(false)
        when(v.id) {
           MASTERBEDRROM.id-> label.text = "Master Bedroom"
            LIVINGROOM.id->label.text="Living Room"
            CHILDRENBEDROOM.id->label.text="Children Bedroom"
            WALKWAY.id->label.text="Walk Way"
            gate.id->label.text="Gate"
            BATHROOM.id->label.text="Bathroom"
            KITCHEN.id->label.text="Kitchen"
            DININGROOM.id->label.text="Dining Room"
        }
            cardView = dialog.findViewById(R.id.card)
            cardView.setOnClickListener(View.OnClickListener {
                if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                    cardView.setCardBackgroundColor(Color.parseColor("#FFFF00"))


                    val toast = Toast.makeText(applicationContext, "BULB turned on", Toast.LENGTH_SHORT)
                    toast.show()
                } else {
                    cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"))


                }
            })

            cardv = dialog.findViewById(R.id.fan_back)
            cardv.setOnClickListener(View.OnClickListener {
                if (cardv.getCardBackgroundColor().getDefaultColor() == -1) {
                    cardv.setCardBackgroundColor(Color.parseColor("#008000"))
                    val toast = Toast.makeText(applicationContext, "Fan turned on", Toast.LENGTH_SHORT)
                    toast.show()


                } else {
                    cardv.setCardBackgroundColor(Color.parseColor("#FFFFFF"))


                }
            })

            firecard = dialog.findViewById(R.id.fire)
            firecard.setOnClickListener(View.OnClickListener {
                if (firecard.getCardBackgroundColor().getDefaultColor() == -1) {
                    firecard.setCardBackgroundColor(Color.parseColor("#e25822"))
                    val toast = Toast.makeText(applicationContext, "Fire Alaram", Toast.LENGTH_SHORT)
                    toast.show()


                } else {
                    firecard.setCardBackgroundColor(Color.parseColor("#FFFFFF"))


                }
            })

            ac = dialog.findViewById(R.id.card_ac)
            ac.setOnClickListener(View.OnClickListener {
                if (ac.getCardBackgroundColor().getDefaultColor() == -1) {
                    ac.setCardBackgroundColor(Color.parseColor("#00FFFF"))
                    val toast = Toast.makeText(applicationContext, "Ac turned on", Toast.LENGTH_SHORT)
                    toast.show()


                } else {
                    ac.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
                    val toast = Toast.makeText(applicationContext, "Ac turned off", Toast.LENGTH_SHORT)
                    toast.show()

                }
            })


            val dialogButton = dialog.findViewById(R.id.dialogButtonOK) as Button
            // if button is clicked, close the custom dialog
            dialogButton.setOnClickListener { dialog.cancel()

                myBlurImage.visibility=View.INVISIBLE
                main_screen.visibility=View.VISIBLE
            }

            dialog.show()
        }
    }










