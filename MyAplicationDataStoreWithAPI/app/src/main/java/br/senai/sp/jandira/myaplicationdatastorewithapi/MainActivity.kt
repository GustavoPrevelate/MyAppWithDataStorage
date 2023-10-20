package br.senai.sp.jandira.myaplicationdatastorewithapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.myaplicationdatastorewithapi.ui.theme.MyAplicationDataStoreWithAPITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAplicationDataStoreWithAPITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    listOf(
                        Color.Blue,
                        Color.Blue
                    )
                )
            )
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 190.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            listOf(
                                Color.Black,
                                Color.Black
                            )
                        ),
                        shape = RoundedCornerShape(50.dp, 50.dp, 0.dp, 0.dp)
                    )
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 30.dp),
                ) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

//                        OutlinedTextField(
//                            value = userNameUserSharedState,
//                            onValueChange = { newUserNameJogador ->
//                                userNameUserSharedState = newUserNameJogador
//                            },
//                            modifier = Modifier
//
//                                .width(350.dp),
//                            shape = RoundedCornerShape(16.dp),
//                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
//                            label = {
//                                Text(
//                                    text = "Label User",
//                                    color = Color.White,
//                                    fontWeight = FontWeight(600),
//                                )
//                            },
//                            colors = TextFieldDefaults.outlinedTextFieldColors(
//                                unfocusedBorderColor = Color(255, 255, 255, 255),
//                                focusedBorderColor = Color(255, 255, 255, 255),
//                                cursorColor = Color.White
//                            ),
//                            textStyle = TextStyle(color = Color.White)
//                        )

                        Spacer(modifier = Modifier.height(10.dp))

                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyAplicationDataStoreWithAPITheme {
        Greeting("Android")
    }
}