package com.example.corrutinasapp.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.corrutinasapp.R
import com.example.corrutinasapp.ui.theme.CorrutinasAppTheme
import com.example.corrutinasapp.viewmodel.MainViewModel

@Composable
fun CoroutinesApp(viewModel: MainViewModel = MainViewModel(), modifier : Modifier = Modifier){
    var changeColor by remember {
        mutableStateOf(false)
    }

    Column(modifier=modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(onClick = {
            changeColor = !changeColor
        },
            colors = ButtonDefaults.buttonColors(
                if (changeColor) Color.Blue else Color.Red
            )
            ) {
            Text(text = stringResource(R.string.cambio_de_color))
        }
        Spacer(modifier = modifier.height(30.dp))
        Text(text = viewModel.resultState)
        Text(text = "${viewModel.counTime1} [s]")
        Text(text = "${viewModel.counTime2} [s]")
        Spacer(modifier = modifier.height(30.dp))
        Button(onClick = { viewModel.fetchData() }) {
            Text(stringResource(R.string.realizar_consulta))
        }
        Spacer(modifier = modifier.height(30.dp))
        Button(onClick = { viewModel.cancelJob() }) {
            Text(stringResource(R.string.cancelar))
        }
    }
}

@Preview
@Composable
fun CoroutinesAppPreview(){
    CorrutinasAppTheme{
        CoroutinesApp()
    }
}
