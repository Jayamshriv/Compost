package com.example.compost

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compost.ui.theme.CompostTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompostTheme {
                MyAPP {
                    MainContent()
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAPP(content: @Composable () -> Unit) {
    CompostTheme {

        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Color.Blue,
                        scrolledContainerColor = Color.Black,
                        navigationIconContentColor = Color.Cyan,
                        titleContentColor = Color.Green,
                        actionIconContentColor = Color.Red
                    ),
                    title = {
                        Text(text = "Movies", fontSize = 18.sp)
                    }, actions = {
                        Text(text = "Action")
                    }, navigationIcon = {
                        Text(text = "NavIcon")
                    }
                )
            }
        ) {
            Surface(
                modifier = Modifier
                    .padding(it)
                    .background(color = Color.White)
            ) {
                content()
            }
        }
    }
}

@Composable
fun MainContent(
    movieList: ArrayList<String> = arrayListOf(
        "A",
        "B",
        "C",
        "D",
        "E",
        "B",
        "C",
        "D",
        "E",
        "B",
        "C",
        "D",
        "E"
    )
) {
    Surface {
        Column(
            Modifier.verticalScroll(rememberScrollState())
        ) {
            movieList.forEach {
                MovieRow(it)
            }
        }
//        LazyColumn {
//            items(items = movieList) {
//                MovieRow(it)
//            }
//        }
    }
}

@Preview
@Composable
fun MovieRow(movieName: String = "A") {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .border(shape = RoundedCornerShape(12.dp), border = BorderStroke(1.dp, Color.Gray))
            .height(130.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(12.dp)
    ) {
        Row(
            modifier = Modifier.padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Surface(
                Modifier
                    .padding(8.dp)
                    .size(100.dp), shape = RoundedCornerShape(12.dp)
            ) {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "SS")
            }

            Text(
                text = movieName,
                fontSize = 24.sp,
//                color = Color.Black,
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .fillMaxWidth()
                    .align(alignment = Alignment.CenterVertically)
//                style = TextStyle(
//                    shadow = Shadow(
//                        Color.Magenta,
//                        blurRadius = 5f
//                    )
//                )
            )
        }
    }
}


// class MainActivity : ComponentActivity() {
// override fun onCreate(savedInstanceState: Bundle?) {
// super.onCreate(savedInstanceState)
// setContent {
// CompostTheme {
// val mainViewModel = viewModels<MainViewModel>().value
// mainViewModel.getAPiData()
// // A surface container using the 'background' color from the theme
// MainScreen(viewModel = mainViewModel)
// }
// }
// }
// }
//
// @Composable
// fun MainScreen(
// viewModel: MainViewModel
// ){
//
// Text(
// text = viewModel.textToDisplay,
// fontSize = 30.sp,
// fontWeight = FontWeight.ExtraBold,
// modifier = Modifier.fillMaxWidth(),
// textAlign = TextAlign.Center
// )
// }
//
//
// class MainViewModel: ViewModel() {
// var textToDisplay by mutableStateOf("")
// fun getAPiData(){
// viewModelScope.launch {
// textToDisplay = "Jayam"
// }
//
// }
// }