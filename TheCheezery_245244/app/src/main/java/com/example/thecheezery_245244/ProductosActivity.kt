package com.example.thecheezery_245244

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ProductosActivity : AppCompatActivity() {

    var products = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_productos)

        var imageTitle: ImageView = findViewById(R.id.image_title)

        // Con esto obtengo el parametro que estoy enviando desde la clase menu
        val product = intent.getStringExtra("product")

        var listView: ListView = findViewById(R.id.listview)

        // Segun el atributo producto enviado previamente, seteamos la imagen del titulo y el producto dentro de la lista que se va poder ver
        when (product){
            "cold" -> {
                agregarColdDrinks()
                imageTitle.setImageResource(R.drawable.colddrinks)
            }
            "hot" ->  {
                agregarHotDrinks()
                imageTitle.setImageResource(R.drawable.hotdrinks)
            }
            "sweet" -> {
                agregarSweets()
                imageTitle.setImageResource(R.drawable.sweets)
            }
            "saltie" ->  {
                agregarSalties()
                imageTitle.setImageResource(R.drawable.salties)
            }
        }

        var adaptador: AdaptadorProductos = AdaptadorProductos(this, products)
        listView.adapter = adaptador
    }

    private fun agregarColdDrinks(){
        products.add(Product("Caramel Frap", R.drawable.caramelfrap, "Caramel syrup meets coffee, milk and ice and whipped cream and buttery caramel sauce layer the love on top.", 5.0))
        products.add(Product("Chocolate Frap", R.drawable.chocolatefrap, "Rich mocha-flavored sauce meets up with chocolaty chips, milk and ice for a blender bash.", 6.0))
        products.add(Product("Cold Brew", R.drawable.coldbrew, "Created by steeping medium-to-coarse ground coffee in room temperature water for 12 hours or longer.", 3.0))
        products.add(Product("Matcha Latte", R.drawable.matcha, "Leafy taste of matcha green tea powder with creamy milk and a little sugar for a flavor balance that will leave you feeling ready and raring to go.", 4.0))
        products.add(Product("Oreo Milkshake", R.drawable.oreomilkshake, "Chocolate ice cream, and oreo cookies. Topped with whipped cream with cocoa and chocolate syrup.", 7.0))
        products.add(Product("Peanut Milkshake", R.drawable.peanutmilkshake, "Vanilla ice cream, mixed with peanut butter and chocolate.", 7.0))
    }

    private fun agregarHotDrinks(){
        products.add(Product("Latte", R.drawable.latte, "Coffee drink made with espresso and steamed milk", 6.0))
        products.add(Product("Hot chocolate", R.drawable.hotchocolate, "Heated drink consisting of shaved chocolate, topped with marshmallows.", 5.0))
        products.add(Product("Espresso", R.drawable.espresso, "Full-flavored, concentrated form of coffee.", 4.0))
        products.add(Product("Chai Latte", R.drawable.chailatte, "Spiced tea concentrate with milk", 6.0))
        products.add(Product("Capuccino", R.drawable.capuccino, "A cappuccino is an espresso-based coffee drink, prepared with steamed foam.", 7.0))
        products.add(Product("American coffee", R.drawable.americano, "Espresso with hot water", 2.0))
    }

    private fun agregarSweets(){
        products.add(Product("Blueberry cake", R.drawable.blueberrycake, "Vanilla cake flavor, topped with cheese topping and blueberries.", 6.0))
        products.add(Product("Chocolate cupcake", R.drawable.chocolatecupcake, "Chocolate cupcakes topped with butter cream and cherries", 3.0))
        products.add(Product("Lemon tartalette", R.drawable.lemontartalette, "Pastry shell with a lemon flavored filling", 4.0))
        products.add(Product("Red Velvet cake", R.drawable.redvelvetcake, "Soft, moist, buttery cake topped with an easy cream cheese frosting.", 6.0))
        products.add(Product("Cherry cheesecake", R.drawable.strawberrycheesecake, "This cherry topped cheesecake is positively creamy and delicious and will be your new favorite dessert.", 7.0))
        products.add(Product("Tiramisu", R.drawable.tiramisu, "Coffee-flavored Italian dessert", 6.0))
    }

    private fun agregarSalties(){
        products.add(Product("Chicken crepes", R.drawable.chickencrepes, "Fine crepes stuffed with Alfredo chicken, spinach and mushrooms.", 6.0))
        products.add(Product("Club Sandwich", R.drawable.clubsandwich, "A delicious sandwich served with french fries.", 5.0))
        products.add(Product("Panini", R.drawable.hampanini, "Sandwich made with Italian bread served warmed by grilling.", 4.0))
        products.add(Product("Philly cheese steak", R.drawable.phillycheesesteak, "Smothered in grilled onions, green peppers, mushrooms, and Provolone.", 6.0))
        products.add(Product("Nachos", R.drawable.nachos, "Tortilla chips layered with beef and melted cheddar cheese. Served with fried beans, guacamole, pico de gallo, and sour topping.", 7.0))
    }

    private class AdaptadorProductos:BaseAdapter{
        var productos = ArrayList<Product>()
        var contexto: Context? = null

        constructor(contexto:Context, productos: ArrayList<Product>){
            this.productos = productos
            this.contexto = contexto
        }

        override fun getCount(): Int {
            return productos.size
        }

        override fun getItem(position: Int): Any {
            return productos[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var prod = productos[position]
            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.producto_view, null)

            var imagen = vista.findViewById(R.id.producto_img) as ImageView
            var nombre = vista.findViewById(R.id.producto_nombre) as TextView
            var desc= vista.findViewById(R.id.producto_desc) as TextView
            var precio = vista.findViewById(R.id.producto_precio) as TextView

            imagen.setImageResource(prod.image)
            nombre.setText(prod.name)
            desc.setText(prod.description)
            precio.setText("$${prod.price}")

            return vista
        }
    }
}