package br.senai.sp.jandira.myaplicationdatastorewithapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.viewmodel.compose.viewModel
import br.senai.sp.jandira.myaplicationdatastorewithapi.ui.theme.MyAplicationDataStoreWithAPITheme
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAplicationDataStoreWithAPITheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UserDataScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserDataScreen() {
    val viewModel: UserDataViewModel = viewModel()
    val dataState by remember { viewModel.dataState }

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
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val name by dataState.name.collectAsState()
            val lastName by dataState.lastName.collectAsState()
            val age by dataState.age.collectAsState()
            val gender by dataState.gender.collectAsState()

            UserDataEntry("Name", name) { viewModel.onNameChange(it) }
            UserDataEntry("Last Name", lastName) { viewModel.onLastNameChange(it) }
            UserDataEntry("Age", age) { viewModel.onAgeChange(it) }
            UserDataEntry("Gender", gender) { viewModel.onGenderChange(it) }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                viewModel.saveUserData()
            }) {
                Text(text = "Save")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Saved Data:")
            Text(text = "Name: $name")
            Text(text = "Last Name: $lastName")
            Text(text = "Age: $age")
            Text(text = "Gender: $gender")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserDataEntry(label: String, value: String, onValueChange: (String) -> Unit) {
    Column {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
            label = { Text(text = label) },
    }
    Spacer(modifier = Modifier.height(10.dp))
}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserDataScreen() {
    // ... código anterior

    val viewModel: UserDataViewModel = viewModel()

    Box(
        modifier = Modifier
            .fillMaxSize()
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
            UserDataEntry("Name", viewModel.name) { viewModel.name = it }
            UserDataEntry("Last Name", viewModel.lastName) { viewModel.lastName = it }
            UserDataEntry("Age", viewModel.age) { viewModel.age = it }
            UserDataEntry("Gender", viewModel.gender) { viewModel.gender = it }
        }
    }
}