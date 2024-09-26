package com.example.happybirthday

import android.R.id.message
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {  // en este bloque se define la interfaz de usuario
            HappyBirthdayTheme {  // se define el tema de la interfaz de usuario
                Surface(  // se define el fondo de la interfaz de usuario
                    modifier = Modifier.fillMaxSize(), // asegura que el surface ocupe todo el espacio disponible
                    color = MaterialTheme.colorScheme.background  // se define el color del fondo
                ) {
                    GreetingImage(  // en esta funcion se metio texto e imagen en una caja (Box)
                        message = stringResource(R.string.happy_birthday_text),
                        from = stringResource(R.string.signature_text),
                        modifier = Modifier.padding(2.dp)  // se define un padding de 2 dp para la caja
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(  // se define una columna para alinear los elementos verticalmente
        verticalArrangement = Arrangement.Center,  // centra los elementos hijos verticalmente dentro de la columna
        modifier = modifier
    ) {
        Text(
            text = message,
            fontSize = 90.sp,
            lineHeight = 116.sp,
            color = Color.DarkGray,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier  // se define un modificador para el texto
                .padding(16.dp)
                .align(alignment = Alignment.End)  // alinea el texto al final de la columna
        )
    }
}


@Composable
fun GreetingImage(modifier: Modifier = Modifier, message: String, from: String) {
    val image = painterResource(R.drawable.fiesta2) // carga la imagen
    Box(modifier) { // se define un box para la imagen y el texto
        Image(
            painter = image,  // se define el painter para la imagen
            contentDescription = null,  // se define el content description para la imagen
            contentScale = ContentScale.Crop,  // ajusta la imagen al tamaño de la pantalla
            alpha = 0.7F,  // opacidad de la imagen
            modifier = Modifier.fillMaxSize()  // se define un modificador para la imagen
        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        // GreetingText(message = "Happy Birthday Sam!", from = "From Emma")
        GreetingImage(
            message = stringResource(R.string.happy_birthday_text),
            from = stringResource(R.string.signature_text)
        )
    }
}