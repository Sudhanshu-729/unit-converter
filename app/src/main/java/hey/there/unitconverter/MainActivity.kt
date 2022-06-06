package hey.there.unitconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    private var editText: EditText? = null
    private var spinner1: Spinner? = null
    private var spinner2: Spinner? = null
    private var convert: Button? = null
    private var textview: TextView? = null
    private var answer: TextView? = null
    private var value:Double? =null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editTextNumber)
        spinner1 = findViewById(R.id.sp_One)
        spinner2 = findViewById(R.id.sp_Two)
        convert = findViewById(R.id.button)
        textview = findViewById(R.id.textView)
        answer = findViewById(R.id.tv_answer)

        val sp1Content = arrayOf("meter")
        val sp2Content = arrayOf("centimeter", "millimeter", "kilometer")

        spinner1?.adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1, sp1Content
        )
        spinner2?.adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1, sp2Content
        )

        convert?.setOnClickListener {
            value = editText!!.text.toString().toDouble()
            if (value !=null) {
                if (spinner1?.selectedItem == "meter"
                    && spinner2?.selectedItem == "centimeter"
                ) {
                    answer?.text = (value!! * 100).toString()
                } else if (spinner1?.selectedItem == "meter"
                    && spinner2?.selectedItem == "millimeter"
                ) {
                    answer?.text = (value!! * 1000).toString()
                } else if (spinner1?.selectedItem == "meter"
                    && spinner2?.selectedItem == "kilometer"
                ) {
                    answer?.text = (value!! / 1000).toString()
                }
            }else{
                Toast.makeText(this,"enter the value first",Toast.LENGTH_LONG).show()
            }
        }
    }
}